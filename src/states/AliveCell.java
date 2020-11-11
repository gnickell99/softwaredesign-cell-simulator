package states;

import java.util.Random;
import javafx.scene.paint.Color;

public class AliveCell extends GameOfLifeMutables{
	Random RNG = new Random();

	public AliveCell(int currentStateRow, int currentStateColumn, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		cellColor = Color.LIGHTBLUE;
		toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
	}

	@Override
	public State act(int currentStateRow, int currentStateColumn) {
		int liveNeighbors = 0;
		for (State neighbor : this.neighbors) {
			if (neighbor.getType().equals(ALIVE_CELL)) {
				liveNeighbors++;
			}
		}
		if (liveNeighbors <= 1 || liveNeighbors > 3) {
			toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
			return new DeadCell();
		}
		toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		return this;

	}

	@Override
	public String getType() {
		return this.ALIVE_CELL;
	}

}
