package com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor_ = {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class PlaylistTracksGeneratedPayload {
    @NotNull
    @JsonProperty("user_id")
    String userId; // a user ID for which this playlist was generated
    @NotNull
    @JsonProperty("tracks")
    List<GeneratedTrack> tracks;
}
