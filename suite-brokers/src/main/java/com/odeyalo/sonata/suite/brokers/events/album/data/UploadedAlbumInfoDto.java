package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UploadedAlbumInfoDto {
    String id;
    String name;
    AlbumType albumType;
    String releaseDateAsString;
    String releaseDatePrecision;
    int totalTracksCount;
    ArtistContainerDto artists;
    SimplifiedTrackDtoContainer tracks;
    CoverImages images;
}
