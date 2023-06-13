package com.odeyalo.sonata.suite.servlet.client

import com.odeyalo.sonata.common.authentication.dto.LoginCredentials
import com.odeyalo.sonata.common.authentication.dto.request.ConfirmationCodeRequestDto
import com.odeyalo.sonata.common.authentication.dto.request.UserRegistrationInfo
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse
import com.odeyalo.sonata.common.authentication.dto.response.EmailConfirmationStatusResponseDto
import com.odeyalo.sonata.common.authentication.dto.response.UserRegistrationConfirmationResponseDto
import com.odeyalo.sonata.common.authentication.exception.ConfirmationCodeException
import com.odeyalo.sonata.common.authentication.exception.LoginAuthenticationFailedException
import com.odeyalo.sonata.common.authentication.exception.RegistrationFailedException
import com.odeyalo.sonata.suite.servlet.servlet.StandardFeignConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * Client that used feign to communicate with Sonata-Authentication microservice
 */
@FeignClient(name = "sonata-authentication", configuration = [StandardFeignConfiguration::class])
interface AuthenticationClient {
    @PostMapping(
        value = ["/auth/login"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        LoginAuthenticationFailedException::class
    )
    fun login(@RequestBody credentials: LoginCredentials?): ResponseEntity<AuthenticationResultResponse?>?

    @PostMapping(
        value = ["/auth/confirm/email"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        RegistrationFailedException::class
    )
    fun confirmEmail(@RequestBody codeDto: ConfirmationCodeRequestDto?): ResponseEntity<EmailConfirmationStatusResponseDto?>?

    @PostMapping(
        value = ["/auth/signup"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        ConfirmationCodeException::class
    )
    fun registerUser(@RequestBody info: UserRegistrationInfo?): ResponseEntity<UserRegistrationConfirmationResponseDto?>?
}