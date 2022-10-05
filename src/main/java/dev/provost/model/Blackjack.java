package dev.provost.model;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

	public Blackjack() {
		new Deck();
	}

	private static List<Card> dealerHand = new ArrayList<>();
	private static List<Card> playerHand = new ArrayList<>();

	public static List<Card> getDealerHand() {
		return dealerHand;
	}

	public static List<Card> getPlayerHand() {
		return playerHand;
	}

	public static int getDealerScore() {
		int dealerScore = 0;
		int acesPresent = 0;

		for (Card c : Blackjack.getDealerHand()) {
			if (c.getValue().equals("Ace")) {
				acesPresent++;
			}
			dealerScore += c.getScore();
		}

		while (dealerScore > 21 && acesPresent > 0) {
			dealerScore -= 10;
			acesPresent--;
		}

		return dealerScore;
	}

	public static int getPlayerScore() {
		int playerScore = 0;
		int acesPresent = 0;

		for (Card c : Blackjack.getPlayerHand()) {
			if (c.getValue().equals("Ace")) {
				acesPresent++;
			}
			playerScore += c.getScore();
		}

		while (playerScore > 21 && acesPresent > 0) {
			playerScore -= 10;
			acesPresent--;
		}

		return playerScore;
	}

}
