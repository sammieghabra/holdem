package core.game;

import core.card.Card;

import java.util.Collections;
import java.util.List;

public class Shuffler {

    public void shuffle(List<Card> cards) {
        Collections.shuffle(cards);
    }
}
