package states;

import java.awt.Point;

public abstract class GameOfLifeMutables extends MutableState {

	public final int NORTH_WEST_NEIGHBOR = 4;
	public final int NORTH_EAST_NEIGHBOR = 5;
	public final int SOUTH_WEST_NEIGHBOR = 6;
	public final int SOUTH_EAST_NEIGHBOR = 7;
	
	final String ALIVE_CELL = "alive cell";
	
	public GameOfLifeMutables(int currentStateRow, int currentStateColumn, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
	}

	@Override
	void toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates) {
		neighbors.add(NORTH_NEIGHBOR, allStates[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, allStates[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, allStates[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, allStates[currentStateRow][currentStateColumn+1]);
		neighbors.add(NORTH_WEST_NEIGHBOR, allStates[currentStateRow-1][currentStateColumn-1]);
		neighbors.add(NORTH_EAST_NEIGHBOR, allStates[currentStateRow-1][currentStateColumn+1]);
		neighbors.add(SOUTH_WEST_NEIGHBOR, allStates[currentStateRow+1][currentStateColumn-1]);
		neighbors.add(SOUTH_EAST_NEIGHBOR, allStates[currentStateRow+1][currentStateColumn+1]);
	}

}
