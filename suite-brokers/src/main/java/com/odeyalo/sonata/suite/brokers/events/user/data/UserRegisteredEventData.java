package com.odeyalo.sonata.suite.brokers.events.user.data;

public record UserRegisteredEventData(String id, String email) {

    public static UserRegisteredEventData of(String id, String email) {
        return new UserRegisteredEventData(id, email);
    }
}
