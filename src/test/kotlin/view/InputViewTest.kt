package view

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

private fun String.createInputView(): InputView {
    val stubInput = StubInput(this)
    return InputView(stubInput)
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
    internal fun duplicateInputLottoNumber() {
        val inputView = "1,1,2,3,4,5".createInputView()

        val exception = shouldThrow<IllegalArgumentException> {
            inputView.inputLottoNumbers()
        }

        exception.message shouldBe "로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다."
    }
}