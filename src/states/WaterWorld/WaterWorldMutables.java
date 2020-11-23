package states.WaterWorld;

import states.*;

public abstract class WaterWorldMutables extends State {

	WaterWorldMutables nextState;
	
	public WaterWorldMutables() {
		super();
	}
	
	/** setNext
	 * 
	 * The setNext method gives a state the ability to set neighboring
	 * states to a new one, while still changing the current state
	 * This is necessary for a swimming fish and shark
	 * 
	 * @param state - the state to be changed
	 */
	public void setNext(WaterWorldMutables state) {
		nextState = state;
	}

}
