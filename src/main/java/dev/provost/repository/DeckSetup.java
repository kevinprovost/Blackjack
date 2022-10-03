package dev.provost.repository;

import java.util.Collections;
import java.util.List;

import dev.provost.model.Card;
import dev.provost.model.Card.Suit;
import dev.provost.model.Deck;

public class DeckSetup {

	private static int initCounter = 0;

	private DeckSetup() {
		throw new IllegalStateException("Utility class should not be instantiated");
	}

	public static void setup(List<Card> deckOfCards) {
		initCounter = 0;
		for (Suit s : Deck.getSuits()) {
			setSuit(s);
		}
		Collections.shuffle(deckOfCards);
	}

	public static void setSuit(Suit suit) {
		for (int i : Deck.getNums()) {
			Deck.setCardinDeck(initCounter, String.valueOf(i), suit);
			initCounter++;
		}

		for (String s : Deck.getFaces()) {
			Deck.setCardinDeck(initCounter, s, suit);
			initCounter++;
		}
	}

}