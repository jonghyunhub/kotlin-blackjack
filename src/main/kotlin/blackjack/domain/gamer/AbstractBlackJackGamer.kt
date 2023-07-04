package blackjack.domain.gamer

import blackjack.domain.CardNumberCalculator
import blackjack.domain.card.Card

abstract class AbstractBlackJackGamer : BlackJackGamer {
    private val cards = mutableListOf<Card>()
    private val cardNumberCalculator = CardNumberCalculator()

    override fun addCard(card: Card) {
        cards.add(card)
    }

    override fun addCards(drawCards: List<Card>) {
        cards.addAll(drawCards)
    }

    override fun getCards(): List<Card> {
        return cards.toList()
    }

    override fun calculateSumOfCardNumbers(): Int {
        return cardNumberCalculator.calculateSumOfCardNumbers(cards)
    }

}