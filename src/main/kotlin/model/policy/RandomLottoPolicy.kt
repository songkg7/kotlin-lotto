package model.policy

import model.LOTTO_NUMBER_COUNT
import model.LOTTO_NUMBER_RANGE
import model.LottoNumbers

class RandomLottoPolicy(private val autoCount: Int) : LottoPolicy {

    override fun generate(): List<LottoNumbers> = List(autoCount) { randomNumbers() }

    private fun randomNumbers(): LottoNumbers {
        val candidates = LOTTO_NUMBER_RANGE.toMutableList()
        candidates.shuffle()
        val randomIntList = List(LOTTO_NUMBER_COUNT) { candidates.removeLast() }
        return LottoNumbers.ofIntList(randomIntList)
    }
}