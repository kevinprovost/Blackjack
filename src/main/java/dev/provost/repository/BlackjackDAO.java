package dev.provost.repository;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;

public class BlackjackDAO {

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

}
