package model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import view.OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE

internal class LottoNumberTest : DescribeSpec({
    describe("Create lottoNumber") {
        it("Should Allow if number in 1..45") {
            val numbers = (1..45).toList()
            numbers.forEach {
                val lottoNumber = LottoNumber.of(it)

                lottoNumber.number shouldBe it
            }
        }

        it("out of range") {
            val outOfRangeNumbers = listOf(0, 46)
            outOfRangeNumbers.forEach {
                val exception = shouldThrow<IllegalArgumentException> {
                    LottoNumber.of(it)
                }

                exception.message shouldBe OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE
            }
        }
    }
})