package controller

import model.LottoCount
import model.LottoTicket
import model.Money
import model.policy.ManualLottoPolicy
import model.policy.RandomLottoPolicy
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val capital = validInputView(this::inputCapital) { outputView.printMessage(it) }
        val lottoCount = validInputView({ inputLottoCount(capital) }) { outputView.printMessage(it) }

        val lottoTicket = validInputView({ buyTicket(lottoCount) }) { outputView.printMessage(it) }

    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return Money(inputView.inputNumber())
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

}