package model.policy

import model.LottoNumbers

interface LottoPolicy {
    fun generate(): List<LottoNumbers>
}