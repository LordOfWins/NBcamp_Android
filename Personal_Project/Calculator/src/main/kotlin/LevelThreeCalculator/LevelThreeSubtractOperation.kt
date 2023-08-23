package LevelThreeCalculator

import numberAndLength
import printSubtractResult

class LevelThreeSubtractOperation {
    fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printSubtractResult(a, b, totalLength)
    }

}