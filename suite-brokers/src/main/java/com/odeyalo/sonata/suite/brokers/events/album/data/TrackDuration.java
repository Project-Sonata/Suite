package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
@Builder
public class TrackDuration {
    @JsonProperty("track_id")
    String trackId;
    @JsonProperty("duration_ms")
    long durationMs;
}
