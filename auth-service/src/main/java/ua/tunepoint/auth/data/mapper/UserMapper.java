package ua.tunepoint.auth.data.mapper;

import org.mapstruct.Mapper;
import ua.tunepoint.auth.data.entity.Role;
import ua.tunepoint.auth.data.entity.User;
import ua.tunepoint.auth.model.response.payload.SignupPayload;

@Mapper(componentModel = "spring")
public interface UserMapper {

    SignupPayload toSignupPayload(User user);

    default String mapRole(Role role) {
        return role.getName();
    }
}
