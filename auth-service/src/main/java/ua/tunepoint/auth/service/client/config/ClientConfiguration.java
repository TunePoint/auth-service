package ua.tunepoint.auth.service.client.config;

import org.springframework.context.annotation.Bean;
import ua.tunepoint.security.JwtAuthorizationRequestInterceptor;

public class ClientConfiguration {

    @Bean
    public JwtAuthorizationRequestInterceptor requestInterceptor() {
        return new JwtAuthorizationRequestInterceptor();
    }
}
