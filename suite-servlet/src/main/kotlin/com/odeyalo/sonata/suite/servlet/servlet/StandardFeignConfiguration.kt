package com.odeyalo.sonata.suite.servlet.servlet

import com.fasterxml.jackson.databind.ObjectMapper
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean

class StandardFeignConfiguration {
    @Bean
    fun errorDecoder(mapper: ObjectMapper): ErrorDecoder {
        return StandardServletSonataResponseErrorDecoder(mapper)
    }
}