package model

class LottoCount private constructor(val manualCount: Int, val autoCount: Int) {

    companion object {
        fun of(manualCount: Int, money: Money): LottoCount {
            val totalCount: Int = money / PRICE
            return LottoCount(manualCount, calcAutoCount(totalCount, manualCount))
        }

        private fun calcAutoCount(totalCount: Int, manualCount: Int): Int {
            val autoCount = totalCount - manualCount
            shouldPositive(autoCount)
            return autoCount
        }

        private fun shouldPositive(autoCount: Int) {
            require(autoCount >= 0) { "구매금액을 초과한 로또 구매는 할 수 없습니다." }
        }
    }
}