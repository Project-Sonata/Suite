package com.odeyalo.sonata.suite.brokers.events.activity.player.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.Assert;

@Value
@Builder
public class TrackPausedPayload {
    @NotNull
    @JsonProperty("user_id")
    String userId;
    @NotNull
    @JsonProperty("track_id")
    String trackId;
    int position;

    public TrackPausedPayload(@NotNull final String userId,
                              @NotNull final String trackId,
                              final int position) {
        Assert.isTrue(position >= 0, "Position should be positive");
        this.userId = userId;
        this.trackId = trackId;
        this.position = position;
    }
}
