package dev.provost;

import dev.provost.model.Blackjack;
import dev.provost.service.BlackjackService;

public class BlackjackRunner {
	public static void main(String[] args) {

		System.out.println("Hello, welcome to Blackjack.");

		BlackjackService bs = new BlackjackService();
//		 for (Card c : Blackjack.getDeck()) {
//			System.out.println(c);
//		}
		bs.dealCards();

		System.out.println(Blackjack.getPlayerHand());
		System.out.println(Blackjack.getPlayerScore());

		System.out.println(Blackjack.getDealerHand());
		System.out.println(Blackjack.getDealerScore());

		System.out.println("Remaining cards: " + Blackjack.getDeck().getDeckOfCards().size());
	}
}
