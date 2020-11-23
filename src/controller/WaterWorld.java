package controller;

import java.util.ArrayList;
import java.util.List;

import states.State;

public class WaterWorld extends Controller {

	public WaterWorld(int height, int width) {
		super(height, width);
	}

	@Override
	protected void setupCells(int currentRow, int currentColumn) {

	}

	@Override
	public List<State> getNeighbors(int currentStateRow, int currentStateColumn) {
		List<State> neighbors = new ArrayList<State>();
		neighbors.add(NORTH_NEIGHBOR, grid[currentStateRow-1][currentStateColumn]);
		neighbors.add(SOUTH_NEIGHBOR, grid[currentStateRow+1][currentStateColumn]);
		neighbors.add(WEST_NEIGHBOR, grid[currentStateRow][currentStateColumn-1]);
		neighbors.add(EAST_NEIGHBOR, grid[currentStateRow][currentStateColumn+1]);
		return neighbors;
	}

}
