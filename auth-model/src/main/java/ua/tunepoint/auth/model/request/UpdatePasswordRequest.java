package ua.tunepoint.auth.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

    @Size(min = 6, max = 64)
    private String oldPassword;

    @Size(min = 6, max = 64)
    private String newPassword;
}
