package com.teamsparta.kiosk.coffee

class CafeLatte(
    name: String = "카페라떼",
    price: Int = 2500,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)
