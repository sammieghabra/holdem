package core.player;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.game.Bet;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Player {
    private List<Card> cardsInHand;
    private Integer money;
    private boolean bankrupt;
    private Integer id;

    Bet decide() {
        return null;
    }

    public static Player defaultPlayer(Integer id) {
        return new Player(ImmutableList.of(), 1000, false, id);
    }
}
