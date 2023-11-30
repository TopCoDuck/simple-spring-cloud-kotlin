package com.simple.review.service

import com.simple.review.model.ReviewReq
import com.simple.review.repository.ReviewRepository
import com.simple.review.repository.entity.Review
import org.springframework.stereotype.Service

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {

    fun findByItemNo(itemNo: Int): List<Review> {
        return reviewRepository.findByItemNo(itemNo)
    }

    fun createReview(reviewReq: ReviewReq) {
        val review = Review(reviewReq.comments, reviewReq.itemNo)
        reviewRepository.save(review)
    }

    fun modifyReview(reviewSeq: Int, reviewReq: ReviewReq) {
        val review = reviewRepository.findById(reviewSeq)
            .orElseThrow { RuntimeException("해당 리뷰가 존재하지 않습니다.") }
            .apply {
                comments = reviewReq.comments
            }

        reviewRepository.save(review)
    }

    fun deleteReview(reviewSeq: Int) {
        reviewRepository.deleteById(reviewSeq)
    }
}
