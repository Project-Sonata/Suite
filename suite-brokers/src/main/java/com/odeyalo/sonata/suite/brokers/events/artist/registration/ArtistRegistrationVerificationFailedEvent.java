package com.odeyalo.sonata.suite.brokers.events.artist.registration;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.artist.registration.data.ArtistVerificationFailedInfo;
import org.jetbrains.annotations.NotNull;

public class ArtistRegistrationVerificationFailedEvent extends AbstractEvent<ArtistVerificationFailedInfo> {

    public ArtistRegistrationVerificationFailedEvent(ArtistVerificationFailedInfo body) {
        super(body);
    }

    public ArtistRegistrationVerificationFailedEvent(String id, long creationTime, ArtistVerificationFailedInfo body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getEventType() {
        return "artist_registration_verification_failed_event";
    }
}
