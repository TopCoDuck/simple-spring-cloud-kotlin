package com.simple.order.repository.entity


data class CartView (
    var itemNo: Int? = null,
    var itemNm: String? = null,
    val amount:Int = 0,
)
