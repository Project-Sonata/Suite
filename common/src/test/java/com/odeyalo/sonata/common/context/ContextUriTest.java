package com.odeyalo.sonata.common.context;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.odeyalo.sonata.common.context.ContextEntityType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContextUriTest {

    @Test
    void shouldReturnTrueIfContextUriStringIsValid() {
        assertThat(ContextUri.isValid("sonata:track:miku")).isTrue();
    }

    @Test
    void shouldReturnFalseIfContextUriStringIsLessThan3Elements() {
        assertThat(ContextUri.isValid("sonata:invalid")).isFalse();
    }

    @Test
    void shouldReturnFalseIfContextUriStringStartsWithWrongPrefix() {
        assertThat(ContextUri.isValid("soundcloud:track:123")).isFalse();
    }

    @Test
    void shouldReturnFalseIfContextUriHasNoLowerCaseForEntityType() {
        assertThat(ContextUri.isValid("sonata:TrAck:mikunakano")).isFalse();
    }

    @Test
    void shouldParseContextUriStringToValidContextUriObject() {
        final var contextUri = ContextUri.fromString("sonata:track:123");

        assertThat(contextUri.getType()).isEqualTo(TRACK);
        assertThat(contextUri.getEntityId()).isEqualTo("123");
    }

    @Test
    void shouldThrowExceptionIfContextUriIsNotValid() {
        assertThatThrownBy(() -> ContextUri.fromString("sonata:123"))
                .isInstanceOf(InvalidContextUriLengthException.class);
    }

    @Test
    void shouldReturnContextUriAsValidContextUriStringForTrack() {
        final ContextUri contextUri = ContextUri.forTrack("123");

        assertThat(contextUri.asString()).isEqualTo("sonata:track:123");
    }

    @Test
    void shouldReturnContextUriAsValidContextUriStringForAlbum() {
        final ContextUri contextUri = ContextUri.forAlbum("12345");

        assertThat(contextUri.asString()).isEqualTo("sonata:album:12345");
    }

    @Test
    void shouldReturnContextUriAsValidContextUriStringForUser() {
        final ContextUri contextUri = ContextUri.forUser("odeyalo");

        assertThat(contextUri.asString()).isEqualTo("sonata:user:odeyalo");
    }

    @Test
    void shouldReturnContextUriAsValidContextUriStringForPlaylist() {
        final ContextUri contextUri = ContextUri.forPlaylist("7777");

        assertThat(contextUri.asString()).isEqualTo("sonata:playlist:7777");
    }

    @Test
    void shouldReturnContextUriAsValidContextUriStringForArtist() {
        final ContextUri contextUri = ContextUri.forArtist("1488");

        assertThat(contextUri.asString()).isEqualTo("sonata:artist:1488");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class FactoryMethodsTest {

        @Test
        void shouldReturnPlaylistWithId() {
            final ContextUri contextUri = ContextUri.forPlaylist("12345");

            assertThat(contextUri.getType()).isEqualTo(PLAYLIST);
            assertThat(contextUri.getEntityId()).isEqualTo("12345");
        }

        @Test
        void shouldReturnAlbumWithId() {
            final ContextUri contextUri = ContextUri.forAlbum("12345");

            assertThat(contextUri.getType()).isEqualTo(ALBUM);
            assertThat(contextUri.getEntityId()).isEqualTo("12345");
        }

        @Test
        void shouldReturnUserWithId() {
            final ContextUri contextUri = ContextUri.forUser("odeyalo");

            assertThat(contextUri.getType()).isEqualTo(USER);
            assertThat(contextUri.getEntityId()).isEqualTo("odeyalo");
        }

        @Test
        void shouldReturnArtistWithId() {
            final ContextUri contextUri = ContextUri.forArtist("salviaPalth");

            assertThat(contextUri.getType()).isEqualTo(ARTIST);
            assertThat(contextUri.getEntityId()).isEqualTo("salviaPalth");
        }

        @Test
        void shouldReturnTrackWithId() {
            final ContextUri contextUri = ContextUri.forTrack("1488");

            assertThat(contextUri.getType()).isEqualTo(TRACK);
            assertThat(contextUri.getEntityId()).isEqualTo("1488");
        }


    }
}