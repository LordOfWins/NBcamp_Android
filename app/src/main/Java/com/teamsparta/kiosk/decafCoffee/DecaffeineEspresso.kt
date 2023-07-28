package com.teamsparta.kiosk.decafCoffee

class DecaffeineEspresso(
    name: String = "디카페인 에스프레소",
    price: Int = 3700,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)
