package view

import model.LOTTO_NUMBER_COUNT
import java.util.*

fun <T> validInputView(supplier: () -> T, consumer: (String) -> Unit): T {
    return try {
        supplier.invoke()
    } catch (e: IllegalArgumentException) {
        consumer.invoke(e.message!!)
        validInputView(supplier, consumer)
    }
}

private const val START = 1

class InputView(private val scanner: Scanner) {

    fun inputLottoNumbers(): List<Int> = try {
        printNewLine() // FIXME: Scanner nextLine 개행문자 오류
        scanner.nextLine().split(",").map { it.trim().toInt() }
            .distinct()
            .also {
                valid(it)
            }
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }

    private fun printNewLine() {
        println()
    }

    private fun valid(intList: List<Int>) {
        require(intList.size == LOTTO_NUMBER_COUNT) { ILLEGAL_LOTTO_NUMBER_COUNT_MESSAGE }
    }

    fun inputLottoNumbers(count: Int): List<List<Int>> {
        return (START..count).map { inputLottoNumbers() }
    }

    fun inputManualCount() = inputNumber()

    fun inputNumber() = try {
        scanner.nextLine().toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }
}
