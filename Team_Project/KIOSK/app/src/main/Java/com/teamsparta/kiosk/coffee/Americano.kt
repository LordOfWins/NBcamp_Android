package com.teamsparta.kiosk.coffee

class Americano(
    name: String = "아메리카노",
    price: Int = 1500,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)
