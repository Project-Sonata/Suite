package com.odeyalo.sonata.suite.reactive.client;

import com.odeyalo.sonata.common.authorization.GeneratedInternalAccessTokenResponseDto;
import com.odeyalo.sonata.suite.reactive.config.ReactiveFeignConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "sonata-authorization",
        configuration = {ReactiveFeignConfiguration.class},
        qualifier = "internal-token-generator-feign-client")
public interface ReactiveInternalTokenClient {
    /**
     * Generate the internal access token
     * @param userId - user id to generate access token to
     * @param scopes - string with scopes separated by space( 'read write profile')
     * @return - GeneratedInternalAccessTokenResponseDto on success
     */
    @PostMapping("/internal/oauth/token/access")
    Mono<ResponseEntity<Mono<GeneratedInternalAccessTokenResponseDto>>> generateInternalToken(@RequestParam("user_id") String userId,
                                                                                              @RequestParam("scope") String scopes);
}
