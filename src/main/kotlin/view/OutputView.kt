package view

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

}