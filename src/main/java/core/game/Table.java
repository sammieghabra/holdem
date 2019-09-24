package core.game;

import core.card.Card;
import core.player.Player;
import lombok.Data;

import java.util.List;

@Data
public class Table {
    private List<Card> cards;
    private List<Player> players;
    private Integer pot;
    private boolean gameInPlay;
}
