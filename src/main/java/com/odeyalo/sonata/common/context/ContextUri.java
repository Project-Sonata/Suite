package com.odeyalo.sonata.common.context;

import com.odeyalo.sonata.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.util.Assert;

import java.util.Objects;

import static com.odeyalo.sonata.common.context.ContextEntityType.*;

/**
 * Basic:
 * Sonata-Project has context-uris to identity the resource.
 * <p>
 * Default structure of the context uri is "sonata:playlist:mikunakano" and all of these mean:
 * <ul>
 * <li> sonata - default prefix for the URI, it will be appended to ALL entity supported by Sonata Project, such album, playlist, artist, so on. </li>
 * <li>playlist - entity type. See {@link ContextEntityType} for further info.</li>
 * <li> mikunakano - ID of the entity.</li>
 * </ul>
 * So if you send sonata:playlist:mikunakano in request, then Sonata-Project will return the info about playlist with ID "mikunakano"
 * </p>
 * Context uri is a URI that identify the resource by ID. URI provide full info about the entity(The type of entity and ID)
 *
 * <p>
 * To create a {@link ContextUri} use a {@link #fromString(String)} method or 'for*' methods to create {@link ContextUri} for specific entity
 */
@Value
@AllArgsConstructor(staticName = "of")
public class ContextUri {
    @NotNull
    ContextEntityType type;
    @NotNull
    String entityId;

    /**
     * Method to check if a {@link String} is a valid context uri string
     *
     * @param contextUriString - string to check
     * @return - {@code true} if {@link String} is a valid context uri, {@code false} otherwise
     */
    public static boolean isValid(@NotNull final String contextUriString) {
        return ContextUriParser.getInstance().isValid(contextUriString);
    }

    /**
     * Factory method to create a {@link ContextUri} from {@link String}
     *
     * @param contextUriString - {@link String} to create {@link ContextUri} from
     * @return created {@link ContextUri}
     * @throws MalformedContextUriException - if a {@link String} is not valid
     */
    @NotNull
    public static ContextUri fromString(final String contextUriString) {
        return ContextUriParser.getInstance().parse(contextUriString);
    }

    @NotNull
    public static ContextUri forPlaylist(@NotNull final String playlistId) {
        return of(PLAYLIST, playlistId);
    }

    @NotNull
    public static ContextUri forAlbum(@NotNull final String albumId) {
        return of(ALBUM, albumId);
    }

    @NotNull
    public static ContextUri forUser(@NotNull final String userId) {
        return of(USER, userId);
    }

    @NotNull
    public static ContextUri forArtist(@NotNull final String artistId) {
        return of(ARTIST, artistId);
    }

    @NotNull
    public static ContextUri forTrack(@NotNull final String trackId) {
        return of(TRACK, trackId);
    }

    private static class ContextUriParser {
        private static final String URI_PREFIX = "sonata";
        private static final String CONTEXT_URI_SPLITERATOR = ":";
        private static final ContextUriParser INSTANCE = new ContextUriParser();

        private ContextUriParser() {
        }

        public static ContextUriParser getInstance() {
            return INSTANCE;
        }

        @NotNull
        public ContextUri parse(@NotNull final String uriString) throws MalformedContextUriException {
            final String[] parts = uriString.split(CONTEXT_URI_SPLITERATOR);

            final ContextUriParts contextUriParts = ContextUriParts.fromArray(parts);

            if ( !contextUriParts.hasPrefix(URI_PREFIX) ) {
                throw new MalformedContextUriException("URI must start with 'sonata'", uriString);
            }

            if ( contextUriParts.getEntityType() == null ) {
                throw new MalformedContextUriException("Invalid entity type received!", uriString);
            }

            return contextUriParts.compact();
        }

        public boolean isValid(@Nullable final String contextUriString) {
            if ( contextUriString == null ) {
                return false;
            }
            // Maybe refactor this but i am not sure about correct way to do so
            try {
                parse(contextUriString);
                return true;
            } catch (MalformedContextUriException ex) {
                return false;
            }
        }


        private static class ContextUriParts {

            private final String[] parts;

            public ContextUriParts(@NotNull final String[] parts) {
                this.parts = parts;
            }

            public static ContextUriParts fromArray(@NotNull final String[] parts) {
                if ( parts.length != 3 ) {
                    throw new InvalidContextUriLengthException(parts);
                }

                return new ContextUriParts(parts);
            }

            public boolean hasPrefix(@NotNull final String expected) {

                return Objects.equals(parts[0], expected);
            }

            @Nullable
            public ContextEntityType getEntityType() {
                final String entityType = parts[1];

                // We need this since by requirement when we need only lowercase characters in entity type section of context uri
                if ( !StringUtils.containsOnlyLowercase(entityType) ) {
                    return null;
                }

                return resolveEntityType(entityType);
            }

            @NotNull
            public String getEntityId() {
                return parts[2];
            }

            public ContextUri compact() {
                Assert.notNull(getEntityType(), () -> "Entity type cannot be null!");
                return ContextUri.of(getEntityType(), getEntityId());
            }

            private ContextEntityType resolveEntityType(@NotNull final String entityType) {
                try {
                    return ContextEntityType.valueOf(entityType.toUpperCase());
                } catch (IllegalArgumentException e) {
                    return null;
                }
            }
        }
    }
}