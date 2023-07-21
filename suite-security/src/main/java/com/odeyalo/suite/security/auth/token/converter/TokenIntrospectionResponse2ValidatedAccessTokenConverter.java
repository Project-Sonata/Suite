package com.odeyalo.suite.security.auth.token.converter;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.suite.security.auth.token.AccessTokenMetadata;
import com.odeyalo.suite.security.auth.token.ValidatedAccessToken;

/**
 * Convert the {@link TokenIntrospectionResponse} to {@link ValidatedAccessToken}
 */
public class TokenIntrospectionResponse2ValidatedAccessTokenConverter implements ValidatedAccessTokenConverter<TokenIntrospectionResponse> {

    public static final String SCOPE_DELIMITER = " ";

    @Override
    public ValidatedAccessToken convertTo(TokenIntrospectionResponse body) {
        System.out.println("CONVERT");
        if (!body.isValid()) {
            return ValidatedAccessToken.invalid();
        }
        AccessTokenMetadata metadata = AccessTokenMetadata.of(body.getUserId(), body.getScope().split(SCOPE_DELIMITER),
                body.getIssuedAt(), body.getExpiresIn());

        return ValidatedAccessToken.valid(metadata);
    }
}