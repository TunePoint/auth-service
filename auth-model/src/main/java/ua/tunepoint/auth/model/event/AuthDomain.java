package ua.tunepoint.auth.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthDomain {

    USER("user");

    private final String name;
}