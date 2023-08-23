package com.teamsparta.kiosk

import com.teamsparta.kiosk.coffee.Coffee
import com.teamsparta.kiosk.decafCoffee.Decaf
import com.teamsparta.kiosk.dessert.*
import com.teamsparta.kiosk.merchandise.Merchandise
import com.teamsparta.kiosk.merchandise.Mug
import com.teamsparta.kiosk.merchandise.Tumbler
import com.teamsparta.kiosk.merchandise.WholeBean
import com.teamsparta.kiosk.teaAde.Ade
import com.teamsparta.kiosk.teaAde.BaseTea
import com.teamsparta.kiosk.teaAde.IceTea
import com.teamsparta.kiosk.teaAde.Tea

object Order {
    val items = mutableListOf<Item>()
}

object OrderCoffee {
    val items = mutableListOf<Coffee>()
}

object OrderDecaf {
    val items = mutableListOf<Decaf>()
}

object OrderDessert {
    val items = mutableListOf<Dessert>()
}

object OrderMerchandise {
    val items = mutableListOf<Merchandise>()
}

object OrderBaseTea {
    val items = mutableListOf<BaseTea>()
}

fun printCoffeeOrderItems() {
    if (OrderCoffee.items.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in OrderCoffee.items.withIndex()) {
            println("${index + 1}. ${item.name}, ${item.size}, ${item.temperature}, ${item.shot}, ${item.packageOption}")
        }
    }
}

fun printDecafOrderItems() {
    if (OrderDecaf.items.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in OrderDecaf.items.withIndex()) {
            println("${index + 1}. ${item.name}, ${item.size}, ${item.temperature}, ${item.shot}, ${item.packaging}, ${item.whippedCream}")
        }
    }
}

fun printDessertOrderItems() {
    if (OrderDessert.items.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in OrderDessert.items.withIndex()) {
            when (item) {
                is Macaron -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 맛: ${item.flavor}, 포장여부: ${item.packaging}")
                }

                is Cake -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 맛: ${item.flavor},  포장여부: ${item.packaging}")
                }

                is Cookie -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 맛: ${item.flavor},  포장여부: ${item.packaging}")
                }

                is IceCream -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 맛: ${item.flavor},  포장여부: ${item.packaging}, 드라이 아이스크림: ${item.dryIce}")
                }
            }
        }
    }
}

fun printMerchandiseOrderItems() {
    if (OrderMerchandise.items.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in OrderMerchandise.items.withIndex()) {
            when (item) {
                is Mug -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 색상: ${item.color}, 사이즈: ${item.size}")
                }

                is Tumbler -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 색상: ${item.color}, 사이즈: ${item.size}")
                }

                is WholeBean -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 사이즈: ${item.size}")
                }
            }
        }
    }
}

fun printBaseTeaOrderItems() {
    if (OrderBaseTea.items.isEmpty()) {
        println("장바구니에 추가된 상품이 없습니다.")
    } else {
        println("\n장바구니 목록:")
        for ((index, item) in OrderBaseTea.items.withIndex()) {
            when (item) {
                is IceTea -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 사이즈: ${item.size}, 포장여부: ${item.packaging}")
                }

                is Ade -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 사이즈: ${item.size}, 포장여부: ${item.packaging}")
                }

                is Tea -> {
                    println("${index + 1}. 제품명: ${item.name}, 가격: ${item.price}, 사이즈: ${item.size}, 포장여부: ${item.packaging}")
                }
            }
        }
    }
}