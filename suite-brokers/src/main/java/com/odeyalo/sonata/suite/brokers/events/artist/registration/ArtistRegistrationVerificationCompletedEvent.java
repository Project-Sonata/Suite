package com.odeyalo.sonata.suite.brokers.events.artist.registration;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.artist.registration.data.ArtistVerificationCompletedInfo;
import org.jetbrains.annotations.NotNull;

public class ArtistRegistrationVerificationCompletedEvent extends AbstractEvent<ArtistVerificationCompletedInfo> {

    public ArtistRegistrationVerificationCompletedEvent(ArtistVerificationCompletedInfo body) {
        super(body);
    }

    public ArtistRegistrationVerificationCompletedEvent(String id, long creationTime, ArtistVerificationCompletedInfo body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getEventType() {
        return "artist_registration_verification_completed_event";
    }
}
