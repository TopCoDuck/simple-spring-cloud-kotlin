package com.simple.item.model

import java.time.LocalDateTime

data class Review(val createId: String,
                  val comments: String,
                  val createDttm: LocalDateTime,
)
