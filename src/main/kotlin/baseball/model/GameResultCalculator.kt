package baseball.model

class GameResultCalculator(
    private val computerNum: MutableList<Int>
) {
    fun calculateGameResult(userNum: MutableList<Int>): MutableMap<GameResult, Int> {
        var gameResult: MutableMap<GameResult, Int> = mutableMapOf(
            GameResult.STRIKE to 0,
            GameResult.BALL to 0,
            GameResult.NOT to 0
        )
        for ((index, num) in userNum.withIndex()) {
            if (num in computerNum) {
                if (index == computerNum.indexOf(num)) {
                    gameResult[GameResult.STRIKE] = gameResult.getValue(GameResult.STRIKE) + 1
                } else {
                    gameResult[GameResult.BALL] = gameResult.getValue(GameResult.BALL) + 1
                }
            } else {
                gameResult[GameResult.NOT] = gameResult.getValue(GameResult.NOT) + 1
            }
        }
        return gameResult
    }
}