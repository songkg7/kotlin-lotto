package controller

import model.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val capital = validInputView(this::inputCapital) { outputView.printMessage(it) }

    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return Money(inputView.inputNumber())
    }

}