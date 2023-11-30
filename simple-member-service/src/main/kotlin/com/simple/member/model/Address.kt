package com.simple.member.model

import jakarta.persistence.Embeddable

@Embeddable
data class Address (
    val zipCode: String,
    val zipInfo: String,
    val zipInfoDetail: String
)
