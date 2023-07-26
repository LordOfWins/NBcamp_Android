package com.teamsparta.kiosk.decafCoffee

import com.teamsparta.kiosk.User
import com.teamsparta.kiosk.menu

fun orderList(
    temperature: String?,
    size: String?,
    shot: String?,
    packaging: String?,
    whippedCream: String?,
    selectedCoffee: Decaf,
    user: User
) {
    var whippedCream1 = whippedCream
    if (temperature != null && size != null && shot != null && packaging != null) {
        whippedCream1 =
            if (selectedCoffee is DecaffeineCaramelMacchiato && whippedCream1 == null) "휘핑 크림 없음" else whippedCream1
        val updatedCoffee = when (selectedCoffee) {
            is DecaffeineAmericano -> DecaffeineAmericano(
                size, temperature, shot, packaging, whippedCream1
            )

            is DecaffeineLatte -> DecaffeineLatte(size, temperature, shot, packaging, whippedCream1)
            is DecaffeineCaramelMacchiato -> DecaffeineCaramelMacchiato(
                size, temperature, shot, packaging, whippedCream1
            )

            is DecaffeineCapuchiino -> DecaffeineCapuchiino(
                size, temperature, shot, packaging, whippedCream1
            )

            is DecaffeineEspresso -> DecaffeineEspresso(
                size, temperature, shot, packaging, whippedCream1
            )

            is DecaffeineCafeMocha -> DecaffeineCafeMocha(
                size, temperature, shot, packaging, whippedCream1
            )

            else -> throw Exception("Invalid coffee type")
        }
        val menuItem = OrderItem(
            menuType = "커피", decaf = updatedCoffee
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

fun canPurchase(user: User, orderItem: OrderItem): Boolean {
    return user.balance >= orderItem.price
}

fun coffeePrintOrder() {
    if (Order.items.isEmpty()) {
        println("주문 내역이 없습니다.")
    } else {
        println("-------------------주문 내역입니다.-------------------")
        for ((index, item) in Order.items.withIndex()) {
            println("Item ${index + 1}")
            println("  메뉴 유형: ${item.menuType}")
            println("  메뉴 이름: ${item.decaf.name}")
            println("  사이즈: ${item.decaf.size}")
            println("  온도: ${item.decaf.temperature}")
            println("  샷 추가 여부: ${item.decaf.shot}")
            println("  포장 여부: ${item.decaf.packaging}")
            if (item.decaf is DecaffeineCaramelMacchiato && item.decaf.whippedCream != null) {
                println("  휘핑 크림 유무: ${item.decaf.whippedCream}")
            }
            println("----------------------------------------------------")
        }
    }
}

class OrderItem(val menuType: String, val decaf: Decaf) {
    val price: Int = decaf.price
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