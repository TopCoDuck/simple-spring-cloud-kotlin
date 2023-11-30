package com.simple.order.controller

import com.simple.order.CurrentUser
import com.simple.order.repository.entity.CartItemPk
import com.simple.order.service.CartItemService
import org.springframework.web.bind.annotation.*

@RestController
class CartController(private val cartItemService: CartItemService) {

    @PostMapping("/cart")
    fun addItem(itemCd: Int, quantity: Int): String {
        cartItemService.addItem(CartItemPk(CurrentUser.userName, itemCd), quantity)
        return "장바구니에 추가 되었습니다."
    }

    @PutMapping("/cart/change-amount")
    fun changeAmount(itemCd: Int, quantity: Int): String {
        cartItemService.changeAmount(CartItemPk(CurrentUser.userName, itemCd), quantity)
        return "수량이 변경 되었습니다."
    }

    @DeleteMapping("/cart/{itemCd}")
    fun deleteItem(@PathVariable itemCd: Int): String {
        cartItemService.deleteItem(CartItemPk(CurrentUser.userName, itemCd))
        return "장바구니에서 삭제 되었습니다."
    }

    @GetMapping("/cart")
    fun cartItemList(memberId: String) =
        cartItemService.getItemList(memberId)
}
