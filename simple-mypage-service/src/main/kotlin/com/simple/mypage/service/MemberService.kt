package com.simple.mypage.service

import com.simple.mypage.config.ApiClient
import com.simple.mypage.config.ApiDomain
import com.simple.mypage.model.Member
import org.springframework.stereotype.Service

@Service
class MemberService(private val apiClient: ApiClient) {
    fun findOne(userName: String) = apiClient.get(ApiDomain.MEMBER, "/member/${userName}", Member::class.java)
}
