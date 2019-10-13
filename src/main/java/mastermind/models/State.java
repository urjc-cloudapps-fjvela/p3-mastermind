package mastermind.models;

public class State {
		
	private StateValue stateValue;
	
	public State() {
		stateValue = StateValue.INITIAL;
	}
	
	public void next() {
		stateValue = StateValue.values()[stateValue.ordinal()+1];
	}
	
	public void reset() {
		stateValue = StateValue.INITIAL;
	}

	public StateValue getValueState() {
		return stateValue;
	}

	public void setValueState(StateValue stateValue) {
		this.stateValue = stateValue;
	}
	
}
