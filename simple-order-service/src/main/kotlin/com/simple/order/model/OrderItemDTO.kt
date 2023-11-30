package com.simple.order.model

data class OrderItemDTO(
     val itemNo: Int,
     val itemNm: String,
     val amount: Int,
     val orderPrice: Long
)
