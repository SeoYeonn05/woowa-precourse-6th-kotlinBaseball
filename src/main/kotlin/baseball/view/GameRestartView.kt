package baseball.view

import baseball.constants.Constants
import baseball.utils.InputHandler

class GameRestartView {
    fun restartGame(game: (() -> Boolean)) {
        var restart = "1"
        while (true) {
            when (restart) {
                "1" -> {
                    if (!game()){
                        break
                    }

                    restart = restartGameMessage()
                }
                "2" -> {
                    printGameExit()
                    break
                }
            }
        }
    }

    private fun restartGameMessage(): String {
        println(Constants.RESTART_MESSAGE)
        return InputHandler().inputHandler()
    }

    private fun printGameExit() {
        println(Constants.GAME_EXIT)
    }
}