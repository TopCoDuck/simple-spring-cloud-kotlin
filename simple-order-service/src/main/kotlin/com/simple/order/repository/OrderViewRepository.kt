package com.simple.order.repository

import com.simple.order.model.OrderItemDTO
import com.simple.order.model.OrderSummary
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.TypedQuery
import jakarta.persistence.Query
import org.springframework.stereotype.Repository

@Repository
class OrderViewRepository(
    @PersistenceContext
    private val em: EntityManager
){

    private val orderSummaryMappingSql =
        ("""SELECT
                 o.ORDER_ID AS orderId, o.USER_ID AS userId , o.SUM_TOTAL AS sumTotal, 					   
                 MAX(i.ITEM_NM) AS  representItemNm, SUM(oi.AMOUNT)  AS totalAmount                             
                FROM (                                                                                          
                  SELECT                                                                                        
                   *                                                                                            
                  FROM (                                                                                        
                    SELECT                                                                                      
                     o.ORDER_ID , o.USER_ID , o.SUM_TOTAL                                                     
                    FROM ORDERS o                                                                               
                    WHERE USER_ID = ?                                                                  	   
                    ORDER BY ORDER_ID DESC                                                                      
                  ) WHERE ROWNUM <= ?                                                                           
                ) o , ORDER_ITEM oi , ITEM i                                                                    
                WHERE o.ORDER_ID = oi.ORDER_ID                                                                  
                  AND oi.ITEM_NO = i.ITEM_NO                                                                    
                GROUP BY o.ORDER_ID , o.USER_ID , o.SUM_TOTAL                                                 """)

    fun findOrderSummaryList(userId: String, limit: Int): List<OrderSummary> {
        val nativeQuery: Query = em.createNativeQuery(orderSummaryMappingSql, "OrderSummaryMapping")
        nativeQuery.setParameter(1, userId)
        nativeQuery.setParameter(2, limit)
        return nativeQuery.resultList as List<OrderSummary>
    }

    private val orderItemDTOSql =
        ("""SELECT  new com.example.order.model.OrderItemDTO(i.itemNo , i.itemNm  , oi.amount , oi.orderPrice) 
                    FROM OrderItem oi join oi.item i 
                    WHERE oi.order.id = :orderId""")

    fun findOrderItemDetail(orderId: Long): List<OrderItemDTO> {
        val query: TypedQuery<OrderItemDTO> = em.createQuery(orderItemDTOSql, OrderItemDTO::class.java)
        query.setParameter("orderId", orderId)
        return query.resultList
    }
}
