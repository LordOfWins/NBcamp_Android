package com.teamsparta.kiosk.decafCoffee

class DecaffeineColdBrew(
    name: String = "콜드브루",
    price: Int = 3000,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override var quantity: Int = 1
) : Decaf(name, price)
