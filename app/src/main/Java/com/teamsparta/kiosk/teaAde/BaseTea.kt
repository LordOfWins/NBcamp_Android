package com.teamsparta.kiosk.teaAde

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.OrderItem
import com.teamsparta.kiosk.OrderManager
import com.teamsparta.kiosk.printOrderItems
import com.teamsparta.kiosk.selectQuantity

// BaseTea 클래스 정의
open class BaseTea(name: String, price: Int, val size: String) : Item(name, price) {

    companion object {
        private val baseTeaList = mutableListOf<BaseTea>()

        // 아이스티 생성 메소드
        fun createIceTea(name: String, price: Int, size: String, packaging: String): IceTea {
            val iceTea = IceTea(name, price, size, packaging)
            baseTeaList.add(iceTea)
            return iceTea
        }

        // 에이드 생성 메소드
        fun createAde(name: String, price: Int, size: String, packaging: String): Ade {
            val ade = Ade(name, price, size, packaging)
            baseTeaList.add(ade)
            return ade
        }

        // 차 생성 메소드
        fun createTea(name: String, price: Int, size: String, packaging: String): Tea {
            val tea = Tea(name, price, size, packaging)
            baseTeaList.add(tea)
            return tea
        }
    }
}

// IceTea 클래스 정의
class IceTea(name: String="아이스티", price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)

// Ade 클래스 정의
class Ade(name: String="에이드", price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)

// Tea 클래스 정의
class Tea(name: String="차", price: Int, size: String, var packaging: String? = null) :
    BaseTea(name, price, size)


// 티/에이드 메뉴 함수
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
                // 아이스티 메뉴 선택
                val iceTeaPair = iceTeaMenu()
                if (iceTeaPair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val iceTea = BaseTea.createIceTea(
                                "${iceTeaPair.first} 아이스티",
                                iceTeaPair.second,
                                selectedSize,
                                selectedPackaging
                            )
                            val quantity = selectQuantity()
                            selectAndAddMenuItem(
                                Pair(
                                    Triple(
                                        iceTea.name,
                                        iceTea.price,
                                        iceTea.size
                                    ), quantity
                                )
                            )
                            println("${iceTeaPair.first} 아이스티 메뉴를 저장했습니다.")
                            break
                        }
                    }
                }
            }

            "2" -> {
                // 에이드 메뉴 선택
                val adePair = AdeMenu()
                if (adePair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val ade = BaseTea.createAde(
                                "${adePair.first} 에이드",
                                adePair.second,
                                selectedSize,
                                selectedPackaging
                            )
                            val quantity = selectQuantity()
                            selectAndAddMenuItem(
                                Pair(
                                    Triple(ade.name, ade.price, ade.size),
                                    quantity
                                )
                            )
                            println("${adePair.first} 에이드 메뉴를 저장했습니다.")
                            break
                        }
                    }
                }
            }

            "3" -> {
                // 차 메뉴 선택
                val teaPair = teaSelection()
                if (teaPair != null) {
                    val selectedSize = selectSize()
                    if (selectedSize.isNotEmpty()) {
                        val selectedPackaging = selectPackaging()
                        if (selectedPackaging.isNotEmpty()) {
                            val tea = BaseTea.createTea(
                                "${teaPair.first} 차",
                                teaPair.second,
                                selectedSize,
                                selectedPackaging
                            )
                            val quantity = selectQuantity()
                            selectAndAddMenuItem(
                                Pair(
                                    Triple(tea.name, tea.price, tea.size),
                                    quantity
                                )
                            )
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

fun selectAndAddMenuItem(menu: Pair<Triple<String, Int, String>, Int>?) {
    if (menu != null) {
        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인 2. 취소")
        print("선택: ")
        val selected = com.teamsparta.kiosk.dessert.readlnOrNull()?.toIntOrNull()
        if (selected == 1) {
            val info = menu.first
            val quantity = menu.second
            val baseTea = BaseTea(info.first, info.second, info.third)
            val orderItem = OrderItem.BaseTeaOrderItem(baseTea, quantity)
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

// 아이스티 메뉴 함수
fun iceTeaMenu(): Pair<String, Int>? {
    while (true) {
        println("\n아이스티")
        println("1. 레몬                     | 1600원 |")
        println("2. 복숭아                   | 1900원 |")
        println("3. 리치앤망고                | 2000원 |")
        println("4. 얼그레이                  | 2200원 |")
        println("5. 딸기                     | 1800원 |")
        println("6. 수박                     | 2100원 |")
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

// 에이드 메뉴 함수
fun AdeMenu(): Pair<String, Int>? {
    while (true) {
        println("\n에이드")
        println("1. 자몽                 | 3000원 |")
        println("2. 레몬                 | 3100원 |")
        println("3. 청포도               | 3100원 |")
        println("4. 오렌지               | 3200원 |")
        println("5. 한라봉               | 3000원 |")
        println("6. 블루베리             | 3100원 |")
        println("7. 복숭아               | 3100원 |")
        println("8. 수박                 | 3500원 |")
        println("9. 딸기                 | 3200원 |")
        println("10. 코코넛              | 3100원 |")
        println("11. 키위                | 3100원 |")
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
            10 -> "코코넛" to 3100
            11 -> "키위" to 3100
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


// 사이즈 선택 함수
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

// 포장 옵션 선택 함수
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

// 차 선택 함수
fun teaSelection(): Pair<String, Int>? {
    while (true) {
        println("\n차 메뉴")
        println("1. 녹차                | 2000원 |")
        println("2. 국화차              | 3500원 |")
        println("3. 유자차              | 3300원 |")
        println("4. 레몬차              | 3100원 |")
        println("5. 자몽차              | 3100원 |")
        println("6. 블루베리차           | 3600원 |")
        println("7. 페퍼민트차           | 3500원 |")
        println("8. 카모마일차           | 3400원 |")
        println("9. 히비스커스차         | 3300원 |")
        println("10. 루이보스차          | 3200원 |")
        println("0. 뒤로가기")
        print("원하는 차를 선택하세요: ")

        val selectedPair = when (readlnOrNull()) {
            "1" -> "녹차" to 2000
            "2" -> "국화차" to 3500
            "3" -> "유자차" to 3300
            "4" -> "레몬차" to 3100
            "5" -> "자몽차" to 3100
            "6" -> "블루베리차" to 3600
            "7" -> "페퍼민트차" to 3500
            "8" -> "카모마일차" to 3400
            "9" -> "히비스커스차" to 3300
            "10" -> "루이보스차" to 3200
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
