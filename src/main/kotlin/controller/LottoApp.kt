package controller

import model.*
import model.policy.ManualLottoPolicy
import model.policy.RandomLottoPolicy
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val capital = validInputView({ inputCapital() }) { outputView.printMessage(it) }
        val lottoCount = validInputView({ inputLottoCount(capital) }) { outputView.printMessage(it) }
        outputView.printLottoCount(lottoCount)

        val lottoTicket = validInputView({ buyTicket(lottoCount) }) { outputView.printMessage(it) }
        outputView.printLottoTicket(lottoTicket)

        val winningNumbers = validInputView({ inputWinningNumbers() }) { outputView.printMessage(it) }

        // 당첨번호와 티켓의 번호 매칭 후 당첨 여부 확인
        val lottoRanks = lottoTicket.match(winningNumbers)

        // 당첨금액과 구매금액을 비교하여 수익율 계산
    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return Money(inputView.inputNumber().toLong())
    }

    private fun inputLottoCount(money: Money): LottoCount {
        val manualCount = inputManualCount()
        return LottoCount.of(manualCount, money)
    }

    private fun inputManualCount(): Int {
        outputView.requestManualCount()
        return inputView.inputManualCount()
    }

    private fun buyTicket(lottoCount: LottoCount): LottoTicket {
        val lottoNumbersGroup = inputManualNumbers(lottoCount.manualCount)
        return LottoTicket.of(ManualLottoPolicy(lottoNumbersGroup), RandomLottoPolicy(lottoCount.autoCount))
    }

    private fun inputManualNumbers(manualCount: Int): List<List<Int>> {
        outputView.requestLottoNumber()
        return inputView.inputLottoNumbers(manualCount)
    }

    private fun inputWinningNumbers(): WinningNumbers {
        val winningNumber = LottoNumbers.ofIntList(inputWinningNumber())
        val bonusBall = LottoNumber.of(inputBonusBall())
        return WinningNumbers.of(winningNumber, bonusBall)
    }

    private fun inputWinningNumber(): List<Int> {
        outputView.requestWinningNumbers()
        return inputView.inputLottoNumbers()
    }

    private fun inputBonusBall(): Int {
        outputView.requestBonusBall()
        return inputView.inputNumber()
    }

}