package com.teamsparta.kiosk.decafCoffee

import com.teamsparta.kiosk.Item

open class Decaf(name: String, price: Int) : Item(name, price,1 ) {
    open var size: String? = null
    open var temperature: String? = null
    open var shot: String? = null
    open var packaging: String? = null
    open var whippedCream: String? = null
}

class DecaffeineAmericano(
    name: String = "디카페인 아메리카노",
    price: Int = 2300,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)

class DecaffeineCaramelMacchiato(
    name: String = "디카페인 카라멜 마끼아또",
    price: Int = 3000,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)

class DecaffeineLatte(
    name: String = "디카페인 카페라떼",
    price: Int = 3800,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)

class DecaffeineCafeMocha(
    name: String = "디카페인 카페모카",
    price: Int = 3200,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)

class DecaffeineEspresso(
    name: String = "디카페인 에스프레소",
    price: Int = 3700,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)

class DecaffeineCapuchiino(
    name: String = "디카페인 카푸치노",
    price: Int = 4000,
    override var size: String?,
    override var temperature: String?,
    override var shot: String?,
    override var packaging: String?,
    override var whippedCream: String?,
    override val quantity: Int = 1
) : Decaf(name, price)


