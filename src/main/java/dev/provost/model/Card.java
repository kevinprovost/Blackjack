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
	private int score;
	private Suit suit;

	public Card() {
	}

	public Card(String value, Suit suit) {
		super();
		this.value = value;
		this.suit = suit;

		try {
			this.score = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			if ("Ace".equals(value)) {
				this.score = 11;
			} else {
				this.score = 10;
			}
		}

	}

	public Card(String value, Suit suit, int score) {
		super();
		this.value = value;
		this.suit = suit;
		this.score = score;
	}

	public String getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		if (!"Ace".equals(value)) {
			return value + " of " + suit + " (" + score + ")";
		}

		return value + " of " + suit + " (" + score + " or " + (score - 10) + ")";
	}

}
