package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
public class AlbumFullyUploadedInfo {
    UploadedAlbumInfoDto albumInfo;
}
