package com.simple.review.filter

import com.simple.review.config.UserHolder
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.HandlerInterceptor
@Configuration
class AuthInterceptor(private val userHolder: UserHolder): HandlerInterceptor {
    override fun  preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any)  : Boolean {
        userHolder.init("test1") //TODO: 향후 실제 값을 가져올 수 있게 변경
        return true
    }
}
