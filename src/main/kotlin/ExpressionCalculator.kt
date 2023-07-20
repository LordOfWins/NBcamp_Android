//식을 입력 받는다.
// 각 문자열을 리스트에 넣는다.
// 하나씩 꺼내면서 (가 있으면 ) 나올 때까지 그 안에 있는 식을 먼저 계산한다.
// 그리고 나서 곱셈과 나눗셈을 먼저 계산한다.
// 그리고 나서 덧셈과 뺄셈을 계산한다.
// 계산된 값을 출력한다.
import java.util.*
import kotlin.math.pow
import kotlin.math.round

class ExpressionCalculator {
    fun expression() {
        print("식을 입력하세요: ")
        println("---------------------------------------")
        val input = readlnOrNull().toString().replace(" ", "")
        val n = totalDecimalPlaces(input)
        val result = calculateExpression(input)

        if (result % 1 == 0.0) {
            println("계산 결과: ${result.toInt()}")
        } else {
            val roundedResult = round(result * 10.0.pow(n.toDouble())) / 10.0.pow(n.toDouble())
            println("계산 결과: $roundedResult")
        }
        println("---------------------------------------")
    }

    private fun totalDecimalPlaces(expression: String): Int {
        val numbers = expression.split("[()+\\-*/]".toRegex()).filter { it.isNotEmpty() }
        var totalDecimalPlaces = 0

        for (number in numbers) {
            totalDecimalPlaces += number.indexOf(".").let { if (it != -1) number.length - it - 1 else 0 }
        }
        return totalDecimalPlaces
    }


    private fun calculateExpression(expression: String): Double {
        val tokens = tokenize(expression)
        return parseExpression(tokens)
    }

    private fun tokenize(expression: String): ArrayList<String> {
        val tokens = ArrayList<String>()
        var index = 0

        while (index < expression.length) {
            val ch = expression[index]
            if (ch.isDigit() || ch == '.') {
                val start = index
                while (index < expression.length && (expression[index].isDigit() || expression[index] == '.')) {
                    index++
                }
                tokens.add(expression.substring(start, index))
            } else {
                tokens.add(ch.toString())
                index++
            }
        }

        return tokens
    }

    private fun parseExpression(tokens: ArrayList<String>): Double {
        val stack = Stack<Double>()

        var operand: Double
        var nextOperator = '+'

        while (tokens.isNotEmpty()) {
            val token = tokens.removeAt(0)

            if ("()+-*/".contains(token)) {
                if (token == "(") {
                    val parenthesisEnd = tokens.indexOf(")")
                    val subExpression = ArrayList(tokens.subList(0, parenthesisEnd))
                    tokens.subList(0, parenthesisEnd + 1).clear()

                    operand = parseExpression(subExpression)
                } else {
                    nextOperator = token[0]
                    continue
                }
            } else {
                try {
                    operand = token.toDouble()
                } catch (e: NumberFormatException) {
                    println("숫자가 아닙니다. 다시 입력해주세요")
                    return 0.0
                }
            }

            when (nextOperator) {
                '+' -> stack.push(operand)
                '-' -> stack.push(-operand)
                '*' -> stack.push(stack.pop() * operand)
                '/' -> stack.push(stack.pop() / operand)
            }

            nextOperator = '+'
        }

        return stack.sum()
    }
}
