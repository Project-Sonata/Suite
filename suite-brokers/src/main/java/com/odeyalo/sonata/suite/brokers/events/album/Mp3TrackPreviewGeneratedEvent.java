package com.odeyalo.sonata.suite.brokers.events.album;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.EventTypeProvider;
import com.odeyalo.sonata.suite.brokers.events.album.data.Mp3TrackPreviewGeneratedPayload;
import org.jetbrains.annotations.NotNull;

public class Mp3TrackPreviewGeneratedEvent extends AbstractEvent<Mp3TrackPreviewGeneratedPayload> implements EventTypeProvider, AlbumUploadingEvent {
    public static final String EVENT_TYPE = "mp3_preview_generated";

    @JsonCreator
    public Mp3TrackPreviewGeneratedEvent(Mp3TrackPreviewGeneratedPayload body) {
        super(body);
    }

    public Mp3TrackPreviewGeneratedEvent(String id, long creationTime, Mp3TrackPreviewGeneratedPayload body) {
        super(id, creationTime, body);
    }

    @Override
    @NotNull
    public String getEventType() {
        return EVENT_TYPE;
    }

    @Override
    public @NotNull String getAlbumId() {
        return body.getAlbumId();
    }
}
