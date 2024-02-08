package com.odeyalo.sonata.suite.brokers.events.album;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.EventTypeProvider;
import com.odeyalo.sonata.suite.brokers.events.album.data.BasicAlbumInfoUploadedPayload;
import org.jetbrains.annotations.NotNull;

public class BasicAlbumInfoUploadedEvent extends AbstractEvent<BasicAlbumInfoUploadedPayload> implements AlbumUploadingEvent {
    public static final String EVENT_TYPE = "basic_album_info_uploaded_event";

    public BasicAlbumInfoUploadedEvent(BasicAlbumInfoUploadedPayload body) {
        super(body);
    }

    @JsonCreator
    public BasicAlbumInfoUploadedEvent(String id, long creationTime, BasicAlbumInfoUploadedPayload body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getAlbumId() {
        return body.getId();
    }

    @Override
    public @NotNull String getEventType() {
        return EVENT_TYPE;
    }
}
