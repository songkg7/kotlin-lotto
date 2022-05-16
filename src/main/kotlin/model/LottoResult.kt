package model

import java.math.BigDecimal

class LottoResult(val lottoRanks: List<LottoRank>, private val capital: Money) {

    fun calcEarningRate(): Double {
        val totalPrize = calcTotalPrize()
        return (totalPrize / capital.amount).toDouble()
    }

    fun calcTotalPrize(): BigDecimal {
        return lottoRanks.sumOf { it.prize.amount }
    }

}