package view

import model.LOTTO_NUMBER_COUNT
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

private const val START = 1

class InputView(private val scanner: Scanner) {

    fun inputLottoNumbers(): List<Int> = try {
        printNewLine() // FIXME: Scanner nextLine 개행문자 오류
        scanner.nextLine().split(",").map { it.trim().toInt() }.distinct()
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }

    private fun printNewLine() {
        println()
    }

    private fun valid(intList: List<Int>) {
        if (intList.size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_COUNT_MESSAGE)
        }
    }

    fun inputLottoNumbers(count: Int): List<List<Int>> {
        return (START..count).map { inputLottoNumbers() }
    }

    fun inputManualCount() = inputNumber().toInt()

    fun inputNumber() = try {
        scanner.nextLine().toLong()
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }
}
