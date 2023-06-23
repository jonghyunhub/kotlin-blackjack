package blackjack.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckTest {

    private lateinit var deck: Deck

    @BeforeEach
    fun setUp() {
        deck = Deck()
    }

    @Test
    fun `Deck은 cardShape와 cardNumber의 조합이 중복되지 않는 Card 리스트를 가진다`() {

        val cards = mutableListOf<Card>()

        for (i in 1..Card.TOTAL_NUMBER_OF_CARDS) {
            cards.add(deck.drawCard())
        }

        val actual = cards.toSet()

        Assertions.assertThat(cards.size).isEqualTo(actual.size)
    }
}