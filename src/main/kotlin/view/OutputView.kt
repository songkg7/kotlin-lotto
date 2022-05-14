package view

const val NUMBER_FORMAT_MESSAGE = "숫자만 입력해주세요."
const val OVER_CAPITAL_MESSAGE = "구매금액을 초과한 로또 구매는 할 수 없습니다."

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

}