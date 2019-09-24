package core.player;

import core.card.Card;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Hand {
    Card firstCard;
    Card secondCard;

    boolean isSameSuit;

    public Hand(Card first, Card second) {
        this.firstCard = first;
        this.secondCard = second;
        this.isSameSuit = first.getSuite().equals(second.getSuite());
    }
}
