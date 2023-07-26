
import com.teamsparta.kiosk.User
import com.teamsparta.kiosk.coffee.ColdBrewLatte
import com.teamsparta.kiosk.coffee.selectedItemMenu
import com.teamsparta.kiosk.decafCoffee.Decaf
import com.teamsparta.kiosk.decafCoffee.DecaffeineAmericano
import com.teamsparta.kiosk.decafCoffee.DecaffeineCafeMocha
import com.teamsparta.kiosk.decafCoffee.DecaffeineCapuchiino
import com.teamsparta.kiosk.decafCoffee.DecaffeineCaramelMacchiato
import com.teamsparta.kiosk.decafCoffee.DecaffeineEspresso
import com.teamsparta.kiosk.decafCoffee.DecaffeineLatte
import com.teamsparta.kiosk.decafCoffee.orderList

fun decafCoffeeMenu(user: User) {
    while (true) {
        println("----------------------------------")
        println("커피 메뉴")
        println("1. 디카페인 아메리카노         | 1,500원 |        ")
        println("2. 디카페인 카페라떼          | 2,500원 |       ")
        println("3. 디카페인 카라멜 마끼아또    | 3,000원 |       ")
        println("4. 디카페인 카푸치노          | 1,500원 |       ")
        println("5. 디카페인 에스프레소        | 1,500원 |       ")
        println("6. 디카페인 콜드브루          | 2,500원 |       ")
        println("7. 디카페인 콜드브루 라떼     | 3,000원 |       ")
        println("0. 뒤로가기")

        print("원하시는 메뉴를 선택해주세요 : ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                selectedItemMenu(
                    user, DecaffeineAmericano(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            2 -> {
                selectedItemMenu(
                    user, DecaffeineCaramelMacchiato(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            3 -> {
                selectedItemMenu(
                    user, DecaffeineLatte(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            4 -> {
                selectedItemMenu(
                    user, DecaffeineCafeMocha(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            5 -> {
                selectedItemMenu(
                    user, DecaffeineEspresso(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            6 -> {
                selectedItemMenu(
                    user, DecaffeineCapuchiino(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            7 -> {
                selectedItemMenu(
                    user, ColdBrewLatte(
                        size = "",
                        temperature = null,
                        shot = null,
                        packaging = null,
                        whippedCream = null
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

fun selectedItemMenu(user: User, selectedCoffee: Decaf) {
    var temperature: String? = null
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    var whippedCream: String? = null

    while (temperature == null) {
        println("\n온도 선택")
        println("1. 핫 2. 아이스")
        print("선택: ")
        temperature = when (readLine()?.toIntOrNull()) {
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
        size = when (readLine()?.toIntOrNull()) {
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
        shot = when (readLine()?.toIntOrNull()) {
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
        println("1. 포장 2. 매장 식사")
        print("선택: ")
        packaging = when (readLine()?.toIntOrNull()) {
            1 -> "포장"
            2 -> "매장 식사"
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                null
            }
        }
    }

    println("\n현재까지 선택한 옵션: ${temperature}, ${size}, ${shot}, $packaging")

    if (selectedCoffee is DecaffeineCaramelMacchiato) {
        while (whippedCream == null) {
            println("\n휘핑 크림 추가 여부")
            println("1. 휘핑 크림 추가  2. 휘핑 크림 없음")
            print("선택: ")
            whippedCream = when (readLine()?.toIntOrNull()) {
                1 -> "휘핑 크림 추가"
                2 -> "휘핑 크림 없음"
                else -> {
                    println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                    null
                }
            }
        }
        println("\n최종 옵션: ${temperature}, ${size}, ${shot}, ${packaging}, ${whippedCream}(추가됨)")
    }

    var confirm: Int? = null
    while (confirm == null) {
        println("\n위 메뉴를 장바구니에 추가하시겠습니까?")
        println("1. 확인 2. 취소")
        print("선택: ")
        confirm = readLine()?.toIntOrNull()
        when (confirm) {
            1 -> {
                orderList(temperature, size, shot, packaging, whippedCream, selectedCoffee, user)
                println("${selectedCoffee.name}이(가) 장바구니에 추가되었습니다.")
            }

            2 -> println("취소되었습니다.")
            else -> {
                println("잘못된 입력입니다. 1 또는 2를 입력하세요.")
                confirm = null
            }
        }
    }
}
