package model

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class MoneyTest : DescribeSpec({
    val amount = 5000
    describe("money") {
        context("amount 가 주어지면") {
            it("해당 금액을 가진 Money 객체가 만들어진다.") {
                val money = Money.of(amount)

                money.amount shouldBe BigDecimal(5000)
            }
        }
        context("amount 를 price 로 나누면") {
            it("구매할 수 있는 전체 로또 개수가 반환된다.") {
                val totalCount = Money.of(amount) / PRICE

                totalCount shouldBe 5
            }
        }
    }
})