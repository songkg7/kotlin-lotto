package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : DescribeSpec({
    val lottoNumberGroup = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }
    describe("LottoNumbers") {
        it("생성된다.") {
            val lottoNumbers = LottoNumbers.of(lottoNumberGroup)

            lottoNumbers.lottoNumberGroup shouldBe lottoNumberGroup
        }
    }

    describe("contains") {
        context("lottoNumbers 안에 보너스볼의 번호가 포함되어 있다면") {
            val bonusBall = LottoNumber.of(6)

            it("true 를 반환한다.") {
                val lottoNumbers = LottoNumbers.of(lottoNumberGroup)
                val actual = lottoNumbers.contains(bonusBall)

                actual shouldBe true
            }
        }

        context("lottoNumbers 안에 보너스볼의 번호가 포함되어 있지 않다면") {
            val lottoNumber = LottoNumber.of(45)
            it("false 를 반환한다.") {
                val lottoNumbers = LottoNumbers.of(lottoNumberGroup)
                val actual = lottoNumbers.contains(lottoNumber)

                actual shouldBe false
            }
        }
    }

    describe("match") {
        context("당첨번호와 보너스볼이 주어지면") {
            val winningNumber = LottoNumbers.of(lottoNumberGroup)
            val bonusBall = LottoNumber.of(7)
            val winningNumbers = WinningNumbers.of(winningNumber, bonusBall)

            it("당첨 등수를 반환한다.") {
                val inputNumbers = LottoNumbers.ofIntList(listOf(1, 3, 4, 5, 6, 7))
                val lottoRank = inputNumbers.match(winningNumbers)

                lottoRank shouldBe LottoRank.SECOND
            }
        }
    }
})