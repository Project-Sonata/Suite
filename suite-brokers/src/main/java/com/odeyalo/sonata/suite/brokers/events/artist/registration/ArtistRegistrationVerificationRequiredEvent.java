package com.odeyalo.sonata.suite.brokers.events.artist.registration;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.artist.registration.data.AwaitingVerificationArtistInfo;
import org.jetbrains.annotations.NotNull;

public class ArtistRegistrationVerificationRequiredEvent extends AbstractEvent<AwaitingVerificationArtistInfo> {
    public ArtistRegistrationVerificationRequiredEvent(AwaitingVerificationArtistInfo body) {
        super(body);
    }

    public ArtistRegistrationVerificationRequiredEvent(String id, long creationTime, AwaitingVerificationArtistInfo body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getEventType() {
        return "artist_registration_verification_required_event";
    }
}
