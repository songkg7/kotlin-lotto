package model

import view.OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE

class LottoNumber private constructor(val number: Int) {
    companion object {
        fun of(number: Int): LottoNumber {
            validRange(number)
            return LottoNumber(number)
        }

        private fun validRange(number: Int) {
            if (number !in 1..45) {
                throw IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE)
            }
        }
    }
}