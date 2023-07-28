package com.teamsparta.kiosk.decafCoffee

class DecaffeineCafeMocha(
    name: String = "디카페인 카페모카",
    price: Int = 3200,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)