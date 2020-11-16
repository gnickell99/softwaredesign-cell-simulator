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
	
	public LiveTree(int currentStateRow, int currentStateColumn, int burnTime, double burnProbability) {
		super(currentStateRow, currentStateColumn, burnTime);
		cellColor = Color.GREEN;
		chanceToBurn = burnProbability;
	}

	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.RED)) {
				if ((double) RNG.nextDouble() <= chanceToBurn) {
					return new BurningTree(this.currentRow, this.currentColumn, this.burnTimer);
				}
			}
		}
		return this;
	}

	
}
