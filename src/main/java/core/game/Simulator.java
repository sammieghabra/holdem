package core.game;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Simulator {

    private final Deck deck;
    private final Table table;
    private final Dealer dealer;

    public Simulator() {
        this.dealer = new Dealer();
        this.table = new Table();
        this.deck = new Deck();
    }

    public void simulate() {

        Player player1 = Player.defaultPlayer(1);
        Player player2 = Player.defaultPlayer(2);
        Player player3 = Player.defaultPlayer(3);
        Player player4 = Player.defaultPlayer(4);
        Player player5 = Player.defaultPlayer(5);

        List<Player> players = ImmutableList.of(player1, player2, player3, player4, player5);

        table.setPlayers(players);

        while (table.isGameInPlay()) {

            List<Card> cards = new ArrayList<>(deck.getDeck());

            Map<Integer, Player> playerMap = players
                    .stream()
                    .filter(player -> !player.isBankrupt())
                    .collect(Collectors.toMap(entry-> entry.getId(), entry-> entry));

            if (playerMap.size() <= 1) {
                System.out.println("We have a winner - PlayerID: "
                        + playerMap.entrySet().iterator().next().getKey());
                // Do we really need game is in play then? 
                table.setGameInPlay(false);
                break;
            }

            dealer.distributeCards(table.getPlayers(), cards);

            // TODO - Do the pre flop

            dealer.distributeFlop(cards, table);

            // TODO - Do the flop decision making

            dealer.distributeTurnCard(cards, table);

            // TODO - Do the turn card decision making

            dealer.distributeRiver(cards, table);

            // TODO - Do the river decision making

            // TODO - handle side bets
            Integer winnerId = dealer.determineWinner(new ArrayList<>(playerMap.values()), table);

            Player winner = playerMap.get(winnerId);
            winner.setMoney(winner.getMoney() + table.getPot());
        }

    }

}
