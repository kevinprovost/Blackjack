package dev.provost;

import java.util.Scanner;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.model.Card.Suit;
import dev.provost.model.Deck;
import dev.provost.service.BlackjackService;

public class BlackjackRunner {
	public static void main(String[] args) {

		System.out.println("Hello, welcome to Blackjack.");
		BlackjackService bs = new BlackjackService();

		Scanner scan = new Scanner(System.in);
		final char exitChar = 'x';
		final char hitChar = 'h';
		final char stayChar = 's';
		char userInput = 'x';
		
//		for (Card c : Deck.getDeckOfCards()) {
//			System.out.println(c);
//		}

		//test
//		Deck.setCardInDeck(0, "Ace", Suit.HEARTS);
//		Deck.setCardInDeck(2, "Ace", Suit.HEARTS);
		//test
		bs.dealCards();

		//put player loop here
		
		System.out.println("Dealer's faceup is: "
				+ (Blackjack.getDealerHand().get(0)));
		
		
		do {
			System.out.println("You currently have:");
			System.out.println("-"+Blackjack.getPlayerHand());
			System.out.println("-"+Blackjack.getPlayerScore());
			System.out.println("press 'h' to hit, or 's' to stay");
			userInput = scan.nextLine().toLowerCase().charAt(0);
			
			
			if (userInput == hitChar) {
				bs.hitMove(Blackjack.getPlayerHand());
			}
			if (userInput == stayChar) {
				System.out.println("You stay");
				break;
			}
						
		}
		while (userInput !='x' && Blackjack.getPlayerScore()<21);
		
		
		System.out.println("You finish with:");
		System.out.println("-"+Blackjack.getPlayerHand());
		System.out.println("-"+Blackjack.getPlayerScore());
		
		System.out.println("Dealer has:");
		System.out.println("-"+Blackjack.getDealerHand());
		System.out.println("-"+Blackjack.getDealerScore());
		bs.playForDealer();

		//doing this here to limit calls and typing
		int pScore = Blackjack.getPlayerScore();
		int dScore = Blackjack.getDealerScore();
		
		if (pScore > 21 && dScore > 21) {
			System.out.println("You both busted!");
		}
		else if (pScore > 21) {
			System.out.println("You busted, Dealer wins!");
		}
		else if (dScore > 21) {
			System.out.println("Dealer busted!, you win!");
		}
		else if (pScore == dScore) {
			System.out.println("You tie!");
		}
		else if (pScore > dScore) {
			System.out.println("You win!");
		}
		else {
			System.out.println("Dealer wins!");
		}
		
		bs.clearCards();
//		System.out.println(Blackjack.getDiscardPile());
//
//		System.out.println("Remaining cards: " + Deck.getDeckOfCards().size());
	}
}
