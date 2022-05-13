package view

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayInputStream
import java.util.*

internal class InputViewTest : AnnotationSpec() {

    @Test
    @DisplayName("1, 2, 3, 4, 5, 6 을 입력하면 [1,2,3,4,5,6] 리스트를 반환한다.")
    fun inputLottoNumber() {
        val inputView = createInputView("1, 2, 3, 4, 5, 6")
        val lottoNumbers = inputView.inputLottoNumbers()

        lottoNumbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    private fun createInputView(input: String): InputView {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        return InputView(Scanner(inputStream))
    }
}