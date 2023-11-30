package com.simple.member.service


import com.simple.member.exception.DuplicationMemberId
import com.simple.member.repository.entity.Member
import com.simple.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {

    fun getMember(memberId: String): Member {
        return memberRepository.findById(memberId)
    }

    fun join(member: Member) {
        if (memberRepository.existsByUserName(member.userId!!)) {
            throw DuplicationMemberId("이미 가입된 회원입니다.")
        } else {
            member.join()
            memberRepository.save(member)
        }
    }

    fun withdrawal(userName: String) {
        val member: Member = memberRepository.findById(userName)
        member.withdrawal()
        memberRepository.save(member)
    }
}
