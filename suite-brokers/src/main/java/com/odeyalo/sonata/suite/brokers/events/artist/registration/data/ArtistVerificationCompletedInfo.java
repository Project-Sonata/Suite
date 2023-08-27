package com.odeyalo.sonata.suite.brokers.events.artist.registration.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * Represent the event info, when artist verification has been successfully completed
 */
@Value
@AllArgsConstructor(staticName = "of")
@Builder
public class ArtistVerificationCompletedInfo {
    // Info that was used to verify the artist
    AwaitingVerificationArtistInfo artistInfo;
    // time when verification has been completed
    LocalDateTime completionTime;
    // Optional message to return
    String additionalMessage;

    public static ArtistVerificationCompletedInfo of(AwaitingVerificationArtistInfo info, LocalDateTime time) {
        return of(info, time, null);
    }
}
