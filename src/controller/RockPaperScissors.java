package controller;

import java.util.ArrayList;
import java.util.List;

import states.*;
import states.RockPaperScissors.Rock;
import states.RockPaperScissors.Paper;
import states.RockPaperScissors.Scissors;

/***
 * 
 * @author Grant Nickell
 * 
 * The Rock Paper Scissors controller
 * Handles the specific setup of an rps cell simulator grid
 *
 */

public class RockPaperScissors extends Controller {

	private int threshold;
	
	public RockPaperScissors(int height, int width, int winThreshold) {
		super(height, width);
		this.threshold = winThreshold;
	}

	/** setupCells
	 * 
	 * The setupCells method places a state object at the given index
	 * The state can be either rock, paper, or scissors
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		// RPS setupCells uses a quadrant idea on the grid to perform logic
		if (currentColumn < grid.length / 2) { // looks at the top two quadrants of the grid
			if (currentRow < grid[0].length / 2) { // left quadrant
				State rock = new Rock(threshold);
				grid[currentRow][currentColumn] = rock;
			}
			else { // right quadrant
				State scissors = new Scissors(threshold);
				grid[currentRow][currentColumn] = scissors;
			}
		}
		else { // looks at the bottom two quadrant of the grid
			// The idea here is to look at the diagonal of the rows and columns much like on a mathematical graph
			// currentRow (mathematical equivalent of y value) is subtracted from the total length to set the bottom row as the 0 value
			// from there, a check is made of the value of the x (column) and y (row), where if the y is larger than the x,
			// the particular cell must be above the diagonal line cutting through the quadrant
			// this idea is repeated for the right quadrant as well
			if (currentColumn < grid.length - currentRow) { //left bottom quadrant with logic
				State rock = new Rock(threshold);
				grid[currentRow][currentColumn] = rock;
			}
			else if (grid[0].length - currentColumn > grid.length - currentRow) { //right bottom quadrant with logic
				State scissors = new Scissors(threshold);
				grid[currentRow][currentColumn] = scissors;
			}
			else { // everything else is set to paper
				State paper = new Paper(threshold);
				grid[currentRow][currentColumn] = paper;
			}
		}
	}


	/** getNeighbors
	 * 
	 * The neighbors for rock paper scissors is defined as all surrounding cells:
	 * adjacent and immediately diagonal
	 */
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
	
	//Method to help test
	public void makeRock(int currentRow, int currentColumn) {
		Rock rock = new Rock(this.threshold);
		grid[currentRow][currentColumn] = rock;
	}
	
	public void makePaper(int currentRow, int currentColumn) {
		Paper paper = new Paper(this.threshold);
		grid[currentRow][currentColumn] = paper;
	}
	
	public void makeScissor(int currentRow, int currentColumn) {
		Scissors paper = new Scissors(this.threshold);
		grid[currentRow][currentColumn] = paper;
	}

}
