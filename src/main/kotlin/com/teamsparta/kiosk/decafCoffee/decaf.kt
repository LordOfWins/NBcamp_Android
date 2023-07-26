package com.teamsparta.kiosk.decafCoffee

abstract class Decaf(
    val name: String,
    val size: String,
    val temperature: String?,
    val shot: String?,
    val packaging: String?,
    val whippedCream: String?,
    val price: Int
)

class DecaffeineAmericano(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("아메리카노", size, temperature, shot, packaging, whippedCream, 2000)

class DecaffeineCaramelMacchiato(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("카라멜 마끼아또", size, temperature, shot, packaging, whippedCream, 2500)

class DecaffeineLatte(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("라떼", size, temperature, shot, packaging, whippedCream, 3000)

class DecaffeineCafeMocha(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("카페모카", size, temperature, shot, packaging, whippedCream, 2600)

class DecaffeineEspresso(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("에스프레소", size, temperature, shot, packaging, whippedCream, 3200)

class DecaffeineCapuchiino(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?,
) : Decaf("카푸치노", size, temperature, shot, packaging, whippedCream, 2800)


