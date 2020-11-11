package states;

import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;

public class AliveCell extends GameOfLifeMutables{
	Random RNG = new Random();

	public AliveCell(int currentStateRow, int currentStateColumn, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		cellColor = Color.LIGHTBLUE;
	}

	@Override
	public State act(int currentStateRow, int currentStateColumn) {
		List<State> neighbors = toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		int liveNeighbors = 0;
		for (State neighbor : neighbors) {
			if (neighbor.getType().equals(ALIVE_CELL)) {
				liveNeighbors++;
			}
		}
		if (liveNeighbors == 2 || liveNeighbors == 3) {
			toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
			return new DeadCell(currentStateRow, currentStateColumn, this.allCells);
		}
		toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		return this;
	}

	@Override
	public String getType() {
		return this.ALIVE_CELL;
	}

}
