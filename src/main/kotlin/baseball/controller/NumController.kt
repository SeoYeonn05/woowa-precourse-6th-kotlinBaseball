package baseball.controller

import baseball.constants.ErrorConstants
import baseball.utils.DigitConverter

class NumController {
    private val digitConverter: DigitConverter = DigitConverter()

    fun isValidInput(userNum: String):Boolean{
        val regex = Regex("\\d{3}")
        return regex.matches(userNum)
    }

    fun convertNumFormat(userNum: String): MutableList<Int> {
        return digitConverter.changeStringToList(userNum)
    }
}