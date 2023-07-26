package com.teamsparta.kiosk

//import com.teamsparta.kiosk.merchandise.merchandiseMenu
import coffeeMenu
import com.teamsparta.kiosk.coffee.Order
import com.teamsparta.kiosk.coffee.User
import com.teamsparta.kiosk.dessert.dessertMenu
import com.teamsparta.kiosk.merchandise.merchandiseMenu
import com.teamsparta.kiosk.teaAde.teaAdeMenu
import decafCoffeeMenu
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread
import kotlin.system.exitProcess

/*
1. 커피 메뉴
  1. 아메리카노
    1. Temperature
      1. 핫
      2. 아이스
      0. 뒤로가기
    2. 사이즈
      1. 라지
      2. 미디엄
      0. 뒤로가기
    3. 샷추가
      1. 하프
      2. 원샷
      3. 투샷
      0. 뒤로가기
    4. 포장 여부
      1. Mug cup
      2. Takeout
      0. 뒤로가기
    0. 뒤로가기
  2.  카페라떼
    1. Temperature
      1. 핫
      2. 아이스
    2. 사이즈
      1. 라지
      2. 미디엄
      0. 뒤로가기
    3. 샷추가
      1. 하프
      2. 원샷
      3. 투샷
      0. 뒤로가기
    4. 포장 여부
      1. Mug cup
      2. Takeout
      0. 뒤로가기
  3. 카라멜 마끼아또
    1. 핫or아이스
      1. 핫
      2. 아이스
      0. 뒤로가기
    2. 사이즈
       1. 라지
       2. 미디엄
       0. 뒤로가기
      0. 뒤로가기
    3. 샷추가
    4. 휘핑크림
      1. 추가
      2. 없음
    5. 포장 여부
      1. Mug cup
      2. Takeout
      0. 뒤로가기
    0 .뒤로가기(커피 메뉴로 이동)
2. 티/ 에이드
  1. 아이스티
      1.레몬
      2.복숭아
      0. 뒤로가기
    2. 사이즈
      1. Short(숏) - 237ml
      2. Tall(톨) - 355ml
      3. Grande(그란데) - 473ml
      4. Venti(벤티) - 591ml
      0. 뒤로가기
    3. 샷추가
      1. 싱글
      2. 더블
    4. 포장or매장
      1. 포장
      2. 매장
      0. 뒤로 가기
  2. 자몽에이드
    1. 사이즈
      1. 미디엄
      2. 라지
    2. 포장 여부
      1. 포장
      2. 매장
  3. 레몬에이드
    1. 사이즈
      1. 미디엄
      2. 라지
    2. 포장 여부
      1. 포장
      2. 매장
  4.녹차
    1. 사이즈
      1. 미디엄
      2. 라지
    2. 포장 여부
      1. 포장
      2. 매장
  5.얼그레이
    1. 사이즈
      1. 미디엄
      2. 라지
    2. 포장 여부
      1. 포장
      2. 매장
  6.허브티
    1. 사이즈
      1. 미디엄
      2. 라지
    2. 포장 여부
      1. 포장
      2. 매장
  0. 뒤로가기(초기 메뉴로 이동)
3. 디저트
  1. 마카롱
    1. 종류
      1. 초코
      2. 민트
      3. 딸기
    2. 포장 여부
      1. 포장
      2. 매장
  2. 케익류
    1. 종류
      1. 딸기생크림
      2. 티라미슈
      3. 당근
      4. 치즈
    2. 포장 여부
      1. 포장
      2. 매장
  3. 쿠키
    1. 종류
      1. 초코칩
      2. 피스타치오
      3. 애플크럼블
    2. 포장 여부
      1. 포장
      2. 매장
  4. 아이스크림
    1. 맛
      1. 바닐라
      2. 초코
      3. 딸기
    2. 포장 여부
      1. 포장
      2. 매장
4. 상품
  1. 머그컵
    1. 색깔
      1. 초록
      2. 노랑
      3. 민트
  2. 텀블러
      1. 초록
      2. 노랑
      3. 민트
  3. 원두
      1. 아라비아
      2. 콜롬비아
      3. 스타벅스
5. 디카페인 커피(디카페인은 샷추가 없음)
  1. 아메리카노
    1. Temperature
      1. 핫
      2. 아이스
      뒤로 가기
    2.사이즈
      1. 라지
      2. 미디움
  2. 라떼
    1. Temperature
      1. 핫
      2. 아이스
    2.사이즈
      1. 라지
      2. 미디움
    3. 포장 여부
      1. 포장
      2. 매장
    */



fun main() {
    println(
        """
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠉⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣦⠀⠀⠀⣴⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢿⡄⠈⠙⢏⣠⣶⣄⡸⠋⠁⢠⡿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⠻⣿⣿⣿⣿⣿⣧⡀⠉⢀⣀⣤⣤⣤⣤⣤⣀⡀⠉⢀⣼⣿⣿⣿⣿⣿⠟⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⡿⠀⠙⣿⠿⠿⢿⣿⣷⢿⣟⡿⠉⠁⠀⠈⠉⢿⣻⡿⣾⣿⡿⠿⠿⣿⠏⠀⢿⣿⣿⣿⣿
  ⣿⣿⣿⡿⠃⠀⠀⠀⢀⣴⣿⣿⢷⡟⣾⣯⣽⣷⠀⣾⣯⣽⣷⢻⡾⣿⣿⣦⡀⠀⠀⠀⠘⢿⣿⣿⣿⣿
  ⣿⣿⠟⢁⣠⣤⣤⣤⣿⣿⡏⣿⢸⡇⢻⡁⠉⢈⣀⡃⠉⢉⡿⢸⡇⣿⢸⣿⣿⣤⣤⣤⣄⡈⠻⣿⣿
  ⣿⠿⠿⠟⠋⣉⣠⣿⣿⣿⣇⢿⡜⣿⡈⣷⡀⠲⣾⠖⢀⣾⢁⣿⢣⡿⢸⣿⣿⣿⣆⣈⠙⠻⠿⠿⣿
  ⣿⣤⣴⡾⠿⢛⣿⣿⣿⣿⣿⢸⡇⢸⣧⢸⣿⣦⣤⣴⣿⡇⣼⡇⢸⡇⣿⣿⣿⣿⣿⡛⠿⢷⣦⣤⣿
  ⣿⣏⣉⣤⣶⣿⣿⣿⣿⣿⢟⣼⢃⣾⠃⣼⠏⠀⠉⠀⠸⣧⠘⣷⡘⢧⡻⣿⣿⣿⣿⣿⣶⣤⣉⣹⣿
  ⣿⣿⠛⢋⣥⣾⣿⣿⣿⢡⡾⢱⡿⢁⣾⠋⠀⠀⠀⠀⠀⠙⣷⡈⢿⡎⢷⡌⣿⣿⣿⣷⣬⡙⠛⣿⣿
  ⣿⣿⣿⠿⢋⣹⠿⠟⠋⠸⣧⠸⣧⠘⣿⡀⠀⠀⠀⠀⠀⢀⣿⠃⣼⡇⣼⠇⠙⠻⠿⣏⡙⠿⣿⣿⣿
  ⣿⣿⣿⣾⡿⢛⣅⠀⢀⣠⣿⣧⠹⣷⡘⢿⡄⠀⠀⠀⢠⣿⢃⣼⠏⣼⣿⣄⡀⠀⣨⡙⢿⣷⣿⣿⣿
  ⣿⣿⣿⣿⣷⡿⢋⣿⣿⣿⣿⣹⡇⢹⡧⠘⣿⠀⠀⠀⣿⠃⢸⡏⢸⣏⣿⣿⣿⣿⡙⢿⣾⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣟⣽⡿⣱⡟⢠⣿⠃⣼⡟⠀⠀⠀⢻⣧⠘⣿⡄⢻⣎⢿⣿⣹⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣴⣿⢡⣿⠃⣰⡿⠀⠀⠀⠀⠀⢻⣧⠘⣿⡌⣿⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿
  ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣤⣿⣇⡀⠀⠀⠀⢀⣸⣿⣤⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
 __      __       .__                             ._.
/  \    /  \ ____ |  |   ____  ____   _____   ____| |
\   \/\/   // __ \|  | _/ ___\/  _ \ /     \_/ __ \ |
 \        /\  ___/|  |_\  \__(  <_> )  Y Y  \  ___/\|
  \__/\  /  \___  >____/\___  >____/|__|_|  /\___  >_
       \/       \/          \/            \/     \/\/
"""

    )
    println("무엇을 도와드릴까요?")
    val user = User(balance = 1_000_000_000)
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

        when (readLine()?.toIntOrNull()) {
            1 -> coffeeMenu(user)
            2 -> teaAdeMenu()
            3 -> dessertMenu()
            4 -> merchandiseMenu()
            5 -> decafCoffeeMenu(user)
            6 -> confirmAndPayOrder(user)
            7 -> cancelOrder(user)
            0 -> {
                print("계속하시겠습니까? (Y/N): ")
                when (readLine()?.uppercase()) {
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

fun temperatureMenu(): String? {
    println("온도를 선택하세요")
    println("1. 핫")
    println("2. 아이스")

    print("원하는 온도를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "핫"
        "2" -> "아이스"
        else -> {
            error()
            null
        }
    }
}

fun sizeMenu(): String? {
    println("사이즈를 선택하세요")
    println("1. Tall")
    println("2. Grande")
    println("3. Venti")

    print("원하는 사이즈를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "Tall"
        "2" -> "Grande"
        "3" -> "Venti"
        else -> {
            error()
            null
        }
    }
}

fun shotMenu(): String? {
    println("샷 추가를 선택하세요")
    println("1. 샷 추가")
    println("2. 기본")
    println("0. 뒤로가기")

    print("원하는 샷 추가를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "샷 추가"
        "2" -> "기본 샷"
        "0" -> null
        else -> {
            error()
            null
        }
    }
}

fun packagingMenu(): String? {
    println("포장 여부를 선택하세요")
    println("1. 포장")
    println("2. 매장 식사")
    println("0. 뒤로가기")

    print("원하는 포장 여부를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "포장"
        "2" -> "매장 식사"
        "0" -> null
        else -> {
            error()
            null
        }
    }
}


fun error() {
    println("잘못 입력하셨습니다. 다시 시도해주세요.")
}

fun confirmAndPayOrder(user: User) { // 주문 내역을 확인하고 결제하는 함수
    var totalPrice = 0
    Order.items.forEachIndexed { index, item ->
        if (item.coffee.name == "카라멜 마끼아또") {
            println("${index + 1}. ${item.coffee.name} (${item.coffee.temperature}, ${item.coffee.size}, ${item.coffee.shot}, ${item.coffee.packaging}, ${item.coffee.whippedCream})")
        } else {
            println("${index + 1}. ${item.coffee.name} (${item.coffee.temperature}, ${item.coffee.size}, ${item.coffee.shot}, ${item.coffee.packaging})")
        }
        totalPrice += item.price // 각 메뉴에 대한 가격이 고정된 경우
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
            println("잔액이 부족합니다. 필요한 금액: ${totalPrice - user.balance}원")
            menu(user)
        } else {
            var input: Int?
            do {
                input = readLine()?.toIntOrNull()
                when (input) {
                    1 -> {
                        monitor.interrupt()
                        val now = LocalTime.now()
                        println("----------------------------------------------------")
                        println("현재 시각은 ${now.hour}시 ${now.minute}분입니다.")
                        println("----------------------------------------------------")
                        if (now.isAfter(LocalTime.of(16, 0)) && now.isBefore(LocalTime.of(18, 0))) {
                            println("\n결제 시스템 점검 중입니다. 4시부터 6시 사이에는 결제할 수 없습니다.")
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

fun cancelOrder(user: User) { // 주문을 취소하는 함수
    if (Order.items.isEmpty()) {
        println("취소할 주문이 없습니다.")
        return
    }
    println("진행 중인 주문을 취소하시겠습니까?(Y/N)")
    val input = readLine()?.uppercase()
    if (input == "Y") {
        for (order in Order.items) {
            user.balance += order.price // 가격을 각 메뉴의 가격으로 변경
        }
        Order.items.clear()
        println("주문이 취소되었습니다. 잔액: ${user.balance}원")
    } else if (input == "N") {
        return
    } else {
        println("잘못된 입력입니다. 다시 입력하세요.")
        cancelOrder(user)
    }
}