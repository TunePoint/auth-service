package ua.tunepoint.auth.model.response;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ua.tunepoint.auth.model.response.domain.User;
import ua.tunepoint.web.model.CommonResponse;

@SuperBuilder
@NoArgsConstructor
public class UserResponse extends CommonResponse<User> {
}
