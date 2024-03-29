package states.Wildfire;

import java.util.List;
import java.util.Random;

//import controller.Controller;
import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 * 
 * The LiveTree state inherits from mutable state,
 * The tree will start to burn if one of it's neighbors is a burning tree
 * and the burning probability condition is met
 * Otherwise, it stays alive
 *
 */

public class LiveTree extends WildFireMutables{
	Random RNG = new Random();
	
	public LiveTree(int burnTime, double burnProbability) {
		super(burnTime);
		cellColor = Color.GREEN;
		chanceToBurn = burnProbability;
	}

	/**
	 * checks if its neighbor is burning
	 * and performs a random check to
	 * determine if it starts burning
	 * based on the spread probability
	 */
	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.RED)) {
				if ((double) RNG.nextDouble() <= chanceToBurn) {
					return new BurningTree(this.burnTimer);
				}
			}
		}
		return this;
	}

	
}
