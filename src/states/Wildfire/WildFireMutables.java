package states.Wildfire;

import states.State;

public abstract class WildFireMutables extends State {
	
	protected int burnTimer;
	protected double chanceToBurn;
	
	public WildFireMutables(int burnTime) {
		super();
		burnTimer = burnTime;
	}

}
