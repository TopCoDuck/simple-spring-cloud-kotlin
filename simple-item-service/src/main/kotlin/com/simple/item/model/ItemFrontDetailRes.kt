package com.simple.item.model

import com.simple.item.repository.entity.Item

data class ItemFrontDetailRes(val itemNo: Int,
                              val itemNm: String,
                              val itemDesc: String,
                              val stock: Int,
                              val price: Int,
                              val reviews: List<Review>,
) {
    companion object {
        fun covert (item: Item, reviews: List<Review>) : ItemFrontDetailRes {
            return ItemFrontDetailRes(
                itemNo = item.itemNo,
                itemNm = item.itemNm,
                itemDesc = item.itemDesc,
                stock = item.stock,
                price = item.price,
                reviews = reviews,
            )
        }
    }
}

