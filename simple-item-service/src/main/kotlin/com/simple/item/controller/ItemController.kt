package com.simple.item.controller

import com.simple.item.model.ItemReq
import com.simple.item.service.ItemService
import org.springframework.web.bind.annotation.*

@RestController
class ItemController(private val itemService: ItemService,
    ) {
    @PostMapping("/item")
    fun createItem(itemReq: ItemReq): String {
        itemService.createItem(itemReq)
        return "상품 등록이 완료 되었습니다."
    }
    @PutMapping("/item/{itemNo}")
    fun modifyItem(@PathVariable itemNo: Int, itemReq: ItemReq): String {
        itemService.modifyItem(itemNo, itemReq)
        return "상품 수정이 완료 되었습니다."
    }

    @DeleteMapping("/item/{itemNo}")
    fun deleteItem(@PathVariable itemNo: Int): String {
        itemService.deleteItem(itemNo)
        return "상품이 삭제 되었습니다."
    }
}
