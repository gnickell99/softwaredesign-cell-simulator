package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import states.WaterWorld.*;
import states.State;

/***
 * 
 * @author Camryn Williams
 * @author Grant Nickell
 * 
 * WaterWorld controller
 * Handles the specific logic and setup for the water world cell simulator
 *
 */

public class WaterWorld extends Controller {

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
	
	public WaterWorld(int height, int width, double fishDensity, double sharkDensity, double waterDensity, int starveTime, int breedTime) {
		super(height, width);
		this.fishDensity = fishDensity / (fishDensity + sharkDensity + waterDensity);
		this.sharkDensity = sharkDensity / (fishDensity + sharkDensity + waterDensity);
		this.waterDensity = waterDensity / (fishDensity + sharkDensity + waterDensity);
		this.starveTime = starveTime;
		this.breedTime = breedTime;
	}

	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		Random random = new Random();
		double currRandom = random.nextInt(VALUE_OF_A_HUNDRED);
		// checks fish density to determine if fish should spawn
		if (currRandom < (fishDensity * VALUE_OF_A_HUNDRED)) {
			// check to see if shark should spawn
			if (currRandom > (sharkDensity * VALUE_OF_A_HUNDRED)) {
				State shark = new Shark(breedTime, starveTime);
				grid[currentRow][currentColumn] = shark;
			}
			// If not then spawn water
			else {
				State water = new Water();
				grid[currentRow][currentColumn] = water;
			}
		}
		else {
			State fish = new Fish(breedTime);
			grid[currentRow][currentColumn] = fish;
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
