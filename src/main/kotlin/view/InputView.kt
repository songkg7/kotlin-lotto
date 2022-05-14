package view

import java.util.*
import java.util.function.Consumer
import java.util.function.Supplier

fun <T> validInputView(input: Supplier<T>, errorMessage: Consumer<String>): T {
    return try {
        input.get()
    } catch (e: IllegalArgumentException) {
        errorMessage.accept(e.message!!)
        validInputView(input, errorMessage)
    }
}

class InputView(private val scanner: Scanner) {

    fun inputNumber(): Long {
        return scanner.nextLine()!!.toLong()
    }

    fun inputLottoNumbers(): List<Int> {
        return scanner.nextLine()!!.split(",").map { it.trim().toInt() }
    }
}
