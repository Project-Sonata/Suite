package com.odeyalo.sonata.suite.brokers.events.album;

import com.odeyalo.sonata.suite.brokers.events.EventTypeProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Interface indicating that this is an album uploading event
 */
public interface AlbumUploadingEvent extends EventTypeProvider {

    @NotNull
    String getAlbumId();

}
