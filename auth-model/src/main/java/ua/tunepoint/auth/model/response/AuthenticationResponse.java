package ua.tunepoint.auth.model.response;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.auth.model.response.payload.AuthenticationPayload;
import ua.tunepoint.web.model.CommonResponse;

@SuperBuilder
@NoArgsConstructor
public class AuthenticationResponse extends CommonResponse<AuthenticationPayload> {
}
