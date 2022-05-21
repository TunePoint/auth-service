package ua.tunepoint.auth.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.tunepoint.auth.service.AuthenticationService;
import ua.tunepoint.auth.service.ConfirmationService;
import ua.tunepoint.auth.model.request.AuthenticationRequest;
import ua.tunepoint.auth.model.request.EmailConfirmationRequest;
import ua.tunepoint.auth.model.request.EmailResendRequest;
import ua.tunepoint.auth.model.request.SignupRequest;
import ua.tunepoint.auth.model.request.UpdatePasswordRequest;
import ua.tunepoint.auth.model.response.AuthenticationResponse;
import ua.tunepoint.auth.model.response.RefreshResponse;
import ua.tunepoint.auth.model.response.SignupResponse;
import ua.tunepoint.auth.model.response.UserResponse;
import ua.tunepoint.auth.model.response.domain.User;
import ua.tunepoint.security.UserPrincipal;
import ua.tunepoint.web.model.StatusResponse;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final ConfirmationService confirmationService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody @Validated SignupRequest request) {
        var signupPayload = authenticationService.signup(request);
        var response = SignupResponse.builder().payload(signupPayload).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/email/confirm")
    public ResponseEntity<StatusResponse> emailConfirm(@RequestBody @Validated EmailConfirmationRequest request) {
        confirmationService.confirmEmail(request.getEmail(), request.getCode(), request.getPassword());
        return ResponseEntity.ok(StatusResponse.builder().build());
    }

    @PostMapping("/email/resend")
    public ResponseEntity<StatusResponse> emailResend(@RequestBody @Validated EmailResendRequest request) {
        confirmationService.resendEmail(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(StatusResponse.builder().build());
    }

    @PostMapping("/token")
    public ResponseEntity<AuthenticationResponse> token(@RequestBody @Validated AuthenticationRequest request) {
        var authenticationPayload = authenticationService.authenticate(request);
        var response = AuthenticationResponse.builder().payload(authenticationPayload).build();
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/token/refresh")
    public ResponseEntity<RefreshResponse> refreshToken(@AuthenticationPrincipal UserPrincipal user) {
        var refreshPayload = authenticationService.refresh(user.getUsername());
        var response = RefreshResponse.builder().payload(refreshPayload).build();
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/password")
    public ResponseEntity<StatusResponse> updatePassword(@RequestBody @Validated UpdatePasswordRequest request, @AuthenticationPrincipal UserPrincipal currentUser) {
        authenticationService.updatePassword(request, currentUser.getId());
        return ResponseEntity.ok(StatusResponse.builder().build());
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok(
                UserResponse.builder()
                        .payload(
                                User.builder()
                                        .id(user.getId())
                                        .username(user.getUsername())
                                        .authorities(
                                                user.getAuthorities()
                                                        .stream().map(
                                                                GrantedAuthority::getAuthority
                                                        ).collect(
                                                                Collectors.toSet()
                                                        )
                                        )
                                        .build()
                        )
                        .build()
        );
    }
}
