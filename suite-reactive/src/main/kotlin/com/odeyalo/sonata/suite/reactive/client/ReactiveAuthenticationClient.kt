package com.odeyalo.sonata.suite.reactive.client

import com.odeyalo.sonata.suite.reactive.config.ReactiveFeignConfiguration
import com.odeyalo.sonata.common.authentication.dto.LoginCredentials
import com.odeyalo.sonata.common.authentication.dto.request.ConfirmationCodeRequestDto
import com.odeyalo.sonata.common.authentication.dto.request.UserRegistrationInfo
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse
import com.odeyalo.sonata.common.authentication.dto.response.EmailConfirmationStatusResponseDto
import com.odeyalo.sonata.common.authentication.dto.response.UserRegistrationConfirmationResponseDto
import com.odeyalo.sonata.common.authentication.exception.ConfirmationCodeException
import com.odeyalo.sonata.common.authentication.exception.LoginAuthenticationFailedException
import com.odeyalo.sonata.common.authentication.exception.RegistrationFailedException
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

@ReactiveFeignClient(name = "sonata-authentication", configuration = [ReactiveFeignConfiguration::class])
interface ReactiveAuthenticationClient {
    @PostMapping(
        value = ["/auth/login"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        LoginAuthenticationFailedException::class
    )
    fun login(@RequestBody credentials: LoginCredentials?): Mono<ResponseEntity<Mono<AuthenticationResultResponse?>?>?>?

    @PostMapping(
        value = ["/auth/confirm/email"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        ConfirmationCodeException::class
    )
    fun confirmEmail(@RequestBody codeDto: ConfirmationCodeRequestDto?): Mono<ResponseEntity<Mono<EmailConfirmationStatusResponseDto?>?>?>?

    @PostMapping(
        value = ["/auth/signup"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        RegistrationFailedException::class
    )
    fun registerUser(@RequestBody info: UserRegistrationInfo?): Mono<ResponseEntity<Mono<UserRegistrationConfirmationResponseDto?>?>?>?
}