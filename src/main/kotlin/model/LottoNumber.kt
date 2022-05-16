package model

import view.OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE

const val MIN = 1
const val MAX = 45
val LOTTO_NUMBER_RANGE = MIN..MAX

class LottoNumber private constructor(val number: Int) {
    companion object {
        fun of(number: Int): LottoNumber {
            validRange(number)
            return LottoNumber(number)
        }

        private fun validRange(number: Int) {
            require(number in LOTTO_NUMBER_RANGE) { OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }
}