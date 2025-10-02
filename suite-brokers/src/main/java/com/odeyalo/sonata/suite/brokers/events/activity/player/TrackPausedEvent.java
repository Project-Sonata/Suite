package com.odeyalo.sonata.suite.brokers.events.activity.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.activity.player.payload.TrackPausedPayload;
import com.odeyalo.sonata.suite.brokers.events.activity.player.payload.TrackPlayedPayload;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Value
public class TrackPausedEvent extends AbstractEvent<TrackPausedPayload> {
    public static final String EVENT_TYPE = "track_paused";

    public TrackPausedEvent(final TrackPausedPayload body) {
        super(body);
    }

    @JsonCreator
    public TrackPausedEvent(final String id,
                            final long creationTime,
                            final TrackPausedPayload body) {
        super(id, creationTime, body);
    }

    @Override
    @NotNull
    public String getEventType() {
        return EVENT_TYPE;
    }
}
