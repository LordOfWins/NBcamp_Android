package com.teamsparta.kiosk

class User {
    var balance: Long = 0
    fun inputBalance() {
        print("금액을 입력하세요: ")
        val input = readln()
        balance = input.toLongOrNull() ?: run {
            inputBalance()
            balance
        }
    }
}