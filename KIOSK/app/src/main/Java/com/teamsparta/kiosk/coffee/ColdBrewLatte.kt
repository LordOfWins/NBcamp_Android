package com.teamsparta.kiosk.coffee

class ColdBrewLatte(
    name: String = "콜드브루 라떼",
    price: Int = 3500,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)