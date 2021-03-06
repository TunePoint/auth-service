package ua.tunepoint.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.tunepoint.event.starter.DomainRelation;
import ua.tunepoint.event.starter.registry.DomainRegistry;
import ua.tunepoint.event.starter.registry.builder.DomainRegistryBuilder;
import ua.tunepoint.auth.model.event.AuthEventType;

import java.util.Set;

import static ua.tunepoint.auth.model.event.AuthDomain.AUTH;

@Configuration
public class EventConfiguration {

    @Bean
    public DomainRegistry domainRegistry() {
        return new DomainRegistryBuilder()
                .register(AUTH.getName(), AuthEventType.values(), Set.of(DomainRelation.PRODUCER))
                .build();
    }
}
