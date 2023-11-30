package com.simple.mypage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


@EnableDiscoveryClient
@SpringBootApplication
class SimpleMypageServiceApplication {
    @LoadBalanced
    @Bean
    fun restTemplate(): RestTemplate {
        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setConnectTimeout(5000)
        return RestTemplate(factory)
    }
}

fun main(args: Array<String>) {
    runApplication<SimpleMypageServiceApplication>(*args)
}