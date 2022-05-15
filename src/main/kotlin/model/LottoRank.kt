package model

fun match(matchCount: Int, matchBonus: Boolean): LottoRank {
    return LottoRank.values().first { it.matchPolicy.invoke(matchCount, matchBonus) }
}

enum class LottoRank(val matchCount: Int, val matchPolicy: (Int, Boolean) -> Boolean) {
    FIRST(6, { matchCount, _ -> matchCount == 6 }),
    SECOND(5, { matchCount, matchBonus -> matchCount == 5 && matchBonus }),
    THIRD(5, { matchCount, matchBonus -> matchCount == 5 && !matchBonus }),
    FORTH(4, { matchCount, _ -> matchCount == 4 }),
    FIFTH(3, { matchCount, _ -> matchCount == 3 }),
    MISS(0, { matchCount, _ -> matchCount < 3 });
}