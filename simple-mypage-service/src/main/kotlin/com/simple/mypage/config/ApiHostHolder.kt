package com.simple.mypage.config

import com.simple.mypage.exception.ApiHostNotFoundException
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(value = "simple-mypage")
class ApiHostHolder () {
     lateinit var apiHosts: Map<String, String>

     operator fun get(apiDomain: ApiDomain): String {
        return apiHosts[apiDomain.domain] ?: throw ApiHostNotFoundException()
    }
}