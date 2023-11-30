package com.simple.order.repository

import com.simple.order.repository.entity.CartItem
import com.simple.order.repository.entity.CartItemPk
import org.springframework.data.jpa.repository.JpaRepository

interface CartItemRepository : JpaRepository<CartItem, CartItemPk> {
	fun  findByCartItemPkUserId(member: String) : List<CartItem>
}
