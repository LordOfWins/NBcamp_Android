package com.teamsparta.kiosk.dessert

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.OrderItem
import com.teamsparta.kiosk.OrderManager
import com.teamsparta.kiosk.printOrderItems

open class Dessert(name: String, price: Int, open var packaging: String?) :
    Item(name, price) {/* 전체 코드 생략 */

    open fun getCategoryName() = ""

    open fun getMenuName() = ""

    open fun getFlavor() = ""

    fun getDescription(): String {
        return "$name (${getCategoryName()} ${getMenuName()} - ${getFlavor()}) ${price}원"
    }
}


// 디저트 메뉴를 표시하는 함수
fun dessertMenu() {
    while (true) {
        println("디저트 메뉴")
        println("1. 마카롱")
        println("2. 케익류")
        println("3. 쿠키")
        println("4. 아이스크림")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readlnOrNull().orEmpty()) {
            "1" -> {
                selectAndAddMenuItem(macaronMenu())
                break
            }

            "2" -> {
                selectAndAddMenuItem(cakeMenu())
                break
            }

            "3" -> {
                selectAndAddMenuItem(cookieMenu())
                break
            }

            "4" -> {
                selectAndAddMenuItem(iceCreamMenu())
                break
            }

            "0" -> break
            else -> println("유효하지 않은 입력입니다. 다시 시도하세요.")
        }
    }
}

fun selectAndAddMenuItem(menu: Pair<Triple<String, Int, String>, Int>?) {
    if (menu != null) {
        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인 2. 취소")
        print("선택: ")
        val selected = readlnOrNull()?.toIntOrNull()
        if (selected == 1) {
            val info = menu.first
            val quantity = menu.second
            val dessert = Dessert(info.first, info.second, null)
            val orderItem = OrderItem.DessertOrderItem(dessert, info.third.split(" ")[0], quantity)
            OrderManager.items.add(orderItem) // 수정된 코드
            printOrderItems() // 수정된 코드
            println("---------------추가 완료---------------")
        } else if (selected == 2) {
            println("취소되었습니다.")
        } else {
            println("잘못 입력하셨습니다.")
        }
    }
}

fun macaronMenu(): Pair<Triple<String, Int, String>, Int>? {
    return getMenuSelection(
        "마카롱",
        listOf("초코 마카롱", "민트 마카롱", "딸기 마카롱", "바닐라 마카롱", "바나나 마카롱"),
        listOf(3500, 3600, 3400, 3700, 3800)
    )
}

fun cakeMenu(): Pair<Triple<String, Int, String>, Int>? {
    return getMenuSelection(
        "케익", listOf(
            "딸기 케익", "티라미슈 케익", "당근 케익", "치즈 케익", "초코 케익"
        ),

        listOf(19000, 22000, 18000, 17000, 20000)
    )
}

fun cookieMenu(): Pair<Triple<String, Int, String>, Int>? {
    return getMenuSelection(
        "쿠키", listOf(
            "초코칩 쿠키", "더블 초코칩 쿠키", "오트밀 레이즌 쿠키", "마카다미아 넛 쿠키"
        ), listOf(5000, 5500, 4900, 6000)
    )
}

fun iceCreamMenu(): Pair<Triple<String, Int, String>, Int>? {
    return getMenuSelection(
        "아이스크림",
        listOf("바닐라 아이스크림", "초콜릿 아이스크림", "딸기 아이스크림", "민트 초콜릿 칩 아이스크림"),
        listOf(3500, 4000, 3500, 3700)
    )
}

fun getMenuSelection(
    name: String, namesList: List<String>, pricesList: List<Int>
): Pair<Triple<String, Int, String>, Int>? {
    while (true) {
        printMenu(name, namesList)
        println("0. 뒤로가기")
        print("원하는 종류를 선택하세요: ")

        val selectedIndex = readlnOrNull()?.toIntOrNull() ?: -1

        if (selectedIndex in 1..namesList.size) {
            val itemName = namesList[selectedIndex - 1]
            val itemPrice = pricesList[selectedIndex - 1]
            println("\n원하시는 수량을 입력하세요(10000개까지 가능합니다) ")
            print("선택: ")
            val quantity = readlnOrNull()?.toIntOrNull() ?: 0

            if (quantity in 1..10000) {
                val itemDetails = Triple(itemName, itemPrice, name)
                return Pair(itemDetails, quantity)

            } else {
                println("10000개 이내로 입력해주세요")
            }
        } else if (selectedIndex == 0) {
            return null
        } else {
            println("유효하지 않은 선택입니다. 다시 시도하세요.")
        }
    }
}

fun printMenu(name: String, namesList: List<String>) {
    println("\n$name")
    for (i in namesList.indices) {
        println("${i + 1}. ${namesList[i]}")
    }
}

fun readlnOrNull(): String? = kotlin.io.readlnOrNull()?.takeIf { it.isNotBlank() }