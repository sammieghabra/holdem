package core.player;

import core.game.Bet;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.Random;

@Data
@AllArgsConstructor
public class Player {
    private Hand hand;
    private Integer money;
    private boolean bankrupt;
    private Integer id;
    private boolean isInRound;

    public Bet decide(Optional<Integer> currentBet) {

        if (money == 0) {
            isInRound = false;
            bankrupt = true;
            return new Bet(Bet.Decision.FOLD, Optional.empty());
        }

        if (currentBet.isPresent() && currentBet.get() >= money) {
            // all in
            Integer toBeBet = money;
            this.money = 0;
            bankrupt = true;
            return new Bet(Bet.Decision.CALL, Optional.of(toBeBet));
        } else if (currentBet.isPresent()) {
            // calling
            this.money = this.money - currentBet.get();
            return new Bet(Bet.Decision.CALL, currentBet);
        } else {

            if (money == 1) {
                money = 0;
                bankrupt = true;
                return new Bet(Bet.Decision.RAISE,Optional.of(1));
            }

            Random random = new Random();
            int low = 0;
            int high = money;
            int result = random.nextInt(high-low) + low;
            this.money = money - result;
            return new Bet(Bet.Decision.RAISE,Optional.of(result));
        }
    }

    public static Player defaultPlayer(Integer id) {
        return new Player(new Hand(), 1000, false, id, true);
    }
}
