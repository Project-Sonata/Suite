package com.odeyalo.sonata.suite.brokers.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public interface EventTypeProvider {
    /**
     * @return unique type of this event that used as identifier
     */
    @NotNull
    @JsonProperty("event_type")
    String getEventType();

}
