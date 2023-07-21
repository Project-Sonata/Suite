package com.odeyalo.suite.security.annotation;

import com.odeyalo.suite.security.config.SuiteSecurityAutoConfiguration;
import com.odeyalo.suite.security.config.SuiteSecurityConfigurationImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
@Import(SuiteSecurityAutoConfiguration.class)
public @interface EnableSuiteSecurity {
}
