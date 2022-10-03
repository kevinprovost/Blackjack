package dev.provost.service;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.repository.BlackjackDAO;

public class BlackjackService {

	public BlackjackService() {
		BlackjackDAO bd = new BlackjackDAO();
	}

	BlackjackDAO bd = new BlackjackDAO();

	public void dealCards() {
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
	}

	public void clearCards() {
		for (Card c : Blackjack.getPlayerHand()) {
			bd.addToDiscardPile(c);
		}
		for (Card c : Blackjack.getDealerHand()) {
			bd.addToDiscardPile(c);
		}
		Blackjack.getPlayerHand().removeAll(null);
	}

}
