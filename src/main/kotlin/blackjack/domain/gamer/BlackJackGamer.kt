package blackjack.domain.gamer

import blackjack.domain.card.Card

interface BlackJackGamer {
    fun addCard(card: Card)

    fun addCards(drawCards: List<Card>)

    fun getCards(): List<Card>

    fun calculateSumOfCardNumbers(): Int

    fun getGamerType(): GamerType

    fun getName(): String

    fun proceedGameRecord(gameRecordType: GameRecordType)

}
