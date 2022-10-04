package dev.provost.service;

import java.util.List;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.repository.BlackjackDAO;

public class BlackjackService {

	BlackjackDAO bd;

	public BlackjackService() {
		bd = new BlackjackDAO();
	}

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
		Blackjack.getPlayerHand().removeAll(Blackjack.getPlayerHand());
		Blackjack.getDealerHand().removeAll(Blackjack.getDealerHand());
	}

	public void hitMove(List<Card> hand) {
		hand.add(bd.drawCard());
	}

	public void changeAceScore(int index) {
		Card c = Blackjack.getPlayerHand().get(index);
		if (c.getScore() == 1) {
			bd.replaceAceInHand(index, c.getSuit(), 11);
		} else if (c.getScore() == 11) {
			bd.replaceAceInHand(index, c.getSuit(), 1);
		} else {
			System.out.println("No Aces to change.");
		}
	}
	
	public  void playForDealer() {
		
		while (Blackjack.getDealerScore() < 16
&&(Blackjack.getDealerScore()>Blackjack.getPlayerScore())) {
			System.out.println("Dealer hits...");
			hitMove(Blackjack.getDealerHand());
			System.out.println("Dealer now has:");
			System.out.println("-"+Blackjack.getDealerHand());
			System.out.println("-"+Blackjack.getDealerScore());
		}
			
			if (Blackjack.getDealerScore()>21) {
				System.out.println("oops, I busted!");
			}
			if (Blackjack.getDealerScore()<=21) {
				System.out.println("Dealer stays...");
			}
	}

}
