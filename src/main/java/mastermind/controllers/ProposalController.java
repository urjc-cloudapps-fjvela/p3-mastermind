package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;

import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public abstract Error addProposedCombination(List<Color> colors);

	public boolean isWinner() {
		return session.isWinner();
	}

	public boolean isLooser() {
		return session.isLooser();
	}

	public int getAttempts() {
		return session.getAttempts();
	}

	public List<Color> getColors(int position) {
		return session.getColors(position);
	}

	public int getBlacks(int position) {
		return session.getBlacks(position);
	}

	public int getWhites(int position) {
		return session.getWhites(position);
	}

	protected Error checkColors(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i + 1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}
			}
		}
		return error;
	}

	public void clear() {
		session.clear();
	}

	public StateValue getStateValue() {
		return session.getValueState();
	}

	public void nextState() {
		session.nextState();
	}

	public void resetState() {
		session.resetState();
	}

}
