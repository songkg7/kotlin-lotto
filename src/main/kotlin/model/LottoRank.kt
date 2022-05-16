package model

enum class LottoRank(val matchCount: Int, val prize: Money, val matchPolicy: (Int, Boolean) -> Boolean) {
    FIRST(6, Money.of(1_500_000_000), { matchCount, _ -> matchCount == 6 }),
    SECOND(5, Money.of(50_000_000), { matchCount, matchBonus -> matchCount == 5 && matchBonus }),
    THIRD(5, Money.of(1_000_000), { matchCount, matchBonus -> matchCount == 5 && !matchBonus }),
    FORTH(4, Money.of(50_000), { matchCount, _ -> matchCount == 4 }),
    FIFTH(3, Money.of(5_000), { matchCount, _ -> matchCount == 3 }),
    MISS(0, Money.ZERO, { matchCount, _ -> matchCount < 3 });

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank {
            return LottoRank.values().find { it.matchPolicy.invoke(matchCount, matchBonus) }?: error("IllegalStateException")
        }
    }
}