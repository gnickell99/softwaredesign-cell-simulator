package main;

import java.util.Random;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import states.*;

public class Wildfire extends Controller {
	private static final double BURN_CHANCE = 0.40;
	public int burnTime;
	public double spreadProbability;
	public double forestDensity;
	public int burningTrees;

	public Wildfire(int height, int width) {
		super(height, width);
	}

	/**
	 * generateForest the generate forest method begins the instantiation of the 2D
	 * forest array
	 */

	/**
	 * placeEdgeOrTree
	 * 
	 * The placeEdgeOrTree method checks if the current index is the border of the
	 * forest, in which case it places an edge, otherwise a tree is setup via the
	 * setupTrees method
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	
	/**
	 * setupTrees
	 * 
	 * The setupTrees method places a state object at the given index The state can
	 * be either a live tree, a burning tree, or an empty space
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	
	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		Random random = new Random();
		// checks forest density to determine if a tree should spawn
		if (random.nextInt(100) < (forestDensity * 100)) {
			// These are the mutable states
			// checks if the tree is should tree should be on fire
			if (burningTrees != 0 && random.nextDouble() < BURN_CHANCE) {
				State burningTree = new BurningTree(currentRow, currentColumn, burnTime, this.board);
				burningTrees--;
				board[currentRow][currentColumn] = burningTree;
			}
			// If not then spawn a normal tree
			else {
				State liveTree = new LiveTree(currentRow, currentColumn, burnTime, spreadProbability, this.board);
				board[currentRow][currentColumn] = liveTree;
			}
		}
		// If forest density is < 1 then it sometimes spawns an empty space
		else {
			State empty = new Empty();
			board[currentRow][currentColumn] = empty;
		}
	}

	public void setBurnTime(int burnTime) {
		if (burnTime > 0) {
			this.burnTime = burnTime;
		} else {
			this.burnTime = 1;
		}
	}

	public void setSpreadProbability(double spreadProbability) {
		if (spreadProbability <= 1.0 && spreadProbability >= 0.0) {
			this.spreadProbability = spreadProbability;
		} else {
			this.spreadProbability = 0.4;
		}
	}

	public void setForestDensity(double forestDensity) {
		if (forestDensity <= 1.0 && forestDensity >= 0.0) {
			this.forestDensity = forestDensity;
		} else {
			this.forestDensity = 1.0;
		}
	}

	public void setBurningTrees(int burningTrees) {
		if (burningTrees > 0 && burningTrees <= (board.length - 2) * (board[0].length - 2)) {
			this.burningTrees = burningTrees;
		} else {
			this.burningTrees = 1;
		}
	}
}
