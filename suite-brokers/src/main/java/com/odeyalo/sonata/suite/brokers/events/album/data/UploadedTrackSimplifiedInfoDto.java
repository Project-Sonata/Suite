package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.net.URI;

@Value
@Builder
@AllArgsConstructor(onConstructor_= {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class UploadedTrackSimplifiedInfoDto {
    @NotNull
    String id;
    @NotNull
    String name;
    @NotNull
    ArtistContainerDto artists;
    // URI indicating where this track is saved for further processing(generating mp3 previews, changing bitrate, etc)
    @NotNull
    URI uri;
}
