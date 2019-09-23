package core.game;

import core.card.Card;
import lombok.Value;

import java.util.List;

@Value
public class Table {
    private List<Card> cards;
}
