package com.odeyalo.suite.security.config;


import com.odeyalo.sonata.common.authorization.TokenIntrospectionResponse;
import com.odeyalo.sonata.suite.reactive.client.ReactiveTokenIntrospectionClient;
import com.odeyalo.suite.security.auth.TokenAuthenticationManager;
import com.odeyalo.suite.security.auth.TokenServerAuthenticationConverter;
import com.odeyalo.suite.security.auth.support.*;
import com.odeyalo.suite.security.auth.token.ReactiveAccessTokenValidator;
import com.odeyalo.suite.security.auth.token.RemoteAccessTokenValidationStrategy;
import com.odeyalo.suite.security.auth.token.RemoteReactiveAccessTokenValidator;
import com.odeyalo.suite.security.auth.token.SuiteClientRemoteAccessTokenValidationStrategy;
import com.odeyalo.suite.security.auth.token.converter.TokenIntrospectionResponse2ValidatedAccessTokenConverter;
import com.odeyalo.suite.security.auth.token.converter.ValidatedAccessTokenConverter;
import com.odeyalo.suite.security.web.filter.UserAuthenticationWebFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.authentication.ServerAuthenticationEntryPointFailureHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;

import java.util.List;

@Configuration
public class SuiteSecurityAutoConfiguration {

    @Bean
    @Primary
    public CompositeAccessTokenExtractor compositeAccessTokenExtractor(List<AccessTokenExtractor> extractors) {
        return new CompositeAccessTokenExtractor(extractors);
    }

    @Bean
    public QueryParamAccessTokenExtractor queryParamAccessTokenExtractor() {
        return new QueryParamAccessTokenExtractor();
    }

    @Bean
    public PrefixedAuthorizationHeaderAccessTokenExtractor accessTokenExtractor() {
        return new PrefixedAuthorizationHeaderAccessTokenExtractor();
    }

    @Bean
    public SessionAccessTokenExtractor sessionAccessTokenExtractor() {
        return new SessionAccessTokenExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    public ServerAuthenticationEntryPoint serverAuthenticationEntryPoint() {
        return new UnathorizedHttpStatusServerEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationWebFilter userAuthenticationWebFilter(ServerAuthenticationConverter converter,
                                                               ReactiveAuthenticationManager authenticationManager,
                                                               ServerAuthenticationFailureHandler failureHandler) {
        return new UserAuthenticationWebFilter(converter, authenticationManager, failureHandler);
    }

    @Bean
    @ConditionalOnMissingBean
    public ServerAuthenticationFailureHandler serverAuthenticationFailureHandler(ServerAuthenticationEntryPoint entryPoint) {
        return new ServerAuthenticationEntryPointFailureHandler(entryPoint);
    }

    @Bean
    @ConditionalOnMissingBean
    public ReactiveAuthenticationManager tokenReactiveAuthenticationManager(ReactiveAccessTokenValidator reactiveAccessTokenValidator) {
        return new TokenAuthenticationManager(reactiveAccessTokenValidator);
    }

    @Bean
    @ConditionalOnMissingBean
    public RemoteAccessTokenValidationStrategy remoteAccessTokenValidationStrategy(ReactiveTokenIntrospectionClient tokenIntrospectionClient,
                                                                                   ValidatedAccessTokenConverter<TokenIntrospectionResponse> accessTokenConverter) {
        return new SuiteClientRemoteAccessTokenValidationStrategy(tokenIntrospectionClient, accessTokenConverter);
    }

    @Bean
    public ReactiveAccessTokenValidator reactiveAccessTokenValidator(RemoteAccessTokenValidationStrategy validationStrategy) {
        return new RemoteReactiveAccessTokenValidator(validationStrategy);
    }

    @Bean
    @ConditionalOnMissingBean
    public ServerAuthenticationConverter serverAuthenticationConverter(AccessTokenExtractor extractor) {
        return new TokenServerAuthenticationConverter(extractor);
    }

    @Bean
    @ConditionalOnMissingBean
    public ValidatedAccessTokenConverter<TokenIntrospectionResponse> validatedAccessTokenConverter() {
        return new TokenIntrospectionResponse2ValidatedAccessTokenConverter();
    }
}
