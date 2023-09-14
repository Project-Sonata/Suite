package com.odeyalo.suite.security.auth.support;

import org.junit.jupiter.api.Test;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.server.session.DefaultWebSessionManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;

class QueryParamAccessTokenExtractorTest {

    @Test
    void extractTokenWithQueryParamAndExpectTokenValue() {
        String tokenValue = "ilovemiku";
        QueryParamAccessTokenExtractor extractor = new QueryParamAccessTokenExtractor();
        MockServerHttpRequest request = get("https://sonata.com/player").queryParam("token", tokenValue).build();
        MockServerWebExchange exchange = MockServerWebExchange.from(request);

        String actualToken = extractor.extractToken(exchange).block();

        assertThat(actualToken).isEqualTo(tokenValue);
    }

    @Test
    void extractTokenWithoutQueryParamAndExpectEmpty() {
        QueryParamAccessTokenExtractor extractor = new QueryParamAccessTokenExtractor();
        MockServerHttpRequest request = get("https://sonata.com/player").build();
        MockServerWebExchange exchange = MockServerWebExchange.from(request);

        String actualToken = extractor.extractToken(exchange).block();

        assertThat(actualToken).isNull();
    }
}