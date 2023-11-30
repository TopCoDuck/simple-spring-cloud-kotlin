package com.simple.mypage.controller


import com.simple.mypage.service.MemberService
import com.simple.mypage.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyInfoController(private val memberService: MemberService,
                       private val orderService: OrderService,
    ) {

    @GetMapping("my-info")
    fun list(): Map<String, Any> {
        val result: MutableMap<String, Any> = HashMap()
        val userName = "test1" //TODO: 차후 실제 값으로 변경
        result["member"] = memberService.findOne(userName) ?: throw RuntimeException("유저 정보가 존재하지 않습니다.")
        result["orders"] = orderService.findOrderSummaryList(userName, 5)!!
        return result
    }
}
