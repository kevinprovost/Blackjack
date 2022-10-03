package dev.provost.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dev.provost.model.Card.Suit;
import dev.provost.repository.DeckSetup;

public class Deck implements Iterable<Card> {

	protected static final int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	protected static final String[] faces = { "Jack", "Queen", "King", "Ace" };
	protected static final Suit[] suits = { Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES };
	private static List<Card> deckOfCards = new ArrayList<>();

	public Deck() {
		DeckSetup.setup(deckOfCards);
	}

	@Override
	public Iterator<Card> iterator() {
		return deckOfCards.iterator();
	}

	public static int[] getNums() {
		return nums;
	}

	public static String[] getFaces() {
		return faces;
	}

	public static Suit[] getSuits() {
		return suits;
	}

	public static Card getCardInDeck(int i) {
		return deckOfCards.get(i);
	}

	public static void setCardinDeck(int index, String value, Suit suit) {
		deckOfCards.add(index, new Card(value, suit));
	}

	public List<Card> getDeck() {
		return deckOfCards;
	}

	public static void setDeck(List<Card> deckToSet) {
		Deck.deckOfCards = deckToSet;
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deckOfCards + "]";
	}

}
