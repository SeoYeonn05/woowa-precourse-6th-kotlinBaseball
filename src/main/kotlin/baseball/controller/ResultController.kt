package baseball.controller

import baseball.model.GameResult
import baseball.model.GameResultCalculator
import baseball.utils.RandomNumGenerator

class ResultController{
    private val gameResultCalculator: GameResultCalculator =
        GameResultCalculator(RandomNumGenerator().generateComputerNum())

    fun calculateGameResult(userNum: MutableList<Int>): MutableMap<GameResult, Int> {
        return gameResultCalculator.calculateGameResult(userNum)
    }


}