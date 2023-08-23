import LevelFourCalculator.LevelFourCalculator

class LevelFourDivideOperation : LevelFourCalculator() {
    override fun operate() {
        val (a, b, totalLength) = numberAndLength()
        printDivideResult(a, b, totalLength)
    }
}
