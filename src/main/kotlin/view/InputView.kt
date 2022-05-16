package view

import model.LOTTO_NUMBER_COUNT

fun <T> validInputView(supplier: () -> T, consumer: (String) -> Unit): T {
    return try {
        supplier.invoke()
    } catch (e: IllegalArgumentException) {
        consumer.invoke(e.message!!)
        validInputView(supplier, consumer)
    }
}

private const val START = 1

class InputView(private val input: Input) {

    fun inputLottoNumbers() = try {
        printNewLine()
        input.read().split(",").map { it.trim().toInt() }
            .distinct()
            .also { valid(it) }
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }

    private fun printNewLine() = println()

    private fun valid(intList: List<Int>) {
        require(intList.size == LOTTO_NUMBER_COUNT) { ILLEGAL_LOTTO_NUMBER_COUNT_MESSAGE }
    }

    fun inputLottoNumbers(count: Int): List<List<Int>> {
        return (START..count).map { inputLottoNumbers() }
    }

    fun inputManualCount() = inputNumber()

    fun inputNumber() = try {
        input.read().toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException(NUMBER_FORMAT_MESSAGE)
    }
}
