package baseball

import baseball.view.BaseballGameView
import baseball.view.GameRestartView

fun main() {
    GameRestartView().restartGame { BaseballGameView().runGame() }
}
