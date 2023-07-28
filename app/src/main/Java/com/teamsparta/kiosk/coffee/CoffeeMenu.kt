
import com.teamsparta.kiosk.coffee.Americano
import com.teamsparta.kiosk.coffee.CafeLatte
import com.teamsparta.kiosk.coffee.Cappuccino
import com.teamsparta.kiosk.coffee.CaramelMacchiato
import com.teamsparta.kiosk.coffee.ColdBrew
import com.teamsparta.kiosk.coffee.ColdBrewLatte
import com.teamsparta.kiosk.coffee.Espresso
import com.teamsparta.kiosk.coffee.selectedItemMenu

fun coffeeMenu() {
    while (true) {
        println("----------------------------------")
        println("커피 메뉴")
        println("1. 아메리카노         | 1,500원 |        ")
        println("2. 카페라떼          | 2,500원 |       ")
        println("3. 카라멜 마끼아또    | 3,000원 |       ")
        println("4. 카푸치노          | 2,800원 |       ")
        println("5. 에스프레소        | 2,700원 |       ")
        println("6. 콜드브루          | 3,000원 |       ")
        println("7. 콜드브루 라떼      | 3,500원 |       ")
        println("0. 뒤로가기")

        print("원하시는 메뉴를 선택해주세요 : ")

        when (readlnOrNull()?.toIntOrNull()) {
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
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
                println("---------------추가 완료---------------")
                break
            }

            0 -> break
            else -> com.teamsparta.kiosk.error()
        }
        println("----------------------------------")
    }
}
