package dev.provost;

import dev.provost.service.BlackjackService;

public class BlackjackRunner {

	public static void main(String[] args) {
		BlackjackService bs = new BlackjackService();

		bs.gameLoop();
	}

}
