package com.simple.review.repository.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class Review(
    var comments: String,
    itemNo: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_seq")
    var id: Int = 0

    val itemNo: Int = itemNo

    @CreatedBy
    @Column(updatable = false)
    lateinit var createId: String

    @CreatedDate
    @Column(updatable = false)
    lateinit var createDttm: LocalDateTime
}
