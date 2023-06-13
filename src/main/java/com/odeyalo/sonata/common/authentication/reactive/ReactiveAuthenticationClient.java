package com.odeyalo.sonata.common.authentication.reactive;

import com.odeyalo.sonata.common.authentication.config.reactive.ReactiveFeignConfiguration;
import com.odeyalo.sonata.common.authentication.dto.LoginCredentials;
import com.odeyalo.sonata.common.authentication.dto.request.ConfirmationCodeRequestDto;
import com.odeyalo.sonata.common.authentication.dto.request.UserRegistrationInfo;
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse;
import com.odeyalo.sonata.common.authentication.dto.response.EmailConfirmationStatusResponseDto;
import com.odeyalo.sonata.common.authentication.dto.response.UserRegistrationConfirmationResponseDto;
import com.odeyalo.sonata.common.authentication.exception.ConfirmationCodeException;
import com.odeyalo.sonata.common.authentication.exception.LoginAuthenticationFailedException;
import com.odeyalo.sonata.common.authentication.exception.RegistrationFailedException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "sonata-authentication", configuration = ReactiveFeignConfiguration.class)
public interface ReactiveAuthenticationClient {

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<Mono<AuthenticationResultResponse>>> login(@RequestBody LoginCredentials credentials) throws LoginAuthenticationFailedException;

    @PostMapping(value = "/auth/confirm/email", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<Mono<EmailConfirmationStatusResponseDto>>> confirmEmail(@RequestBody ConfirmationCodeRequestDto codeDto) throws ConfirmationCodeException;

    @PostMapping(value = "/auth/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ResponseEntity<Mono<UserRegistrationConfirmationResponseDto>>> registerUser(@RequestBody UserRegistrationInfo info) throws RegistrationFailedException;
}