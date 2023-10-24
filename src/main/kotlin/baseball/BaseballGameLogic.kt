package baseball

import camp.nextstep.edu.missionutils.Console


fun getUserInput():String{
    print(Dialogues.requestEnterNumMessage)
    var userNum = Console.readLine()
    println(userNum)

    return userNum
}

fun checkCorrectNum(num:String):Boolean{
    if (num.all { it.isDigit() } && num.length == 3 && num.toSet().size == 3) {
        return true
    }
    return false
}

fun compareNum(computerNum: HashMap<Int, Int>, userNum: HashMap<Int, Int>): HashMap<String, Int> {
    var resultHashMap:HashMap<String, Int> = hashMapOf(
        "strike" to 0, "ball" to 0, "nothing" to 0
    )
    for ((key, value) in userNum) {
        val hasKey = computerNum.containsKey(key)
        if (hasKey) {
            if (computerNum[key] == value) {
                resultHashMap["strike"] = resultHashMap["strike"]!! + 1
            } else {
                resultHashMap["ball"] = resultHashMap["ball"]!! + 1
            }
        } else {
            resultHashMap["nothing"] = resultHashMap["nothing"]!! + 1
        }
    }
    return resultHashMap
}


fun printBaseBallGameResult(numArray:HashMap<String, Int>):String{
    var strike = numArray["strike"]
    var ball = numArray["ball"]
    var nothing = numArray["nothing"]
    return if(nothing==3){
        Dialogues.nothingMessage
    }else if(strike==3){
        "3${Dialogues.strikeMessage}"
    }else{
        val result = mutableListOf<String>()

        if (ball!! > 0) {
            result.add("${ball}${Dialogues.ballMessage}")
        }

        if (strike!! > 0) {
            result.add("${strike}${Dialogues.strikeMessage}")
        }
        result.joinToString(" ")
    }
}


fun isGameOver(result: String):Boolean{
    return result == "3스트라이크"
}