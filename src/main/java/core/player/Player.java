package core.player;

import core.game.Bet;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private Hand hand;
    private Integer money;
    private boolean bankrupt;
    private Integer id;
    private boolean isInRound;

    Bet decide() {
        return null;
    }

    public static Player defaultPlayer(Integer id) {
        return new Player(new Hand(), 1000, false, id, true);
    }
}
