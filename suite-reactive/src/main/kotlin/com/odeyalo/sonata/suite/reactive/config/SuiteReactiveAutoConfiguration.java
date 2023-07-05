package com.odeyalo.sonata.suite.reactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = {ExceptionDecodersRegistryConfiguration.class, ErrorCodeConvertersConfiguration.class})
@Configuration
public class SuiteReactiveAutoConfiguration {

}
