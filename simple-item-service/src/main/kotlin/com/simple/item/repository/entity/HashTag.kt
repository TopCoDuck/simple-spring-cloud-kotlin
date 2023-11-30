package com.simple.item.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "hash_tag")
class HashTag (
    @Id
    var hashCd: String,
    var hashNm: String
)
