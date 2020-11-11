package states;

import java.util.List;
import java.util.Random;

//import controller.Controller;
import javafx.scene.paint.Color;

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
	
	public LiveTree(int currentStateRow, int currentStateColumn, int burnTime, double burnProbability, State[][] allStates) {
		super(currentStateRow, currentStateColumn, burnTime, allStates);
		cellColor = Color.GREEN;
		chanceToBurn = burnProbability;
	}

	@Override
	public State act(int currentStateRow, int currentStateColumn) {
		List<State> neighbors = toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.RED)) {
				if ((double) RNG.nextDouble() <= chanceToBurn) {
					//toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
					return new BurningTree(currentStateRow, currentStateColumn, this.burnTimer, this.allCells);
				}
			}
		}
		//toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		return this;
	}

	@Override
	public String getType() {
		return "live tree";
	}
	

}
