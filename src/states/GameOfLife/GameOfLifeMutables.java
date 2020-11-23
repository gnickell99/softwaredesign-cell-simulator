package states.GameOfLife;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
import states.State;

public abstract class GameOfLifeMutables extends State {
	Random RNG = new Random();
	
	public GameOfLifeMutables() {
		super();
	}
	
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
