package com.simple.review.config

import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component
import java.util.*

@Component
class JpaAuditor(private val userHolder: UserHolder) : AuditorAware<String> {

    override fun getCurrentAuditor() = Optional.ofNullable(userHolder.userId)
}
