package com.simple.order.service

import com.simple.order.config.ApiClient
import com.simple.order.config.ApiDomain
import com.simple.order.repository.entity.Member
import org.springframework.stereotype.Service

@Service
class MemberService(private val apiClient: ApiClient) {
    fun getMember(memberId: String): Member =
        apiClient.get(ApiDomain.MEMBER, "/member/${memberId}", Member::class.java)!!
}
