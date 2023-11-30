package com.simple.member.controller
import com.simple.member.config.UserHolder
import com.simple.member.repository.entity.Member
import com.simple.member.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(private val memberService: MemberService,
                       private val userHolder: UserHolder,
    ) {

    @GetMapping( "/member/{memberId}")
    fun getMember(@PathVariable memberId: String) = memberService.getMember(memberId)

    @PostMapping( "/member/join")
    fun createMember(member: Member):String {
        memberService.join(member)
        return "회원가입이 정상적으로 완료 되었습니다."
    }

    @PutMapping( "/member/withdrawal")
    fun withdrawalMember(): String {
        memberService.withdrawal(userHolder.userId!!) //TODO : 향후개선
        return "회원 탈퇴 처리 되었습니다."
    }
}
