import LevelFourCalculator.LevelFourCalculator

class LevelFourModOperation : LevelFourCalculator() {
    override fun operate() {
        val (a, b, _) = numberAndLength()
        printModulusResult(a, b)
    }
}

