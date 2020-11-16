package states.Waterworld;

import java.util.List;

import states.MutableState;
import states.State;

public abstract class WaterWorldMutables extends MutableState {

	protected double starveTimer;
	protected double breedTimer;
	
	public WaterWorldMutables(int currentStateRow, int currentStateColumn, double starveTime, double breedTime) {
		super(currentStateRow, currentStateColumn);
		starveTimer = starveTime;
		breedTimer = breedTime;
	}

}
