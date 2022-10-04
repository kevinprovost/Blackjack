package dev.provost.repository;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.model.Card.Suit;
import dev.provost.model.Deck;

public class BlackjackDAO {

	public BlackjackDAO() {
		new Blackjack();
	}

	public Card drawCard() {
		return Deck.getDeckOfCards().remove(0);
	}

	public Card drawCard(int index) {
		return Deck.getDeckOfCards().remove(index);
	}

	public void addToDealerHand(Card card) {
		Blackjack.getDealerHand().add(card);
	}

	public void addToPlayerHand(Card card) {
		Blackjack.getPlayerHand().add(card);
	}

	public void addToDiscardPile(Card discardedCard) {
		Blackjack.getDiscardPile().add(discardedCard);
	}

	public void replaceAceInHand(int index, Suit suit, int score) {
		if (Blackjack.getPlayerHand().get(index).getValue().equals("Ace")) {
			Blackjack.getPlayerHand().set(index, new Card("Ace", suit, score));
		} else {
			System.out.println("No Ace in that position.");
		}
	}
}
