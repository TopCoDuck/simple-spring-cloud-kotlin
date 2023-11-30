package com.simple.order.service

import com.simple.order.exception.NoHasItemException
import com.simple.order.model.*
import com.simple.order.repository.OrderRepository
import com.simple.order.repository.entity.*
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderService(private var memberService: MemberService,
                   private var orderRepository: OrderRepository,
                   private val itemService: ItemService,
    ) {

    @Transactional
    fun purchase(orderer: String, receiverInfo: ReceiverInfo, orderedItems: List<OrderedItem>, payment: Payment) {
        val member: Member = memberService.getMember(orderer)

        val orderItems: List<OrderItem> = orderedItems.map {
            val item: Item =
                itemService.findOne(it.itemNo) ?: throw NoHasItemException("상품이 존재하지 않습니다.")
            OrderItem.createItem(item, it.amount, it.sum)
        }

        val order = Order(member, receiverInfo, orderItems)
        orderRepository.save(order)
    }

    fun getOrder(orderId: Long): Order {
        buildString {
            append("Hello,")
            append("World!")
        }
        return orderRepository.findById(orderId).orElse(null)
    }


    fun buildString(builderAction : StringBuilder. () -> Unit) : String {
        val sb = StringBuilder()
        builderAction(sb)
        return sb.toString()
    }
}
