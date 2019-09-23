package core.game;

import java.util.Optional;

public class Bet {

    Optional<Integer> bet;

    public enum Decision {
        FOLD, CHECK, RAISE, CALL
    }

}
