package com.simple.member.repository


import com.simple.member.repository.entity.Member
import org.springframework.data.repository.Repository

interface MemberRepository : Repository<Member, String> {
    fun findById(id: String): Member
    fun save(member: Member): Member
    fun existsByUserName(userName: String): Boolean
    fun deleteById(id: String)
}
