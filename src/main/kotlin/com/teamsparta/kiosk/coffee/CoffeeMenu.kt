
import com.teamsparta.kiosk.coffee.*

fun coffeeMenu() {
    while (true) {
        println("----------------------------------")
        println("커피 메뉴")
        println("1. 아메리카노         | 1,500원 |        ")
        println("2. 카페라떼          | 2,500원 |       ")
        println("3. 카라멜 마끼아또    | 3,000원 |       ")
        println("4. 카푸치노          | 1,500원 |       ")
        println("5. 에스프레소        | 1,500원 |       ")
        println("6. 콜드브루          | 2,500원 |       ")
        println("7. 콜드브루 라떼      | 3,000원 |       ")
        println("0. 뒤로가기")

        print("원하시는 메뉴를 선택해주세요 : ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                selectedItemMenu(
                    Americano(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            2 -> {
                selectedItemMenu(
                    CafeLatte(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,

                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            3 -> {
                selectedItemMenu(
                    CaramelMacchiato(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            4 -> {
                selectedItemMenu(
                    Cappuccino(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            5 -> {
                selectedItemMenu(
                    Espresso(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            6 -> {
                selectedItemMenu(
                    ColdBrew(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
                    )
                )
                println("---------------주문 완료---------------")
                break
            }

            7 -> {
                selectedItemMenu(
                    ColdBrewLatte(
                        size = "",
                        temperature = null,
                        shot = null,
                        packageOption = null,
                        quantity = 1,
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
