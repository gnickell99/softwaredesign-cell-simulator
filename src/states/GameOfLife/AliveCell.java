package states.GameOfLife;

import java.util.List;
import javafx.scene.paint.Color;
import states.State;

/**
 * 
 * @author Grant Nickell
 * @author Kim Jones
 * 
 * The Alive Cell is representative of an alive bacteria
 * If it has 0 or 1 live neighbors it will die of loneliness
 * If it has 2 or 3 live neighbors it will remain
 * If it has 4 or more live  neighbors it will die from overcrowding
 *
 */

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
