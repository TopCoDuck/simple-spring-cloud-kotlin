package com.simple.order.model

data class Payment (
     val paymentId: String? = null,
     val orderId: String? = null,
     val nameOnCard: String? = null,
     val cardNumber: String? = null,
     val expiration: Int = 0,
     val cvv: Int = 0,
     val totalSum: Int = 0,
)
