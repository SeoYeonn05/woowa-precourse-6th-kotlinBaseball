package baseball.utils

class DigitConverter {
    fun changeStringToList(num: String):MutableList<Int>{
        val numList = mutableListOf<Int>()

        for (char in num) {
            val digit = Character.getNumericValue(char)
            if (digit in 0..9) {
                numList.add(digit)
            } else {
            }
        }
        return numList
    }
}