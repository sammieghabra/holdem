package core.player;

import core.card.Card;
import core.game.Bet;
import lombok.Value;

import java.util.List;

@Value
public class Player {
    List<Card> cardsInHand;

    Bet decide() {
        return null;
    }
}
