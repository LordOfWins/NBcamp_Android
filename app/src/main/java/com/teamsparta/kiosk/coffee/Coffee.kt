package com.teamsparta.kiosk.coffee

import com.teamsparta.kiosk.error

abstract class Coffee(
    val name: String,
    val size: String,
    val temperature: String?,
    val shot: String?,
    val packaging: String?,
    val whippedCream: String?,
)

class Americano(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("아메리카노", size, temperature, shot, packaging, whippedCream)

class CaramelMacchiato(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("카라멜 마끼아또", size, temperature, shot, packaging, whippedCream)

class CafeLatte(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("카페라떼", size, temperature, shot, packaging, whippedCream)

class Capuchiino(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("카푸치노", size, temperature, shot, packaging, whippedCream)

class Espresso(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("에스프레소", size, temperature, shot, packaging, whippedCream)

class ColdBrew(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("콜드브루", size, temperature, shot, packaging, whippedCream)

class ColdBrewLatte(
    size: String, temperature: String?, shot: String?, packaging: String?, whippedCream: String?
) : Coffee("콜드브루 라떼", size, temperature, shot, packaging, whippedCream)


fun whippedCreamMenu(): String {
    println("휘핑크림 추가 여부를 선택하세요")
    println("1. 휘핑 추가")
    println("2. 기본")
    println("0. 뒤로가기")
    print("원하시는 휘핑크림 옵션을 선택해주세요: ")
    return when (readLine()?.toIntOrNull()) {
        1 -> "휘핑추가"
        2 -> "기본"
        0 -> {
            println("뒤로 돌아갑니다.")
            ""
        }

        else -> {
            error()
            ""
        }
    }
}

fun selectedItemMenu(user: User, selectedCoffee: Coffee) {
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

    if (selectedCoffee is CaramelMacchiato) {
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
