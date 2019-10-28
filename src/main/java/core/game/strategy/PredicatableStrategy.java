package core.game.strategy;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.game.Bet;
import core.game.Evaluator;
import core.game.Table;
import core.player.Player;

import java.util.List;
import java.util.NavigableMap;
import java.util.Optional;
import java.util.TreeMap;

public class PredicatableStrategy implements Strategy {

    private Evaluator evaluator;

    private final Integer PRE_FLOP_HAND_THRESHOLD = 28;

    private final NavigableMap<Integer, Double> valueToPrecent = new TreeMap<>();

    public PredicatableStrategy() {
        evaluator = new Evaluator();
        valueToPrecent.put(28, 0.05);
        valueToPrecent.put(30, 0.06);
        valueToPrecent.put(36, 0.07);
        valueToPrecent.put(40, 0.08);
        valueToPrecent.put(45, 0.09);
        valueToPrecent.put(48, 0.10);
    }

    @Override
    public Bet preFlopStrategy(Player player, Table table) {

        /*
        The safe player would ask themselves:
        1. What is my hand?
        If i have a good hand, i will most likely continue
        2. How many players are in the game?
        3. What is my chip count in relation to others and the pot?
        4. How much have i bet in this round?
        5. Am i the last player in this round and do i need to
         */

        final Integer handValue = evaluator.evaluatePreFlop(player.getHand().getFirstCard(),
                player.getHand().getSecondCard());

        if (handValue <= PRE_FLOP_HAND_THRESHOLD && table.getCurrentBet() > 0) {
            return new Bet(Bet.Decision.FOLD, Optional.empty());
        } else if (handValue <= PRE_FLOP_HAND_THRESHOLD && table.getCurrentBet() == 0) {
            return new Bet(Bet.Decision.CHECK, Optional.empty());
        }

        Integer valueToBet =
                (int) (valueToPrecent.ceilingEntry(handValue).getValue().doubleValue() * player.getMoney());

        if (valueToBet < table.getCurrentBet()) {
            return new Bet(Bet.Decision.FOLD, Optional.empty());
        }

        if (table.getCurrentBet() == 0) {
            return new Bet(Bet.Decision.RAISE, Optional.of(valueToBet));
        }

        return new Bet(Bet.Decision.CALL, Optional.of(table.getCurrentBet()));
    }

    @Override
    public Bet flopStrategy(Player player, Table table) {

        /*
         * The strategy is to see if we have any pairings,  any realized or potential pairings
         */

        List<Card> toBeAdded = player.getCardHand();
        toBeAdded.addAll(table.getCards());
        Integer evaluation = evaluator.evaluateFlop(toBeAdded);
        return null;
    }

    @Override
    public Bet riverStrategy(Player player, Table table) {
        return null;
    }

    @Override
    public Bet turnStrategy(Player player, Table table) {
        return null;
    }
}
