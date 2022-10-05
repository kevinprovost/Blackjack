package dev.provost.service;

import java.util.List;
//these are the correct imports to make the logger work
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.util.Scanner;

import dev.provost.model.Blackjack;
import dev.provost.model.Card;
import dev.provost.repository.BlackjackDAO;

public class BlackjackService {
//	instance of logger for future testing purposes
//	Logger logger = LogManager.getLogger(BlackjackService.class);
	BlackjackDAO bd;
	static Scanner scan;
	static final char STAY_CHAR = 's';
	static final char HIT_CHAR = 'h';

	public BlackjackService() {
		bd = new BlackjackDAO();
		scan = new Scanner(System.in);
	}

	private void dealCards() {
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
	}

	private void clearCards() {
		Blackjack.getPlayerHand().removeAll(Blackjack.getPlayerHand());
		Blackjack.getDealerHand().removeAll(Blackjack.getDealerHand());
	}

	private void hitMove(List<Card> hand) {
		hand.add(bd.drawCard());
	}

	private void playForDealer() {

		while (Blackjack.getDealerScore() <= 16) {
			System.out.println("\nDealer hits...");
			hitMove(Blackjack.getDealerHand());
			System.out.println("\nDealer now has:");
			System.out.println("-" + Blackjack.getDealerHand());
			System.out.println("- Score: " + Blackjack.getDealerScore());
			System.out.println("\nPress any key to continue.");
			scan.nextLine();
		}

		if (Blackjack.getDealerScore() <= 21) {
			System.out.println("Dealer stays...");
		}

	}

	public void gameLoop() {
		System.out.println("Hello, welcome to Blackjack.");
		dealCards();

		System.out.println("\nDealer's faceup is: " + (Blackjack.getDealerHand().get(0)));

		System.out.println("\nYou currently have:");
		System.out.println("- " + Blackjack.getPlayerHand());
		System.out.println("- Score: " + Blackjack.getPlayerScore());

		char userInput = askPlayer();
		while (userInput != STAY_CHAR && Blackjack.getPlayerScore() < 21) {

			System.out.println("\nYou have:");
			System.out.println("- " + Blackjack.getPlayerHand());
			System.out.println("- Score: " + Blackjack.getPlayerScore());
			userInput = askPlayer();
		}

		if (Blackjack.getPlayerScore() > 21) {
			System.out.println("\nYou currently have:");
			System.out.println("- " + Blackjack.getPlayerHand());
			System.out.println("- Score: " + Blackjack.getPlayerScore());
			System.out.println("\nYou bust!");
			System.out.println("\nPress any key to continue.");
			scan.nextLine();
		}

		playForDealer();
		System.out.println("\n" + checkWhoWins());

		System.out.println("\nYou finish with a score of: " + Blackjack.getPlayerScore());
		System.out.println("Dealer has a score of: " + Blackjack.getDealerScore() + "\n");
		clearCards();
		playAgain();
	}

	private String checkWhoWins() {
		int pScore = Blackjack.getPlayerScore();
		int dScore = Blackjack.getDealerScore();

		if (pScore > 21 && dScore > 21) {
			return "You both busted!";
		} else if (pScore > 21) {
			return "You busted, dealer wins!";
		} else if (dScore > 21) {
			return "Dealer busted, you win!";
		} else if (pScore == dScore) {
			return "You push.";
		} else if (pScore > dScore) {
			return "You win!";
		} else if (pScore == 21 && pScore > dScore) {
			return "You win! Blackjack!";
		} else if (dScore == 21 && dScore > pScore) {
			return "Dealer wins! Blackjack!";
		} else {
			return "Dealer wins!";
		}
	}

	private char askPlayer() {
		System.out.println("\nPress 'h' to hit, or 's' to stay");
		char userInput = ' ';
		if (scan.hasNext()){  //this will check for empty string
			userInput = scan.next().toLowerCase().charAt(0); //stopped using nextLine to avoid the newline issues
		}
		if (userInput == HIT_CHAR) {
			System.out.println("You hit...");
			hitMove(Blackjack.getPlayerHand());
		} else if (userInput == STAY_CHAR) {
			System.out.println("You stay...");

			System.out.println("\nPress any key to continue.");
			scan.nextLine();
		} else {
			System.out.println("Invalid entry.");
			System.out.println("You have:");
			System.out.println("- " + Blackjack.getPlayerHand());
			System.out.println("- Score: " + Blackjack.getPlayerScore());
			askPlayer();
		}

		return userInput;
	}

	private void playAgain() {
		char userInput;

		System.out.println("Play again?");
		System.out.println("Press 'c' to continue, 'q' to quit.");
		userInput = scan.nextLine().toLowerCase().charAt(0);

		if (userInput == 'c') {
			gameLoop();
		} else if (userInput == 'q') {
			System.out.println("Thanks for playing!");
			scan.close();
		} else {
			System.out.println("Invalid entry.\n");
			playAgain();
		}
	}

}
