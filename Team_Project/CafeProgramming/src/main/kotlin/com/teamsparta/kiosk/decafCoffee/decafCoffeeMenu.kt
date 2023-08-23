import com.teamsparta.kiosk.Order
import com.teamsparta.kiosk.OrderDecaf
import com.teamsparta.kiosk.decafCoffee.*
import com.teamsparta.kiosk.printDecafOrderItems

fun decafCoffeeMenu() {
    while (true) {
        println("----------------------------------")
        println("커피 메뉴")
        println("1. 디카페인 아메리카노          | 1,500원 |       ")
        println("2. 디카페인 카페라떼            | 2,500원 |       ")
        println("3. 디카페인 카라멜 마끼아또      | 3,000원 |       ")
        println("4. 디카페인 카푸치노            | 1,500원 |       ")
        println("5. 디카페인 에스프레소          | 1,500원 |       ")
        println("6. 디카페인 콜드브루            | 2,500원 |        ")
        println("7. 디카페인 콜드브루 라떼        | 3,000원 |        ")
        println("0. 뒤로가기")

        print("원하시는 메뉴를 선택해주세요 : ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                decaffeineMenu(
                    DecaffeineAmericano(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            2 -> {
                decaffeineMenu(
                    DecaffeineCaramelMacchiato(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            3 -> {
                decaffeineMenu(
                    DecaffeineLatte(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            4 -> {
                decaffeineMenu(
                    DecaffeineCafeMocha(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            5 -> {
                decaffeineMenu(
                    DecaffeineEspresso(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            6 -> {
                decaffeineMenu(
                    DecaffeineCapuchiino(
                        size = "", temperature = null, shot = null, packaging = null, whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            0 -> break
            else -> com.teamsparta.kiosk.error()
        }
        println("----------------------------------")
    }
}

fun decaffeineMenu(selectedCoffee: Decaf) {
    var temperature: String? = null
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    var whippedCream: String? = null
    var quantity: Int

    while (temperature == null) {
        println("\n온도 선택")
        println("1. 핫 2. 아이스")
        print("선택: ")
        temperature = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "핫"
            2 -> "아이스"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    while (size == null) {
        println("\n사이즈 선택")
        println("1. Tall 2. Grande 3. Venti")
        print("선택: ")
        size = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "Tall"
            2 -> "Grande"
            3 -> "Venti"
            else -> {
                println("잘못된 입력입니다. 1~3 사이의 숫자를 입력하세요.")
                null
            }
        }
    }

    while (shot == null) {
        println("\n샷 추가 선택")
        println("1. 샷 추가 2. 기본")
        print("선택: ")
        shot = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "샷 추가"
            2 -> "기본"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    while (packaging == null) {
        println("\n포장 여부 선택")
        println("1. 포장 2. 포장 안 함")
        print("선택: ")
        packaging = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "포장"
            2 -> "포장 안 함"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }


    while (whippedCream == null) {
        println("\n휘핑 크림 추가 여부")
        println("1. 휘핑 크림 추가  2. 휘핑 크림 없음")
        print("선택: ")
        whippedCream = when (readlnOrNull()?.toIntOrNull()) {
            1 -> "휘핑 크림 추가"
            2 -> "휘핑 크림 없음"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    while (true) {
        println("\n수량을 입력해주세요(10000개까지 가능합니다)")
        print("선택: ")
        quantity = readlnOrNull()?.toIntOrNull()!!
        if (quantity in 1..9999) {
            for (i in 0..<quantity) {
                selectedCoffee.price *= quantity
            }
            break
        } else {
            println("잘못된 입력입니다. 10000이하 1 이상의 숫자를 입력하세요.")
        }
    }


    println("\n최종 옵션: ${temperature}, ${size}, ${shot}, ${packaging}, ${whippedCream}, ${quantity}개")

    var confirm: Int? = null
    while (confirm == null) {
        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인 2. 취소")
        print("선택: ")
        confirm = readlnOrNull()?.toIntOrNull()
        when (confirm) {
            1 -> {
                val updatedCoffee = when (selectedCoffee) {
                    is DecaffeineAmericano -> DecaffeineAmericano(
                        size = size,
                        shot = shot,
                        temperature = temperature,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity,
                    )

                    is DecaffeineCaramelMacchiato -> DecaffeineCaramelMacchiato(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity
                    )

                    is DecaffeineLatte -> DecaffeineLatte(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity
                    )

                    is DecaffeineCafeMocha -> DecaffeineCafeMocha(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity
                    )

                    is DecaffeineEspresso -> DecaffeineEspresso(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity
                    )

                    is DecaffeineCapuchiino -> DecaffeineCapuchiino(
                        size = size,
                        temperature = temperature,
                        shot = shot,
                        packaging = packaging,
                        whippedCream = whippedCream,
                        quantity = quantity
                    )

                    else -> null
                } ?: throw IllegalStateException("Unknown coffee class.")
                Order.items.add(updatedCoffee)
                OrderDecaf.items.add(updatedCoffee)
                printDecafOrderItems()
                println("${updatedCoffee.name}가 장바구니에 추가되었습니다.")
            }

            2 -> println("취소되었습니다.")
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                confirm = null
            }
        }
    }
}
