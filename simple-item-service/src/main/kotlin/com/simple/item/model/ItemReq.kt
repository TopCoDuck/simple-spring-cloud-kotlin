package com.simple.item.model

data class ItemReq(
    val itemNo: Int = 0,
    val categoryCd: String?,
    val itemNm: String,
    val itemDesc: String,
    val stock: Int,
    val price: Int,
    val hashTageCds: Set<String>? = HashSet(),
)