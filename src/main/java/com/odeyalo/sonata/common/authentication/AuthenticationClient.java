package com.odeyalo.sonata.common.authentication;

import com.odeyalo.sonata.common.authentication.dto.LoginCredentials;
import com.odeyalo.sonata.common.authentication.dto.request.ConfirmationCodeRequestDto;
import com.odeyalo.sonata.common.authentication.dto.request.UserRegistrationInfo;
import com.odeyalo.sonata.common.authentication.dto.response.AuthenticationResultResponse;
import com.odeyalo.sonata.common.authentication.dto.response.EmailConfirmationStatusResponseDto;
import com.odeyalo.sonata.common.authentication.dto.response.UserRegistrationConfirmationResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8888/auth")
public interface AuthenticationClient {

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AuthenticationResultResponse> login(@RequestBody LoginCredentials credentials);

    @PostMapping(value = "/confirm/email", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmailConfirmationStatusResponseDto> confirmEmail(@RequestBody ConfirmationCodeRequestDto codeDto);

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserRegistrationConfirmationResponseDto> registerUser(@RequestBody UserRegistrationInfo info);
}
