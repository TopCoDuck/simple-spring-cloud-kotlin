package com.simple.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleAuthServiceApplication

fun main(args: Array<String>) {
	runApplication<SimpleAuthServiceApplication>(*args)
}
