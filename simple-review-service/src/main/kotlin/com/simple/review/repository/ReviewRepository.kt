package com.simple.review.repository

import com.simple.review.repository.entity.Review
import org.springframework.data.jpa.repository.JpaRepository


/**
 * 리뷰 repository
 * @author us
 */
interface ReviewRepository : JpaRepository<Review, Int> {
    fun findByItemNo(itemNo: Int): List<Review>
}
