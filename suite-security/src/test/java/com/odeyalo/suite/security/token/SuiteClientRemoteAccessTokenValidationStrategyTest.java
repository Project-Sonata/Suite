package com.odeyalo.suite.security.token;

import com.odeyalo.sonata.suite.reactive.annotation.EnableSuiteReactive;
import com.odeyalo.suite.security.auth.token.SuiteClientRemoteAccessTokenValidationStrategy;
import com.odeyalo.suite.security.auth.token.ValidatedAccessToken;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Hooks;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.REMOTE;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureStubRunner(stubsMode = REMOTE,
        repositoryRoot = "git://https://github.com/Project-Sonata/Sonata-Contracts.git",
        ids = "com.odeyalo.sonata:authorization:+:stubs:${stubrunner.runningstubs.authorization.port}")
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
@EnableSuiteReactive
class SuiteClientRemoteAccessTokenValidationStrategyTest {

    @Autowired
    SuiteClientRemoteAccessTokenValidationStrategy validationStrategy;

    public static final String VALID_ACCESS_TOKEN = "mikunakanoisthebestgirl";

    String[] predefinedScopes = {"user-account-modify", "write"};

    @BeforeAll
    void setup() {
        Hooks.onOperatorDebug();
    }

    @Test
    void validateValidAccessToken_andExpectNotNull() {
        ValidatedAccessToken result = validationStrategy.validateAccessToken(VALID_ACCESS_TOKEN).block();
        assertNotNull(result, "Result must be not null!");
    }

    @Test
    void validateValidAccessToken_andExpectValidTrue() {
        ValidatedAccessToken result = validationStrategy.validateAccessToken(VALID_ACCESS_TOKEN).block();
        assertTrue(result.isValid(), "If token is valid, then true must be returned!");
    }

    @Test
    void validateValidAccessToken_andExpectNotNullToken() {
        ValidatedAccessToken result = validationStrategy.validateAccessToken(VALID_ACCESS_TOKEN).block();
        assertNotNull(result.getToken(), "The token metadata must be not null!");
    }

    @Test
    void validateValidAccessToken_andExpectScopesInMedata() {
        ValidatedAccessToken result = validationStrategy.validateAccessToken(VALID_ACCESS_TOKEN).block();
        List<String> expectedScopes = List.of(predefinedScopes);
        List<String> actualScopes = List.of(result.getToken().getScopes());
        assertTrue(expectedScopes.size() == actualScopes.size()
                && expectedScopes.containsAll(actualScopes) &&
                actualScopes.containsAll(expectedScopes));
    }

    @Test
    void validateInvalidAccessToken_andExpectNull() {
        ValidatedAccessToken token = validationStrategy.validateAccessToken("invalidtoken").block();
        assertEquals(ValidatedAccessToken.invalid(), token, "Token must be equal to invalid one!");
    }
}