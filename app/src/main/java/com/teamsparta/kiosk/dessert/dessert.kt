package com.teamsparta.kiosk.dessert

import com.teamsparta.kiosk.packagingMenu
import com.teamsparta.kiosk.shotMenu
import com.teamsparta.kiosk.sizeMenu
import com.teamsparta.kiosk.temperatureMenu
import com.teamsparta.kiosk.whippedCreamMenu

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

fun dessertMenu() {
    while (true) {
        println("디저트 메뉴")
        println("1. 마카롱")
        println("2. 케익류")
        println("3. 쿠키")
        println("4. 아이스크림")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readLine()!!) {
            "1" -> selectedItemMenu("마카롱", "디저트")
            "2" -> selectedItemMenu("케익류", "디저트")
            "3" -> selectedItemMenu("쿠키", "디저트")
            "4" -> selectedItemMenu("아이스크림", "디저트")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun macaronMenu() {
    while (true) {
        println("마카롱")
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> macaronTypeMenu()
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun macaronTypeMenu() {
    println("종류를 선택하세요")
    println("1. 초코")
    println("2. 민트")
    println("3. 딸기")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("초코 마카롱을 선택하셨습니다.")
        "2" -> println("민트 마카롱을 선택하셨습니다.")
        "3" -> println("딸기 마카롱을 선택하셨습니다.")
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun cakeMenu() {
    while (true) {
        println("케익류")
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> cakeTypeMenu()
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun cakeTypeMenu() {
    println("종류를 선택하세요")
    println("1. 딸기생크림")
    println("2. 티라미슈")
    println("3. 당근")
    println("4. 치즈")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("딸기생크림 케익을 선택하셨습니다.")
        "2" -> println("티라미슈 케익을 선택하셨습니다.")
        "3" -> println("당근 케익을 선택하셨습니다.")
        "4" -> println("치즈 케익을 선택하셨습니다.")
        "0" -> {
            println("뒤로 돌아갑니다.")
            dessertMenu()
        }

        else -> com.teamsparta.kiosk.error()
    }
}

fun cookieMenu() {
    while (true) {
        println("케익류")
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> cookieTypeMenu()
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun cookieTypeMenu() {
    println("종류를 선택하세요")
    println("1. 딸기생크림")
    println("2. 티라미슈")
    println("3. 당근")
    println("4. 치즈")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("딸기생크림 케익을 선택하셨습니다.")
        "2" -> println("티라미슈 케익을 선택하셨습니다.")
        "3" -> println("당근 케익을 선택하셨습니다.")
        "4" -> println("치즈 케익을 선택하셨습니다.")
        "0" -> {
            println("뒤로 돌아갑니다.")
            dessertMenu()
        }

        else -> com.teamsparta.kiosk.error()
    }
}

fun iceCreamMenu() {
    while (true) {
        println("케익류")
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> iceCreamTypeMenu()
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun iceCreamTypeMenu() {
    println("종류를 선택하세요")
    println("1. 딸기생크림")
    println("2. 티라미슈")
    println("3. 당근")
    println("4. 치즈")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> println("딸기생크림 케익을 선택하셨습니다.")
        "2" -> println("티라미슈 케익을 선택하셨습니다.")
        "3" -> println("당근 케익을 선택하셨습니다.")
        "4" -> println("치즈 케익을 선택하셨습니다.")
        "0" -> {
            println("뒤로 돌아갑니다.")
            dessertMenu()
        }

        else -> com.teamsparta.kiosk.error()
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
                    whippedCream = whippedCreamMenu()
                } else {
                    println("해당 메뉴에는 휘핑 크림 옵션이 없습니다.")
                }
            }

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
            println("  온도: ${item.temperature}")
            println("  샷 추가 여부: ${item.shot}")
            println("  포장 여부: ${item.packaging}")

            if (item.whippedCream != null) {
                println("  휘핑 크림 추가 여부: ${item.whippedCream}")
            }
        }
    }
}