package controller;

import java.util.Random;

import states.*;

public class Wildfire extends Controller {

	/***
	 * 
	 * @author Camyrn and Grant
	 * Wildfire - Sub class controller for wildfire
	 * 
	 * Based on previous wildfire cell simulation code
	 *
	 */
	
	//Constants
	private static final double BURN_CHANCE = 0.40;
	private static final double DEFAULT_SPREADPROBABILITY = .40;
	private static final int VALUE_OF_ZERO = 0;
	private static final int VALUE_OF_ONE = 1;
	private static final double VALUE_OF_ZERO_DOUBLE = 0.0;
	private static final double VALUE_OF_ONE_DOUBLE = 1.0;
	private static final int  VALUE_OF_TWO = 2;
	private static final int VALUE_OF_A_HUNDRED = 100;
	public int burnTime;
	public double spreadProbability;
	public double forestDensity;
	public int burningTrees;

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
				State burningTree = new BurningTree(currentRow, currentColumn, burnTime, this.grid);
				burningTrees--;
				grid[currentRow][currentColumn] = burningTree;
			}
			// If not then spawn a normal tree
			else {
				State liveTree = new LiveTree(currentRow, currentColumn, burnTime, spreadProbability, this.grid);
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

	
}