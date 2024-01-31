package com.odeyalo.sonata.suite.brokers.events.album;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.EventTypeProvider;
import com.odeyalo.sonata.suite.brokers.events.album.data.AlbumDurationResolvedPayload;
import org.jetbrains.annotations.NotNull;

public class AlbumDurationResolvedEvent extends AbstractEvent<AlbumDurationResolvedPayload> implements EventTypeProvider {

    public static final String EVENT_TYPE = "track_length_resolved";

    @JsonCreator
    public AlbumDurationResolvedEvent(AlbumDurationResolvedPayload body) {
        super(body);
    }

    @Override
    public @NotNull String getEventType() {
        return EVENT_TYPE;
    }
}
