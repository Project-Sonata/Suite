package com.odeyalo.sonata.suite.brokers.events.playlist.gen;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.GenerativePlaylistEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.PlaylistImagesGeneratedPayload;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.PlaylistMetaGeneratedPayload;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@EqualsAndHashCode(callSuper = true)
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaylistImagesGeneratedEvent extends GenerativePlaylistEvent<PlaylistImagesGeneratedPayload> {
    public static final String EVENT_TYPE = "playlist_images_generated";

    public PlaylistImagesGeneratedEvent(@NotNull final PlaylistImagesGeneratedPayload body,
                                        @NotNull final GeneratedPlaylistType type) {
        super(body, type);
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PlaylistImagesGeneratedEvent(@JsonProperty("id") @NotNull final String id,
                                        @JsonProperty("creationTime") final long creationTime,
                                        @JsonProperty("body") @NotNull final PlaylistImagesGeneratedPayload body,
                                        @JsonProperty("playlist_type") @NotNull final GeneratedPlaylistType type) {
        super(id, creationTime, body, type);
    }

    @Override
    @NotNull
    public String getEventType() {
        return EVENT_TYPE;
    }
}
