package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class LottoResultTest : DescribeSpec({
    describe("earningRate 계산") {
        context("4등과 5등에 당첨되었다면") {
            val lottoRanks = listOf(LottoRank.FORTH, LottoRank.FIFTH)
            val lottoResult = LottoResult(lottoRanks, Money.of(5000))

            it("수익율은 11이다. (55000 / 5000)") {
                val earningRate = lottoResult.calcEarningRate()

                earningRate shouldBe 11
            }
        }

        context("10000 원의 자본금으로 5등 하나에만 당첨되었다면") {
            val lottoRanks = listOf(LottoRank.FIFTH)
            val lottoResult = LottoResult(lottoRanks, Money.of(10000))

            it("수익율은 0.5 이다.") {
                val earningRate = lottoResult.calcEarningRate()

                earningRate shouldBe 0.5
            }
        }
    }
})