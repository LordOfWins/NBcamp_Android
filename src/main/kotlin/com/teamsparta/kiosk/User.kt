package com.teamsparta.kiosk

import com.teamsparta.kiosk.coffee.OrderItem


class User
{
    var balance: Int = 0
    fun inputBalance() {
        print("금액을 입력하세요: ")
        balance = readLine()!!.toInt()
    }
}

fun canPurchase(user: User, orderItem: OrderItem): Boolean {
    return user.balance >= orderItem.price
}
