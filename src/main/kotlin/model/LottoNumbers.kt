package model

const val PRICE = 1000
const val LOTTO_NUMBER_COUNT = 6

class LottoNumbers private constructor(val lottoNumberGroup: List<LottoNumber>) {
    companion object {
        fun of(lottoNumberGroup: List<LottoNumber>) = LottoNumbers(lottoNumberGroup)
        fun ofIntList(intList: List<Int>): LottoNumbers {
            return of(intList.map { LottoNumber.of(it) })
        }
    }

    fun contains(lottoNumber: LottoNumber) = lottoNumberGroup.contains(lottoNumber)

    fun match(winningNumbers: WinningNumbers): LottoRank {
        val winningNumber = winningNumbers.winningNumber
        val bonusBall = winningNumbers.bonusBall

        return LottoRank.of(matchCount(winningNumber), contains(bonusBall))
    }

    private fun matchCount(winningNumber: LottoNumbers) =
        lottoNumberGroup.count { winningNumber.contains(it) }

    fun toIntNumbers() = lottoNumberGroup.map { it.number }
}