package LevelThreeCalculator

import numberAndLength
import printAddResult

class LevelThreeAddOperation {
    fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printAddResult(a, b, totalLength)
    }
}