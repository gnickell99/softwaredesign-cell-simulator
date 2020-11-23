package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import states.*;

public class WaterWorldControl extends Controller{

	private static final int VALUE_OF_ZERO = 0;
	private static final int VALUE_OF_ONE = 1;
	private static final double VALUE_OF_ZERO_DOUBLE = 0.0;
	private static final double VALUE_OF_ONE_DOUBLE = 1.0;
	private static final int  VALUE_OF_TWO = 2;
	private static final int VALUE_OF_A_HUNDRED = 100;
	public double fishDensity;
	public double sharkDensity;
	public double waterDensity;
	public int starveTime;
	public int breedTime;
	
	public WaterWorldControl(int height, int width) {
		super(height, width);
	}
	
	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		Random random = new Random();
		double currRandom = random.nextInt(VALUE_OF_A_HUNDRED);
		// checks fish density to determine if fish should spawn
		
		if (currRandom < (fishDensity * VALUE_OF_A_HUNDRED)) {
			// check to see if shark should spawn
			if (currRandom > (sharkDensity * VALUE_OF_A_HUNDRED)) {
				State shark = new Shark(starveTime);
				grid[currentRow][currentColumn] = shark;
			}
			// If not then spawn spawn water
			else {
				State water = new Water();
				grid[currentRow][currentColumn] = water;
			}
		}
		else {
			State fish = new Fish(breedTime);
			grid[currentRow][currentColumn] = water;
		}
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
