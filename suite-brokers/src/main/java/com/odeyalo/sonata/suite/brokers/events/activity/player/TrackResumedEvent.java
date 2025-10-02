package com.odeyalo.sonata.suite.brokers.events.activity.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.activity.player.payload.TrackSeekPayload;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Value
public class TrackResumedEvent extends AbstractEvent<TrackPlayedEvent> {
    public static final String EVENT_TYPE = "track_resumed";

    public TrackResumedEvent(final TrackPlayedEvent body) {
        super(body);
    }

    @JsonCreator
    public TrackResumedEvent(final String id,
                             final long creationTime,
                             final TrackPlayedEvent body) {
        super(id, creationTime, body);
    }

    @Override
    @NotNull
    public String getEventType() {
        return EVENT_TYPE;
    }
}
