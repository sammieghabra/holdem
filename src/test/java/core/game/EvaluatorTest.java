package core.game;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.card.Suite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EvaluatorTest {

    Evaluator evaluator;

    @BeforeEach
    public void setUp() {
        evaluator = new Evaluator();
    }

    @Test
    public void testEvaluatesStraightFlush() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.HEART, 9), new Card(Suite.HEART, 8),
                new Card(Suite.HEART, 7), new Card(Suite.HEART, 6), new Card(Suite.HEART, 2));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(1000));
    }

    @Test
    public void testEvaluatesFullHouse() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.HEART, 9), new Card(Suite.SPADE, 9),
                new Card(Suite.CLUBS, 10), new Card(Suite.DIAMONDS, 9), new Card(Suite.HEART, 2));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(800));
    }

    @Test
    public void testEvaluatesFourPair() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.CLUBS, 10), new Card(Suite.HEART, 8),
                new Card(Suite.SPADE, 10), new Card(Suite.DIAMONDS, 10), new Card(Suite.HEART, 2));
        Integer result = evaluator.evaluate(cards);
        System.out.println(result);
        Assertions.assertTrue(result.equals(900));
    }

    @Test
    public void testEvaluatesFlush() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.HEART, 3), new Card(Suite.HEART, 8),
                new Card(Suite.HEART, 2), new Card(Suite.HEART, 5), new Card(Suite.SPADE, 2));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(700));
    }

    @Test
    public void testEvaluatesStraight() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.SPADE, 10), new Card(Suite.CLUBS, 9), new Card(Suite.DIAMONDS, 8),
                new Card(Suite.HEART, 7), new Card(Suite.HEART, 6), new Card(Suite.HEART, 2));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(600));
    }

    @Test
    public void testEvaluatesThreePair() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.SPADE, 10), new Card(Suite.HEART, 8),
                new Card(Suite.DIAMONDS, 10), new Card(Suite.HEART, 6), new Card(Suite.HEART, 2));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(500));
    }

    @Test
    public void testEvaluatesTwoPair() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.DIAMONDS, 10), new Card(Suite.HEART, 8),
                new Card(Suite.DIAMONDS, 8), new Card(Suite.HEART, 6));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(400));
    }

    @Test
    public void testEvaluatesPair() {
        List<Card> cards = ImmutableList.of(
                new Card(Suite.HEART, 10), new Card(Suite.CLUBS, 10), new Card(Suite.HEART, 8),
                new Card(Suite.HEART, 7), new Card(Suite.HEART, 6));
        Integer result = evaluator.evaluate(cards);
        Assertions.assertTrue(result.equals(300));
    }
}
