package model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

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

                exception.message shouldBe "로또 번호의 범위를 벗어났습니다."
            }
        }
    }
})