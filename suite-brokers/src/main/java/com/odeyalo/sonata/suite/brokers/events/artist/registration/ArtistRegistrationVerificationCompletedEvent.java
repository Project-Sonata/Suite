package com.odeyalo.sonata.suite.brokers.events.artist.registration;

import com.odeyalo.sonata.suite.brokers.events.AbstractEvent;
import com.odeyalo.sonata.suite.brokers.events.artist.registration.data.ArtistVerificationCompletedInfo;

public class ArtistRegistrationVerificationCompletedEvent extends AbstractEvent<ArtistVerificationCompletedInfo> {

    public ArtistRegistrationVerificationCompletedEvent(ArtistVerificationCompletedInfo body) {
        super(body);
    }

    public ArtistRegistrationVerificationCompletedEvent(String id, long creationTime, ArtistVerificationCompletedInfo body) {
        super(id, creationTime, body);
    }
}
