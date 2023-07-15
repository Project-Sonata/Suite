package com.odeyalo.sonata.suite.reactive.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odeyalo.sonata.suite.reactive.exception.converter.ErrorCode2ThrowableConverter;
import com.odeyalo.sonata.suite.reactive.exception.converter.ErrorCodeConvertersRegistry;
import com.odeyalo.sonata.suite.reactive.exception.converter.MapErrorCodeConvertersContainer;
import com.odeyalo.sonata.suite.reactive.exception.decoder.AuthClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.DetaultReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.ReactiveFeignClientMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.impl.AuthClientConfirmationMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.impl.AuthClientLoginMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.impl.AuthClientRegistrationMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.impl.DefaultMethodExceptionHandlerDecoder;
import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderContainer;
import com.odeyalo.sonata.suite.reactive.exception.decoder.registry.ClientMethodExceptionHandlerDecoderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ExceptionDecodersRegistryConfiguration {

    @Bean
    public AuthClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder authClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        return new AuthClientPasswordChangeReactiveFeignClientMethodExceptionHandlerDecoder(mapper);
    }

    @Bean
    public ErrorCodeConvertersRegistry errorCodeConvertersRegistry(List<ErrorCode2ThrowableConverter> converters) {
        return new MapErrorCodeConvertersContainer(converters);
    }

    @Bean
    public DetaultReactiveFeignClientMethodExceptionHandlerDecoder detaultReactiveFeignClientMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        return new DefaultMethodExceptionHandlerDecoder(mapper);
    }

    @Bean
    public AuthClientLoginMethodExceptionHandlerDecoder authClientLoginMethodExceptionHandlerDecoder(ObjectMapper mapper,
                                                                                                     ErrorCodeConvertersRegistry registry) {
        return new AuthClientLoginMethodExceptionHandlerDecoder(mapper, registry);
    }

    @Bean
    public AuthClientRegistrationMethodExceptionHandlerDecoder authClientRegistrationMethodExceptionHandlerDecoder(ObjectMapper mapper,
                                                                                                                   ErrorCodeConvertersRegistry registry) {
        return new AuthClientRegistrationMethodExceptionHandlerDecoder(mapper, registry);
    }

    @Bean
    public AuthClientConfirmationMethodExceptionHandlerDecoder authClientConfirmationMethodExceptionHandlerDecoder(ObjectMapper mapper) {
        return new AuthClientConfirmationMethodExceptionHandlerDecoder(mapper);
    }

    @Bean
    public ClientMethodExceptionHandlerDecoderRegistry clientMethodExceptionHandlerDecoderRegistry(List<ReactiveFeignClientMethodExceptionHandlerDecoder> decodersList,
                                                                                                   DetaultReactiveFeignClientMethodExceptionHandlerDecoder defaultHandler) {
        return new ClientMethodExceptionHandlerDecoderContainer(decodersList, defaultHandler);
    }
}
