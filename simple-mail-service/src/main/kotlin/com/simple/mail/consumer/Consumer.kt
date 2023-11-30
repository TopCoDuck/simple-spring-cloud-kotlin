package com.simple.mail.consumer

import com.simple.order.model.Mail
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {
    @KafkaListener(topics = ["EMAIL_TEST"])
    fun list(mail: Mail) {
        print(mail)
    }
}