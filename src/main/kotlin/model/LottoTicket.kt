package model

import model.policy.LottoPolicy

class LottoTicket private constructor(val lottoNumbersGroup: List<LottoNumbers>) {
    companion object {
        fun of(vararg policies: LottoPolicy): LottoTicket {
            return LottoTicket(policies.flatMap { it.generate() })
        }
    }

    fun match(winningNumbers: WinningNumbers) =
        lottoNumbersGroup.map { it.match(winningNumbers) }
}