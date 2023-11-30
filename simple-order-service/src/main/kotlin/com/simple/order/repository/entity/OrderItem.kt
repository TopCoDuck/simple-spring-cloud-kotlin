package com.simple.order.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

/**
 * ������ ���������� ���
 * @author us
 */
@Entity
class OrderItem (
    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
     var order: Order? = null,

    var itemNo: Int? = null,
    var amount: Int = 0,
    var orderPrice: Long = 0,
) {

    fun addOrder(order: Order) {
        this.order = order
    }

    companion object {
        fun createItem(item: Item, amount: Int, orderPrice: Long): OrderItem {
            val orderItem = OrderItem()
            orderItem.itemNo = item.itemNo
            orderItem.amount = amount
            orderItem.orderPrice = orderPrice
            //item.removeStock(amount)
            return orderItem
        }
    }
}
