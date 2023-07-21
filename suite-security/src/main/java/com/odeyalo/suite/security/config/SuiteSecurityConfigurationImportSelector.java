package com.odeyalo.suite.security.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class SuiteSecurityConfigurationImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                SuiteSecurityAutoConfiguration.class.getName()
        };
    }
}
