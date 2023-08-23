package com.teamsparta.kiosk.coffee

class Espresso(
    name: String = "에스프레소",
    price: Int = 2700,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)
