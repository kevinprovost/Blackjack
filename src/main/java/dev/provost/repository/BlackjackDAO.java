package dev.provost.repository;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.model.Deck;

public class BlackjackDAO {

	public BlackjackDAO() {
		Blackjack bj = new Blackjack();
	}

	public void changeAceScore(int index) {
		Card c = Blackjack.getPlayerHand().get(index);
		if (c.getScore() == 1) {
			Blackjack.replaceAceInHand(index, c.getSuit(), 11);
		} else if (c.getScore() == 11) {
			Blackjack.replaceAceInHand(index, c.getSuit(), 1);
		} else {
			System.out.println("No Aces to change.");
		}
	}

	public Card drawCard(int index) {
		return Deck.getDeckOfCards().remove(index);
	}

	public Card drawCard() {
		return Deck.getDeckOfCards().remove(0);
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
}
