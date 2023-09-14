package com.odeyalo.suite.security.auth.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Composite of AccessTokenExtractor that returns first non-empty match
 */
public class CompositeAccessTokenExtractor implements AccessTokenExtractor {
    final List<AccessTokenExtractor> extractors;
    private final Logger logger = LoggerFactory.getLogger(CompositeAccessTokenExtractor.class);

    public CompositeAccessTokenExtractor(List<AccessTokenExtractor> extractors) {
        this.extractors = extractors;
        logger.info("Initialized with: {}", extractors);
    }

    @Override
    public Mono<String> extractToken(ServerWebExchange exchange) {
        return Flux.fromIterable(extractors)
                .flatMap(extractor -> extractor.extractToken(exchange))
                .next();
    }
}
