package ua.tunepoint.auth.utils;

import ua.tunepoint.auth.data.entity.User;
import ua.tunepoint.auth.model.event.user.UserRegisteredEvent;

import java.time.LocalDateTime;

public class EventUtils {

    public static UserRegisteredEvent toCreatedEvent(User user) {
        return UserRegisteredEvent.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .time(LocalDateTime.now())
                .build();
    }
}
