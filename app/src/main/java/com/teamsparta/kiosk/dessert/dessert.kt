package com.teamsparta.kiosk.dessert

import com.teamsparta.kiosk.coffee.whippedCreamMenu
import com.teamsparta.kiosk.packagingMenu
import com.teamsparta.kiosk.shotMenu
import com.teamsparta.kiosk.sizeMenu
import com.teamsparta.kiosk.temperatureMenu


object Order {
    val items = mutableListOf<MenuItem>()
}

data class MenuItem(
    val name: String,
    val menuType: String,
    val packaging: String,
    val shot: Boolean = false,
    val temperature: String? = null,
    val size: String? = null
)

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
            "1" -> macaronMenu("마카롱", "디저트")
            "2" -> cakeMenu("케익류", "디저트")
            "3" -> cookieMenu("쿠키", "디저트")
            "4" -> iceCreamMenu("아이스크림", "디저트")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun selectedItemMenu(name: String, type: String) {
    when (name) {
        "마카롱" -> macaronMenu(name, type)
        "케익류" -> cakeMenu(name, type)
        "쿠키" -> cookieMenu(name, type)
        "아이스크림" -> iceCreamMenu(name, type)
    }
}

fun macaronMenu(name: String, type: String) {
    while (true) {
        println(name)
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> macaronTypeMenu(name, type)
            "2" -> packagingMenu(name, type,"포장")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun macaronTypeMenu(name: String, type: String) {
    println("종류를 선택하세요")
    println("1. 초코")
    println("2. 민트")
    println("3. 딸기")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val menuItem = MenuItem("초코 마카롱", type,"포장")
            Order.items.add(menuItem)
            println("초코 마카롱을 선택하셨습니다.")
        }
        "2" -> {
            val menuItem = MenuItem("민트 마카롱", type,"포장")
            Order.items.add(menuItem)
            println("민트 마카롱을 선택하셨습니다.")
        }
        "3" -> {
            val menuItem = MenuItem("딸기 마카롱", type,"포장")
            Order.items.add(menuItem)
            println("딸기 마카롱을 선택하셨습니다.")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun cakeMenu(name: String, type: String) {
    while (true) {
        println(name)
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> cakeTypeMenu(name, type)
            "2" -> packagingMenu(name, type,"포장")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun cakeTypeMenu(name: String, type: String) {
    println("종류를 선택하세요")
    println("1. 딸기생크림")
    println("2. 티라미슈")
    println("3. 당근")
    println("4. 치즈")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val menuItem = MenuItem("딸기생크림 케익", type,"포장")
            Order.items.add(menuItem)
            println("딸기생크림 케익을 선택하셨습니다.")
        }
        "2" -> {
            val menuItem = MenuItem("티라미슈 케익", type,"포장")
            Order.items.add(menuItem)
            println("티라미슈 케익을 선택하셨습니다.")
        }
        "3" -> {
            val menuItem = MenuItem("당근 케익", type,"포장")
            Order.items.add(menuItem)
            println("당근 케익을 선택하셨습니다.")
        }
        "4" -> {
            val menuItem = MenuItem("치즈 케익", type,"포장")
            Order.items.add(menuItem)
            println("치즈 케익을 선택하셨습니다.")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun cookieMenu(name: String, type: String) {
    while (true) {
        println(name)
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> cookieTypeMenu(name, type)
            "2" -> packagingMenu(name, type,"포장")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun cookieTypeMenu(name: String, type: String) {
    println("종류를 선택하세요")
    println("1. 초코칩 쿠키")
    println("2. 더블 초코칩 쿠키")
    println("3. 오트밀 레이즌 쿠키")
    println("4. 마카다미아 넛 쿠키")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val menuItem = MenuItem("초코칩 쿠키", type,"포장")
            Order.items.add(menuItem)
            println("초코칩 쿠키를 선택하셨습니다.")
        }
        "2" -> {
            val menuItem = MenuItem("더블 초코칩 쿠키", type,"포장")
            Order.items.add(menuItem)
            println("더블 초코칩 쿠키를 선택하셨습니다.")
        }
        "3" -> {
            val menuItem = MenuItem("오트밀 레이즌 쿠키", type,"포장")
            Order.items.add(menuItem)
            println("오트밀 레이즌 쿠키를 선택하셨습니다.")
        }
        "4" -> {
            val menuItem = MenuItem("마카다미아 넛 쿠키", type,"포장")
            Order.items.add(menuItem)
            println("마카다미아 넛 쿠키를 선택하셨습니다.")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun iceCreamMenu(name: String, type: String) {
    while (true) {
        println(name)
        println("1. 종류")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> iceCreamTypeMenu(name, type)
            "2" -> packagingMenu(name, type,"포장")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun iceCreamTypeMenu(name: String, type: String) {
    println("종류를 선택하세요")
    println("1. 바닐라 아이스크림")
    println("2. 초콜릿 아이스크림")
    println("3. 딸기 아이스크림")
    println("4. 민트 초콜릿 칩 아이스크림")
    println("0. 뒤로가기")

    print("원하는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val menuItem = MenuItem("바닐라 아이스크림", type,"포장")
            Order.items.add(menuItem)
            println("바닐라 아이스크림을 선택하셨습니다.")
        }
        "2" -> {
            val menuItem = MenuItem("초콜릿 아이스크림", type,"포장")
            Order.items.add(menuItem)
            println("초콜릿 아이스크림을 선택하셨습니다.")
        }
        "3" -> {
            val menuItem = MenuItem("딸기 아이스크림", type,"포장")
            Order.items.add(menuItem)
            println("딸기 아이스크림을 선택하셨습니다.")
        }
        "4" -> {
            val menuItem = MenuItem("민트 초콜릿 칩 아이스크림", type,"포장")
            Order.items.add(menuItem)
            println("민트 초콜릿 칩 아이스크림을 선택하셨습니다.")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun packagingMenu(name: String, type: String,packaging: String) {
    println("$name 포장 여부")
    println("1. 포장")
    println("2. 포장하지 않음")
    println("0. 뒤로가기")

    print("포장 여부를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val lastItem = Order.items.last()
            val newItem = MenuItem("${lastItem.name} (포장)", type,"포장")
            Order.items[Order.items.size - 1] = newItem
            println("${lastItem.name}을(를) 포장하여 주문목록에 추가했습니다.")
        }
        "2" ->{
            val lastItem = Order.items.last()
            val newItem = MenuItem("${lastItem.name} (포장)", type,"포장하지않음")
            Order.items[Order.items.size - 1] = newItem
            println("${lastItem.name}을(를) 포장하지 않고 주문목록에 추가했습니다.")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun desertPrintOrder() {
    if (Order.items.isEmpty()) {
        println("주문 내역이 없습니다.")
    } else {
        println("주문 내역:")
        for ((index, item) in Order.items.withIndex()) {
            println("Item ${index + 1}:")
            println("  메뉴 유형: ${item.menuType}")

            println("  메뉴 이름: ${item.name}")
            if (item.menuType == "디저트") {
                println("  포장 여부: ${item.packaging}")
            } else if (item.menuType == "커피") {
                println("  샷 추가 여부: ${if (item.shot) "추가" else "미추가"}")
                println("  온도: ${item.temperature}")
                println("  사이즈: ${item.size}")
            }
            println()
        }
    }
}