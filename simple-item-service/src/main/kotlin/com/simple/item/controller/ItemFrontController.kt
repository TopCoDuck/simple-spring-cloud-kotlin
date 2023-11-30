package com.simple.item.controller

import com.simple.item.exception.HasNotItemException
import com.simple.item.model.ItemFrontDetailRes
import com.simple.item.model.ItemFrontDetailRes.Companion.covert
import com.simple.item.service.ItemService
import com.simple.item.service.ReviewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Deprecated("차후 display-api 만들어서 구현하기")
@RestController
class ItemFrontController (private val itemService: ItemService,
                           private val reviewService: ReviewService,
    ){

    @GetMapping("/item/{itemNo}/front")
    fun getItemDetail(@PathVariable itemNo: Int): ItemFrontDetailRes {
        val item = itemService.getItem(itemNo) ?: throw HasNotItemException("상품이 존재하지 않습니다.")
        val reviews = reviewService.findByItemCd(itemNo)

        return covert(item, reviews)
    }

    @GetMapping("/items/front")
    fun getList(
        @RequestParam(defaultValue = "ALL") searchType: String,
        @RequestParam(defaultValue = "") searchValue: String,
        @RequestParam(defaultValue = "0") page: Int,
    ) = itemService.getItemList(searchType, searchValue, page)
}
