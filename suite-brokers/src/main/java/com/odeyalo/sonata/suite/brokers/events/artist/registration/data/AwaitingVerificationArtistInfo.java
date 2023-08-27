package com.odeyalo.sonata.suite.brokers.events.artist.registration.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

/**
 * Represents essential information about an artist who is awaiting verification.
 * This class holds the details necessary to register an artist for verification,
 * including the artist's identification, associated user ID (required to associate user with artist),
 * artist name, and a list of genres associated with the artist.
 *
 * Note: This class is specifically designed for registering new artists from the USER perspective
 * and does not handle associating an existing artist with a user.
 *
 */
@Value
@AllArgsConstructor(staticName = "of")
@Builder
public class AwaitingVerificationArtistInfo {
    // ID of the artist entity that waits for the verification.
    // This ID is immutable, so if artist has ID 'myID', then this ID should be used for saving and/or association with user entity
    String artistId;
    // ID of the user that want to become an artist
    String userId;
    String artistName;
    List<String> genres;
}
