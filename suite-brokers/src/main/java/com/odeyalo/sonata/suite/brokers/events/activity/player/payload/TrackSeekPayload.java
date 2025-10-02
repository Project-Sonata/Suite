package com.odeyalo.sonata.suite.brokers.events.activity.player.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.Assert;


@Value
@Builder
public class TrackSeekPayload {
    @NotNull
    @JsonProperty("user_id")
    String userId;
    @NotNull
    @JsonProperty("track_id")
    String trackId;
    @JsonProperty("old_position")
    int oldPosition;
    @JsonProperty("new_position")
    int newPosition;

    public TrackSeekPayload(@NotNull final String userId,
                            @NotNull final String trackId,
                            final int oldPosition,
                            final int newPosition) {
        Assert.isTrue(oldPosition > 0, "Old position should be positive");
        Assert.isTrue(newPosition > 0, "New position should be positive");
        this.userId = userId;
        this.trackId = trackId;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
    }
}