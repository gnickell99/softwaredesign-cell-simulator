package states.WaterWorld;

import states.*;

public abstract class WaterWorldMutables extends State {

	WaterWorldMutables nextState;
	
	public WaterWorldMutables() {
		super();
	}
	
	public void setNext(WaterWorldMutables state) {
		nextState = state;
	}

}
