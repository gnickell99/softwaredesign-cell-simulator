package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import states.*;
import states.Wildfire.BurningTree;
import states.Wildfire.BurntDownTree;
import states.Wildfire.Empty;
import states.Wildfire.LiveTree;

public class Wildfire extends Controller {

	//Constants
	private static final double BURN_CHANCE = 0.40;
	private static final double DEFAULT_SPREADPROBABILITY = .40;
	private static final int VALUE_OF_ZERO = 0;
	private static final int VALUE_OF_ONE = 1;
	private static final double VALUE_OF_ZERO_DOUBLE = 0.0;
	private static final double VALUE_OF_ONE_DOUBLE = 1.0;
	private static final int  VALUE_OF_TWO = 2;
	private static final int VALUE_OF_A_HUNDRED = 100;
	private int burnTime;
	private double spreadProbability;
	private double forestDensity;
	private int burningTrees;

	public Wildfire(int height, int width, int burnTime, double spreadProbability, double forestDensity, int burningTrees) {
		super(height, width);
		this.burningTrees = burningTrees;
		this.burnTime = burnTime;
		this.forestDensity = forestDensity;
		this.spreadProbability = spreadProbability;
	}

	/**
	 * setupCells
	 * 
	 * The setupCells method places a state object at the given index The state can
	 * be either a live tree, a burning tree, or an empty space
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		Random random = new Random();
		// checks forest density to determine if a tree should spawn
		if (random.nextInt(VALUE_OF_A_HUNDRED) < (forestDensity * VALUE_OF_A_HUNDRED)) {
			// These are the mutable states
			// checks if the tree is should tree should be on fire
			if (burningTrees != VALUE_OF_ZERO && random.nextDouble() < BURN_CHANCE) {
				State burningTree = new BurningTree(burnTime);
				burningTrees--;
				grid[currentRow][currentColumn] = burningTree;
			}
			// If not then spawn a normal tree
			else {
				State liveTree = new LiveTree(burnTime, spreadProbability);
				grid[currentRow][currentColumn] = liveTree;
			}
		}
		// If forest density is < 1 then it sometimes spawns an empty space
		else {
			State empty = new Empty();
			grid[currentRow][currentColumn] = empty;
		}
	}

	public void setBurnTime(int burnTime) {
		if (burnTime > VALUE_OF_ZERO) {
			this.burnTime = burnTime;
		} else {
			this.burnTime = VALUE_OF_ONE;
		}
	}

	public void setSpreadProbability(double spreadProbability) {
		if (spreadProbability <= VALUE_OF_ONE_DOUBLE && spreadProbability >= VALUE_OF_ZERO_DOUBLE) {
			this.spreadProbability = spreadProbability;
		} else {
			this.spreadProbability = DEFAULT_SPREADPROBABILITY;
		}
	}

	public void setForestDensity(double forestDensity) {
		if (forestDensity <= VALUE_OF_ONE_DOUBLE && forestDensity >= VALUE_OF_ZERO_DOUBLE) {
			this.forestDensity = forestDensity;
		} else {
			this.forestDensity = VALUE_OF_ONE_DOUBLE;
		}
	}

	public void setBurningTrees(int burningTrees) {
		if (burningTrees > VALUE_OF_ZERO && burningTrees <= (grid.length - VALUE_OF_TWO) * (grid[VALUE_OF_ONE].length - VALUE_OF_TWO)) {
			this.burningTrees = burningTrees;
		} else {
			this.burningTrees = VALUE_OF_ONE;
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
	public void setBurningTree(int currentRow, int currentColumn) {

		State burningTree = new BurningTree(this.burnTime);
		grid[currentRow][currentColumn] = burningTree;
	}
	
	public void setBurntTree(int currentRow, int currentColumn) {
		grid[currentRow][currentColumn] = new BurntDownTree();
	}
	
	public void setLiveTree(int currentRow, int currentColumn) {
		State liveTree = new LiveTree(this.burnTime, this.spreadProbability);
		grid[currentRow][currentColumn] = liveTree;
	}

	
}
