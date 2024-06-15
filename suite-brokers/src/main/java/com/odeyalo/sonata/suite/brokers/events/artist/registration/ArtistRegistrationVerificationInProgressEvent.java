package com.odeyalo.sonata.suite.brokers.events.artist.registration;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.artist.registration.data.AwaitingVerificationArtistInfo;
import org.jetbrains.annotations.NotNull;

public class ArtistRegistrationVerificationInProgressEvent extends AbstractEvent<AwaitingVerificationArtistInfo> {
    public ArtistRegistrationVerificationInProgressEvent(AwaitingVerificationArtistInfo body) {
        super(body);
    }

    public ArtistRegistrationVerificationInProgressEvent(String id, long creationTime, AwaitingVerificationArtistInfo body) {
        super(id, creationTime, body);
    }

    @Override
    public @NotNull String getEventType() {
        return "artist_registration_verification_in_progress_event";
    }
}
