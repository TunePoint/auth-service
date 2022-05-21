package ua.tunepoint.auth.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    @Email
    private String email;

    @Size(min = 6, max = 64)
    private String password;
}
