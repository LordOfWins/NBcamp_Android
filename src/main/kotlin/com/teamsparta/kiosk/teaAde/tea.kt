package com.teamsparta.kiosk.teaAde

data class MenuItem(
    val menuType: String,
    val name: String,
    val size: String,
    val packaging: String?,
)

object Order {
    val items = mutableListOf<MenuItem>()
}

fun teaAdeMenu() {
    while (true) {
        println("티/에이드")
        println("1. 아이스티")
        println("2. 에이드")
        println("3. 차")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> icedTeaMenu()
            "2" -> AdeMenu()
            "3" -> TeaMenu()
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun icedTeaMenu() {
    while (true) {
        println("아이스티")
        println("1. 레몬")
        println("2. 복숭아")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> adeMenu("레몬 아이스티", "아이스티")
            "2" -> adeMenu("복숭아 아이스티", "아이스티")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}
fun AdeMenu() {
    while (true) {
        println("에이드")
        println("1. 자몽")
        println("2. 레몬")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> adeMenu("자몽 에이드", "에이드")
            "2" -> adeMenu("레몬 에이드", "에이드")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}
fun TeaMenu() {
    while (true) {
        println("차")
        println("1. 녹차")
        println("2. 얼그레이티")
        println("3. 허브티")
        println("0. 뒤로가기")
        print("원하는 항목을 선택하세요: ")
        when (readLine()!!) {
            "1" -> teaMenu("녹차", "차")
            "2" -> teaMenu("얼그레이", "차")
            "3" -> teaMenu("허브티", "차")
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun adeMenu(name: String, menuType: String) {
    val type: String = menuType
    var size: String? = null
    var shot: String? = null
    var packaging: String? = null
    while (true) {
        println("1. 사이즈 선택")
        println("2. 샷 추가 여부")
        println("3. 포장 여부")
        println("6. 주문 완료")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> size = sizeMenu()
            "2" -> shot = shotMenu()
            "3" -> packaging = packagingMenu()
            "6" -> {
                // 사이즈 체크
                if (size == null) {
                    println("사이즈를 다시 선택해주세요.")
                    continue
                }
                // 샷추가 체크
                if (shot == null) {
                    println("샷 추가를 다시 선택해주세요.")
                    continue
                }
                // 포장 체크
                if (packaging == null) {
                    println("포장 여부를 다시 선택해주세요.")
                    continue
                }
                // 모든 변수가 선택되었을 때 실행되는 부분
                val menuItem = MenuItem(
                    menuType = type,
                    name = name,
                    size = size,
                    packaging = packaging,
                )
                Order.items.add(menuItem)
                printOrder()
                teaAdeMenu()
                break
            }
            "0" -> break
            else -> com.teamsparta.kiosk.error()
        }
    }
}

fun teaMenu(name: String, menuType: String) {
    val type: String = menuType
    var temperature: String? = null
    var size: String? = null
    var packaging: String? = null
    while (true) {
        println("1. 온도 선택")
        println("2. 사이즈 선택")
        println("3. 포장 여부")
        println("6. 주문 완료")
        println("0. 뒤로가기")

        print("원하는 항목을 선택하세요: ")

        when (readLine()!!) {
            "1" -> temperature = temperatureMenu()
            "2" -> size = sizeMenu()
            "3" -> println("차 음료에는 샷 추가를 할 수 없습니다")
            "4" -> packaging = packagingMenu()
            "6" -> {
                // 온도 체크
                if (temperature == null) {
                    println("온도를 다시 선택해주세요.")
                    continue
                }
                // 사이즈 체크
                if (size == null) {
                    println("사이즈를 다시 선택해주세요.")
                    continue
                }
                // 포장 체크
                if (packaging == null) {
                    println("포장 여부를 다시 선택해주세요.")
                    continue
                }
                // 모든 변수가 선택되었을 때 실행되는 부분
                val menuItem = MenuItem(
                    menuType = type,
                    name = name,
                    size = size,
                    packaging = packaging,
                )
                Order.items.add(menuItem)
                printOrder()
                teaAdeMenu()
                break
            }

            "0" -> break
            else -> com.teamsparta.kiosk.error()
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
            com.teamsparta.kiosk.error()
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
            com.teamsparta.kiosk.error()
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
            com.teamsparta.kiosk.error()
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
            com.teamsparta.kiosk.error()
            null
        }
    }
}
fun printOrder() {
    if (Order.items.isEmpty()) {
        println("주문 내역이 없습니다.")
    } else {
        println("주문 내역:")
        for ((index, item) in Order.items.withIndex()) {
            println("Item ${index + 1}:")
            println("  메뉴 유형: ${item.menuType}")
            println("  메뉴 이름: ${item.name}")
            println("  사이즈: ${item.size}")
            println("  포장 여부: ${item.packaging}")

        }
    }
}