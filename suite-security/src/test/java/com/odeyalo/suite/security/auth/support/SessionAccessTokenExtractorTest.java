package com.odeyalo.suite.security.auth.support;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpCookie;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import reactor.test.StepVerifier;

class SessionAccessTokenExtractorTest {

    @Test
    void shouldExtractAccessTokenFromRequestCookie() {
        SessionAccessTokenExtractor testable = new SessionAccessTokenExtractor();

        var mockRequest = MockServerHttpRequest.get("/hello")
                .cookie(new HttpCookie("Access-Token", "ilovemikunakano"))
                .build();
        var webExchange = new MockServerWebExchange.Builder(mockRequest)
                .build();

        testable.extractToken(webExchange)
                .as(StepVerifier::create)
                .expectNext("ilovemikunakano")
                .verifyComplete();
    }

    @Test
    void shouldReturnNothingIfCookieNotPresent() {
        SessionAccessTokenExtractor testable = new SessionAccessTokenExtractor();

        var mockRequest = MockServerHttpRequest.get("/hello")
                .build();
        var webExchange = new MockServerWebExchange.Builder(mockRequest)
                .build();

        testable.extractToken(webExchange)
                .as(StepVerifier::create)
                .verifyComplete();
    }
}