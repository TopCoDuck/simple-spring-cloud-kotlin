package com.simple.spring.eureka.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class SimpleSpringEurekaServerApplication

fun main(args: Array<String>) {
    runApplication<SimpleSpringEurekaServerApplication>(*args)
}