package ua.tunepoint.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ua.tunepoint.model.response.UserResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public interface AuthEndpoint {

    @GetMapping("/auth")
    ResponseEntity<UserResponse> authenticateUser(@RequestHeader(AUTHORIZATION) String authorizationHeader);
}
