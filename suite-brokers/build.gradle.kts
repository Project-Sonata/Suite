plugins {
    `java-library`
    `maven-publish`
}

dependencies {
    api(libs.org.projectlombok.lombok)
    api(libs.com.odeyalo.sonata.suite)
    annotationProcessor(libs.org.projectlombok.lombok)
}

group = "com.odeyalo.sonata.suite"
version = "0.0.9"
description = "suite-brokers"

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
