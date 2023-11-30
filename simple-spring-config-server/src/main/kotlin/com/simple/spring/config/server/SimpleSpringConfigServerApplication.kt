package com.simple.spring.config.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer


@EnableConfigServer
@SpringBootApplication
class SimpleSpringConfigServerApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpringConfigServerApplication>(*args)
}
