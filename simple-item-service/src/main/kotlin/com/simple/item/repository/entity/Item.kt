package com.simple.item.repository.entity

import com.simple.item.model.ItemReq
import jakarta.persistence.*

@Entity
@Table(name = "item")
class Item (
    @Id
    var itemNo: Int,

    @ManyToOne
    @JoinColumn(name = "category_cd")
    var category: Category?,
    var itemNm: String,
    var itemDesc: String,
    var stock: Int,
    var price: Int,

    @ManyToMany
    @JoinTable(
        name = "hash_join",
        joinColumns = [JoinColumn(name = "item_no")],
        inverseJoinColumns = [JoinColumn(name = "hash_cd")]
    )
    var hashTage: Set<HashTag>? = HashSet(),
) {

    companion object {
        fun create (itemReq: ItemReq) : Item =
             Item(itemNo = 0,
                category = null,
                itemNm = itemReq.itemNm,
                itemDesc = itemReq.itemDesc,
                stock = itemReq.stock,
                price = itemReq.price,
                hashTage = HashSet())

    }

    fun modify(itemReq: ItemReq) {
        itemNm = itemReq.itemNm
        itemDesc = itemReq.itemDesc
        stock = itemReq.stock
        price = itemReq.price
    }
}

