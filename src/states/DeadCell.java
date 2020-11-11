package states;

import java.util.List;

import javafx.scene.paint.Color;

public class DeadCell extends GameOfLifeMutables{
	
	public DeadCell(int currentStateRow, int currentStateColumn, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		cellColor = Color.WHITE;
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
		if (liveNeighbors == 3) {
			toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
			return new AliveCell(currentStateRow, currentStateColumn, this.allCells);
		}
		toListNeighbors(currentStateRow, currentStateColumn, this.allCells);
		return this;
	}
	
	@Override
	public String getType() {
		return "dead cell";
	}

}
