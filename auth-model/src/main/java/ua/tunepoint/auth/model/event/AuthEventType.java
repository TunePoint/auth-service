package ua.tunepoint.auth.model.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ua.tunepoint.event.model.DomainEventType;
import ua.tunepoint.auth.model.event.user.UserRegisteredEvent;

@Getter
@RequiredArgsConstructor
public enum AuthEventType implements DomainEventType {

    USER_REGISTERED("registered", UserRegisteredEvent.class);

    private final String name;
    private final Class<?> type;
}
