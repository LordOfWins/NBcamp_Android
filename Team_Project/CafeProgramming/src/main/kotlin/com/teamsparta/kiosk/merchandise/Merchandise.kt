package com.teamsparta.kiosk.merchandise

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.Order
import com.teamsparta.kiosk.OrderMerchandise
import com.teamsparta.kiosk.merchandise.Merchandise.Companion.createMug
import com.teamsparta.kiosk.merchandise.Merchandise.Companion.createTumbler
import com.teamsparta.kiosk.merchandise.Merchandise.Companion.createWholeBean
import com.teamsparta.kiosk.printMerchandiseOrderItems


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

class Tumbler(name: String = "텀블러", price: Int, var size: String, var color: String) : Merchandise(name, price)

class Mug(name: String = "머그컵", price: Int, var size: String, var color: String) : Merchandise(name, price)

class WholeBean(name: String = "원두", price: Int, var size: String) : Merchandise(name, price)

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
                    createdMerchandise = createMug("Mug", 8000, size, color)
                }
            }

            2 -> {
                val color = selectColor()
                val size = selectSize("텀블러")
                if (color != null && size != null) {
                    createdMerchandise = createTumbler("Tumbler", 10000, size, color)
                }
            }

            3 -> {
                val size = selectSize("원두")
                if (size != null) {
                    createdMerchandise = createWholeBean("WholeBean", 15000, size)
                }
            }

            0 -> {
                println("뒤로 돌아갑니다.")
                break
            }

            else -> println("올바른 메뉴 번호를 입력해주세요.")
        }

        if (createdMerchandise != null) {
            Order.items.add(createdMerchandise)
            OrderMerchandise.items.add(createdMerchandise)
            printMerchandiseOrderItems()
            println("선택한 상품이 주문 목록에 추가되었습니다.")
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

fun selectSize(type: String): String? {
    val sizes = when (type) {
        "Tumbler", "Mug" -> listOf("250ml", "350ml", "550ml", "400ml", "600ml", "800ml", "1000ml")
        "WholeBean" -> listOf("200g", "300g", "400g", "500g", "1kg")
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

