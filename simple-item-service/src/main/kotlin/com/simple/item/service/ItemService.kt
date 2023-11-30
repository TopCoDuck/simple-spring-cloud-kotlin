package com.simple.item.service

import com.simple.item.exception.HasNotItemException
import com.simple.item.model.ItemReq
import com.simple.item.repository.entity.Item
import com.simple.item.repository.ItemRepository
import com.simple.item.spec.ItemSpec
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

@Service
class ItemService(private val itemRepository: ItemRepository) {

    fun getItemList(searchType: String,
                    searchValue: String,
                    page: Int): Page<Item> =
        itemRepository.findAll(ItemSpec(searchType, searchValue), PageRequest.of(page, 10))

    fun getItem(itemId: Int): Item? =
        itemRepository.findById(itemId).getOrNull()

    fun createItem(itemReq: ItemReq)  =
        itemRepository.save(Item.create(itemReq))


    @Transactional
    fun modifyItem(itemNo: Int, itemReq: ItemReq) {
        val item = itemRepository.findById(itemNo).getOrElse { throw HasNotItemException("상품이 존재하지 않습니다.") }
        item.modify(itemReq)
        itemRepository.save(item)
    }

    fun deleteItem(itemId: Int) = itemRepository.deleteById(itemId)
}
