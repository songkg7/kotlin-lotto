package view

import model.LottoCount
import model.LottoNumbers
import model.LottoTicket

const val NUMBER_FORMAT_MESSAGE = "숫자만 입력해주세요."
const val OVER_CAPITAL_MESSAGE = "구매금액을 초과한 로또 구매는 할 수 없습니다."
const val OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE = "로또 번호의 범위를 벗어났습니다."
const val ILLEGAL_LOTTO_NUMBER_COUNT_MESSAGE = "로또 번호는 서로 다른 6개의 번호로 구성되어야 합니다."
const val DUPLICATE_BONUS_BALL_MESSAGE = "bonusBall 은 당첨번호와 중복되어선 안됩니다."

private const val LOTTO_DELIMITER = ", "

class OutputView {

    fun requestCapital() {
        println("구입할 금액을 입력해주세요.")
    }

    fun requestLottoNumber() {
        println("6개의 숫자를 입력해주세요. (, 로 구분)")
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun requestManualCount() {
        println("수동으로 구매할 로또의 개수를 입력해주세요.")
    }

    fun requestWinningNumbers() {
        printNewLine()
        println("당첨 번호를 입력해주세요")
    }

    private fun printNewLine() = println()

    fun requestBonusBall() {
        println("보너스볼을 입력해주세요.")
    }

    fun printLottoTicket(lottoTicket: LottoTicket) {
        val lottoNumbersGroup = lottoTicket.lottoNumbersGroup
        lottoNumbersGroup.forEach { println(renderLottoNumbers(it)) }
    }

    private fun renderLottoNumbers(lottoNumbers: LottoNumbers): String {
        val lottoIntNumber = lottoNumbers.toIntNumbers()
        return "[${lottoIntNumber.joinToString(LOTTO_DELIMITER) { "$it" }}]"
    }

    fun printLottoCount(lottoCount: LottoCount) {
        println("수동으로 ${lottoCount.manualCount}개, 자동으로 ${lottoCount.autoCount}개 구매했습니다.")
    }

}