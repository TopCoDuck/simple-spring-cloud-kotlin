package com.simple.mypage.service

import com.simple.mypage.config.ApiClient
import com.simple.mypage.config.ApiDomain.ORDER
import com.simple.mypage.model.OrderSummary
import org.springframework.stereotype.Service

@Service
class OrderService(private val apiClient: ApiClient) {
    fun findOrderSummaryList(userName: String, limit: Int) = apiClient.get(ORDER ,"/mypage/order-summary", OrderSummary::class.java)
}