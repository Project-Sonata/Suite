package com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistMetaGeneratedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class PlaylistImagesGeneratedPayload {
    @NotNull
    @JsonProperty("meta")
    PlaylistMetaGeneratedPayload parent;
    @JsonProperty("images")
    List<Image> images;

    @Value
    @Builder
    @AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
    public static class Image {
        @NotNull
        @JsonProperty("url")
        String url;
        @Nullable
        @JsonProperty("height")
        Integer height;
        @Nullable
        @JsonProperty("width")
        Integer width;

        public Image(@NotNull final String url) {
            this.url = url;
            this.height = null;
            this.width = null;
        }
    }
}
