package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartNum = ""
    print(Dialogues.startGameMessage)
    do {
        val computerNum = generateRandomNum()
        try {
            solveBaseBallGame(computerNum)
        } catch (e: java.lang.IllegalArgumentException){
            throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }
        print(Dialogues.restartMessage)
        restartNum = Console.readLine()
    } while (restartNum == "1")
    print("게임 종료")
}







