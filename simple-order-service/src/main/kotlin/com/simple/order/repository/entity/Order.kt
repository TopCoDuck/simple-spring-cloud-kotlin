package com.simple.order.repository.entity

import com.simple.order.model.OrderSummary
import jakarta.persistence.*
import java.math.BigInteger

@SqlResultSetMapping(
    name = "OrderSummaryMapping",
    classes = [ConstructorResult(
        targetClass = OrderSummary::class,
        columns = [ColumnResult(name = "orderId", type = BigInteger::class), ColumnResult(
            name = "userName",
            type = String::class
        ), ColumnResult(name = "sumTotal", type = BigInteger::class), ColumnResult(
            name = "representItemNm",
            type = String::class
        ), ColumnResult(name = "totalAmount", type = Int::class)]
    )]
)
@Entity
@SequenceGenerator(name = "ORDER_SEQ_GENERATOR", sequenceName = "ORDER_SEQ")
@Table(name = "ORDERS")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NAME")
    private var orderer: Member? = null

    @Embedded
    var receiverInfo: ReceiverInfo? = null
        private set

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var orderItems: List<OrderItem>? = null
    var sumTotal: Long = 0

    constructor(orderer: Member, receiverInfo: ReceiverInfo, orderItems: List<OrderItem>) {
        this.orderer = orderer
        this.receiverInfo = receiverInfo
        this.orderItems = orderItems
        for (orderItem in orderItems) {
            orderItem.addOrder(this)
        }
        this.sumTotal = caculate(orderItems)
    }

    private fun caculate(orderItems: List<OrderItem>) =
        orderItems.sumOf { it.amount * it.orderPrice  }
}
