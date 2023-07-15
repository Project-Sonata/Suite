package com.odeyalo.sonata.suite.reactive.config;

import com.odeyalo.sonata.suite.reactive.exception.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorCodeConvertersConfiguration {

    @Bean
    public InvalidNewPasswordErrorCode2ThrowableConverter invalidNewPasswordErrorCode2ThrowableConverter() {
        return new InvalidNewPasswordErrorCode2ThrowableConverter();
    }

    @Bean
    public InvalidOldPasswordErrorCode2ThrowableConverter invalidOldPasswordErrorCode2ThrowableConverter() {
        return new InvalidOldPasswordErrorCode2ThrowableConverter();
    }

    @Bean
    public EmailAlreadyTakenErrorCode2ThrowableConverter emailAlreadyTakenErrorCode2ThrowableConverter() {
        return new EmailAlreadyTakenErrorCode2ThrowableConverter();
    }

    @Bean
    public EmailConfirmationRequiredErrorCode2ThrowableConverter emailConfirmationRequiredErrorCode2ThrowableConverter() {
        return new EmailConfirmationRequiredErrorCode2ThrowableConverter();
    }

    @Bean
    public InvalidEmailErrorCode2ThrowableConverter invalidEmailErrorCode2ThrowableConverter() {
        return new InvalidEmailErrorCode2ThrowableConverter();
    }

    @Bean
    public InvalidPasswordErrorCode2ThrowableConverter invalidPasswordErrorCode2ThrowableConverter() {
        return new InvalidPasswordErrorCode2ThrowableConverter();
    }
}
