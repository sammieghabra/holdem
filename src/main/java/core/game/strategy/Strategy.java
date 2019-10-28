package core.game.strategy;

import core.game.Bet;
import core.game.Table;
import core.player.Player;

public interface Strategy {

    Bet preFlopStrategy(Player player, Table table);

    Bet flopStrategy(Player player, Table table);

    Bet riverStrategy(Player player, Table table);

    Bet turnStrategy(Player player, Table table);
}
