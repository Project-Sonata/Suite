package com.odeyalo.suite.security.auth.token.converter;


import com.odeyalo.suite.security.auth.token.ValidatedAccessToken;

/**
 * Convert the class to {@link ValidatedAccessToken}
 *
 * @param <T> - type to convert from
 */
public interface ValidatedAccessTokenConverter<T> {
    ValidatedAccessToken convertTo(T from);
}
