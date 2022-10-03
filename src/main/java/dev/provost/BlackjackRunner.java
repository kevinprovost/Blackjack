package dev.provost;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.model.Deck;
import dev.provost.service.BlackjackService;

public class BlackjackRunner {
	public static void main(String[] args) {

		System.out.println("Hello, welcome to Blackjack.");

		BlackjackService bs = new BlackjackService();

		for (Card c : Deck.getDeckOfCards()) {
			System.out.println(c);
		}

		bs.dealCards();
		

		System.out.println(Blackjack.getPlayerHand());
		System.out.println(Blackjack.getPlayerScore());

		System.out.println(Blackjack.getDealerHand());
		System.out.println(Blackjack.getDealerScore());


		bs.clearCards();
		System.out.println(Blackjack.getDiscardPile());

		System.out.println("Remaining cards: " + Deck.getDeckOfCards().size());
	}
}
