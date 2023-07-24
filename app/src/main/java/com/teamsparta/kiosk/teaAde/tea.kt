package com.teamsparta.kiosk.teaAde

import com.teamsparta.kiosk.packagingMenu
import com.teamsparta.kiosk.shotMenu
import com.teamsparta.kiosk.sizeMenu
import com.teamsparta.kiosk.temperatureMenu

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
        println("2. 에이드")
        println("3. 차")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readLine()!!) {
            "1" -> icedTeaMenu()
            "2" -> AdeMenu()
            "3" -> TeaMenu()
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
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> adeMenu("레몬 아이스티", "아이스티")
            "2" -> adeMenu("복숭아 아이스티", "아이스티")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}
fun AdeMenu() {
    while (true) {
        println("에이드")
        println("1. 자몽")
        println("2. 레몬")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> adeMenu("자몽 에이드", "에이드")
            "2" -> adeMenu("레몬 에이드", "에이드")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}
fun TeaMenu() {
    while (true) {
        println("차")
        println("1. 녹차")
        println("2. 얼그레이티")
        println("3. 허브티")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> teaMenu("녹차", "차")
            "2" -> teaMenu("얼그레이", "차")
            "3" -> teaMenu("허브티", "차")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun adeMenu(name: String, menuType: String) {
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
            "1" -> println("아이스티와 에이드 음료는 온도를 선택하실 수 없습니다")
            "2" -> size = sizeMenu()
            "3" -> shot = shotMenu()
            "4" -> packaging = packagingMenu()
            "6" -> {
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

fun teaMenu(name: String, menuType: String) {
    val type: String = menuType
    var temperature: String? = null
    var size: String? = null
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
            "1" -> temperature = temperatureMenu()
            "2" -> size = sizeMenu()
            "3" -> println("차 음료에는 샷 추가를 할 수 없습니다")
            "4" -> packaging = packagingMenu()
            "6" -> {
                if (temperature != null && size != null && packaging != null) {
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
                    println("모든 타입을 다시 선택해주세요.")
                } // if문을 온도 체크, 사이즈 체크, 포장 체크로 분리
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