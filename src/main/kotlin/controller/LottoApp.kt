package controller

import model.LottoCount
import model.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val capital = validInputView(this::inputCapital) { outputView.printMessage(it) }
        val lottoCount = validInputView({ inputLottoCount(capital) }) { outputView.printMessage(it) }

        // TODO: 수동, 자동 전략 생성
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

}