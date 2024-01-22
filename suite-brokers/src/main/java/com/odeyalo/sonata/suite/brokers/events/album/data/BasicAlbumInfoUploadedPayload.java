package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

/**
 * BasicAlbumInfoUploadedEvent - entry point event, always invoked first,
 * indicate that the basic info about album has been saved,
 * basic validation of album has been successfully passed,
 * track(s) info has been saved and
 * files(tracks and cover image) has been successfully uploaded to storage.
 *
 * @see <a href=https://github.com/Project-Sonata/Harmony/issues/16">Github issue for more info</a>
 */
@Value
@Builder
@AllArgsConstructor(onConstructor_= {@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)})
public class BasicAlbumInfoUploadedPayload {
    @NotNull
    String id;
    @NotNull
    String albumName;
    @NotNull
    AlbumType albumType;
    @NotNull
    String releaseDateAsString;
    @NotNull
    String releaseDatePrecision;
    @NotNull
    ArtistContainerDto artists;
    @NotNull
    UploadedTrackSimplifiedInfoContainerDto uploadedTracks;
    @NotNull
    CoverImage coverImage;
    int trackCount;
}
