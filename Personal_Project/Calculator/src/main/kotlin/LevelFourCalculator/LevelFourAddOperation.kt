import LevelFourCalculator.LevelFourCalculator

class LevelFourAddOperation : LevelFourCalculator() {
    override fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printAddResult(a, b, totalLength)
    }
}