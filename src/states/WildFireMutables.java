package states;

import java.util.ArrayList;
import java.util.List;

public abstract class WildFireMutables extends MutableState {

	final String LIVE_TREE = "live tree";
	final String BURNING_TREE = "burning tree";
	int burnTimer;
	double chanceToBurn;
	
	public WildFireMutables(int currentStateRow, int currentStateColumn, int burnTime, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		burnTimer = burnTime;
	}

	@Override
	List<State> toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates) {
		List<State> neighbors = new ArrayList<State>();
		neighbors.add(NORTH_NEIGHBOR, allStates[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, allStates[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, allStates[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, allStates[currentStateRow][currentStateColumn+1]);
		return neighbors;
	}

}
