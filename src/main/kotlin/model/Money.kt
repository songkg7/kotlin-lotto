package model

import java.math.BigDecimal

class Money private constructor(val amount: BigDecimal) {
    companion object {
        val ZERO = Money(BigDecimal.ZERO)

        fun of(amount: Long): Money {
            return Money(BigDecimal(amount))
        }

        fun of(amount: Int): Money {
            return Money(BigDecimal(amount))
        }
    }

    operator fun div(price: Int) = amount.toInt() / price

    operator fun plus(other: Money) = Money(amount + other.amount)

}