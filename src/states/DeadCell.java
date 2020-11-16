package states;

import java.util.List;

import javafx.scene.paint.Color;

public class DeadCell extends MutableState{
	
	public DeadCell(int currentStateRow, int currentStateColumn) {
		super(currentStateRow, currentStateColumn);
		cellColor = Color.WHITE;
	}

	@Override
	public State act(List<State> neighbors) {
		int liveNeighbors = 0;
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.LIGHTBLUE)) {
				liveNeighbors++;
			}
		}
		if (liveNeighbors == 3) {
			return new AliveCell(this.currentRow, this.currentColumn);
		}
		return this;
	}

}
