package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import santaTecla.utils.TCPIP;

public abstract class Controller {

	protected Game game;
	
	protected State state;
	protected TCPIP tcpip;

	Controller(Game game, State state, TCPIP tcpip) {
		this.game = game;
		this.state = state;
		this.tcpip = tcpip;
	}
	
	public int getWidth() {
		return game.getWidth();
	}


}
