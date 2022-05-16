package model

import view.DUPLICATE_BONUS_BALL_MESSAGE

class WinningNumbers private constructor(
    val winningNumber: LottoNumbers,
    val bonusBall: LottoNumber,
) {
    companion object {
        fun of(winningNumber: LottoNumbers, bonusBall: LottoNumber): WinningNumbers {
            return WinningNumbers(winningNumber, bonusBall).also {
                validBonusBall(winningNumber, bonusBall)
            }
        }

        private fun validBonusBall(winningNumber: LottoNumbers, bonusBall: LottoNumber) {
            require(!winningNumber.contains(bonusBall)) { DUPLICATE_BONUS_BALL_MESSAGE }
        }
    }

}