package LevelThreeCalculator

import numberAndLength
import printDivideResult

class LevelThreeDivideOperation {
    fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printDivideResult(a, b, totalLength)
    }
}
