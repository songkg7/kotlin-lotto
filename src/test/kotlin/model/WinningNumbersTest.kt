package model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class WinningNumbersTest : DescribeSpec({
    describe("WinningNumbers 생성 검증") {
        val lottoNumbers = LottoNumbers.ofIntList(listOf(1, 2, 3, 4, 5, 6))

        context("입력된 bonusBall 이 당첨 번호와 중복되지 않는다면") {
            val bonusBall = LottoNumber.of(7)

            it("정상적으로 생성된다.") {
                val winningNumbers = WinningNumbers.of(lottoNumbers, bonusBall)

                winningNumbers.winningNumber shouldBe lottoNumbers
                winningNumbers.bonusBall shouldBe bonusBall
            }
        }

        context("입력된 bonusBall 이 당첨 번호와 중복된다면") {
            val bonusBall = LottoNumber.of(6)

            it("IllegalArgumentException 예외가 발생한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinningNumbers.of(lottoNumbers, bonusBall)
                }

                exception.message shouldBe "bonusBall 은 당첨번호와 중복되어선 안됩니다."
            }
        }
    }
})