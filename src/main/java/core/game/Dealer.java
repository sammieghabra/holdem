package core.game;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.player.Hand;
import core.player.Player;

import java.util.List;
import java.util.Random;

public class Dealer {

    public Dealer() {
        shuffler = new Shuffler();
    }

    private Shuffler shuffler;

    public void distributeCards(List<Player> players, List<Card> cards) {
            shuffler.shuffle(cards);

            for (int i = 0; i < players.size(); ++i) {
                final Card first = cards.remove(0);
                final Card second = cards.remove(0);
                players.get(i).setHand(new Hand(first, second));

                System.out.println("Player " + i + " has " + first.getValue() + " of " + first.getSuite());
                System.out.println("Player " + i + " has " + second.getValue() + " of " + second.getSuite());
            }
    }

    public void distributeFlop(List<Card> cards, Table table) {
        final Card first = cards.remove(0);
        final Card second = cards.remove(0);
        final Card third = cards.remove(0);

        table.getCards().addAll(ImmutableList.of(first, second, third));

        System.out.println("Flop is " + first.getValue() + " of " + first.getSuite() + ", " +
                second.getValue() + " of " + second.getSuite() + ", "
                + third.getValue() + " of " + third.getSuite() + ".");
    }

    public void distributeTurnCard(List<Card> cards, Table table) {
        final Card turnCard = cards.remove(0);
        table.getCards().add(turnCard);

        System.out.println("TurnCard is " + turnCard.getValue() + " of " + turnCard.getSuite() + ". ");
    }

    public void distributeRiver(List<Card> cards, Table table) {
        final Card river = cards.remove(0);
        table.getCards().add(river);
        System.out.println("River is " + river.getValue() + " of " + river.getSuite() + ". ");
    }

    public Integer determineWinner(List<Player> players, Table table) {
        Random r = new Random();
        int low = 0;
        int high = players.size()-1;
        int result = r.nextInt(high-low) + low;

        return players.get(result).getId();
    }
}
