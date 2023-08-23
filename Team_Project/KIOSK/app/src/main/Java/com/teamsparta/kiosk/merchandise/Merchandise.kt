package com.teamsparta.kiosk.merchandise

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.OrderItem
import com.teamsparta.kiosk.OrderManager
import com.teamsparta.kiosk.printOrderItems
import com.teamsparta.kiosk.selectQuantity


open class Merchandise(name: String, price: Int) : Item(name, price) {

    companion object {
        private val merchandiseList = mutableListOf<Merchandise>()

        fun createTumbler(name: String, price: Int, size: String, color: String): Tumbler {
            val tumbler = Tumbler(name, price, size, color)
            merchandiseList.add(tumbler)
            return tumbler
        }

        fun createMug(name: String, price: Int, size: String, color: String): Mug {
            val mug = Mug(name, price, size, color)
            merchandiseList.add(mug)
            return mug
        }

        fun createWholeBean(name: String, price: Int, size: String): WholeBean {
            val wholeBean = WholeBean(name, price, size)
            merchandiseList.add(wholeBean)
            return wholeBean
        }
    }
}

val shoppingCart = mutableListOf<Pair<Merchandise, Int>>()

fun merchandiseMenu() {
    while (true) {
        println("< 상품 메뉴 >")
        println("1. 머그컵")
        println("2. 텀블러")
        println("3. 원두")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")
        val choice = readlnOrNull()?.toIntOrNull()

        var createdMerchandise: Merchandise? = null

        when (choice) {
            1 -> {
                val color = selectColor()
                val size = selectSize("머그컵")
                if (color != null && size != null) {
                    createdMerchandise = Merchandise.createMug("머그컵", 8000, size, color)
                }
            }

            2 -> {
                val color = selectColor()
                val size = selectSize("텀블러")
                if (color != null && size != null) {
                    createdMerchandise = Merchandise.createTumbler("텀블러", 10000, size, color)
                }
            }

            3 -> {
                val size = selectSize("원두")
                if (size != null) {
                    createdMerchandise = Merchandise.createWholeBean("원두", 15000, size)
                }
            }

            0 -> {
                println("돌아갑니다.")
                break
            }

            else -> println("올바른 메뉴 번호를 입력해주세요.")
        }

        if (createdMerchandise != null) {
            val quantity = selectQuantity()
            selectAndAddMenuItem(Pair(createdMerchandise, quantity))
            break
        } else {
            println("주문 목록이 비었습니다.")
        }
    }
}

fun selectColor(): String? {
    val colors = listOf("red", "blue", "green", "yellow", "orange", "purple", "black", "white")

    while (true) {
        println("\n색상 선택")
        colors.forEachIndexed { i, color ->
            println("${i + 1}. $color")
        }
        println("0. 뒤로가기")
        print("원하는 색상을 선택하세요: ")

        val choice = readlnOrNull()?.toIntOrNull()

        if (choice != null) {
            if (choice in 1..8) return colors[choice - 1]
            else if (choice == 0) return null
        }
        println("다시 입력해주세요.")
    }
}

fun selectAndAddMenuItem(menu: Pair<Merchandise, Int>) {
    val (item, quantity) = menu

    println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
    println("1. 확인 2. 취소")
    print("선택: ")
    when (readlnOrNull()?.toIntOrNull()) {
        1 -> {
            shoppingCart.add(Pair(item, quantity))
            println("장바구니에 상품이 추가되었습니다.")
            val orderItem = OrderItem.MerchandiseOrderItem(item, quantity)
            OrderManager.items.add(orderItem)
            printOrderItems() // 수정된 코드
            println("---------------추가 완료---------------")
            return
        }

        2 -> {
            println("취소되었습니다.")
        }

        else -> {
            println("잘못 입력하셨습니다.")
        }
    }
}

fun selectSize(type: String): String? {
    val sizes = when (type) {
        "텀블러", "머그컵" -> listOf("250ml", "350ml", "550ml", "400ml", "600ml", "800ml", "1000ml")
        "원두" -> listOf("200g", "300g", "400g", "500g", "1kg")
        else -> emptyList()
    }

    while (true) {
        println("\n용량 선택")
        sizes.forEachIndexed { i, size ->
            println("${i + 1}. $size")
        }
        println("0. 뒤로가기")
        print("원하는 용량을 선택하세요: ")

        val choice = readlnOrNull()?.toIntOrNull()

        if (choice != null) {
            if (choice >= 1 && choice <= sizes.size) return sizes[choice - 1]
            else if (choice == 0) return null
        }
        println("다시 입력해주세요.")
    }
}