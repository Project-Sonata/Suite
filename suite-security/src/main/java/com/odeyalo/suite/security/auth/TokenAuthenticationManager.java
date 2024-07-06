package com.odeyalo.suite.security.auth;

import com.odeyalo.suite.security.auth.token.AccessTokenMetadata;
import com.odeyalo.suite.security.auth.token.ReactiveAccessTokenValidator;
import com.odeyalo.suite.security.auth.token.ValidatedAccessToken;
import com.odeyalo.suite.security.exception.InvalidAccessTokenException;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Used to validate the access token
 */
public class TokenAuthenticationManager implements ReactiveAuthenticationManager {
    private final ReactiveAccessTokenValidator accessTokenValidator;
    private final Logger logger = new Logger();


    public TokenAuthenticationManager(ReactiveAccessTokenValidator accessTokenValidator) {
        this.accessTokenValidator = accessTokenValidator;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        if (!(authentication instanceof TokenAuthentication tokenAuthentication)) {
            logger.onUnsatisfiedAuthentication(authentication);
            return Mono.empty();
        }

        final String accessToken = tokenAuthentication.getToken();

        if (accessToken == null) {
            logger.onMissingAccessToken(tokenAuthentication);
            return Mono.empty();
        }

        return accessTokenValidator.validateToken(accessToken)
                .doOnError(logger::onTokenValidationException)
                .flatMap(validatedAccessToken -> {
                    if (validatedAccessToken.isValid()) {
                        logger.onValidAccessTokenResponse(validatedAccessToken);

                        Set<GrantedAuthority> authorities = convertScopesToAuthorities(validatedAccessToken);
                        AccessTokenMetadata metadata = validatedAccessToken.getToken();
                        AuthenticatedUserDetails details = new AuthenticatedUserDetails(metadata.getUserId(), tokenAuthentication.getName(), accessToken, authorities);
                        return Mono.just(AuthenticatedUser.of(tokenAuthentication.getName(), details, accessToken, authorities));
                    }

                    logger.onInvalidAccessTokenResponse(validatedAccessToken);
                    return Mono.error(new InvalidAccessTokenException("Access token is invalid!", accessToken));
                });
    }

    @NotNull
    private static Set<GrantedAuthority> convertScopesToAuthorities(ValidatedAccessToken validatedAccessToken) {
        return Arrays.stream(validatedAccessToken.getToken().getScopes()).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    private static final class Logger {
        private final org.slf4j.Logger logger = LoggerFactory.getLogger(TokenAuthenticationManager.class);

        public void onUnsatisfiedAuthentication(@NotNull final Authentication original) {
            logger.info("Received no: TokenAuthentication. Skipped. {}", original);
        }

        public void onMissingAccessToken(@NotNull final TokenAuthentication tokenAuthentication) {
            logger.debug("Missing access token in: {}", tokenAuthentication);
        }

        public void onTokenValidationException(@NotNull final Throwable err) {
            logger.error("Access token validation terminated with an error", err);
        }

        public void onValidAccessTokenResponse(@NotNull final ValidatedAccessToken token) {
            logger.info("[OK] Successfully validated access token. Token status: [VALID]. {}", token);
        }

        public void onInvalidAccessTokenResponse(@NotNull final ValidatedAccessToken token) {
            logger.info("[FAILED] Successfully validated access token. Token status: [INVALID]. {}", token);
        }
    }
}
