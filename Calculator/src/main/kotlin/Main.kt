
import LevelFourCalculator.LevelFourCalculatorImpl
import LevelThreeCalculator.LevelThreeCalculator
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow
import kotlin.math.round

val sc = BufferedReader(InputStreamReader(System.`in`))

var run = true

fun main() {
    while (true) {
        try {
            println("계산기 번호를 입력해주세요 1: 레벨 1 계산기, 2: 레벨 2 계산기 3: 레벨 3 계산기 4: 레벨 4 계산기 5: 식 계산기 0: 계산기 종료")
            print("계산기 번호: ")

            when (sc.readLine()[0]) {
                '1' -> {
                    println("---------------------------------------")
                    println("Level 1 계산기를 선택하셨군요")
                    println("---------------------------------------")
                    LevelOneCalculator().levelOneCalculator()
                }

                '2' -> {
                    println("---------------------------------------")
                    println("Level 2 계산기를 선택하셨군요")
                    println("---------------------------------------")
                    LevelTwoCalculator().levelTwoCalculator()
                }

                '3' -> {
                    println("---------------------------------------")
                    println("Level 3 계산기를 선택하셨군요")
                    println("---------------------------------------")
                    LevelThreeCalculator().levelThreeCalculator()
                }

                '4' -> {
                    println("---------------------------------------")
                    println("Level 4 계산기를 선택하셨군요")
                    println("---------------------------------------")
                    val levelFourCalculator = LevelFourCalculatorImpl()
                    levelFourCalculator.operate()

                }

                '5' -> {
                    println("---------------------------------------")
                    println("식 계산기를 선택하셨군요")
                    println("---------------------------------------")
                    ExpressionCalculator().expression()

                }

                '0' -> {
                    println("---------------------------------------")
                    println("계산기 프로그램을 종료합니다.")
                    println("---------------------------------------")
                    sc.close()
                    return
                }

                else -> {
                    println("---------------------------------------")
                    println("잘못된 번호를 입력하셨습니다.")
                    println("---------------------------------------")
                }

            }
        } catch (e: InputMismatchException) {
            println("---------------------------------------")
            println("숫자를 입력해주세요")
            println("---------------------------------------")
            sc.readLine()
        }

    }
}


fun decimalLength(num: String?): Int { //Double 타입의 num을 받는다.
    if (num != null && num.contains('.')) { //String 타입의 num에 '.'이 포함되어 있다면
        return num.split('.')[1].length //소수점 이하의 자릿수를 반환한다.
    }
    return 0
}

fun numberAndLength(): Triple<Double, Double, Int> {
    try {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val aInput = sc.readLine()
        val aNumber = aInput.toDouble()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val bInput = sc.readLine()
        val bNumber = bInput.toDouble()
        val length1 = decimalLength(aInput)
        val length2 = decimalLength(bInput)
        val totalLength = length1 + length2 //전체 자리수 구하기
        return Triple(aNumber, bNumber, totalLength)
    } catch (e: NumberFormatException) {
        println("---------------------------------------")
        println("다시 입력해주세요")
        println("---------------------------------------")
        return numberAndLength()
    }
}


fun operand(): Char {
    println("연산자(+,-,*,/,% 중 택1)를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 연산자가 입력됩니다.) ")
    println("---------------------------------------")
    println("잘못된 연산자 입력시 계산이 되지 않습니다.")
    println("---------------------------------------")
    println("만약 종료를 하고 싶으시면 @을 입력해주세요")
    println("---------------------------------------")
    val operator = sc.readLine()[0]
    println("---------------------------------------")
    return operator
}

fun printAddResult(aNumber: Double, bNumber: Double, totalLength: Int) {
    val addResult =
        round((aNumber + bNumber) * 10.0.pow(totalLength.toDouble())) / 10.0.pow(totalLength.toDouble())
    if (addResult % 1 == 0.0) {
        println("계산 결과: ${addResult.toInt()}")
    } else {
        println("더하기 결과: $addResult")
    }
    println("---------------------------------------")
}

fun printSubtractResult(aNumber: Double, bNumber: Double, totalLength: Int) {
    val subtractResult =
        round((aNumber - bNumber) * 10.0.pow(totalLength.toDouble())) / 10.0.pow(totalLength.toDouble())
    if (subtractResult % 1 == 0.0) {
        println("계산 결과: ${subtractResult.toInt()}")
    } else {
        println("빼기 결과: $subtractResult")
    }
    println("---------------------------------------")
}

fun printMultiplyResult(aNumber: Double, bNumber: Double, totalLength: Int) {
    val multiplyResult = round(aNumber * bNumber * 10.0.pow(totalLength.toDouble())) / 10.0.pow(totalLength.toDouble())
    if (multiplyResult % 1 == 0.0) {
        println("계산 결과: ${multiplyResult.toInt()}")
    } else {
        println("곱하기 결과: $multiplyResult")
    }
    println("---------------------------------------")
}

fun printDivideResult(aNumber: Double, bNumber: Double, totalLength: Int) {
    val divideResult = round(aNumber / bNumber * 10.0.pow((totalLength).toDouble())) / 10.0.pow((totalLength).toDouble())
    if (divideResult % 1 == 0.0) {
        println("계산 결과: ${divideResult.toInt()}")
    } else {
        println("나누기 결과: $divideResult")
    }
    println("---------------------------------------")
}

fun printModulusResult(aNumber: Double, bNumber: Double) {

    println("나머지 결과: " + (aNumber % bNumber).toInt())
    println("---------------------------------------")
}

fun continueCondition(): Boolean {
    while (true) {
        print("계속 하시겠습니까? (y/n) : ")
        val yn = sc.readLine()[0]
        println("---------------------------------------")
        when (yn) {
            'y' -> {
                println("계산기를 계속합니다.")
                println("---------------------------------------")
                break
            }

            'n' -> {
                println("계산기를 종료합니다.")
                println("---------------------------------------")
                return true
            }

            else -> {
                println("잘못된 입력입니다. 다시 입력해주세요")
                println("---------------------------------------")
                continue
            }
        }
    }
    return false
}