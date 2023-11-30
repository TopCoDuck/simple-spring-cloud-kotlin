package com.simple.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleOrderServiceApplication

fun main(args: Array<String>) {
    runApplication<SimpleOrderServiceApplication>(*args)
}
