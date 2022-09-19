package dev.provost.model;

import java.util.ArrayList;
import java.util.List;

import dev.provost.model.Card.Suit;

public class Deck {

//	private static Card[] deckOfCards = new Card[52];
	private static List<Card> deckOfCards = new ArrayList<>();
	private static int[] nums = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static String[] faces = { "Jack", "Queen", "King", "Ace" };
	private static Suit[] suits = { Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES };
	private int counter = 0;

	public Deck() {
		super();
		for (Suit s : suits) {
			setSuit(s);
		}
	}

	public void setSuit(Suit suit) {
		for (int i : nums) {
			setCardinDeck(counter, String.valueOf(i), suit);
			counter++;
		}

		for (String s : faces) {
			setCardinDeck(counter, s, suit);
			counter++;
		}

	}

	public Card getCardInDeck(int i) {
//		return deckOfCards[i];
		return deckOfCards.get(i);
	}

	public static void setCardinDeck(int index, String value, Suit suit) {
//		deckOfCards[index] = new Card(value, suit);
		deckOfCards.set(index, new Card(value, suit));
	}

	public static /* Card[] */List<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public static void setDeckOfCards(/* Card[] */List<Card> deckOfCards) {
		Deck.deckOfCards = deckOfCards;

	}

	@Override
	public String toString() {
//		return Arrays.toString(deckOfCards);
		return deckOfCards.toString();
	}

}
