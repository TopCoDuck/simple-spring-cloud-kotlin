package com.simple.order.service

import com.simple.order.config.ApiClient
import com.simple.order.config.ApiDomain
import com.simple.order.repository.entity.Item
import org.springframework.stereotype.Service

@Service
class ItemService(private val apiClient: ApiClient) {
    fun findOne(itemNo: Int): Item? =
        apiClient.get(ApiDomain.ITEM, "/member/${itemNo}", Item::class.java)
}