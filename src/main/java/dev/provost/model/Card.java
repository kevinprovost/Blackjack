package dev.provost.model;

public class Card {

	public enum Suit {
		HEARTS {
			@Override
			public String toString() {
				return "Hearts";
			}
		},
		CLUBS {
			@Override
			public String toString() {
				return "Clubs";
			}
		},
		SPADES {
			@Override
			public String toString() {
				return "Spades";
			}
		},
		DIAMONDS {
			@Override
			public String toString() {
				return "Diamonds";
			}
		}
	}

	private String value;
	private int aceScore = 11;
	private int score;
	private Suit suit;

	public Card(String value, Suit suit) {
		super();
		this.value = value;
		this.suit = suit;

		try {
			this.score = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			if (value == "Ace") {this.score = 1;}
			else {this.score = 10;}
		}
		
		
	}

	public String getValue() {
		return value;
	}

	public String getSuit() {
		return suit.toString();
	}

	public int getScore() {
		return score;
	}

	public int getAceScore() {
		return aceScore;
	}

	@Override
	public String toString() {
		return "Card [value=" + value + ", score=" + score + ", suit=" + suit + "]";
	}

}
