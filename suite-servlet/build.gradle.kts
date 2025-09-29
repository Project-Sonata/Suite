plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.jetbrains.kotlin.kotlin.reflect)
    api(libs.org.jetbrains.kotlin.kotlin.stdlib)
    api(libs.org.projectlombok.lombok)
    api(libs.com.odeyalo.sonata.suite)
    api(libs.org.springframework.cloud.spring.cloud.starter.openfeign)
    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
}

group = "com.odeyalo.sonata.suite"
version = "0.0.2-SNAPSHOT"
description = "suite-servlet"

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
