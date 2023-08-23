import java.util.*

class LevelTwoCalculator {
    fun levelTwoCalculator() {
        while (true) {
            try {
                val operator = operand()
                if (operator == '@') {
                    println("레벨 2 계산기가 종료되었습니다.")
                    println("---------------------------------------")
                    return
                } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    println("잘못된 연산자 입니다.")
                    println("다시 입력해주세요. ")
                    println("---------------------------------------")
                    continue
                }
                val (a, b, totalLength) = numberAndLength()
                when (operator) {
                    '+' -> printAddResult(a, b, totalLength)
                    '-' -> printSubtractResult(a, b, totalLength)
                    '*' -> printMultiplyResult(a, b, totalLength)
                    '/' -> printDivideResult(a, b, totalLength)
                    '%' -> {
                        printModulusResult(a, b)
                    }

                    else -> {
                        println("연산자가 올바르지 않습니다.")
                        println("---------------------------------------")
                    }
                }
                if (continueCondition()) return
            } catch (e: ArithmeticException) {
                println("0으로 나눌 수 없습니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc
            } catch (e: InputMismatchException) {
                println("숫자를 입력해주여야 합니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc
            }
        }
    }
}