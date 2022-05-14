package view

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayInputStream
import java.util.*

internal class InputViewTest : AnnotationSpec() {

    @Test
    internal fun inputNumber() {
        val inputView = "5000".createInputView()
        val number = inputView.inputNumber()

        number shouldBe 5000
    }

    @Test
    @DisplayName("1, 2, 3, 4, 5, 6 을 입력하면 [1,2,3,4,5,6] 리스트를 반환한다.")
    fun inputLottoNumber() {
        val inputView = "1, 2, 3, 4, 5, 6".createInputView()
        val lottoNumbers = inputView.inputLottoNumbers()

        lottoNumbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    private fun String.createInputView(): InputView {
        val inputStream = ByteArrayInputStream(toByteArray())
        return InputView(Scanner(inputStream))
    }
}