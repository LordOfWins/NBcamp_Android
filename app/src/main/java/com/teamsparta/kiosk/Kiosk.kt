package com.teamsparta.kiosk

import com.teamsparta.kiosk.coffee.coffeeMenu
import com.teamsparta.kiosk.coffee.printOrder
import com.teamsparta.kiosk.decafCoffee.decafCoffeeMenu
import com.teamsparta.kiosk.dessert.dessertMenu
import com.teamsparta.kiosk.merchandise.merchandiseMenu
import com.teamsparta.kiosk.teaAde.Order
import com.teamsparta.kiosk.teaAde.teaAdeMenu
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
    menu()
}

fun menu() {
    while (true) {
        println("1. 커피 메뉴")
        println("2. 티/에이드")
        println("3. 디저트")
        println("4. 상품")
        println("5. 디카페인 커피")
        println("0. 나가기")

        print("원하는 메뉴를 선택하세요: ")

        when (readLine()!!) {
            "1" -> coffeeMenu()
            "2" -> teaAdeMenu()
            "3" -> dessertMenu()
            "4" -> merchandiseMenu()
            "5" -> decafCoffeeMenu()
            "0" -> {
                print("계속하시겠습니까? (Y/N): ")
                when (readLine()?.uppercase()) {
                    "Y" -> menu()
                    "N" -> {
                        println("Order:")
                        printOrder()
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
    println("0. 뒤로가기")

    print("원하는 온도를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "핫"
        "2" -> "아이스"
        "0" -> null
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
    println("0. 뒤로가기")

    print("원하는 사이즈를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "Tall"
        "2" -> "Grande"
        "3" -> "Venti"
        "0" -> null
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
fun color(): String? {
    println("색깔을 선택해주세요")
    println("1. 초록")
    println("2. 노랑")
    println("3. 민트")
    println("0. 뒤로가기")

    print("원하는 샷 추가를 선택하세요: ")

    return when (readLine()!!) {
        "1" -> "초록"
        "2" -> "노랑"
        "3" -> "민트"
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




fun whippedCreamMenu(): String {
    println("휘핑크림 추가 여부를 선택하세요")
    println("1. 휘핑 추가")
    println("2. 기본")
    println("0. 뒤로가기")
    print("원하는 휘핑크림 옵션을 선택하세요: ")
    return when (readLine()!!) {
        "1" -> "휘핑추가"
        "2" -> "기본"
        "0" -> {
            println("뒤로 돌아갑니다.")
            ""
        }

        else -> {
            error()
            ""
        }
    }
}