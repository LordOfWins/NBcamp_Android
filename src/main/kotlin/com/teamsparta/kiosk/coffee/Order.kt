package com.teamsparta.kiosk.coffee

import com.teamsparta.kiosk.User
import com.teamsparta.kiosk.canPurchase
import com.teamsparta.kiosk.menu

fun orderList(
    temperature: String?,
    size: String?,
    shot: String?,
    packaging: String?,
    whippedCream: String?,
    selectedCoffee: Coffee,
    user: User
) {
    var whippedCream1 = whippedCream
    if (temperature != null && size != null && shot != null && packaging != null) {
        whippedCream1 =
            if (selectedCoffee is CaramelMacchiato && whippedCream1 == null) "휘핑 크림 없음" else whippedCream1
        val updatedCoffee = when (selectedCoffee) {
            is Americano -> Americano(size, temperature, shot, packaging, whippedCream1)
            is CafeLatte -> CafeLatte(size, temperature, shot, packaging, whippedCream1)
            is CaramelMacchiato -> CaramelMacchiato(
                size, temperature, shot, packaging, whippedCream1
            )

            is Capuchiino -> Capuchiino(
                size, temperature, shot, packaging, whippedCream1
            )

            is Espresso -> Espresso(size, temperature, shot, packaging, whippedCream1)
            is ColdBrew -> ColdBrew(size, temperature, shot, packaging, whippedCream1)
            is ColdBrewLatte -> ColdBrewLatte(
                size, temperature, shot, packaging, whippedCream1
            )

            else -> throw Exception("Invalid coffee type")
        }
        val menuItem = OrderItem(
            menuType = "커피", coffee = updatedCoffee
        )
        if (canPurchase(user, menuItem)) {
            Thread.sleep(1000)
            Order.items.add(menuItem)
            coffeePrintOrder()
            menu(user)
            return
        } else {
            println("잔액이 부족합니다. 필요한 금액: ${menuItem.price - user.balance}원")
        }
    } else {
        if (temperature == null) {
            println("1. 온도를 선택해주세요.")
        }
        if (size == null) {
            println("2. 사이즈를 선택해주세요.")
        }
        if (shot == null) {
            println("3. 샷 추가 여부를 선택해주세요.")
        }
        if (packaging == null) {
            println("4. 포장 여부를 선택해주세요.")
        }
    }

}

fun coffeePrintOrder() {
    if (Order.items.isEmpty()) {
        println("주문 내역이 없습니다.")
    } else {
        println("-------------------주문 내역입니다.-------------------")
        for ((index, item) in Order.items.withIndex()) {
            println("Item ${index + 1}")
            println("  메뉴 유형: ${item.menuType}")
            println("  메뉴 이름: ${item.coffee.name}")
            println("  사이즈: ${item.coffee.size}")
            println("  온도: ${item.coffee.temperature}")
            println("  샷 추가 여부: ${item.coffee.shot}")
            println("  포장 여부: ${item.coffee.packaging}")
            if (item.coffee is CaramelMacchiato && item.coffee.whippedCream != null) {
                println("  휘핑 크림 유무: ${item.coffee.whippedCream}")
            }
            println("----------------------------------------------------")
        }
    }
}

class OrderItem(val menuType: String, val coffee: Coffee) {
    val price: Int = coffee.price!!
//        when (coffee) {
//        is Americano -> 1500
//        is CafeLatte -> 2500
//        is CaramelMacchiato -> 3000
//        is Capuchiino -> 1500
//        is Espresso -> 1500
//        is ColdBrew -> 2500
//        is ColdBrewLatte -> 3000
//        else -> {
//            throw Exception("가격이 존재하지 않는 메뉴입니다.")
//        }
//    }
}

object Order {
    val items = mutableListOf<OrderItem>()
}