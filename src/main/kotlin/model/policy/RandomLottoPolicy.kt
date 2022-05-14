package model.policy

import model.LottoNumbers

class RandomLottoPolicy(val autoCount: Int) : LottoPolicy {

    override fun generate(): List<LottoNumbers> {
        return emptyList()
    }
}