package dev.provost.model;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {

	private static List<Card> dealerHand = new ArrayList<>();
	private static List<Card> playerHand = new ArrayList<>();
	private static List<Card> discardPile = new ArrayList<>();
	private static int dealerScore = 0;
	private static int playerScore = 0;

	public static List<Card> getDealerHand() {
		return dealerHand;
	}

	public static List<Card> getPlayerHand() {
		return playerHand;
	}

	public static List<Card> getDiscardPile() {
		return discardPile;
	}

	public static String getDealerScore() {
		dealerScore = 0;
		int acesPresent = 0;

		for (Card c : Blackjack.getDealerHand()) {
			if (c.getValue().equals("Ace")) {
				acesPresent++;
			}
			dealerScore += c.getScore();
		}

		if (acesPresent != 0) {
			return dealerScore + " or " + (dealerScore + (10 * acesPresent));
		} else {
			return String.valueOf(dealerScore);
		}
	}

	public static String getPlayerScore() {
		playerScore = 0;
		int acesPresent = 0;

		for (Card c : Blackjack.getPlayerHand()) {
			if (c.getValue().equals("Ace")) {
				acesPresent++;
			}
			playerScore += c.getScore();
		}

		if (acesPresent != 0) {
			return playerScore + " or " + (playerScore + (10 * acesPresent));
		} else {
			return String.valueOf(playerScore);
		}
	}

}
