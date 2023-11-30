package com.simple.api.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SimpleApiGatewayApplication

fun main(args: Array<String>) {
	runApplication<SimpleApiGatewayApplication>(*args)
}
