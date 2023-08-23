package com.teamsparta.kiosk.coffee

class CaramelMacchiato(
    name: String = "카라멜 마끼아또",
    price: Int = 3000,
    override var size: String? = null,
    override var temperature: String? = null,
    override var shot: String? = null,
    override var packageOption: String? = null,
    override var quantity: Int = 1
) : Coffee(name, price)
