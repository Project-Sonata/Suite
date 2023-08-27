package com.odeyalo.suite.security.auth.token.converter;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.suite.security.auth.token.AccessTokenMetadata;
import com.odeyalo.suite.security.auth.token.ValidatedAccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Convert the {@link TokenIntrospectionResponse} to {@link ValidatedAccessToken}
 */
public class TokenIntrospectionResponse2ValidatedAccessTokenConverter implements ValidatedAccessTokenConverter<TokenIntrospectionResponse> {

    public static final String SCOPE_DELIMITER = " ";

    private final Logger logger = LoggerFactory.getLogger(TokenIntrospectionResponse2ValidatedAccessTokenConverter.class);

    @Override
    public ValidatedAccessToken convertTo(TokenIntrospectionResponse body) {
        this.logger.debug("Convert the body: {} to ValidatedAccessToken token", body);

        if (!body.isValid()) {
            this.logger.debug("The token is invalid. Conversation has been failed and reason is unavailable");
            return ValidatedAccessToken.invalid();
        }

        AccessTokenMetadata metadata = AccessTokenMetadata.of(body.getUserId(), body.getScope().split(SCOPE_DELIMITER),
                body.getIssuedAt(), body.getExpiresIn());

        return ValidatedAccessToken.valid(metadata);
    }
}