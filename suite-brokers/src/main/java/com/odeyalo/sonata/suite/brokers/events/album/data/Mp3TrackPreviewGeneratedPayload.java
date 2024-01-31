package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
@Builder
public class Mp3TrackPreviewGeneratedPayload {
    @JsonProperty("track_id")
    String trackId;
    @JsonProperty("album_id")
    String albumId;
    @JsonProperty("preview_url")
    String previewUrl;
}
