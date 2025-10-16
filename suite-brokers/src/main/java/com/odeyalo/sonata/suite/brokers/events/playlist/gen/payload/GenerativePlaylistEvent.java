package com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistTracksGeneratedEvent;
import lombok.EqualsAndHashCode;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "event_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "playlist_tracks_generated",  value = PlaylistTracksGeneratedEvent.class),
})
@EqualsAndHashCode(callSuper = true)
public abstract class GenerativePlaylistEvent<T> extends AbstractEvent<T> {

    public GenerativePlaylistEvent(final T body) {
        super(body);
    }

    public GenerativePlaylistEvent(final String id,
                                   final long creationTime,
                                   final T body) {
        super(id, creationTime, body);
    }
}
