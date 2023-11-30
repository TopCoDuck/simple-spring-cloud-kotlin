package com.simple.mail

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleMailServiceApplication

fun main(args: Array<String>) {
    runApplication<SimpleMailServiceApplication>(*args)
}
