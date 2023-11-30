package com.simple.order.config

import com.simple.order.exception.ApiHostNotFoundException
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(value = "simple-order")
class ApiHostHolder () {
     lateinit var apiHosts: Map<String, String>

     operator fun get(apiDomain: ApiDomain): String {
        return apiHosts[apiDomain.domain] ?: throw ApiHostNotFoundException()
    }
}