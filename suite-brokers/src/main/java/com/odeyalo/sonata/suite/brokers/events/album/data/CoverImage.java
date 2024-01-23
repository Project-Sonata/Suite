package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;

@Value
@Builder
@AllArgsConstructor(onConstructor_= {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class CoverImage {
    @NotNull
    URI uri;
    @Nullable
    Integer width;
    @Nullable
    Integer height;
}
