package ua.tunepoint.auth.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    @Email
    private String email;

    @Size(min = 6, max = 64)
    private String password;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?!\\.)(?!.*\\.$)(?!.*\\.\\.)[a-z0-9_\\.]{3,24}$", message = "following characters are allowed: 'a'-'z',  '0'-'9', '_', '.'")
    private String username;
}
