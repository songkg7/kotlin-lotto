package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class LottoRankTest : DescribeSpec({
    val matchBonus = listOf(true, false)

    describe("로또 당첨 판단") {
        context("matchCount 가 6이라면") {
            it("FIRST 가 반환된다.") {
                val lottoRank = LottoRank.of(6, true)

                lottoRank shouldBe LottoRank.FIRST
            }
            it("FIRST 가 반환된다.") {
                val lottoRank = LottoRank.of(6, false)

                lottoRank shouldBe LottoRank.FIRST
            }
        }

        context("matchCount 가 5 일때") {
            it("bonusBall 이 일치한다면 SECOND 가 반환된다.") {
                val lottoRank = LottoRank.of(5, true)

                lottoRank shouldBe LottoRank.SECOND
            }
            it("bonusBall 이 일치하지 않는다면 THIRD 가 반환된다.") {
                val lottoRank = LottoRank.of(5, false)

                lottoRank shouldBe LottoRank.THIRD
            }
        }

        context("matchCount 가 4 라면 bonusBall 일치 여부에 상관없이") {
            it("FORTH 가 반환된다.") {
                matchBonus.forEach {
                    val lottoRank = LottoRank.of(4, it)

                    lottoRank shouldBe LottoRank.FORTH
                }
            }
        }

        context("matchCount 가 3 이라면") {
            it("FIFTH 가 반환된다.") {
                matchBonus.forEach {
                    val lottoRank = LottoRank.of(3, it)

                    lottoRank shouldBe LottoRank.FIFTH
                }
            }
        }

        context("matchCount 가 3 미만이라면") {
            val matchCounts = listOf(1, 2)
            it("MISS 가 반환된다.") {
                matchCounts.forEach {
                    val lottoRank = LottoRank.of(it, false)

                    lottoRank shouldBe LottoRank.MISS
                }
            }
        }
    }
})