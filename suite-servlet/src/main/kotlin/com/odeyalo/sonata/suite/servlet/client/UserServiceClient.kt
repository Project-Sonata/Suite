package com.odeyalo.sonata.suite.servlet.client

import com.odeyalo.sonata.common.user.dto.CreateUserPayloadDto
import com.odeyalo.sonata.common.user.exception.UserRegistryException
import com.odeyalo.sonata.suite.servlet.servlet.StandardFeignConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

/**
 * Feign client to send request to User Microservice
 */
@FeignClient(name = "sonata-users", configuration = [StandardFeignConfiguration::class])
interface UserServiceClient {

    @PostMapping(
        value = ["/users"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @Throws(
        UserRegistryException::class
    )
    fun createUser(@RequestBody userPayload: CreateUserPayloadDto): ResponseEntity<Void>

}