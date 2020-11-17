package controller;

import java.util.ArrayList;
import java.util.List;

import states.State;

public class RockPaperScissors extends Controller {

	public RockPaperScissors(int height, int width) {
		super(height, width);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<State> getNeighbors(int currentStateRow, int currentStateColumn) {
		List<State> neighbors = new ArrayList<State>();
		neighbors.add(NORTH_NEIGHBOR, grid[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, grid[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, grid[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, grid[currentStateRow][currentStateColumn+1]);
		neighbors.add(NORTH_WEST_NEIGHBOR, grid[currentStateRow-1][currentStateColumn-1]);
		neighbors.add(NORTH_EAST_NEIGHBOR, grid[currentStateRow-1][currentStateColumn+1]);
		neighbors.add(SOUTH_WEST_NEIGHBOR, grid[currentStateRow+1][currentStateColumn-1]);
		neighbors.add(SOUTH_EAST_NEIGHBOR, grid[currentStateRow+1][currentStateColumn+1]);
		return neighbors;
	}

}
