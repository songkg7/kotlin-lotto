package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : DescribeSpec({
    describe("LottoNumbers") {
        val lottoNumberGroup = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }
        it("생성된다.") {
            val lottoNumbers = LottoNumbers.of(lottoNumberGroup)

            lottoNumbers.lottoNumberGroup shouldBe lottoNumberGroup
        }
    }
})