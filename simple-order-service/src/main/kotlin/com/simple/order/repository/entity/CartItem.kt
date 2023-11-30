package com.simple.order.repository.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table
class CartItem (
    @EmbeddedId
    var cartItemPk: CartItemPk? = null,
    var amount: Int = 0,
) {
    fun addAmount(quantity: Int) {
        amount += quantity
    }
}
