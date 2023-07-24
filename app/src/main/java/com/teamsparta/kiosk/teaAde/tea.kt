package com.teamsparta.kiosk.teaAde

import com.teamsparta.kiosk.packagingMenu
import com.teamsparta.kiosk.shotMenu
import com.teamsparta.kiosk.sizeMenu

data class MenuItem(
    val menuType: String,
    val name: String,
    val size: String,
    val packaging: String?,
)

object Order {
    val items = mutableListOf<MenuItem>()
}

fun teaAdeMenu() {
    while (true) {
        println("티/에이드")
        println("1. 아이스티")
        println("2. 자몽에이드")
        println("3. 레몬에이드")
        println("4. 녹차")
        println("5. 얼그레이")
        println("6. 허브티")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readLine()!!) {
            "1" -> icedTeaMenu()
            "2" -> teaMenu("자몽에이드", "에이드")
            "3" -> teaMenu("레몬에이드", "에이드")
            "4" -> teaMenu("녹차", "차")
            "5" -> teaMenu("얼그레이", "차")
            "6" -> teaMenu("허브티", "차")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun icedTeaMenu() {
    while (true) {
        println("아이스티")
        println("1. 레몬")
        println("2. 복숭아")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> teaMenu("레몬 아이스티", "아이스티")
            "2" -> teaMenu("복숭아 아이스티", "아이스티")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun teaMenu(name: String, menuType: String) {
    val type: String = menuType
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    while (true) {
        println("1. 온도 선택")
        println("2. 사이즈 선택")
        println("3. 샷 추가 여부")
        println("4. 포장 여부")
        println("6. 주문 완료")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> size = sizeMenu()
            "2" -> shot = shotMenu()
            "3" -> packaging = packagingMenu()
            "9" -> {
                if (size != null && shot != null && packaging != null) {
                    val menuItem = MenuItem(
                        menuType = type,
                        name = name,
                        size = size,
                        packaging = packaging,
                    )
                    Order.items.add(menuItem)
                    printOrder()
                    return
                } else {
                    println("모든 타입을 선택해주세요.")
                }
            }

            "0" -> break
            else -> com.teamsparta.kiosk.error()
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
            println("  포장 여부: ${item.packaging}")

        }
    }
}