package com.odeyalo.sonata.suite.brokers.events.album;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.album.data.BasicAlbumInfoUploadedPayload;

public class BasicAlbumInfoUploadedEvent extends AbstractEvent<BasicAlbumInfoUploadedPayload> {


    public BasicAlbumInfoUploadedEvent(BasicAlbumInfoUploadedPayload body) {
        super(body);
    }

    public BasicAlbumInfoUploadedEvent(String id, long creationTime, BasicAlbumInfoUploadedPayload body) {
        super(id, creationTime, body);
    }
}
