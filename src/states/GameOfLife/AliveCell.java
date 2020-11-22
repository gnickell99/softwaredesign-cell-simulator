package states.GameOfLife;

import java.util.List;
import javafx.scene.paint.Color;
import states.State;

public class AliveCell extends GameOfLifeMutables{

	public AliveCell() {
		super();
		cellColor = Color.LIGHTBLUE;
	}

	@Override
	public State act(List<State> neighbors) {
		int liveNeighbors = countLiveNeighbors(neighbors);
		if (liveNeighbors <= 1 || liveNeighbors >= 4) {
			return new DeadCell();
		}
		else {
			return this;
		}
  }


}
