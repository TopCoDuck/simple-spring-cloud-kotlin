package com.simple.item.service

import com.simple.item.model.Review
import org.springframework.stereotype.Service

@Service
class ReviewService {
    fun findByItemCd(itemCd: Int): List<Review> = emptyList()
}