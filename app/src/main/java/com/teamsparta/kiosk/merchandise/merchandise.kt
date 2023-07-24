package com.teamsparta.kiosk.merchandise

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

fun merchandiseMenu() {
    while (true) {
        println("상품 메뉴")
        println("1. 머그컵")
        println("2. 텀블러")
        println("3. 원두")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")
        when (readLine()!!) {
            "1" -> selectedItemMenu("머그컵", "상품")
            "2" -> selectedItemMenu("텀블러", "상품")
            "3" -> selectedItemMenu("원두", "상품")
            "0" -> break
            else -> error()
        }
    }
}

fun mugMenu() {
    println("머그컵")
    println("1. 색깔")
    println("0. 뒤로가기")

    print("원하는 항목을 선택하세요: ")
    when (readLine()!!) {
        "1" -> mugColorMenu()
        "0" -> merchandiseMenu()
        else -> error()
    }
}

/* */fun mugColorMenu() {
    println("색깔을 선택하세요")
    println("1. 초록")
    println("2. 노랑")
    println("3. 민트")
    println("0. 뒤로가기")

    print("원하는 색깔을 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("초록색 머그컵을 선택하셨습니다.")
        "2" -> println("노랑색 머그컵을 선택하셨습니다.")
        "3" -> println("민트색 머그컵을 선택하셨습니다.")
        "0" -> mugMenu()
        else -> error()
    }/* */
}

fun tumblerMenu() {
    println("텀블러")
    println("1. 색깔")
    println("0. 뒤로가기")

    print("원하는 항목을 선택하세요: ")

    when (readLine()!!) {
        "1" -> tumblerColorMenu()
        "0" -> merchandiseMenu()
        else -> error()
    }
}

/* */fun tumblerColorMenu() {
    println("색깔을 선택하세요")
    println("1. 초록")
    println("2. 노랑")
    println("3. 민트")
    println("0. 뒤로가기")

    print("원하는 색깔을 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("초록색 텀블러를 선택하셨습니다.")
        "2" -> println("노랑색 텀블러를 선택하셨습니다.")
        "3" -> println("민트색 텀블러를 선택하셨습니다.")
        "0" -> tumblerMenu()
        else -> error()
    }/* */
}

fun beansMenu() {
    println("원두")
    println("1. 아라비아")
    println("2. 콜롬비아")
    println("3. 스타벅스")
    println("0. 뒤로가기")

    print("원하는 원두를 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("아라비아 원두를 선택하셨습니다.")
        "2" -> println("콜롬비아 원두를 선택하셨습니다.")
        "3" -> println("스타벅스 원두를 선택하셨습니다.")
        "0" -> merchandiseMenu()
        else -> error()
    }
}

fun selectedItemMenu(name: String, menuType: String) {
    val type: String = menuType
    var temperature: String? = null
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
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

            "6" -> {
                if (temperature != null && size != null && shot != null && packaging != null) {
                    val menuItem = MenuItem(
                        menuType = type,
                        name = name,
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = null,
                        color = null
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