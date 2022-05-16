import controller.LottoApp
import view.InputView
import view.OutputView
import view.ReadInInput

fun main() {
    val lottoApp = LottoApp(InputView(ReadInInput()), OutputView())
    lottoApp.run()
}