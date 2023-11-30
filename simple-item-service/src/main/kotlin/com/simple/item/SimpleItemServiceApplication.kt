package com.simple.item

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleItemServiceApplication

fun main(args: Array<String>) {
    runApplication<SimpleItemServiceApplication>(*args)
}
