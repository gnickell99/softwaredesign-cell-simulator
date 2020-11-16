package states;

import java.util.List;
import java.util.Random;

import controller.GameOfLife;
import javafx.scene.paint.Color;

public class AliveCell extends MutableState{

	public AliveCell(int currentStateRow, int currentStateColumn) {
		super(currentStateRow, currentStateColumn);
		cellColor = Color.LIGHTBLUE;
	}

	@Override
	public State act(List<State> neighbors) {
		int liveNeighbors = 0;
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.LIGHTBLUE)) {
				liveNeighbors++;
			}
		}
		
		if (liveNeighbors <= 1 || liveNeighbors >= 4) {
			return new DeadCell(this.currentRow, this.currentColumn);
		} else { return this; }
	}


}
