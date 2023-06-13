package com.odeyalo.sonata.suite.servlet.servlet

import com.fasterxml.jackson.databind.ObjectMapper
import com.odeyalo.sonata.common.authentication.AuthenticationErrorCodes
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse
import com.odeyalo.sonata.common.authentication.exception.InvalidCredentialsException
import com.odeyalo.sonata.common.shared.GenericApiException
import feign.Response
import feign.codec.ErrorDecoder

class StandardServletSonataResponseErrorDecoder(private val objectMapper: ObjectMapper) : ErrorDecoder {

    override fun decode(s: String, response: Response): Exception {
        val error = objectMapper.readValue(response.body().asInputStream(), AuthenticationResultResponse::class.java)
        when (error.errorDetails.code) {
            AuthenticationErrorCodes.INVALID_CREDENTIALS -> return InvalidCredentialsException(error.errorDetails)
        }
        return GenericApiException(error.errorDetails)
    }
}