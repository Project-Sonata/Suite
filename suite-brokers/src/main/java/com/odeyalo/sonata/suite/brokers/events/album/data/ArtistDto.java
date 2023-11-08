package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistDto {
    String id;
    String name;
}
