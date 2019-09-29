package core.game;

import com.google.common.collect.ImmutableMap;
import core.card.Card;
import core.card.Suite;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Evaluator {

    private static final Map<Integer, Predicate<List<Card>>> PREDICATES =
            ImmutableMap.<Integer, Predicate<List<Card>>>builder()
                    .put(1000, Evaluator::isStraightFlush)
                    .put(900, Evaluator::isFourPair)
                    .put(800, Evaluator::isFullHouse)
                    .put(700, Evaluator::isFlush)
                    .put(600, Evaluator::isStraight)
                    .put(500, Evaluator::isThreePair)
                    .put(400, Evaluator::isTwoPair)
                    .put(300, Evaluator::isOnePair).build();

    public Integer evaluate(List<Card> cardsOnTable) {

        // sort the cards
        List<Card> cards = new ArrayList<>(cardsOnTable);
        Collections.sort(cards, Comparator.comparing(card -> card.getValue()));

        for (Map.Entry<Integer, Predicate<List<Card>>> entry: PREDICATES.entrySet()) {
            if (entry.getValue().test(cards)) {
                return entry.getKey();
            }
        }

        return 0;
    }

    private static boolean isStraightFlush(List<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    private static boolean isFourPair(List<Card> cards) {
        Map<Integer, Integer> valueToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getValue, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));

        return valueToOccMap.values().contains(4);
    }

    private static boolean isFullHouse(List<Card> cards) {
        Map<Integer, Integer> valueToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getValue, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));

        return valueToOccMap.values().contains(3) && valueToOccMap.values().contains(2);
    }

    private static boolean isFlush(List<Card> cards) {

        Map<Suite, Integer> suitToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getSuite, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));

        return suitToOccMap.getOrDefault(Suite.HEART, 0) >= 5 ||
                suitToOccMap.getOrDefault(Suite.SPADE, 0) >= 5 ||
                suitToOccMap.getOrDefault(Suite.DIAMONDS, 0) >= 5 ||
                suitToOccMap.getOrDefault(Suite.CLUBS, 0) >= 5;
    }

    private static boolean isStraight(List<Card> cards) {

        int cardsInConsecutive = 1;

        for (int i = 0; i < cards.size(); ++i) {
            if (i < cards.size()-1) {
                if (cards.get(i).getValue() == cards.get(i+1).getValue() -1) {
                    cardsInConsecutive++;
                }
            }
        }

        return cardsInConsecutive >= 5;
    }

    private static boolean isThreePair(List<Card> cards) {
        Map<Integer, Integer> valueToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getValue, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));
        return valueToOccMap.values().contains(3);
    }

    private static boolean isTwoPair(List<Card> cards) {
        Map<Integer, Integer> valueToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getValue, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));
        return valueToOccMap.values().stream().filter(value -> value == 2).count() == 2;
    }

    private static boolean isOnePair(List<Card> cards) {
        Map<Integer, Integer> valueToOccMap = cards.stream().collect(
                Collectors.toMap(Card::getValue, card -> 1,
                        (oldValue, newValue) -> newValue + oldValue));
        return valueToOccMap.values().contains(2);
    }
}
