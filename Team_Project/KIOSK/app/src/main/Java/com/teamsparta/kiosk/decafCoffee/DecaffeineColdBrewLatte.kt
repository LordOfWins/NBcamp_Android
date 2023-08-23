package com.teamsparta.kiosk.decafCoffee

class DecaffeineColdBrewLatte(
    name: String = "다카페인 콜드브루 라떼",
    price: Int = 3500,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)