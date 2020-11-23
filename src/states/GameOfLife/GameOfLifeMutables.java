package states.GameOfLife;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 * 
 * The superclass for mutable Game of Life states
 * 
 * When the inheriting states act they can either die, remain, or multiply
 *
 */

public abstract class GameOfLifeMutables extends State {
	Random RNG = new Random();
	
	public GameOfLifeMutables() {
		super();
	}
	
	/** countLiveNeighbors
	 * 
	 * This method is used to count how many of the neighbors are alive cells
	 * Both the Alive and Dead cells need this method
	 * 
	 * @param neighbors - the list of neighbors to count from
	 * @return liveNeighbors - the count of live neighbors
	 */
	int countLiveNeighbors(List<State> neighbors) {
		int liveNeighbors = 0;
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.LIGHTBLUE)) {
				liveNeighbors++;
			}
		}
		return liveNeighbors;
	}

}
