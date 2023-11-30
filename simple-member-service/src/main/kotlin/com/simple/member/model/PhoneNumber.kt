package com.simple.member.model


data class PhoneNumber (
    var fNumber: String,
    var mNumber: String,
    var lNmber: String
) {
    val fullPhoneNumber: String
        get() {
            val sb = StringBuilder()
            return sb.append(fNumber)
                .append(mNumber)
                .append(lNmber)
                .toString()
        }
}
