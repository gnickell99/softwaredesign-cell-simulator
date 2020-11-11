package controller;

import java.util.Random;

import javafx.scene.layout.GridPane;
import states.*;

public class GameOfLife extends Controller {

	//Constants
	public static final int EMPTY_GRID = 0;	// If cell is empty its 0
	public static final int BACTERIA_PROBABILITY = 40;	// set bacteria probability
	public static final int RATE_OF_INFECTION_PROBABILITY = 100;	// spread rate of bacteria probability

	public GameOfLife(int gridHeight, int gridWidth) {
		super(gridHeight, gridWidth);

	}


	/**
	 * setupCells
	 * 
	 * The setupCells method places a state object at the given index The state can
	 * be either a infected cell that contains a bacteria or an empty cell that does not contain a bacteria
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */

	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		Random randomInfectedCellsProbability = new Random();

		// Sets the amount of bacteria probability for grid
		int infectedCellProbability = randomInfectedCellsProbability.nextInt(RATE_OF_INFECTION_PROBABILITY);

		// Logic for determining which cells start as infected
		if(infectedCellProbability < BACTERIA_PROBABILITY) {
			State AliveCell = new AliveCell(currentRow, currentColumn, this.grid);
			grid[currentRow][currentColumn] = AliveCell;
		}

		// if the cell should not be infected/alive then it will be a dead/empty cell
		else{ 
			State DeadCell = new DeadCell();
			grid[currentRow][currentColumn] = DeadCell;
		}

	}

	


}



