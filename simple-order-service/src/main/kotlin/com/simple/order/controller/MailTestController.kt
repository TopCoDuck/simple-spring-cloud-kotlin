package com.simple.order.controller

import com.simple.order.model.Mail
import com.simple.order.service.MailService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MailTestController(private val mailService: MailService) {
    @GetMapping("/test")
    fun test() {
        mailService.sendMail(Mail("test","test"))
    }
}