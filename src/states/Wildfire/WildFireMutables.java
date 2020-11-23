package states.Wildfire;

import states.State;

/***
 * 
 * @author Grant Nickell
 *
 * WildFireMutables is an abstract super class inheriting from State
 * that is used by the mutable states in wild fire
 * 
 * When the inheriting states act, they change state depending on
 * the state of its neighbors and the burn probability
 * or when the burn timer has reached 0.
 *
 */

public abstract class WildFireMutables extends State {
	
	protected int burnTimer;
	protected double chanceToBurn;
	
	public WildFireMutables(int burnTime) {
		super();
		burnTimer = burnTime;
	}

}
