package com.simple.order.service

import com.simple.order.exception.LackOfQuantityException
import com.simple.order.exception.NoHasItemException
import com.simple.order.repository.entity.CartItem
import com.simple.order.repository.entity.CartItemPk
import com.simple.order.repository.entity.Item
import com.simple.order.repository.CartItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrDefault
import kotlin.jvm.optionals.getOrNull

@Service
class CartItemService(
    private val cartItemRepository: CartItemRepository,
    private val itemService: ItemService
) {
    @Transactional
    fun addItem(cartItemPk: CartItemPk, quantity: Int) {
        val item: Item = itemService.findOne(cartItemPk.itemNo)
            ?: throw NoHasItemException("상품이 존재하지 않습니다.")

        if (item.stock < quantity) throw LackOfQuantityException("구매할 있는 수량을 초과했습니다.")

        var cartItem: CartItem? = cartItemRepository.findById(cartItemPk).getOrNull()
        if (cartItem != null) {
            cartItem.addAmount(quantity)
        } else {
            cartItem = CartItem(cartItemPk, quantity)
        }
        cartItemRepository.save(cartItem)
    }

    @Transactional
    fun changeAmount(cartItemPk: CartItemPk, quantity: Int) {
        val cartItem: CartItem = cartItemRepository.findById(cartItemPk)
            .getOrDefault(CartItem(cartItemPk, quantity))
        cartItemRepository.save(cartItem)
    }

    fun deleteItem(cartItemPks: List<CartItemPk>) {
        cartItemRepository.deleteAllById(cartItemPks)
    }

    fun deleteItem(cartItemPk: CartItemPk) {
        cartItemRepository.deleteById(cartItemPk)
    }

    fun getItemList(memberId: String): List<CartItem> {
        return cartItemRepository.findByCartItemPkUserId(memberId)
    }
}
