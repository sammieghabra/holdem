package core.game;

import core.card.Card;
import core.player.Player;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Table {

    public Table() {
        cards = new ArrayList<>();
        players = new ArrayList<>();
        pot = 0;
    }

    private List<Card> cards;
    private List<Player> players;
    private Integer pot;
    private boolean gameInPlay;
    private Integer currentBet;
}
