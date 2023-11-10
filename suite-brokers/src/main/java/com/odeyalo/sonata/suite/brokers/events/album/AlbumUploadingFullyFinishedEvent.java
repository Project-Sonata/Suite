package com.odeyalo.sonata.suite.brokers.events.album;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.album.data.AlbumFullyUploadedInfo;

public class AlbumUploadingFullyFinishedEvent extends AbstractEvent<AlbumFullyUploadedInfo> {

    AlbumUploadingFullyFinishedEvent() {
        super(null);
    }

    public AlbumUploadingFullyFinishedEvent(AlbumFullyUploadedInfo body) {
        super(body);
    }

    public AlbumUploadingFullyFinishedEvent(String id, long creationTime, AlbumFullyUploadedInfo body) {
        super(id, creationTime, body);
    }
}
