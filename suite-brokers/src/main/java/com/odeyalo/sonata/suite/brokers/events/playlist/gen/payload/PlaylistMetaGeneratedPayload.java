package com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class PlaylistMetaGeneratedPayload {
    @NotNull
    @JsonProperty("tracks")
    PlaylistTracksGeneratedPayload parent;
    @NotNull
    @JsonProperty("meta")
    Meta meta;

    @Value
    @Builder
    @AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
    public static class Meta {
        @NotNull
        @JsonProperty("name")
        String name;
        @NotNull
        @JsonProperty("description")
        String description;
    }
}
