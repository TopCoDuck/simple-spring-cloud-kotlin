package com.simple.order.repository.entity


import jakarta.persistence.Entity
import jakarta.persistence.Id

//TODO:
@Entity
class Member (
    @Id
    var userId: String? = null
)