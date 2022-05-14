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

    fun inputNumber() = try {
        scanner.nextLine().toLong()
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }

    fun inputLottoNumbers() = try {
        scanner.nextLine().split(",").map { it.trim().toInt() }
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }
}
