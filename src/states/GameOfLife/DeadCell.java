package states.GameOfLife;

import java.util.List;
import javafx.scene.paint.Color;
import states.State;

/**
 * 
 * @author Grant Nickell
 * @author Kim Jones
 * 
 * The Dead Cell is representative of an empty space and dead bacteria
 * If it has 3 living neighbors, a new alive cell is born
 *
 */

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
