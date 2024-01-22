package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;

@Value
@Builder
public class CoverImage {
    @NotNull
    URI uri;
    @Nullable
    Integer width;
    @Nullable
    Integer height;
}
