package com.odeyalo.sonata.suite.reactive.annotation;

import com.odeyalo.sonata.suite.reactive.config.SuiteReactiveAutoConfiguration;
import org.springframework.context.annotation.Import;
import reactivefeign.spring.config.EnableReactiveFeignClients;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Enable the reactive-suite module, import all necessary configs, enable reactive feign clients
 */
@Retention(RUNTIME)
@Target(TYPE)
@Import(SuiteReactiveAutoConfiguration.class)
@EnableReactiveFeignClients(basePackages = "com.odeyalo.sonata.suite.reactive")
public @interface EnableSuiteReactive {
}
