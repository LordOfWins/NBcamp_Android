package com.teamsparta.kiosk

//import com.teamsparta.kiosk.merchandise.merchandiseMenu
import coffeeMenu
import com.example.starcoffee.ANSI_BLUE
import com.example.starcoffee.ANSI_GREEN_BACKGROUND
import com.example.starcoffee.ANSI_RESET
import com.example.starcoffee.ANSI_WHITE
import com.teamsparta.kiosk.dessert.dessertMenu
import com.teamsparta.kiosk.merchandise.merchandiseMenu
import com.teamsparta.kiosk.teaAde.teaAdeMenu
import decafCoffeeMenu
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread
import kotlin.system.exitProcess


fun main() {


    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠉⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣦⠀⠀⠀⣴⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⡄⠈⠙⢏⣠⣶⣄⡸⠋⠁⢠⡿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⠻⣿⣿⣿⣿⣿⣧⡀⠉⢀⣀⣤⣤⣤⣤⣤⣀⡀⠉⢀⣼⣿⣿⣿⣿⣿⠟⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⡿⠀⠙⣿⠿⠿⢿⣿⣷⢿⣟⡿⠉⠁⠀⠈⠉⢿⣻⡿⣾⣿⡿⠿⠿⣿⠏⠀⢿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⡿⠃⠀⠀⠀⢀⣴⣿⣿⢷⡟⣾⣯⣽⣷⠀ ⣾⣯⣽⣷⢻⡾⣿⣿⣦⡀⠀⠀⠀⠘⢿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⠟⢁⣠⣤⣤⣤⣿⣿⡏⣿⢸⡇⢻⡁⠉⢈⣀⡃⠉⢉⡿⢸⡇⣿⢸⣿⣿⣤⣤⣤⣄⡈⠻⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⠿⠿⠟⠋⣉⣠⣿⣿⣿⣇⢿⡜⣿⡈⣷⡀⠲⣾⠖⢀⣾⢁⣿⢣⡿⢸⣿⣿⣿⣆⣈⠙⠻⠿⠿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣤⣴⡾⠿⢛⣿⣿⣿⣿⣿⢸⡇⢸⣧⢸⣿⣦⣤⣴⣿⡇⣼⡇⢸⡇⣿⣿⣿⣿⣿⡛⠿⢷⣦⣤⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣏⣉⣤⣶⣿⣿⣿⣿⣿⢟⣼⢃⣾⠃⣼⠏⠀⠉⠀⠸⣧⠘⣷⡘⢧⡻⣿⣿⣿⣿⣿⣶⣤⣉⣹⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⠛⢋⣥⣾⣿⣿⣿⢡⡾⢱⡿⢁⣾⠋⠀⠀⠀⠀⠀⠙⣷⡈⢿⡎⢷⡌⣿⣿⣿⣷⣬⡙⠛⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⠿⢋⣹⠿⠟⠋⠸⣧⠸⣧⠘⣿⡀⠀⠀⠀⠀⠀⢀⣿⠃⣼⡇⣼⠇⠙⠻⠿⣏⡙⠿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣾⡿⢛⣅⠀⢀⣠⣿⣧⠹⣷⡘⢿⡄⠀⠀⠀⢠⣿⢃⣼⠏⣼⣿⣄⡀⠀⣨⡙⢿⣷⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣷⡿⢋⣿⣿⣿⣿⣹⡇⢹⡧⠘⣿⠀⠀⠀⣿⠃⢸⡏⢸⣏⣿⣿⣿⣿⡙⢿⣾⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣟⣽⡿⣱⡟⢠⣿⠃⣼⡟⠀⠀⠀⢻⣧⠘⣿⡄⢻⣎⢿⣿⣹⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣴⣿⢡⣿⠃⣰⡿⠀⠀⠀⠀⠀⢻⣧⠘⣿⡌⣿⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣤⣿⣇⡀⠀⠀⠀⢀⣸⣿⣤⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿" + ANSI_RESET)
    println(
        ANSI_BLUE + """
 __      __       .__                             ._.
/  \    /  \ ____ |  |   ____  ____   _____   ____| |
\   \/\/   // __ \|  | _/ ___\/  _ \ /     \_/ __ \ |
 \        /\  ___/|  |_\  \__(  <_> )  Y Y  \  ___/\|
  \__/\  /  \___  >____/\___  >____/|__|_|  /\___  >_
       \/       \/          \/            \/     \/\/
""" + ANSI_RESET
    )
    println(ANSI_GREEN_BACKGROUND + "★★★★★★★★★★★★★★★★★★★★★★★" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + ANSI_WHITE + "STARBUCKS 14호점에 오신걸 환영합니다" + ANSI_RESET)
    println(ANSI_GREEN_BACKGROUND + "★★★★★★★★★★★★★★★★★★★★★★★" + ANSI_RESET)
    println("무엇을 도와드릴까요?")
    val user = User()
    user.inputBalance()
    menu(user)
}

fun menu(user: User) {
    while (true) {
        println("1. 커피 메뉴")
        println("2. 티/에이드")
        println("3. 디저트")
        println("4. 상품")
        println("5. 디카페인 커피")
        println("6. 주문 내역")
        println("7. 주문 취소")
        println("0. 나가기")

        print("원하시는 메뉴를 선택해주세요: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> coffeeMenu()
            2 -> teaAdeMenu()
            3 -> dessertMenu()
            4 -> merchandiseMenu()
            5 -> decafCoffeeMenu()
            6 -> confirmAndPayOrder(user)
            7 -> cancelOrder(user)
            0 -> {
                print("계속하시겠습니까? (Y/N): ")
                when (readlnOrNull()?.uppercase()) {
                    "Y" -> menu(user)
                    "N" -> {
                        print("키오스크 프로그램을 종료합니다.")
                        exitProcess(0)
                    }

                    else -> println("다시 입력 해주세요.")
                }
            }

            else -> error()
        }
    }
}


fun error() {
    println("잘못 입력하셨습니다. 다시 시도해주세요.")
}

fun confirmAndPayOrder(user: User) { // 주문 내역을 확인하고 결제하는 함수
    var totalPrice = 0

    // 주문 내역 출력
    println("주문 내역:")
    for (order in Order.items) {
        val itemPrice = order.price * order.quantity
        totalPrice += itemPrice
        println("- ${order.name} x ${order.quantity}: $itemPrice")
    }

    // 임시적으로 각 메뉴에 대해 고정 가격 처리
    if (totalPrice == 0) {
        println("----------------------------------")
        println("주문 내역이 없습니다.")
        println("메뉴로 돌아갑니다.")
        println("----------------------------------")
        return
    } else {
        fun canPurchase(user: User, totalPrice: Int): Boolean {
            return user.balance >= totalPrice
        }
        if (totalPrice > 0) {

            println("[ Total ]")
            println(" $totalPrice")
            println("1. 주문\t2. 메뉴판")
            println("선택하세요: ")
            val monitor = thread(start = true) {
                try {
                    while (!Thread.currentThread().isInterrupted) {
                        print("----------------------------------------------------")
                        println("\n아래와 같이 주문하시겠습니까? (현재 주문 대기수: ${Order.items.size})")
                        println("----------------------------------------------------")
                        Thread.sleep(5000)
                    }
                } catch (e: InterruptedException) {
                    print("")
                }
            }
            if (!canPurchase(user, totalPrice)) {
                // 사용자가 주문을 결제할 충분한 잔액이 없는 경우 먼저 처리합니다.
                println("잔액이 부족합니다. 현재 금액: ${user.balance}, 필요한 금액: ${totalPrice - user.balance}원")
                println("금액을 충전하시겠습니까?(Y/N)")
                monitor.interrupt()
                val input = readlnOrNull()?.uppercase()
                when (input) {
                    "Y" -> {
                        user.inputBalance()
                        confirmAndPayOrder(user)
                    }

                    "N" -> {
                        return
                    }

                    else -> {
                        println("잘못된 입력입니다. 다시 입력하세요.")
                        confirmAndPayOrder(user)
                    }
                }
            } else {
                var input: Int?
                do {
                    input = readlnOrNull()?.toIntOrNull()
                    when (input) {
                        1 -> {
                            monitor.interrupt()
                            val now = LocalTime.now()
                            println("----------------------------------------------------")
                            println("현재 시각은 ${now.hour}시 ${now.minute}분입니다.")
                            println("----------------------------------------------------")
                            if (now.isAfter(LocalTime.of(16, 0)) && now.isBefore(LocalTime.of(18, 0))) {
                                println("\n결제 시스템 점검 중입니다. 4시부터 6시 사이에는 결제할 수 없습니다.")
                            break
                            } else {
                                user.balance -= totalPrice
                                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                val currentDateAndTime = LocalDateTime.now().format(formatter)
                                println("결제를 완료했습니다. ($currentDateAndTime) 현재 잔액: ${user.balance} 원")
                                Order.items.clear()
                                return
                            }
                        }

                        2 -> {
                            monitor.interrupt()
                            println("----------------------------------")
                            println("추가 주문 합니다.")
                            println("----------------------------------")
                            menu(user)
                        }

                        else -> {
                            println("다시 입력 해주세요.")
                            confirmAndPayOrder(user)
                        }
                    }
                } while (input !in 1..2)
            }
        }
    }
}

fun cancelOrder(user: User) { // 주문을 취소하는 함수
    if (Order.items.isEmpty()) {
        println("취소할 주문이 없습니다.")
        return
    }
    println("진행 중인 주문을 취소하시겠습니까?(Y/N)")
    val input = readlnOrNull()?.uppercase()
    when (input) {
        "Y" -> {
            for (order in Order.items) {
                user.balance += order.price // 가격을 각 메뉴의 가격으로 변경
            }
            Order.items.clear()
            println("주문이 취소되었습니다. 잔액: ${user.balance}원")
        }
        "N" -> {
            return
        }
        else -> {
            println("잘못된 입력입니다. 다시 입력하세요.")
            cancelOrder(user)
        }
    }
}


