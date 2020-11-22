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

	
	@Override
	protected void setupCells(int currentRow, int currentColumn) {
		if (currentRow > grid[0].length / 2) {
			if (currentColumn < grid.length / 2) {
				State rock = new Rock(threshold);
				grid[currentRow][currentColumn] = rock;
			}
			else {
				State scissors = new Scissors(threshold);
				grid[currentRow][currentColumn] = scissors;
			}
		}
		else {
			if (currentColumn > currentRow - grid[0].length && currentColumn < grid.length / 2) {
				State rock = new Rock(threshold);
				grid[currentRow][currentColumn] = rock;
			}
			else if (currentColumn < currentRow - grid[0].length && currentColumn > grid.length / 2) {
				State scissors = new Scissors(threshold);
				grid[currentRow][currentColumn] = scissors;
			}
			else {
				State paper = new Paper(threshold);
				grid[currentRow][currentColumn] = paper;
			}
		}
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
	
	//Method to help test
	public void makeRock(int currentRow, int currentColumn) {
		Rock rock = new Rock(this.threshold);
		grid[currentRow][currentColumn] = rock;
	}
	
	public void makePaper(int currentRow, int currentColumn) {
		Paper paper = new Paper(this.threshold);
		grid[currentRow][currentColumn] = paper;
	}

}
