package com.simple.mypage.config

import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class ApiClient(private val apiHostHolder:ApiHostHolder, private val restTemplate:RestTemplate) {

    fun <T> get(apiDomain: ApiDomain,uri: String, responseType: Class<T>): T? {
        return restTemplate.getForObject(apiHostHolder[apiDomain] + uri, responseType)
    }
}