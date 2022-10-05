package dev.provost.repository;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
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
}
