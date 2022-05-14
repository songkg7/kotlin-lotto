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
}