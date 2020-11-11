package states;

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
	void toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates) {
		neighbors.add(NORTH_NEIGHBOR, this.allCells[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, this.allCells[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, this.allCells[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, this.allCells[currentStateRow][currentStateColumn+1]);
	}

}
