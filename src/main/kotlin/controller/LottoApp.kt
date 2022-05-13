package controller

import view.InputView
import view.OutputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        outputView.requestLottoNumber()
        val lottoNumbers = inputView.inputLottoNumbers()

        println(lottoNumbers)
    }

}