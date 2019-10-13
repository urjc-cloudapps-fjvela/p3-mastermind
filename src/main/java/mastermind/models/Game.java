package mastermind.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private Stack<ProposedCombination> proposedCombinations;
	private Stack<ProposedCombination> undoProposedCombinations;

	private List<Result> results;

	// private int attempts;

	public Game() {
		clear();
	}

	public void clear() {
		secretCombination = new SecretCombination();
		proposedCombinations = new Stack<ProposedCombination>();
		undoProposedCombinations = new Stack<ProposedCombination>();
		results = new ArrayList<Result>();
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		proposedCombinations.add(proposedCombination);
		results.add(secretCombination.getResult(proposedCombination));
	}

	public boolean isLooser() {
		return getAttempts() == Game.MAX_LONG;
	}

	public boolean isWinner() {
		return results.get(getAttempts() - 1).isWinner();
	}

	public int getAttempts() {
		return proposedCombinations.size();
	}

	public List<Color> getColors(int position) {
		return proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public void redo() {
		proposedCombinations.add(undoProposedCombinations.pop());
	}

	public boolean isRedoable() {
		return undoProposedCombinations.size() > 0;
	}

	public void undo() {
		undoProposedCombinations.add(proposedCombinations.pop());
	}

	public boolean isUndoable() {
		return proposedCombinations.size() > 0;
	}
}
