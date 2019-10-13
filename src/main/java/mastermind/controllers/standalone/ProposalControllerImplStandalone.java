package mastermind.controllers.standalone;

import java.util.List;

import mastermind.controllers.ProposalController;

import mastermind.models.Session;

import mastermind.types.Color;
import mastermind.types.Error;

public  class ProposalControllerImplStandalone extends ProposalController {

	public ProposalControllerImplStandalone(Session session) {
		super(session);
	}

	@Override
	public  Error addProposedCombination(List<Color> colors) {

		Error error = checkColors(colors);
		if (error == null) {
			session.addProposedCombination(colors);
			if (session.isWinner() || session.isLooser()) {
				session.nextState();
			}
		}
		return error;
	}	
}
