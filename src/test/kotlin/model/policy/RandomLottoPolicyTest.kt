package model.policy

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class RandomLottoPolicyTest : DescribeSpec({
    describe("generate random Lotto") {
        val autoCount = 3
        context("autoCount 가 주어지면") {
            it("주어진 autoCount 만큼 6개의 랜덤한 로또 번호가 생성된다.") {
                val randomLottoPolicy = RandomLottoPolicy(autoCount)
                val lottoNumbers = randomLottoPolicy.generate()

                lottoNumbers.size shouldBe 3
            }
        }
    }
})