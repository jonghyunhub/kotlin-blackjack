package blackjack.domain

import blackjack.domain.card.Card
import blackjack.domain.card.CardNumber
import blackjack.domain.card.CardShape
import blackjack.exception.PlayerLoseException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BlackJackGameTest {

    private lateinit var blackJackGame: BlackJackGame

    @BeforeEach()
    fun setUp() {
        blackJackGame = BlackJackGame(NotRandomDeckShuffleStrategy())
    }

    @Test
    fun `게임이 시작되면 플레이어에게 카드를 2장씩 나눠준다`() {
        val pobi = Player("pobi")
        val jason = Player("jason")

        val playerList = listOf(pobi, jason)
        val pobiCards = listOf(
            Card(shape = CardShape.DIAMOND, number = CardNumber.J),
            Card(shape = CardShape.DIAMOND, number = CardNumber.Q)
        )
        val jasonCards = listOf(
            Card(shape = CardShape.DIAMOND, number = CardNumber.K),
            Card(shape = CardShape.DIAMOND, number = CardNumber.TEN)
        )

        blackJackGame.firstDraw(playerList)

        Assertions.assertThat(pobi.getCards()).isEqualTo(pobiCards)
        Assertions.assertThat(jason.getCards()).isEqualTo(jasonCards)
    }

    @Test
    fun `플레이어가 카드 뽑는것을 선택하면 카드를 1장 나눠준다`() {
        val pobi = Player("pobi")

        blackJackGame.onePlayerDraw(pobi)
        val pobiCards = listOf(Card(shape = CardShape.DIAMOND, number = CardNumber.J))

        Assertions.assertThat(pobi.getCards()).isEqualTo(pobiCards)
    }

    @Test
    fun `플레이어의 카드합이 21이 넘으면 PlayerLoseException를 throw한다`() {
        val pobi = Player("pobi")
        val cards = listOf(
            Card(shape = CardShape.CLOVER, number = CardNumber.TEN),
            Card(shape = CardShape.CLOVER, number = CardNumber.TEN),
            Card(shape = CardShape.CLOVER, number = CardNumber.TWO)
        )
        pobi.addCards(cards)

        assertThrows<PlayerLoseException> { blackJackGame.checkPlayerIsLose(pobi) }
    }
}