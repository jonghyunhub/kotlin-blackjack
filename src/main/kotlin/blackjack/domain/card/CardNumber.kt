package blackjack.domain.card

enum class CardNumber(val value: Int) {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    K(10),
    Q(10),
    J(10),
    A(11);

    override fun toString(): String {
        return when (this) {
            K -> "K"
            Q -> "Q"
            J -> "J"
            A -> "A"
            else -> value.toString()
        }
    }
}