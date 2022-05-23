package view

import model.*

private const val LOTTO_DELIMITER = ", "

class OutputView {

    fun requestCapital() {
        println("구입할 금액을 입력해주세요.")
    }

    fun requestLottoNumber() {
        printNewLine()
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
        printNewLine()
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

    fun printLottoResult(lottoResult: LottoResult) {
        printNewLine()
        println("--- 게임 결과 ---")
        renderRankCount(lottoResult)
        println("수익금 : ${lottoResult.calcTotalPrize()}원, 수익율 : ${lottoResult.calcEarningRate()} (기준은 1)")
    }

    private fun renderRankCount(lottoResult: LottoResult) {
        println("1등 : ${lottoResult.calcRankCount(LottoRank.FIRST)}개")
        println("2등 : ${lottoResult.calcRankCount(LottoRank.SECOND)}개")
        println("3등 : ${lottoResult.calcRankCount(LottoRank.THIRD)}개")
        println("4등 : ${lottoResult.calcRankCount(LottoRank.FORTH)}개")
        println("5등 : ${lottoResult.calcRankCount(LottoRank.FIFTH)}개")
        println("MISS : ${lottoResult.calcRankCount(LottoRank.MISS)}개")
    }
}