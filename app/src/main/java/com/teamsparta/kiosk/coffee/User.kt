package com.teamsparta.kiosk.coffee


class User(var balance: Int)

fun canPurchase(user: User, orderItem: OrderItem): Boolean {
    return user.balance >= orderItem.price
}
