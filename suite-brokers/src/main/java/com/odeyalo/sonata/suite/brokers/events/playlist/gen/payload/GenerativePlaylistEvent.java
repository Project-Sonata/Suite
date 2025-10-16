package com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.GeneratedPlaylistType;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistMetaGeneratedEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistTracksGeneratedEvent;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "event_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "playlist_tracks_generated", value = PlaylistTracksGeneratedEvent.class),
        @JsonSubTypes.Type(name = "playlist_meta_generated", value = PlaylistMetaGeneratedEvent.class),
})
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public abstract class GenerativePlaylistEvent<T> extends AbstractEvent<T> {
    @JsonProperty("playlist_type")
    GeneratedPlaylistType type;

    public GenerativePlaylistEvent(@NotNull final T body,
                                   @NotNull final GeneratedPlaylistType type) {
        super(body);
        this.type = type;
    }

    public GenerativePlaylistEvent(@NotNull final String id,
                                   final long creationTime,
                                   @NotNull final T body,
                                   @NotNull final GeneratedPlaylistType type) {
        super(id, creationTime, body);
        this.type = type;
    }
}
