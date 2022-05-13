import controller.LottoApp
import view.InputView
import view.OutputView
import java.util.*

fun main() {
    val lottoApp = LottoApp(InputView(Scanner(System.`in`)), OutputView())
    lottoApp.run()
}