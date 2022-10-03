package dev.provost;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;

public class BlackjackRunner {
	public static void main(String[] args) {
		System.out.println("Hello, welcome to Blackjack.");
		for (Card c : Blackjack.getDeck()) {
			System.out.println(c);
		}
	}
}
