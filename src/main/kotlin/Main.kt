import java.util.*

val sc = Scanner(System.`in`)


fun main() {
    while (true) {
        println("계산기 번호를 입력해주세요 1: 레벨 1 계산기, 2: 레벨 2 계산기 3: 레벨 3 계산기 4: 레벨 4 계산기 5: 계산기 종료")
        print("계산기 번호: ")
        when (sc.nextInt()) {
            1 -> {
                println("---------------------------------------")
                println("Level 1 계산기를 선택하셨군요")
                println("---------------------------------------")
                LevelOneCalculator().levelOneCalculator()
            }

            2 -> {
                println("---------------------------------------")
                println("Level 2 계산기를 선택하셨군요")
                println("---------------------------------------")
                LevelTwoCalculator().levelTwoCalculator()
            }

            3 -> {
                println("---------------------------------------")
                println("Level 3 계산기를 선택하셨군요")
                println("---------------------------------------")
                LevelThreeCalculator().levelThreeCalculator()
            }

            4 -> {
                println("---------------------------------------")
                println("Level 4 계산기를 선택하셨군요")
                println("---------------------------------------")
                val levelFourCalculator = LevelFourCalculatorImpl()
                levelFourCalculator.operate()

            }

            5 -> {
                println("---------------------------------------")
                println("계산기 프로그램을 종료합니다.")
                println("---------------------------------------")
                return
            }

        }
    }

}


class LevelOneCalculator {
    fun levelOneCalculator() {
        while (true) {
            try {
                println("연산자(+,-,*,/ 중 택1)를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 연산자가 입력됩니다.) \n잘못된 연산자 입력시 계산이 되지 않습니다.")
                println("---------------------------------------")
                println("만약 종료를 하고 싶으시면 @을 입력해주세요")
                val operator = sc.next().toCharArray()[0]
                println("---------------------------------------")
                if (operator == '@') {
                    println("레벨 1 계산기가 종료되었습니다.")
                    println("---------------------------------------")
                    return
                } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    println("잘못된 연산자 입니다.")
                    println("잘못된 연산자가 입력 됐으므로 계산기를 종료합니다. ")
                    println("---------------------------------------")
                    break
                }
                println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
                val a = sc.nextInt() //입력값을 받는 메서드
                println("---------------------------------------")
                println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
                val b = sc.nextInt()
                println("---------------------------------------")
                when (operator) {
                    '+' -> {
                        println("더하기 결과: " + (a + b))
                        println("---------------------------------------")
                    }

                    '-' -> {
                        println("빼기 결과: " + (a - b))
                        println("---------------------------------------")
                    }

                    '*' -> {
                        println("곱하기 결과: " + (a * b))
                        println("---------------------------------------")
                    }

                    '/' -> {
                        println("나누기 결과: " + (a / b))
                        println("---------------------------------------")
                    }

                    else -> {
                        println("연산자가 올바르지 않습니다.")
                        println("---------------------------------------")
                    }
                }
                while (true) {
                    print("계속 하시겠습니까? (y/n) : ")
                    val yn = sc.next().toCharArray()[0]
                    println("---------------------------------------")
                    if (yn == 'y') {
                        println("계산기를 계속합니다.")
                        println("---------------------------------------")
                        break
                    } else if (yn == 'n') {
                        println("레벨 1 계산기를 종료합니다.")
                        println("---------------------------------------")
                        return
                    } else {
                        println("잘못된 입력입니다. 다시 입력해주세요")
                        println("---------------------------------------")
                        continue
                    }
                }
            } catch (e: Exception) {
                println("숫자를 입력해주여야 합니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc.nextLine()
            }
        }

    }
}

class LevelTwoCalculator {
    fun levelTwoCalculator() {
        while (true) {
            try {
                println("연산자(+,-,*,/,% 중 택1)를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 연산자가 입력됩니다.) \n잘못된 연산자 입력시 계산이 되지 않습니다.")
                println("---------------------------------------")
                println("만약 종료를 하고 싶으시면 @을 입력해주세요")
                val operator = sc.next().toCharArray()[0]
                println("---------------------------------------")
                if (operator == '@') {
                    println("레벨 2 계산기가 종료되었습니다.")
                    println("---------------------------------------")
                    return
                } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    println("잘못된 연산자 입니다.")
                    println("잘못된 연산자가 입력 됐으므로 계산기를 종료합니다. ")
                    println("---------------------------------------")
                    break
                }
                println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
                val a = sc.nextInt() //입력값을 받는 메서드
                println("---------------------------------------")
                println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
                val b = sc.nextInt()
                println("---------------------------------------")
                when (operator) {
                    '+' -> {
                        println("더하기 결과: " + (a + b))
                        println("---------------------------------------")
                    }

                    '-' -> {
                        println("빼기 결과: " + (a - b))
                        println("---------------------------------------")
                    }

                    '*' -> {
                        println("곱하기 결과: " + (a * b))
                        println("---------------------------------------")
                    }

                    '/' -> {
                        println("나누기 결과: " + (a / b))
                        println("---------------------------------------")
                    }

                    '%' -> {
                        println("나머지 결과: " + (a % b))
                        println("---------------------------------------")
                    }

                    else -> {
                        println("연산자가 올바르지 않습니다.")
                        println("---------------------------------------")
                    }
                }
                while (true) {
                    print("계속 하시겠습니까? (y/n) : ")
                    val yn = sc.next().toCharArray()[0]
                    println("---------------------------------------")
                    when (yn) {
                        'y' -> {
                            println("계산기를 계속합니다.")
                            println("---------------------------------------")
                            break
                        }

                        'n' -> {
                            println("레벌 2 계산기를 종료합니다.")
                            println("---------------------------------------")
                            return
                        }

                        else -> {
                            println("잘못된 입력입니다. 다시 입력해주세요")
                            println("---------------------------------------")
                            continue
                        }
                    }
                }
            } catch (e: Exception) {
                println("숫자를 입력해주여야 합니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc.nextLine()
            }
        }
    }
}

class LevelThreeCalculator {
    fun levelThreeCalculator() {
        while (true) {
            try {
                println("연산자(+,-,*,/,% 중 택1)를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 연산자가 입력됩니다.) \n잘못된 연산자 입력시 계산이 되지 않습니다.")
                println("---------------------------------------")
                println("만약 종료를 하고 싶으시면 @을 입력해주세요")
                val operator = sc.next().toCharArray()[0]
                if (operator == '@') {
                    println("레벨 3 계산기가 종료되었습니다.")
                    println("---------------------------------------")
                    return
                } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    println("잘못된 연산자 입니다.")
                    println("잘못된 연산자가 입력 됐으므로 계산기를 종료합니다. ")
                    println("---------------------------------------")
                    break
                }
                when (operator) {
                    '+' -> {
                        AddOperation().addOperation()
                    }

                    '-' -> {
                        SubtractOperation().subtractOperation()
                    }

                    '*' -> {
                        MultiplyOperation().multiplyOperation()
                    }

                    '/' -> {
                        DivideOperation().divideOperation()
                    }

                    '%' -> {
                        ModulusOperation().modulusOperation()
                    }

                    else -> {
                        println("연산자가 올바르지 않습니다.")
                        println("---------------------------------------")
                    }

                }
                while (true) {
                    print("계속 하시겠습니까? (y/n) : ")
                    val yn = sc.next().toCharArray()[0]
                    println("---------------------------------------")
                    when (yn) {
                        'y' -> {
                            println("계산기를 계속합니다.")
                            println("---------------------------------------")
                            break
                        }

                        'n' -> {
                            println("레벨 3 계산기를 종료합니다.")
                            println("---------------------------------------")
                            return
                        }

                        else -> {
                            println("잘못된 입력입니다. 다시 입력해주세요")
                            println("---------------------------------------")
                            continue
                        }
                    }
                }
            } catch (e: Exception) {
                println("숫자를 입력해주여야 합니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc.nextLine()
            }
        }
    }

    class AddOperation {
        fun addOperation() {
            println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val a = sc.nextInt()
            println("---------------------------------------")
            println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val b = sc.nextInt()
            println("---------------------------------------")
            println("더하기 결과: " + (a + b))
            println("---------------------------------------")
        }
    }

    class SubtractOperation {
        fun subtractOperation() {
            println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val a = sc.nextInt()
            println("---------------------------------------")
            println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val b = sc.nextInt()
            println("---------------------------------------")
            println("빼기 결과: " + (a - b))
            println("---------------------------------------")
        }

    }

    class MultiplyOperation {
        fun multiplyOperation() {
            println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val a = sc.nextInt()
            println("---------------------------------------")
            println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val b = sc.nextInt()
            println("---------------------------------------")
            println("곱하기 결과: " + (a * b))
            println("---------------------------------------")
        }
    }

    class DivideOperation {
        fun divideOperation() {
            println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val a = sc.nextInt()
            println("---------------------------------------")
            println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val b = sc.nextInt()
            println("---------------------------------------")
            println("나누기 결과: " + (a / b))
            println("---------------------------------------")
        }
    }

    class ModulusOperation {
        fun modulusOperation() {
            println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val a = sc.nextInt()
            println("---------------------------------------")
            println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
            val b = sc.nextInt()
            println("---------------------------------------")
            println("나머지 결과: " + (a % b))
            println("---------------------------------------")
        }
    }
}


abstract class LevelFourCalculator {
    abstract fun operate()

}

class AddOperation : LevelFourCalculator() {
    override fun operate() {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val a = sc.nextInt()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val b = sc.nextInt()
        println("---------------------------------------")
        println("더하기 결과: " + (a + b))
        println("---------------------------------------")
    }
}

class SubtractOperation : LevelFourCalculator() {
    override fun operate() {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val a = sc.nextInt()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val b = sc.nextInt()
        println("---------------------------------------")
        println("빼기 결과: " + (a - b))
        println("---------------------------------------")
    }
}

class MultiplyOperation : LevelFourCalculator() {
    override fun operate() {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val a = sc.nextInt()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val b = sc.nextInt()
        println("---------------------------------------")
        println("곱하기 결과: " + (a * b))
        println("---------------------------------------")
    }
}

class DivideOperation : LevelFourCalculator() {
    override fun operate() {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val a = sc.nextInt()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val b = sc.nextInt()
        println("---------------------------------------")
        println("나누기 결과: " + (a / b))
        println("---------------------------------------")
    }
}

class ModOperation : LevelFourCalculator() {
    override fun operate() {
        println("처음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val a = sc.nextInt()
        println("---------------------------------------")
        println("다음 숫자를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 숫자가 입력됩니다)")
        val b = sc.nextInt()
        println("---------------------------------------")
        println("나머지 결과: " + (a % b))
        println("---------------------------------------")
    }
}

class LevelFourCalculatorImpl : LevelFourCalculator() {
    override fun operate() {
        while (true) {
            try {
                println("연산자(+,-,*,/,% 중 택1)를 입력하시고 엔터 키를 눌러주세요(엔터키를 입력하셔야 연산자가 입력됩니다.) \n잘못된 연산자 입력시 계산이 되지  않습니다.")
                println("---------------------------------------")
                println("만약 종료를 하고 싶으시면 @을 입력해주세요")
                println("---------------------------------------")
                val operator = sc.next().toCharArray()[0]
                if (operator == '@') {
                    println("레벨 4 계산기가 종료되었습니다.")
                    println("---------------------------------------")
                    break
                } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                    println("잘못된 연산자 입니다.")
                    println("잘못된 연산자가 입력 됐으므로 계산기를 종료합니다. ")
                    println("---------------------------------------")
                    break
                }
                when (operator) {
                    '+' -> {
                        AddOperation().operate()
                    }

                    '-' -> {
                        SubtractOperation().operate()
                    }

                    '*' -> {
                        MultiplyOperation().operate()
                    }

                    '/' -> {
                        DivideOperation().operate()
                    }

                    '%' -> {
                        ModOperation().operate()
                    }
                }
                while (true) {
                    print("계속 하시겠습니까? (y/n) : ")
                    val yn = sc.next().toCharArray()[0]
                    println("---------------------------------------")
                    when (yn) {
                        'y' -> {
                            println("계산기를 계속합니다.")
                            println("---------------------------------------")
                            break
                        }

                        'n' -> {
                            println("레벨 4 계산기를 종료합니다.")
                            println("---------------------------------------")
                            return
                        }

                        else -> {
                            println("잘못된 입력입니다. 다시 입력해주세요")
                            println("---------------------------------------")
                            continue
                        }
                    }
                }
            } catch (e: Exception) {
                println("숫자를 입력해주여야 합니다.")
                println("입력 값이 잘못 되었으므로 계산기를 다시 실행합니다.")
                println("---------------------------------------")
                sc.nextLine()
            }
        }
    }
}
