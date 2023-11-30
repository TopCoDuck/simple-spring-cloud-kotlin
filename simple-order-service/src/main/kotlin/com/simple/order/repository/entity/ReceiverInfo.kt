package com.simple.order.repository.entity

import jakarta.persistence.Embeddable

@Embeddable
data class ReceiverInfo (
     val name: String? = null,
     val address: Address? = null //private PhoneNumber phoneNumber;
)
