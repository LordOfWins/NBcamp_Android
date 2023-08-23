package com.teamsparta.kiosk.teaAde

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.Order
import com.teamsparta.kiosk.OrderBaseTea
import com.teamsparta.kiosk.printBaseTeaOrderItems

open class BaseTea(name: String, price: Int, val size: String) : Item(name, price) {

    companion object {
        private val baseTeaList = mutableListOf<BaseTea>()

        fun createIceTea(name: String, price: Int, size: String, packaging: String): IceTea {
            val iceTea = IceTea(name, price, size, packaging)
            baseTeaList.add(iceTea)
            return iceTea
        }

        fun createAde(name: String, price: Int, size: String, packaging: String): Ade {
            val ade = Ade(name, price, size, packaging)
            baseTeaList.add(ade)
            return ade
        }

        fun createTea(name: String, price: Int, size: String, packaging: String): Tea {
            val tea = Tea(name, price, size, packaging)
            baseTeaList.add(tea)
            return tea
        }
    }
}

class IceTea(name: String, price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)

class Ade(name: String, price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)

class Tea(name: String, price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)


fun teaAdeMenu() {
    while (true) {
        println("\n티/에이드")
        println("1. 아이스티")
        println("2. 에이드")
        println("3. 차")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")

        when (readlnOrNull()) {
            "1" -> {
                val iceTeaPair = iceTeaMenu()
                if (iceTeaPair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val iceTea = BaseTea.createIceTea(
                                "${iceTeaPair.first} 아이스티", iceTeaPair.second, selectedSize, selectedPackaging
                            )
                            Order.items.add(iceTea)
                            OrderBaseTea.items.add(iceTea)
                            printBaseTeaOrderItems()
                            println("${iceTeaPair.first} 아이스티 메뉴를 저장했습니다.")
                            break
                        }
                    }
                }
            }

            "2" -> {
                val adePair = AdeMenu()
                if (adePair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val ade = BaseTea.createAde(
                                "${adePair.first} 에이드", adePair.second, selectedSize, selectedPackaging
                            )
                            Order.items.add(ade)
                            OrderBaseTea.items.add(ade)
                            printBaseTeaOrderItems()
                            println("${adePair.first} 에이드 메뉴를 저장했습니다.")
                            break
                        }
                    }
                }
            }

            "3" -> {
                val teaPair = teaSelection()
                if (teaPair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val tea =
                                BaseTea.createTea("${teaPair.first} 차", teaPair.second, selectedSize, selectedPackaging)
                            Order.items.add(tea)
                            OrderBaseTea.items.add(tea)
                            printBaseTeaOrderItems()
                            println("${teaPair.first} 차 메뉴를 저장했습니다.")
                            break
                        }
                    }
                }
            }

            "0" -> {
                println("뒤로가기")
                break
            }

            else -> {
                println("다시 입력해주세요.")
            }
        }
    }
}

fun iceTeaMenu(): Pair<String, Int>? {
    while (true) {
        println("\n아이스티")
        println("1. 레몬")
        println("2. 복숭아")
        println("3. 리치앤망고")
        println("4. 얼그레이")
        println("5. 딸기")
        println("6. 수박")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")

        val selectedPair = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "레몬" to 1600
            2 -> "복숭아" to 1900
            3 -> "리치앤망고" to 2000
            4 -> "얼그레이" to 2200
            5 -> "딸기" to 1800
            6 -> "수박" to 2100
            0 -> {
                println("뒤로가기")
                return null
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }

        return selectedPair
    }
}

fun AdeMenu(): Pair<String, Int>? {
    while (true) {
        println("에이드")
        println("1. 자몽")
        println("2. 레몬")
        println("3. 청포도")
        println("4. 오렌지")
        println("5. 한라봉")
        println("6. 블루베리")
        println("7. 복숭아")
        println("8. 수박")
        println("9. 딸기")
        println("10. 코코넛 에이드")
        println("11. 키위 에이드")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        val selectedPair = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "자몽" to 3000
            2 -> "레몬" to 3100
            3 -> "청포도" to 3100
            4 -> "오렌지" to 3200
            5 -> "한라봉" to 3000
            6 -> "블루베리" to 3100
            7 -> "복숭아" to 3100
            8 -> "수박" to 3500
            9 -> "딸기" to 3200
            10 -> "코코넛 에이드" to 3100
            11 -> "키위 에이드" to 3100
            0 -> {
                println("뒤로가기")
                return null
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }

        return selectedPair
    }
}


fun selectSize(): String {
    while (true) {
        println("\n사이즈 선택")
        println("1. Large")
        println("2. Grande")
        println("3. Venti")
        println("0. 뒤로가기")
        print("원하는 사이즈를 선택하세요: ")

        val selectedSize = when (readlnOrNull()) {
            "1" -> "Large"
            "2" -> "Grande"
            "3" -> "Venti"
            "0" -> {
                println("뒤로가기")
                return ""
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }

        return selectedSize
    }
}

fun selectPackaging(): String {
    while (true) {
        println("\n포장 옵션 선택")
        println("1. 포장")
        println("2. 매장")
        println("0. 뒤로가기")
        print("원하는 포장 옵션을 선택하세요: ")

        val selectedPackaging = when (readlnOrNull()) {
            "1" -> "포장"
            "2" -> "매장"
            "0" -> {
                println("뒤로가기")
                return ""
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }

        return selectedPackaging
    }
}

fun teaSelection(): Pair<String, Int>? {
    while (true) {
        println("\n차 메뉴")
        println("1. 녹차")
        println("2. 국화차")
        println("3. 유자차")
        println("0. 뒤로가기")
        print("원하는 차를 선택하세요: ")

        val selectedPair = when (readlnOrNull()) {
            "1" -> "녹차" to 1000
            "2" -> "국화차" to 1200
            "3" -> "유자차" to 1400
            "0" -> {
                println("뒤로가기")
                return null
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }

        return selectedPair
    }
}