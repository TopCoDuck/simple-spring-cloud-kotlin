package com.simple.order.service

import com.simple.order.model.Mail
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MailService(private val kafkaTemplate: KafkaTemplate<String, Any>) {
    fun sendMail(mail: Mail) {
        kafkaTemplate.send("EMAIL_TEST", mail)
    }
}
