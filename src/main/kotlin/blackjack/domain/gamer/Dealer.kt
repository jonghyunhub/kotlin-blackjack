package blackjack.domain.gamer

import blackjack.domain.gamer.GameRecordType.*

class Dealer : BlackJackGamer(name = DEALER_NAME, 0) {
    private var winRecord = (WIN to 0)
    private var loseRecord = (LOSE to 0)
    private var drawRecord = (DRAW to 0)

    override fun getGamerType(): GamerType {
        return GamerType.DEALER
    }

    override fun proceedGameRecord(gameRecordType: GameRecordType) {
        when (gameRecordType) {
            WIN -> winRecord = Pair(WIN, winRecord.second + 1)
            LOSE -> loseRecord = Pair(LOSE, loseRecord.second + 1)
            DRAW -> drawRecord = Pair(DRAW, drawRecord.second + 1)
        }
    }

    fun getTotalGameRecord(): List<Pair<GameRecordType, Int>> {
        return listOf(winRecord, loseRecord, drawRecord)
    }

    fun winMoney(winMoney: Int) {
        money += winMoney
    }

    fun loseMoney(loseMoney: Int) {
        money -= loseMoney
    }

    companion object {
        const val DEALER_NAME = "딜러"
        const val CONDITION_TO_DEALER_DRAW_CARD = 16
    }
}
