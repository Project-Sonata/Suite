package com.odeyalo.sonata.suite.reactive.client;

import com.odeyalo.sonata.common.authorization.TokenIntrospectionRequest;
import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.sonata.suite.reactive.config.ReactiveFeignConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "sonata-authorization", configuration = {ReactiveFeignConfiguration.class})
public interface ReactiveTokenIntrospectionClient {

    @PostMapping("/token/info")
    Mono<ResponseEntity<Mono<TokenIntrospectionResponse>>> introspectToken(@RequestBody TokenIntrospectionRequest req);

    @PostMapping("/token/oauth2/info")
    Mono<ResponseEntity<Mono<TokenIntrospectionResponse>>> introspectOauth2Token(@RequestBody TokenIntrospectionRequest req);

}
