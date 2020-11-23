package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import states.WaterWorld.*;
import states.Wildfire.BurningTree;
import states.Wildfire.BurntDownTree;
import states.Wildfire.LiveTree;
import states.Edge;
import states.State;

/***
 * 
 * @author Camryn Williams
 * @author Grant Nickell
 * 
 * WaterWorld controller
 * handles the specific logic and setup for the water world cell simulator
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
	private int fishCount = 0;
	private int sharkCount = 0;

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
		// checks fish density to determine if fish should spawn
		if (random.nextInt(VALUE_OF_A_HUNDRED) >= (fishDensity * VALUE_OF_A_HUNDRED) 
				&& fishCount < (fishDensity*grid.length*grid.length)) {
			fishCount++;
			State fish = new Fish(breedTime);
			grid[currentRow][currentColumn] = fish;
		}
		// check to see if shark should spawn
		else if (random.nextInt(VALUE_OF_A_HUNDRED) >= (sharkDensity * VALUE_OF_A_HUNDRED)
				&& sharkCount < (sharkDensity*grid.length*grid.length)) {
			sharkCount++;
			State shark = new Shark(breedTime, starveTime);
			grid[currentRow][currentColumn] = shark;
		}
		// If not then spawn water
		else {
			State water = new Water();
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

	//Methods to help test
	//Given a point position they will make the needed state for testing

	public void plantFish(int currentRow, int currentColumn) {
		State fish = new Fish(this.breedTime);
		grid[currentRow][currentColumn] = fish;
	}

	public void plantShark(int currentRow, int currentColumn) {
		State shark = new Shark(this.breedTime, this.starveTime);
		grid[currentRow][currentColumn] = shark;
	}

	public void makeWater(int currentRow, int currentColumn) {
		State water = new Water();
		grid[currentRow][currentColumn] = water;
	}
	
	public void makeEdge(int currentRow, int currentColumn) {
		State edge = new Edge();
		grid[currentRow][currentColumn] = edge;
	}

}
