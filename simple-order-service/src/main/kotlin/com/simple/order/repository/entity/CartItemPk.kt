package com.simple.order.repository.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class CartItemPk(val userId: String,
                      val itemNo: Int,
    ) : Serializable
