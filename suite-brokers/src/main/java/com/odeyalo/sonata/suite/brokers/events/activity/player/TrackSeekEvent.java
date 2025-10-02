package com.odeyalo.sonata.suite.brokers.events.activity.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.activity.player.payload.TrackPlayedPayload;
import com.odeyalo.sonata.suite.brokers.events.activity.player.payload.TrackSeekPayload;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Value
public class TrackSeekEvent extends AbstractEvent<TrackSeekPayload> {
    public static final String EVENT_TYPE = "track_played";

    public TrackSeekEvent(final TrackSeekPayload body) {
        super(body);
    }

    @JsonCreator
    public TrackSeekEvent(final String id,
                          final long creationTime,
                          final TrackSeekPayload body) {
        super(id, creationTime, body);
    }

    @Override
    @NotNull
    public String getEventType() {
        return EVENT_TYPE;
    }
}
