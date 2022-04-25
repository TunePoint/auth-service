package ua.tunepoint.auth.security;

import ua.tunepoint.auth.data.entity.User;

public interface TokenProvider {

    String accessToken(User user);

    String refreshToken(User user);
}
