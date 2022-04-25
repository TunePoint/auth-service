package ua.tunepoint.auth.utils;

import ua.tunepoint.auth.data.entity.User;
import ua.tunepoint.auth.model.event.user.UserCreatedEvent;

import java.time.LocalDateTime;

public class EventUtils {

    public static UserCreatedEvent toCreatedEvent(User user) {
        return UserCreatedEvent.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .time(LocalDateTime.now())
                .build();
    }
}
