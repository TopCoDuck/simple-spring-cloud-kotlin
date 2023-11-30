package com.simple.member.repository.entity

import com.simple.member.exception.AlreadyBanMember
import com.simple.member.model.Address
import com.simple.member.model.Authority
import com.simple.member.model.MemberState
import com.simple.member.model.PhoneNumber
import com.simple.member.repository.converter.PhoneNumberConverter
import jakarta.persistence.*

@Entity
class Member  (
    @Id
    var userId: String? = null,
    var userName: String? = null,
    var password: String? = null,

    @Enumerated(EnumType.STRING)
    val role: Authority = Authority.USER,
    var email: String? = null,

    @Convert(converter = PhoneNumberConverter::class)
    var phoneNumber: PhoneNumber? = null,

    @Embedded
    var address: Address? = null,

    @Enumerated(EnumType.STRING)
    var state: MemberState? = null,

    ) {

    fun join() {
        state = MemberState.JOIN
    }

    fun withdrawal() {
        when (state) {
            MemberState.BAN -> throw AlreadyBanMember("차단 된 회원입니다.")
            else -> state = MemberState.WITHDRAWAL
        }
    }
}



