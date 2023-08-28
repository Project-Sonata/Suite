package com.odeyalo.sonata.common.context;

public class HardcodedContextUriParser implements ContextUriParser {
    public static final String CONTEXT_URI_SPLITERATOR_REGEX = ":";
    public static final String URI_PREFIX = "sonata";

    @Override
    public ContextUri parse(String uriString) throws MalformedContextUriException {
        String[] splitContextUri = uriString.split(CONTEXT_URI_SPLITERATOR_REGEX);

        if (splitContextUri.length != 3) {
            throw new MalformedContextUriException("The URI does not pass the REGEX!\n More or less than 3 parts was received", uriString);
        }

        String uriPrefix = splitContextUri[0];
        String entityType = splitContextUri[1];

        if (!uriPrefix.equals(URI_PREFIX)) {
            throw new MalformedContextUriException("URI must start with 'sonata'", uriString);
        }

        ContextEntityType entityTypeEnum = resolveEntityType(entityType);

        if (!entityType.equals(entityType.toLowerCase()) || entityTypeEnum == null) {
            throw new MalformedContextUriException("URI must contain entity type in lower case!", uriString);
        }

        String entityId = splitContextUri[2];

        return ContextUri.of(entityTypeEnum, entityId);
    }

    private ContextEntityType resolveEntityType(String entityType) {
        try {
            return ContextEntityType.valueOf(entityType.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
