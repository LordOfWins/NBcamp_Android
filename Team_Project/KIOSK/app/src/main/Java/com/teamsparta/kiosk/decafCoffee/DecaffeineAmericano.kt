package com.teamsparta.kiosk.decafCoffee

class DecaffeineAmericano(
    name: String = "디카페인 아메리카노",
    price: Int = 2300,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)
