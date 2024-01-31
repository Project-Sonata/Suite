package com.odeyalo.sonata.suite.brokers.events;

import org.jetbrains.annotations.NotNull;

public interface EventTypeProvider {
    /**
     * @return unique type of this event that used as identifier
     */
    @NotNull
    String getEventType();

}
