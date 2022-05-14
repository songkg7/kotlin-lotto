package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class MoneyTest : DescribeSpec({
    val amount: Long = 5000
    describe("money") {
        context("amount 가 주어지면") {
            it("해당 금액을 가진 Money 객체가 만들어진다.") {
                val money = Money(amount)

                money.amount shouldBe 5000
            }
        }
    }
})