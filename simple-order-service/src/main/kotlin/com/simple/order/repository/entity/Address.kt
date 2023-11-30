package com.simple.order.repository.entity

import jakarta.persistence.Embeddable


@Embeddable
data class Address (
     val addressCode: String? = null,
     val addressInfo: String? = null,
     val addressInfoDesc: String? = null,
)

