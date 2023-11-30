package com.simple.item.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "category")
class Category(
    @Id
    var categoryCd: String,
    var categoryNm: String
)
