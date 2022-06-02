package view

import model.LOTTO_NUMBER_COUNT

fun <T> validInputView(supplier: () -> T, consumer: (String) -> Unit): T {
    return try {
        supplier()
    } catch (e: IllegalArgumentException) {
        consumer(e.message!!)
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
        throw NumberFormatException("숫자만 입력해주세요.")
    }

    private fun printNewLine() = println()

    private fun valid(intList: List<Int>) {
        require(intList.size == LOTTO_NUMBER_COUNT) { "로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다." }
    }

    fun inputLottoNumbers(count: Int): List<List<Int>> {
        return (START..count).map { inputLottoNumbers() }
    }

    fun inputManualCount() = inputNumber()

    fun inputNumber() = try {
        input.read().toInt()
    } catch (e: NumberFormatException) {
        throw NumberFormatException("숫자만 입력해주세요.")
    }
}
