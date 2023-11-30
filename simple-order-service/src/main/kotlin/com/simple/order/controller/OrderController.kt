package com.simple.order.controller


import com.simple.order.CurrentUser
import com.simple.order.repository.entity.Member
import com.simple.order.model.OrderedItemList
import com.simple.order.model.Payment
import com.simple.order.repository.entity.ReceiverInfo
import com.simple.order.repository.OrderViewRepository
import com.simple.order.service.MemberService
import com.simple.order.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController(private val memberService: MemberService,
                      private val orderService: OrderService,
                      private val orderViewRepository: OrderViewRepository,
    ) {

    @PostMapping("/order/check")
    fun orderCheck(reqItemList: OrderedItemList) {
    }

    @PostMapping("/order/page")
    fun orderPage(): Map<String, Any> {
        print("test")
        val result: MutableMap<String, Any> = HashMap()
        val member: Member = memberService.getMember(CurrentUser.userName)
        result["userInfo"] = member
        return result
    }

    @PostMapping("/order/purchase")
    fun purchase(receiverInfo: ReceiverInfo,
                 orderedItems: OrderedItemList,
                 payment: Payment
    ) {
        orderService.purchase(
            CurrentUser.userName, receiverInfo, orderedItems.orderedItems, payment
        )
    }

    @GetMapping("/orders/{orderId}")
    fun getOrderDetail(@PathVariable orderId: Long): Map<String, Any> {
        val result: MutableMap<String, Any> = HashMap()
        result["order"] = orderService.getOrder(orderId)
        result["orderItems"] = orderViewRepository.findOrderItemDetail(orderId)
        return result
    }
}
