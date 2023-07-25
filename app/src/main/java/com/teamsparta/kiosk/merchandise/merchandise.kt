package com.teamsparta.kiosk.merchandise

import com.teamsparta.kiosk.packagingMenu

object Order {
    val items = mutableListOf<String>()
}

data class MenuItem(
    val name: String,
    val menuType: String,
    val packaging: String,
)

fun merchandiseMenu() {
    while (true) {
        println("< 상품 메뉴 >")
        println("1. 머그컵")
        println("2. 텀블러")
        println("3. 원두")
        println("0. 뒤로가기")

        print("원하시는 상품을 선택하세요: ")
        when (readLine()!!) {
            "1" -> mugMenu("머그컵", "상품")
            "2" -> tumbrleMenu("텀블러", "상품")
            "3" -> beansMenu("원두", "상품")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun selectedItemMenu(name: String, type: String) {
    when (name) {
        "머그컵" -> mugMenu(name, type)
        "텀블러" -> tumbrleMenu(name, type)
        "원두" -> beansMenu(name, type)
    }
}

fun mugMenu(name: String, type: String) {
    while (true) {
        println("선택하신 상품은: ${name}")
        println("1. 색상")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> getColorChoice(name, type)
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun getColorChoice(name: String, type: String) {
    println("1. 초록색")
    println("2. 노랑색")
    println("3. 민트색")
    println("0. 뒤로가기")
    print("원하시는 색상 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val colorChoice = MenuItem("초록색", type, "포장")
            Order.items.add("색상 : ${colorChoice}")
        }

        "2" -> {
            val colorChoice = MenuItem("노랑색", type, "포장")
            Order.items.add("색상 : ${colorChoice}")
        }

        "3" -> {
            val colorChoice = MenuItem("민트색", type, "포장")
            Order.items.add("색상 : ${colorChoice}")
        }
        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun tumbrleMenu(name: String, type: String) {
    while (true) {
        println("선택하신 상품은: ${name}")
        println("1. 타입")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> getTypeChoice(name, type)
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun getTypeChoice(name: String, type: String) {
    println("1. 스테인리스")
    println("2. 콜드컵")
    println("3. 보온병")
    println("0. 뒤로가기")
    print("원하시는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val typeChoice = MenuItem("스테인리스", type, "포장")
            Order.items.add("타입 : ${typeChoice}")
        }

        "2" -> {
            val typeChoice = MenuItem("콜드컵", type, "포장")
            Order.items.add("타입 : ${typeChoice}")
        }

        "3" -> {
            val typeChoice = MenuItem("보온병", type, "포장")
            Order.items.add("타입 : ${typeChoice}")
        }

        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}

fun beansMenu(name: String, type: String) {
    while (true) {
        println("선택하신 상품은: ${name}")
        println("1. 원두")
        println("2. 포장 여부")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> getBeansChoice(name, type)
            "2" -> packagingMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun getBeansChoice(name: String, type: String) {
    println("1. 콜림비아")
    println("2. 에티오피아")
    println("3. 케냐")
    println("0. 뒤로가기")
    print("원하시는 종류를 선택하세요: ")

    when (readLine()!!) {
        "1" -> {
            val beanChoice = MenuItem("콜림비아", type, "포장")
            Order.items.add("원두 : ${beanChoice}")
        }

        "2" -> {
            val beanChoice = MenuItem("에티오피아", type, "포장")
            Order.items.add("원두 : ${beanChoice}")
        }

        "3" -> {
            val beanChoice = MenuItem("케냐", type, "포장")
            Order.items.add("원두 : ${beanChoice}")
        }

        "0" -> println("뒤로 돌아갑니다.")
        else -> com.teamsparta.kiosk.error()
    }
}
