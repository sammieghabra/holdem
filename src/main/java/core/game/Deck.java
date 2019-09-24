package core.game;

import com.google.common.collect.ImmutableList;
import core.card.Card;
import core.card.Suite;

import java.util.List;

public class Deck {

    private static final List<Card> DECK = ImmutableList.of(
            Card.builder().value(2).suite(Suite.HEART).build(),
            Card.builder().value(3).suite(Suite.HEART).build(),
            Card.builder().value(4).suite(Suite.HEART).build(),
            Card.builder().value(5).suite(Suite.HEART).build(),
            Card.builder().value(6).suite(Suite.HEART).build(),
            Card.builder().value(7).suite(Suite.HEART).build(),
            Card.builder().value(8).suite(Suite.HEART).build(),
            Card.builder().value(9).suite(Suite.HEART).build(),
            Card.builder().value(10).suite(Suite.HEART).build(),
            Card.builder().value(11).suite(Suite.HEART).build(),
            Card.builder().value(12).suite(Suite.HEART).build(),
            Card.builder().value(13).suite(Suite.HEART).build(),
            Card.builder().value(14).suite(Suite.HEART).build(),

            Card.builder().value(2).suite(Suite.DIAMONDS).build(),
            Card.builder().value(3).suite(Suite.DIAMONDS).build(),
            Card.builder().value(4).suite(Suite.DIAMONDS).build(),
            Card.builder().value(5).suite(Suite.DIAMONDS).build(),
            Card.builder().value(6).suite(Suite.DIAMONDS).build(),
            Card.builder().value(7).suite(Suite.DIAMONDS).build(),
            Card.builder().value(8).suite(Suite.DIAMONDS).build(),
            Card.builder().value(9).suite(Suite.DIAMONDS).build(),
            Card.builder().value(10).suite(Suite.DIAMONDS).build(),
            Card.builder().value(11).suite(Suite.DIAMONDS).build(),
            Card.builder().value(12).suite(Suite.DIAMONDS).build(),
            Card.builder().value(13).suite(Suite.DIAMONDS).build(),
            Card.builder().value(14).suite(Suite.DIAMONDS).build(),

            Card.builder().value(2).suite(Suite.SPADE).build(),
            Card.builder().value(3).suite(Suite.SPADE).build(),
            Card.builder().value(4).suite(Suite.SPADE).build(),
            Card.builder().value(5).suite(Suite.SPADE).build(),
            Card.builder().value(6).suite(Suite.SPADE).build(),
            Card.builder().value(7).suite(Suite.SPADE).build(),
            Card.builder().value(8).suite(Suite.SPADE).build(),
            Card.builder().value(9).suite(Suite.SPADE).build(),
            Card.builder().value(10).suite(Suite.SPADE).build(),
            Card.builder().value(11).suite(Suite.SPADE).build(),
            Card.builder().value(12).suite(Suite.SPADE).build(),
            Card.builder().value(13).suite(Suite.SPADE).build(),
            Card.builder().value(14).suite(Suite.SPADE).build(),

            Card.builder().value(2).suite(Suite.CLUBS).build(),
            Card.builder().value(3).suite(Suite.CLUBS).build(),
            Card.builder().value(4).suite(Suite.CLUBS).build(),
            Card.builder().value(5).suite(Suite.CLUBS).build(),
            Card.builder().value(6).suite(Suite.CLUBS).build(),
            Card.builder().value(7).suite(Suite.CLUBS).build(),
            Card.builder().value(8).suite(Suite.CLUBS).build(),
            Card.builder().value(9).suite(Suite.CLUBS).build(),
            Card.builder().value(10).suite(Suite.CLUBS).build(),
            Card.builder().value(11).suite(Suite.CLUBS).build(),
            Card.builder().value(12).suite(Suite.CLUBS).build(),
            Card.builder().value(13).suite(Suite.CLUBS).build(),
            Card.builder().value(14).suite(Suite.CLUBS).build());

    List<Card> getDeck() {
        return DECK;
    }
}
