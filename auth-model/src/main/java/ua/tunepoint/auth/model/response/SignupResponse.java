package ua.tunepoint.auth.model.response;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.auth.model.response.payload.SignupPayload;
import ua.tunepoint.web.model.CommonResponse;

@SuperBuilder
@NoArgsConstructor
public class SignupResponse extends CommonResponse<SignupPayload> {
}
