package com.odeyalo.sonata.common.context;

import lombok.AllArgsConstructor;
import lombok.Value;

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
 */
@Value
@AllArgsConstructor(staticName = "of")
public class ContextUri {
    static String prefix = "sonata";
    ContextEntityType type;
    String entityId;

}