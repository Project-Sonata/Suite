package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class AlbumDurationResolvedPayload {
    @JsonProperty("album_id")
    String albumId;
    @JsonProperty("total_duration_ms")
    long totalDurationMs;
    @JsonProperty("tracks")
    TrackDurationContainer trackDurationContainer;
}
