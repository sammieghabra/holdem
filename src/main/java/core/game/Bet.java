package core.game;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Bet {

    Decision decision;
    Optional<Integer> bet;

    public enum Decision {
        FOLD, CHECK, RAISE, CALL
    }

}
