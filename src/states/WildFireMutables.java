package states;

public abstract class WildFireMutables extends MutableState {

	int burnTimer;
	double chanceToBurn;
	
	public WildFireMutables(int currentStateRow, int currentStateColumn, int burnTime, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		burnTimer = burnTime;
	}

	@Override
	void toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates) {
		neighbors.add(NORTH_NEIGHBOR, allStates[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, allStates[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, allStates[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, allStates[currentStateRow][currentStateColumn+1]);
	}

}
