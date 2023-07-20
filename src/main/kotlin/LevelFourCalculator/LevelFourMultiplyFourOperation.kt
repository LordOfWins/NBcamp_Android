import LevelFourCalculator.LevelFourCalculator

class LevelFourMultiplyFourOperation : LevelFourCalculator() {
    override fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printMultiplyResult(a, b, totalLength)
    }
}
