package model

class Money(val amount: Long) {
    operator fun div(price: Int) = amount.toInt() / price

}