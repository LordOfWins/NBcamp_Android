package com.teamsparta.kiosk.dessert

import com.teamsparta.kiosk.Item
import com.teamsparta.kiosk.Order
import com.teamsparta.kiosk.OrderDessert
import com.teamsparta.kiosk.printDessertOrderItems


open class Dessert(name: String, price: Int, var packaging: String?) : Item(name, price) {
    companion object {
        private val dessertList = mutableListOf<Dessert>()

        fun createMacaron(name: String, price: Int, packaging: String, flavor: String): Macaron {
            val macaron = Macaron(name, price, packaging, flavor)
            dessertList.add(macaron)
            return macaron
        }

        fun createCake(name: String, price: Int, packaging: String, flavor: String): Cake {
            val cake = Cake(name, price, packaging, flavor)
            dessertList.add(cake)
            return cake
        }

        fun createCookie(name: String, price: Int, packaging: String?, flavor: String): Cookie {
            val cookie = Cookie(name, price, packaging, flavor)
            dessertList.add(cookie)
            return cookie
        }

        fun createIceCream(name: String, price: Int, packaging: String, flavor: String, dryIce: String?): IceCream {
            val iceCream = IceCream(name, price, packaging, flavor, dryIce)
            dessertList.add(iceCream)
            return iceCream
        }
    }
}

class Macaron(name: String, price: Int, packaging: String?, var flavor: String?) : Dessert(name, price, packaging)


class Cake(name: String, price: Int, packaging: String?, var flavor: String?) : Dessert(name, price, packaging)


class Cookie(name: String, price: Int, packaging: String?, var flavor: String?) : Dessert(name, price, packaging)


class IceCream(name: String, price: Int, packaging: String?, var flavor: String?, var dryIce: String?) :
    Dessert(name, price, packaging)


fun dessertMenu() {
    while (true) {
        println("디저트 메뉴")
        println("1. 마카롱")
        println("2. 케익류")
        println("3. 쿠키")
        println("4. 아이스크림")
        println("0. 뒤로가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readln()) {
            "1" -> {
                val macaronTriple = macaronMenu("마카롱")
                if (macaronTriple != null) {
                    val selectedPackaging = packagingMenu("마카롱")
                    if (selectedPackaging.isNotEmpty()) {
                        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
                        println("1. 확인 2. 취소")
                        print("선택: ")
                        val selected = readln().toIntOrNull()
                        if (selected == 1) {
                            val macaron = Dessert.createMacaron(
                                macaronTriple.first, macaronTriple.second, selectedPackaging, macaronTriple.third
                            )
                            Order.items.add(macaron)
                            OrderDessert.items.add(macaron)
                            printDessertOrderItems()
                            println("---------------주문 완료---------------")
                            break
                        } else if (selected == 2) {
                            println("취소되었습니다.")
                            break
                        } else {
                            println("잘못 입력하셨습니다.")
                            continue
                        }
                    }
                }
            }

            "2" -> {
                val cakeTriple = cakeMenu("케익")
                if (cakeTriple != null) {
                    val selectedPackaging = packagingMenu("케익")
                    if (selectedPackaging.isNotEmpty()) {
                        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
                        println("1. 확인 2. 취소")
                        print("선택: ")
                        val selected = readln().toIntOrNull()
                        if (selected == 1) {
                            val cake = Dessert.createCake(
                                cakeTriple.first, cakeTriple.second, selectedPackaging, cakeTriple.third
                            )
                            Order.items.add(cake)
                            OrderDessert.items.add(cake)
                            printDessertOrderItems()
                            println("---------------주문 완료---------------")
                            break
                        } else if (selected == 2) {
                            println("취소되었습니다.")
                            break
                        } else {
                            println("잘못 입력하셨습니다.")
                            continue
                        }
                    }
                }
                break
            }

            "3" -> {
                val cookieTriple = cookieMenu("쿠키")
                if (cookieTriple != null) {
                    val selectedPackaging = packagingMenu("쿠키")
                    if (selectedPackaging.isNotEmpty()) {
                        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
                        println("1. 확인 2. 취소")
                        print("선택: ")
                        val selected = readln().toIntOrNull()
                        if (selected == 1) {
                            val cookie = Dessert.createCookie(
                                cookieTriple.first, cookieTriple.second, selectedPackaging, cookieTriple.third
                            )
                            Order.items.add(cookie)
                            OrderDessert.items.add(cookie)
                            printDessertOrderItems()
                            println("---------------주문 완료---------------")
                            break
                        } else if (selected == 2) {
                            println("취소되었습니다.")
                            break
                        } else {
                            println("잘못 입력하셨습니다.")
                            continue
                        }
                    }
                }
                break
            }

            "4" -> {
                val iceCreamTriple = iceCreamMenu("아이스크림")
                if (iceCreamTriple != null) {
                    val selectedPackaing = packagingMenu("아이스크림")
                    if (selectedPackaing.isNotEmpty()) {
                        val selectedDryIce = withDryIce()
                        if (selectedDryIce.isNotEmpty()) {
                            println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
                            println("1. 확인 2. 취소")
                            print("선택: ")
                            val selected = readln().toIntOrNull()
                            if (selected == 1) {
                                val iceCream = Dessert.createIceCream(
                                    iceCreamTriple.first,
                                    iceCreamTriple.second,
                                    selectedPackaing,
                                    iceCreamTriple.third,
                                    selectedDryIce
                                )
                                Order.items.add(iceCream)
                                OrderDessert.items.add(iceCream)
                                printDessertOrderItems()
                                println("---------------주문 완료---------------")
                                break
                            } else if (selected == 2) {
                                println("취소되었습니다.")
                                break
                            } else {
                                println("잘못 입력하셨습니다.")
                                continue
                            }
                        }
                    }
                }
                break
            }

            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun macaronMenu(name: String): Triple<String, Int, String>? {
    while (true) {
        println(name)
        println("종류를 선택하세요")
        println("1. 초코")
        println("2. 민트")
        println("3. 딸기")
        println("4. 바닐라")
        println("5. 바나나")
        println("0. 뒤로가기")

        print("원하는 종류를 선택하세요: ")

        return when (readlnOrNull().orEmpty()) {
            "1" -> {
                val selectedMacaron = Triple("초코 마카롱", 3500, "초코")
                println("${selectedMacaron.first}을 선택하셨습니다.")
                selectedMacaron
            }

            "2" -> {
                val selectedMacaron = Triple("민트 마카롱", 3600, "민트")
                println("${selectedMacaron.first}을 선택하셨습니다.")
                selectedMacaron
            }

            "3" -> {
                val selectedMacaron = Triple("딸기 마카롱", 3400, "딸기")
                println("${selectedMacaron.first}을 선택하셨습니다.")
                selectedMacaron
            }

            "4" -> {
                val selectedMacaron = Triple("바닐라 마카롱", 3700, "바닐라")
                println("${selectedMacaron.first}을 선택하셨습니다.")
                selectedMacaron
            }

            "5" -> {
                val selectedMacaron = Triple("바나나 마카롱", 3800, "바나나")
                println("${selectedMacaron.first}을 선택하셨습니다.")
                selectedMacaron
            }

            "0" -> {
                println("뒤로 돌아갑니다.")
                null
            }

            else -> {
                println("유효하지 않은 입력입니다. 다시 시도하세요.")
                continue
            }
        }
    }
}

fun cakeMenu(name: String): Triple<String, Int, String>? {
    while (true) {
        println(name)
        println("종류를 선택하세요")
        println("1. 딸기생크림")
        println("2. 티라미슈")
        println("3. 당근")
        println("4. 치즈")
        println("5. 초코")
        println("0. 뒤로가기")

        print("원하는 종류를 선택하세요: ")

        return when (readlnOrNull().orEmpty()) {
            "1" -> {
                val selectedCake = Triple("딸기생크림 케이크", 19000, "딸기")
                println("${selectedCake.first}을(를) 선택하셨습니다.")
                selectedCake
            }

            "2" -> {
                val selectedCake = Triple("티라미슈 케이크", 22000, "티라미슈")
                println("${selectedCake.first}을(를) 선택하셨습니다.")
                selectedCake
            }

            "3" -> {
                val selectedCake = Triple("당근 케이크", 18000, "당근")
                println("${selectedCake.first}을(를) 선택하셨습니다.")
                selectedCake
            }

            "4" -> {
                val selectedCake = Triple("치즈 케이크", 17000, "치즈")
                println("${selectedCake.first}을(를) 선택하셨습니다.")
                selectedCake
            }

            "5" -> {
                val selectedCake = Triple("초코 케이크", 20000, "초코")
                println("${selectedCake.first}을(를) 선택하셨습니다.")
                selectedCake
            }

            "0" -> {
                println("뒤로 돌아갑니다.")
                null
            }

            else -> {
                println("유효하지 않은 입력입니다. 다시 시도하세요.")
                continue
            }
        }
    }
}

fun cookieMenu(name: String): Triple<String, Int, String>? {
    while (true) {
        println(name)
        println("종류를 선택하세요")
        println("1. 초코칩 쿠키")
        println("2. 더블 초코칩 쿠키")
        println("3. 오트밀 레이즌 쿠키")
        println("4. 마카다미아 넛 쿠키")
        println("0. 뒤로가기")

        print("원하는 종류를 선택하세요: ")

        return when (readlnOrNull().orEmpty()) {
            "1" -> {
                val selectedCookie = Triple("초코칩 쿠키", 5000, "초코칩")
                println("${selectedCookie.first}을(를) 선택하셨습니다.")
                selectedCookie
            }

            "2" -> {
                val selectedCookie = Triple("더블 초코칩 쿠키", 5500, "더블 초코칩")
                println("${selectedCookie.first}을(를) 선택하셨습니다.")
                selectedCookie
            }

            "3" -> {
                val selectedCookie = Triple("오트밀 레이즌 쿠키", 4900, "오트밀 레이즌")
                println("${selectedCookie.first}을(를) 선택하셨습니다.")
                selectedCookie
            }

            "4" -> {
                val selectedCookie = Triple("마카다미아 넛 쿠키", 5000, "마카다미아 넛")
                println("${selectedCookie.first}을(를) 선택하셨습니다.")
                selectedCookie
            }

            "0" -> {
                println("뒤로 돌아갑니다.")
                null
            }

            else -> {
                println("유효하지 않은 입력입니다. 다시 시도하세요.")
                continue
            }
        }
    }
}


fun iceCreamMenu(name: String): Triple<String, Int, String>? {
    while (true) {
        println(name)
        println("종류를 선택하세요")
        println("1. 바닐라 아이스크림")
        println("2. 초콜릿 아이스크림")
        println("3. 딸기 아이스크림")
        println("4. 민트 초콜릿 칩 아이스크림")
        println("0. 뒤로가기")

        print("원하는 종류를 선택하세요: ")

        return when (readlnOrNull().orEmpty()) {
            "1" -> {
                val selectedIceCream = Triple("바닐라 아이스크림", 3500, "바닐라")
                println("${selectedIceCream.first}을(를) 선택하셨습니다.")
                selectedIceCream
            }

            "2" -> {
                val selectedIceCream = Triple("초콜릿 아이스크림", 4000, "초코")
                println("${selectedIceCream.first}을(를) 선택하셨습니다.")
                selectedIceCream
            }

            "3" -> {
                val selectedIceCream = Triple("딸기 아이스크림", 3500, "딸기")
                println("${selectedIceCream.first}을(를) 선택하셨습니다.")
                selectedIceCream
            }

            "4" -> {
                val selectedIceCream = Triple("민트 초코 아이스크림", 3700, "민트 초코")
                println("${selectedIceCream.first}을(를) 선택하셨습니다.")
                selectedIceCream
            }

            "0" -> {
                println("뒤로 돌아갑니다.")
                null
            }

            else -> {
                println("유효하지 않은 입력입니다. 다시 시도하세요.")
                continue
            }
        }
    }
}


fun withDryIce(): String {
    while (true) {
        println("드라이아이스 필요하세요?")
        println("1. 필요 없음")
        println("2. 필요함")
        val selectedDryIce = when (readln().toIntOrNull()) {
            1 -> "드라이아이스 없음"
            2 -> "드라이아이스 동봉"
            else -> {
                println("잘못 입력하셨습니다.")
                continue
            }
        }
        return selectedDryIce
    }
}

fun packagingMenu(name: String): String {
    while (true) {
        println("$name 포장 여부")
        println("1. 포장")
        println("2. 매장 식사")
        println("0. 뒤로가기")
        print("포장 여부를 선택하세요: ")
        val selectedPackaing = when (readln().toIntOrNull()) {
            1 -> {
                "포장"
            }

            2 -> {
                "매장 식사"
            }

            0 -> {
                println("뒤로 돌아갑니다.")
                return ""
            }

            else -> {
                println("다시 입력해주세요.")
                continue
            }
        }
        return selectedPackaing
    }
}