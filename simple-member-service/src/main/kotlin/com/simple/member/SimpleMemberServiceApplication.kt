package com.simple.member

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleMemberServiceApplication

fun main(args: Array<String>) {
    runApplication<SimpleMemberServiceApplication>(*args)
}
