package states.GameOfLife;

import java.util.List;
import javafx.scene.paint.Color;
import states.State;

public class DeadCell extends GameOfLifeMutables{
	
	public DeadCell() {
		super();
		cellColor = Color.WHITE;
	}

	@Override
	public State act(List<State> neighbors) {
		int liveNeighbors = countLiveNeighbors(neighbors);
		if (liveNeighbors == 3) {
			return new AliveCell();
		}
		else {
			return this;
		}
	}

}
