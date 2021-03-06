package ua.tunepoint.auth.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.tunepoint.auth.data.entity.Role;
import ua.tunepoint.auth.data.entity.User;
import ua.tunepoint.auth.model.request.SignupRequest;

import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class SignupRequestMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Mappings({
            @Mapping(target = "passwordHash", source = "request.password", qualifiedByName = "hashPassword"),
            @Mapping(target = "username", source = "request.username"),
            @Mapping(target = "email", source = "request.email"),
            @Mapping(target = "roles", source = "roles")
    })
    public abstract User toUser(SignupRequest request, Set<Role> roles);

    @Named("hashPassword")
    protected String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
