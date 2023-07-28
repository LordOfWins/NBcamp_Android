package com.teamsparta.kiosk.coffee

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.OrderItem
import com.teamsparta.kiosk.OrderManager
import com.teamsparta.kiosk.printOrderItems

open class Coffee(name: String, price: Int) : Item(name, price, 1) {
    open var size: String? = null
    open var temperature: String? = null
    open var shot: String? = null
    open var packageOption: String? = null
}

fun selectedItemMenu(selectedCoffee: Coffee) {
    var temperature: String? = null
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    var whippedCream: String? = null
    var quantity: Int

    while (temperature == null) {
        println("\n온도 선택")
        println("1. 핫 2. 아이스")
        print("선택: ")
        temperature = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "핫"
            2 -> "아이스"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    while (size == null) {
        println("\n사이즈 선택")
        println("1. Tall 2. Grande 3. Venti")
        print("선택: ")
        size = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "Tall"
            2 -> "Grande"
            3 -> "Venti"
            else -> {
                println("잘못된 입력입니다. 1~3 사이의 숫자를 입력하세요.")
                null
            }
        }
    }

    while (shot == null) {
        println("\n샷 추가 선택")
        println("1. 샷 추가 2. 기본")
        print("선택: ")
        shot = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "샷 추가"
            2 -> "기본"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    while (packaging == null) {
        println("\n포장 여부 선택")
        println("1. 포장 2. 매장 식사")
        print("선택: ")
        packaging = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "포장"
            2 -> "매장 식사"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    println("\n현재까지 선택한 옵션: ${temperature}, ${size}, ${shot}, $packaging")

    if (selectedCoffee is CaramelMacchiato) {
        while (whippedCream == null) {
            println("\n휘핑 크림 추가 여부")
            println("1. 휘핑 크림 추가  2. 휘핑 크림 없음")
            print("선택: ")
            whippedCream = when (readlnOrNull()?.toIntOrNull()) {
                1 -> "휘핑 크림 추가"
                2 -> "휘핑 크림 없음"
                else -> {
                    println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                    null
                }
            }
        }
        println("\n최종 옵션: ${temperature}, ${size}, ${shot}, ${packaging}, ${whippedCream}(추가됨)")
    }

    while (true) {
        println("\n원하시는 수량을 입력하세요(10000개까지 가능합니다) ")
        print("선택: ")
        quantity = readlnOrNull()?.toIntOrNull()!!
        if (quantity in 1..9999) {
            for (i in 0 until quantity) {
                selectedCoffee.price *= quantity
            }
            break
        } else {
            println("잘못된 입력입니다. 10000이하 1 이상의 숫자를 입력하세요.")
        }
    }

    var confirm: Int? = null
    while (confirm == null) {
        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인 2. 취소")
        print("선택: ")
        confirm = readlnOrNull()?.toIntOrNull()
        when (confirm) {
            1 -> {
                val updatedCoffee = when (selectedCoffee) {
                    is Americano -> Americano(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is CafeLatte -> CafeLatte(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is CaramelMacchiato -> CaramelMacchiato(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is Cappuccino -> Cappuccino(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is Espresso -> Espresso(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is ColdBrew -> ColdBrew(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    is ColdBrewLatte -> ColdBrewLatte(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packageOption = packaging,
                        quantity = quantity
                    )

                    // 여기에 다른 커피 클래스에 대한 처리를 추가합니다.
                    else -> null
                } ?: throw IllegalStateException("Unknown coffee class.")
                OrderManager.items.add(OrderItem.CoffeeOrderItem(updatedCoffee, quantity))
                printOrderItems()
                println("${updatedCoffee.name}이(가) 장바구니에 추가되었습니다.")
            }

            2 -> println("취소되었습니다.")
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                confirm = null
            }
        }
    }
}