package model

class WinningNumbers private constructor(
    val winningNumber: LottoNumbers,
    val bonusBall: LottoNumber,
) {
    init {
        validBonusBall(winningNumber, bonusBall)
    }

    companion object {
        fun of(winningNumber: LottoNumbers, bonusBall: LottoNumber): WinningNumbers {
            return WinningNumbers(winningNumber, bonusBall)
        }

        private fun validBonusBall(winningNumber: LottoNumbers, bonusBall: LottoNumber) {
            require(!winningNumber.contains(bonusBall)) { "bonusBall 은 당첨번호와 중복되어선 안됩니다." }
        }
    }

}