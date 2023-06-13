package com.odeyalo.sonata.suite.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SuiteReactiveApplication

fun main(args: Array<String>) {
    runApplication<SuiteReactiveApplication>(*args)
}
