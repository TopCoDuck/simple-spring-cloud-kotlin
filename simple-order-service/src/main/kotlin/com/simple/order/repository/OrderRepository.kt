package com.simple.order.repository

import com.simple.order.repository.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
    //	@Query("select o from Order o where o.orderer.userName = :userName")
    //	List<Order> findByUserName(@Param("userName") String userName,Pageable pageable);
}
