package view

import java.util.*

class InputView(private val scanner: Scanner) {

    fun inputLottoNumbers(): List<Int> {
        return scanner.nextLine()!!.split(",").map { it.trim().toInt() }
    }

}