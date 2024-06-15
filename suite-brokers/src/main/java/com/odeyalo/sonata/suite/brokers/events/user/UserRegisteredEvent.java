package com.odeyalo.sonata.suite.brokers.events.user;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.user.data.UserRegisteredEventData;
import org.jetbrains.annotations.NotNull;

public class UserRegisteredEvent extends AbstractEvent<UserRegisteredEventData> {

    public UserRegisteredEvent() {
        super(null);
    }

    public UserRegisteredEvent(String id, long creationTime, UserRegisteredEventData body) {
        super(id, creationTime, body);
    }

    public UserRegisteredEvent(UserRegisteredEventData body) {
        super(body);
    }

    public UserRegisteredEventData getEventData() {
        return getBody();
    }

    @Override
    public @NotNull String getEventType() {
        return "user_registered_event";
    }
}
