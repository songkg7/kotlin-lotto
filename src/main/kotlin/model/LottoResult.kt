package model

import java.math.BigDecimal

class LottoResult(private val lottoRanks: List<LottoRank>, private val capital: Money) {

    fun calcEarningRate(): Double {
        val totalPrize = calcTotalPrize()
        return (totalPrize.divide(capital.amount)).toDouble()
    }

    fun calcTotalPrize(): BigDecimal {
        return lottoRanks.sumOf { it.prize.amount }
    }

    fun calcRankCount(lottoRank: LottoRank) = lottoRanks.count { it == lottoRank }

}