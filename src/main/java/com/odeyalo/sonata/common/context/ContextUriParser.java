package com.odeyalo.sonata.common.context;

/**
 * A simple helper interface to parse URI string to {@link ContextUri}
 */
public interface ContextUriParser {
    /**
     * Parse the given string to ContextUri
     * @param uriString - valid uri string
     * @throws MalformedContextUriException - if the uri string is not valid context uri
     * @return - parsed ContextUri
     */
    ContextUri parse(String uriString) throws MalformedContextUriException;
}
