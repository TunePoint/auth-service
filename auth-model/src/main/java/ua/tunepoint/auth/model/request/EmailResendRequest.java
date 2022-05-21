package ua.tunepoint.auth.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailResendRequest {

    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 64)
    private String password;
}
