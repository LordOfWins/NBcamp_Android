package com.teamsparta.kiosk.decafCoffee

abstract class Decaf(
    val name: String,
    val size: String,
    val temperature: String?,
    val shot: String?,
    val packaging: String?,
    val whippedCream: String?
)

class Americano(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("아메리카노", size, temperature, shot, packaging, whippedCream)

class CaramelMacchiato(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("카라멜 마끼아또", size, temperature, shot, packaging, whippedCream)

class Latte(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("라떼", size, temperature, shot, packaging, whippedCream)

class CafeMocha(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("카페모카", size, temperature, shot, packaging, whippedCream)

class Espresso(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("에스프레소", size, temperature, shot, packaging, whippedCream)

class Capuchiino(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Decaf("카푸치노", size, temperature, shot, packaging, whippedCream)


