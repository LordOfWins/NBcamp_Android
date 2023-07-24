package com.teamsparta.kiosk.coffee

import com.teamsparta.kiosk.error
import com.teamsparta.kiosk.packagingMenu
import com.teamsparta.kiosk.shotMenu
import com.teamsparta.kiosk.sizeMenu
import com.teamsparta.kiosk.temperatureMenu

data class MenuItem(
    val menuType: String,
    val name: String,
    val size: String,
    val temperature: String?,
    val shot: String?,
    val packaging: String?,
    val whippedCream: String?,
    val color: String?
)

object Order {
    val items = mutableListOf<MenuItem>()
}

fun coffeeMenu() {
    while (true) {
        println("커피 메뉴")
        println("1. 아메리카노")
        println("2. 카페라떼")
        println("3. 카라멜 마끼아또")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readLine()!!) {
            "1" -> selectedItemMenu("아메리카노", "커피")
            "2" -> selectedItemMenu("카페라떼", "커피")
            "3" -> selectedItemMenu("카라멜 마끼아또", "커피")
            "0" -> break
            else -> error()
        }
    }
}

fun whippedCreamMenu(): String {
    println("휘핑크림 추가 여부를 선택하세요")
    println("1. 휘핑 추가")
    println("2. 기본")
    println("0. 뒤로가기")

    print("원하는 휘핑크림 옵션을 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "휘핑추가"
        "2" -> "기본"
        "0" -> {
            println("뒤로 돌아갑니다.")
            ""
        }

        else -> {
            error()
            ""
        }
    }
}

fun selectedItemMenu(name: String, menuType: String) {
    val type: String = menuType
    var temperature: String? = null
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    var whippedCream: String? = null
    while (true) {
        println("1. 온도 선택")
        println("2. 사이즈 선택")
        println("3. 샷 추가 여부")
        println("4. 포장 여부")
        if (name == "카라멜 마끼아또") {
            println("5. 휘핑 크림 추가 여부")
        }
        println("6. 주문 완료")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> temperature = temperatureMenu()
            "2" -> size = sizeMenu()
            "3" -> shot = shotMenu()
            "4" -> packaging = packagingMenu()
            "5" -> {
                if (name == "카라멜 마끼아또") {
                    whippedCream = com.teamsparta.kiosk.whippedCreamMenu()
                } else {
                    println("해당 메뉴에는 휘핑 크림 옵션이 없습니다.")
                }
            }

            "6" -> {
                if (temperature != null && size != null && shot != null && packaging != null) {
                    whippedCream =
                        if (name == "카라멜 마끼아또" && whippedCream == null) "휘핑 크림 없음" else whippedCream
                    val menuItem = MenuItem(
                        menuType = type,
                        name = name,
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        color=null
                    )
                    Order.items.add(menuItem)
                    printOrder()
                    return
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

            "0" -> break
            else -> error()
        }
    }
}

fun printOrder() {
    if (Order.items.isEmpty()) {
        println("주문 내역이 없습니다.")
    } else {
        println("주문 내역:")
        for ((index, item) in Order.items.withIndex()) {
            println("Item ${index + 1}:")
            println("  메뉴 유형: ${item.menuType}")
            println("  메뉴 이름: ${item.name}")
            println("  사이즈: ${item.size}")
            println("  온도: ${item.temperature}")
            println("  샷 추가 여부: ${item.shot}")
            println("  포장 여부: ${item.packaging}")

            if (item.whippedCream != null) {
                println("  휘핑 크림 추가 여부: ${item.whippedCream}")
            }
        }
    }
}