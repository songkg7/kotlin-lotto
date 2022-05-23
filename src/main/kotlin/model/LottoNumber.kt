package model

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
            require(number in LOTTO_NUMBER_RANGE) { "로또 번호의 범위를 벗어났습니다." }
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