import LevelFourCalculator.LevelFourCalculator

class LevelFourSubtractOperation : LevelFourCalculator() {
    override fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printSubtractResult(a, b, totalLength)
    }
}