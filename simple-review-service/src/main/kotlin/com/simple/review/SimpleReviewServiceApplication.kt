package com.simple.review

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class SimpleReviewServiceApplication


fun main(args: Array<String>) {
    runApplication<SimpleReviewServiceApplication>(*args)
}
