package com.teamsparta.kiosk.coffee

class Cappuccino(
    name: String = "카푸치노",
    price: Int = 2800,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)
