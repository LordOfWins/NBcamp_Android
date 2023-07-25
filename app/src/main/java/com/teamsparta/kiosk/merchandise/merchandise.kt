package com.teamsparta.kiosk.merchandise

import com.teamsparta.kiosk.coffee.Coffee
import com.teamsparta.kiosk.coffee.User
import com.teamsparta.kiosk.color
import com.teamsparta.kiosk.error

object Order {
    val items = mutableListOf<String>()
}
fun merchandiseMenu() {
    while (true) {
        println("< 상품 메뉴 >")
        println("1. 머그컵")
        println("2. 텀블러")
        println("3. 원두")
        println("4. 주문이 완료되면 선택해주세요")

        print("원하시는 상품을 선택하세요: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                Order.items.add("상품 : 머그컵")
                val colorChoice = getColorChoice()
                Order.items.add("색상 : ${getColorName(colorChoice)}")
                val packagingChoice = getPackagingChoice()
                Order.items.add("포장 : ${if (packagingChoice) "포장함" else "포장 안함"}")
                }
            2 -> {
                Order.items.add("상품 : 텀블러")
                val typeChoice = getTypeChoice()
                Order.items.add("타입 : ${getTypeName(typeChoice)}")
                val packagingChoice = getPackagingChoice()
                Order.items.add("포장 : ${if (packagingChoice) "포장함" else "포장 안함"}")
            }
            3 -> {
                Order.items.add("상품 : 원두")
                val beansChoice = getBeansChoice()
                Order.items.add("타입 : ${getBeansName(beansChoice)}")
                val packagingChoice = getPackagingChoice()
                Order.items.add("포장 : ${if (packagingChoice) "포장함" else "포장 안함"}")
            }
            4 -> {
                println("========================")
                println("주문이 완료 되었습니다.")
                println("주문 내역: ")
                for ((index, item) in Order.items.withIndex()) {
                    println("${item} ")
                }
                println("========================")
            }
            else -> {
                println("잘못 입력하셨습니다. 다시 시도해주세요.")
            }
        }
    }
}

fun getColorChoice(): Int {
    println("1. 초록색")
    println("2. 노랑색")
    println("3. 민트색")
    print("원하시는 색상 선택하세요: ")
    return readLine()?.toIntOrNull() ?: 0
}
fun getColorName(colorChoice: Int): String {
    return when (colorChoice) {
        1 -> "초록색"
        2 -> "노랑색"
        3 -> "민트색"
        else -> "알 수 없음"
    }
}

fun getTypeChoice(): Int {
    println("1. 스테인리스")
    println("2. 콜드컵")
    println("3. 보온병")
    print("원하시는 종류를 선택하세요: ")
    return readLine()?.toIntOrNull() ?: 0
}
fun getTypeName(typeChoice: Int): String {
    return when (typeChoice) {
        1 -> "스테인리스"
        2 -> "콜드컵"
        3 -> "보온병"
        else -> "알 수 없음"
    }
}

fun getBeansChoice(): Int {
    println("1. 아라비카")
    println("2. 콜롬비아")
    println("3. 에티오피아")
    print("원하시는 원두를 선택하세요: ")
    return readLine()?.toIntOrNull() ?: 0
}
fun getBeansName(beansChoice: Int): String {
    return when (beansChoice) {
        1 -> "아라비카"
        2 -> "콜롬비아"
        3 -> "에티오피아"
        else -> "알 수 없음"
    }
}
fun getPackagingChoice(): Boolean {
    println("1. YES")
    println("2. NO")
    print("포장을 원하시면 1번 아니면 2번을 선택해 주세요: ")
    val input = readLine()!!
    return input == "1"
}
