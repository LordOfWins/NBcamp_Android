package com.teamsparta.kiosk.decafCoffee

import com.teamsparta.kiosk.Item

open class Decaf(name: String, price: Int) : Item(name, price, 1) {
    open var size: String? = null
    open var temperature: String? = null
    open var shot: String? = null
    open var packaging: String? = null
    open var whippedCream: String? = null
}









