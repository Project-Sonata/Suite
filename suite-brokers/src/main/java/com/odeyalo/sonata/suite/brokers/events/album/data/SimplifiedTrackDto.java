package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.net.URI;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimplifiedTrackDto {
    String id;
    String name;
    Long durationMs;
    URI streamingUri;
    ArtistContainerDto artists;
}
