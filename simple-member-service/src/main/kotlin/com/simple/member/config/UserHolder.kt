package com.simple.member.config

import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
class UserHolder {
    var userId: String? = null

    fun init(userId: String) {
        this.userId = userId
    }
}
