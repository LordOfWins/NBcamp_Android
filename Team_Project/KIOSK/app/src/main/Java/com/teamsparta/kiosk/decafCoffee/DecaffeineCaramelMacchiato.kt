package com.teamsparta.kiosk.decafCoffee

class DecaffeineCaramelMacchiato(
    name: String = "디카페인 카라멜 마끼아또",
    price: Int = 3000,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)
