package com.teamsparta.kiosk

import com.teamsparta.kiosk.coffee.Coffee
import com.teamsparta.kiosk.decafCoffee.Decaf
import com.teamsparta.kiosk.dessert.Dessert
import com.teamsparta.kiosk.merchandise.Merchandise
import com.teamsparta.kiosk.merchandise.Mug
import com.teamsparta.kiosk.merchandise.Tumbler
import com.teamsparta.kiosk.merchandise.WholeBean
import com.teamsparta.kiosk.teaAde.BaseTea

sealed class OrderItem(open val quantity: Int, open val price: Int) {
    data class CoffeeOrderItem(val coffee: Coffee, override var quantity: Int) :
        OrderItem(quantity, coffee.price)

    data class DecafOrderItem(val decaf: Decaf, override var quantity: Int) :
        OrderItem(quantity, decaf.price)

    data class DessertOrderItem(
        val dessert: Dessert, val flavor: String, override var quantity: Int
    ) : OrderItem(quantity, dessert.price)

    data class MerchandiseOrderItem(val merchandise: Merchandise, override var quantity: Int) :
        OrderItem(quantity, merchandise.price)

    data class BaseTeaOrderItem(val baseTea: BaseTea, override var quantity: Int) :
        OrderItem(quantity, baseTea.price)
}

object OrderManager {
    val items = mutableListOf<OrderItem>()
}

fun printOrderItems() {
    val orderItems = OrderManager.items

    if (orderItems.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in orderItems.withIndex()) {
            when (item) {
                is OrderItem.CoffeeOrderItem -> {
                    val coffee = item.coffee
                    println("${index + 1}. 제품명: ${coffee.name}, 수량: ${item.quantity}, 가격: ${coffee.price * item.quantity}원")
                }

                is OrderItem.DecafOrderItem -> {
                    val decaf = item.decaf
                    println("${index + 1}. 제품명: ${decaf.name}, 수량: ${item.quantity}, 가격: ${decaf.price * item.quantity}원")
                }

                is OrderItem.DessertOrderItem -> {
                    val dessert = item.dessert
                    println("${index + 1}. 제품명: ${dessert.name}, 종류: ${dessert.name.split(" ")[0]}, 수량: ${item.quantity}, 가격: ${dessert.price * item.quantity}원")
                }

                is OrderItem.MerchandiseOrderItem -> {
                    when (val merchandise = item.merchandise) {
                        is Mug -> {
                            println("${index + 1}. 제품명: ${merchandise.name}, 색상: ${merchandise.color}, 사이즈: ${merchandise.size}, 수량: ${item.quantity}, 가격: ${merchandise.price * item.quantity}원")
                        }

                        is Tumbler -> {
                            println("${index + 1}. 제품명: ${merchandise.name}, 색상: ${merchandise.color}, 사이즈: ${merchandise.size}, 수량: ${item.quantity}, 가격: ${merchandise.price * item.quantity}원")
                        }

                        is WholeBean -> {
                            println("${index + 1}. 제품명: ${merchandise.name}, 사이즈: ${merchandise.size}, 수량: ${item.quantity}, 가격: ${merchandise.price * item.quantity}원")
                        }
                    }
                }

                is OrderItem.BaseTeaOrderItem -> {
                    val baseTea = item.baseTea
                    println("${index + 1}. 제품명: ${baseTea.name}, 사이즈: ${baseTea.size}, 수량: ${item.quantity}, 가격: ${baseTea.price * item.quantity}원")
                }
            }
        }
    }
}

fun selectQuantity(): Int {
    while (true) {
        println("\n원하시는 수량을 입력하세요(10000개까지 가능합니다) ")
        print("선택: ")
        val choice = readln().toIntOrNull()

        if (choice != null && choice in 1..10000) {
            return choice
        } else {
            println("유효하지 않은 입력입니다. 다시 시도하세요.")
        }
    }
}


