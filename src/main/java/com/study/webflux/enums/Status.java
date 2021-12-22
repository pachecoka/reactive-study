package com.study.webflux.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {

    AVAILABLE("available"),
    PENDING("pending"),
    ADOPTED("adopted");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Status create(String value) {
        return Status.valueOf(value.toUpperCase());
    }

}
