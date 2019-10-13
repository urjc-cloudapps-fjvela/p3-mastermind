package mastermind.server.proxy;

import java.util.List;

import mastermind.controllers.ProposalController;

import mastermind.models.Session;

import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class ProposalControllerImplProxy extends ProposalController {

	private TCPIP tcpip;

	public ProposalControllerImplProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public Error addProposedCombination(List<Color> colors) {

		Error error = checkColors(colors);
		if (error == null) {
			tcpip.send(FrameType.ADD_PROPOSED_COMBINATION);
			tcpip.send(colors);
			error = tcpip.receiveError();
			if (error == null) {
				if (isWinnerOrIsLooser()) {
					session.nextState();
				}
			}
		}
		return error;
	}

	private boolean isWinnerOrIsLooser() {
		tcpip.send(FrameType.IS_WINNER);
		boolean isWinner = tcpip.receiveBoolean();

		tcpip.send(FrameType.IS_LOOSER);
		boolean isLooser = tcpip.receiveBoolean();

		return isWinner || isLooser;

	}
}
