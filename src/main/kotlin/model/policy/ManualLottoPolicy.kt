package model.policy

import model.LottoNumbers

class ManualLottoPolicy(private val intListGroup: List<List<Int>>) : LottoPolicy {

    override fun generate(): List<LottoNumbers> {
        return intListGroup.map { LottoNumbers.ofIntList(it) }
    }
}