package view

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.util.*

private fun String.createInputView(): InputView {
    val inputStream = ByteArrayInputStream(toByteArray())
    return InputView(Scanner(inputStream))
}

internal class InputViewTest : AnnotationSpec() {

    @Test
    internal fun inputNumber() {
        val inputView = "5000".createInputView()
        val number = inputView.inputNumber()

        number shouldBe 5000
    }

    @Test
    internal fun inputLottoNumber() {
        val inputView = "1, 2, 3, 4, 5, 6".createInputView()
        val lottoNumbers = inputView.inputLottoNumbers()

        lottoNumbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    internal fun inputLottoNumbers() {
        val inputView = "1,2,3,4,5,6 \n 1, 2,3 ,4,5,6".createInputView()
        val lottoNumbers = inputView.inputLottoNumbers(2)

        lottoNumbers shouldBe listOf(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    internal fun duplicateInputLottoNumber() {
        val inputView = "1,1,2,3,4,5".createInputView()

        val exception = shouldThrow<IllegalArgumentException> {
            inputView.inputLottoNumbers()
        }

        exception.message shouldBe ILLEGAL_LOTTO_NUMBER_COUNT_MESSAGE
    }
}