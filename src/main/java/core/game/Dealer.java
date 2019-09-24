package core.game;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.player.Hand;
import core.player.Player;

import java.util.List;

public class Dealer {

    private Shuffler shuffler;

    public void distributeCards(List<Player> players, List<Card> cards) {
            shuffler.shuffle(cards);

            for (int i = 0; i < players.size(); ++i) {
                final Card first = cards.remove(0);
                final Card second = cards.remove(0);
                players.get(i).setHand(new Hand(first, second));
            }
    }

    public void distributeFlop(List<Card> cards, Table table) {
        final Card first = cards.remove(0);
        final Card second = cards.remove(0);
        final Card third = cards.remove(0);

        table.getCards().addAll(ImmutableList.of(first, second, third));
    }

    public void distributeTurnCard(List<Card> cards, Table table) {
        final Card turnCard = cards.remove(0);
        table.getCards().add(turnCard);
    }

    public void distributeRiver(List<Card> cards, Table table) {
        final Card river = cards.remove(0);
        table.getCards().add(river);
    }

    public Integer determineWinner(List<Player> players, Table table) {
        return players.get(0).getId();
    }
}
