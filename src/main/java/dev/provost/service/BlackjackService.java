package dev.provost.service;

import dev.provost.repository.BlackjackDAO;

public class BlackjackService {

	BlackjackDAO bd = new BlackjackDAO();

	public void dealCards() {
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
		bd.addToPlayerHand(bd.drawCard());
		bd.addToDealerHand(bd.drawCard());
	}

}
