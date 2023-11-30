package com.simple.member.repository.converter

import com.simple.member.model.PhoneNumber
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class PhoneNumberConverter : AttributeConverter<PhoneNumber?, String?> {
    override fun convertToDatabaseColumn(attribute: PhoneNumber?): String? {
        return attribute?.fullPhoneNumber
    }

    override fun convertToEntityAttribute(dbData: String?): PhoneNumber? {
        return dbData?.let {
            if (it.length == 11) {
                return PhoneNumber(
                    it.substring(0, 3), it.substring(3, 7), it.substring(7, 11)
                )
            } else {
                return PhoneNumber(
                    it.substring(0, 2), it.substring(2, 6), it.substring(6, 10)
                )
            }
        }
    }
}
