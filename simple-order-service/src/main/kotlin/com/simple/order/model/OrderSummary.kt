package com.simple.order.model

data class OrderSummary(
    val orderId: Long,
    val userName: String,
    val sumTotal: Long,
    val representItemNm: String,
    val totalAmount: Int
)
