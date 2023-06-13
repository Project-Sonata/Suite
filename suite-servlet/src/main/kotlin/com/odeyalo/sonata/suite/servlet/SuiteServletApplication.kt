package com.odeyalo.sonata.suite.servlet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SuiteServletApplication

fun main(args: Array<String>) {
    runApplication<SuiteServletApplication>(*args)
}
