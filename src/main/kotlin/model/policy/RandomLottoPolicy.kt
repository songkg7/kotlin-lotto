package model.policy

import model.LOTTO_NUMBER_COUNT
import model.LOTTO_NUMBER_RANGE
import model.LottoNumbers

class RandomLottoPolicy(private val autoCount: Int) : LottoPolicy {

    override fun generate(): List<LottoNumbers> = (1..autoCount).map { randomNumbers() }

    private fun randomNumbers(): LottoNumbers {
        val candidates = LOTTO_NUMBER_RANGE.toMutableList()
        candidates.shuffle()
        val randomIntList = (1..LOTTO_NUMBER_COUNT).map { candidates.removeLast() }
        return LottoNumbers.ofIntList(randomIntList)
    }
}