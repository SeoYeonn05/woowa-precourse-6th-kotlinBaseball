package baseball.view

import baseball.constants.Constants
import baseball.constants.ErrorConstants
import baseball.controller.NumController
import baseball.controller.ResultController
import baseball.model.GameResult
import baseball.utils.InputHandler

class BaseballGameView {
    private val numController: NumController = NumController()
    private val gameController: ResultController = ResultController()
    private val inputHandler = InputHandler()
    private lateinit var gameResult: MutableMap<GameResult, Int>

    private fun printStartMessage() {
        println(Constants.START_MESSAGE)
    }

    fun runGame(): Boolean {
        var isCorrectAnswer = false
        printStartMessage()
        isCorrectAnswer = processGame()
        if (isCorrectAnswer) {
            printGameOverMessage()
        }
        return isCorrectAnswer
    }

    private fun processGame(): Boolean {
        var isCorrectAnswer = false
        var inputNum = mutableListOf<Int>()

        while (!isCorrectAnswer) {

            inputNum = requestNum()

            gameResult = gameController.calculateGameResult(inputNum)
            printGameResult()
            if (gameResult[GameResult.STRIKE] == 3) {
                isCorrectAnswer = true
            }
        }
        return isCorrectAnswer
    }

    private fun requestNum(): MutableList<Int> {
        println(Constants.REQUEST_NUM)

        var input = inputHandler.inputHandler()
        println(input)
        if(!numController.isValidInput(input)){
            println("${ErrorConstants.ERROR} ${ErrorConstants.INVALID_VALUE_MESSAGE}")
            throw IllegalArgumentException()
        }
        return numController.convertNumFormat(input)
    }

    private fun printGameResult() {
        if (gameResult.getValue(GameResult.NOT) == 3) {
            println(Constants.NOTHING)
        } else if (gameResult.getValue(GameResult.STRIKE) == 3) {
            println("3${Constants.STRIKE}")
        } else {
            var result = ""
            if (gameResult[GameResult.BALL] != 0) {
                result = "${gameResult.getValue(GameResult.BALL)}${Constants.BALL} "
            }
            if (gameResult[GameResult.STRIKE] != 0) {
                result += "${gameResult.getValue(GameResult.STRIKE)}${Constants.STRIKE}"
                println("$result")
            }
        }
    }

    private fun printGameOverMessage() {
        println(Constants.GAME_OVER)
    }
}