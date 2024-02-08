package com.odeyalo.sonata.suite.brokers.events.album;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.album.data.AlbumFullyUploadedInfo;
import org.jetbrains.annotations.NotNull;

public class AlbumUploadingFullyFinishedEvent extends AbstractEvent<AlbumFullyUploadedInfo> implements AlbumUploadingEvent {
    public static final String EVENT_TYPE = "album_uploading_fully_finished_event";

    AlbumUploadingFullyFinishedEvent() {
        super(null);
    }

    public AlbumUploadingFullyFinishedEvent(AlbumFullyUploadedInfo body) {
        super(body);
    }

    public AlbumUploadingFullyFinishedEvent(String id, long creationTime, AlbumFullyUploadedInfo body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getAlbumId() {
        return body.getAlbumInfo().getId();
    }

    @Override
    public @NotNull String getEventType() {
        return EVENT_TYPE;
    }
}
