package states.Wildfire;

import java.util.ArrayList;
import java.util.List;

import states.MutableState;

public abstract class WildFireMutables extends MutableState {
	
	protected int burnTimer;
	protected double chanceToBurn;
	
	public WildFireMutables(int currentStateRow, int currentStateColumn, int burnTime) {
		super(currentStateRow, currentStateColumn);
		burnTimer = burnTime;
	}

}
