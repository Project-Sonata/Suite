package com.odeyalo.sonata.suite.brokers.events.artist.registration.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor(staticName = "of")
@Builder
public class ArtistVerificationFailedInfo {
    VerificationFailedErrorDetails errorDetails;
    LocalDateTime failureTime;

    @Value
    @AllArgsConstructor(staticName = "of")
    public static class VerificationFailedErrorDetails {
        // Unique code for the error
        String errorCode;
        String description;
    }
}

