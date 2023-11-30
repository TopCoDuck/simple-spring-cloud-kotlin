package com.simple.review.controller

import com.simple.review.model.ReviewReq
import com.simple.review.service.ReviewService
import org.springframework.web.bind.annotation.*

@RestController
class ReviewController (private val reviewService: ReviewService) {

    @GetMapping("/reviews/{itemNo}")
    fun getReviews(@PathVariable itemNo: Int) =
        reviewService.findByItemNo(itemNo)

    @PostMapping("/review")
    fun createReview(reviewReq: ReviewReq): String {
        reviewService.createReview(reviewReq)
        return "댓글이 등록되었습니다."
    }

    @PutMapping("/review/{reviewSeq}")
    fun modifyReview(@PathVariable reviewSeq: Int, reviewReq: ReviewReq): String {
        reviewService.modifyReview(reviewSeq, reviewReq)
        return "댓글이 등록되었습니다."
    }

    @DeleteMapping("/review/{reviewSeq}")
    fun deleteReview(@PathVariable reviewSeq: Int): String {
        reviewService.deleteReview(reviewSeq)
        return "댓글이 삭제되었습니다."
    }
}
