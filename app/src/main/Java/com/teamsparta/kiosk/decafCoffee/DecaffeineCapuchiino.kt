package com.teamsparta.kiosk.decafCoffee

class DecaffeineCapuchiino(
    name: String = "디카페인 카푸치노",
    price: Int = 4000,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)
