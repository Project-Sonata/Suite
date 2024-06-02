package com.odeyalo.sonata.suite.brokers.events;

import org.jetbrains.annotations.NotNull;

public interface SonataEvent {

    @NotNull
    String id();

    long creationTime();

    @NotNull
    String getEventType();
}
