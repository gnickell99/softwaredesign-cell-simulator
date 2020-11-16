package controller;

import java.util.List;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import states.*;

public abstract class Controller {
	public State[][] grid;
	public State[][] mirrorGrid;
	public GridPane originalGridPane;
	
	private static final int VALUE_OF_ZERO = 0;
	private static final int VALUE_OF_ONE = 1;
	private static final int  VALUE_OF_TWO = 2;
	private static final int GRID_DISPLACEMENT = 10;
	
	public final int NORTH_NEIGHBOR = 0;
	public final int SOUTH_NEIGHBOR = 1;
	public final int WEST_NEIGHBOR = 2;
	public final int EAST_NEIGHBOR = 3;
	public final int NORTH_WEST_NEIGHBOR = 4;
	public final int NORTH_EAST_NEIGHBOR = 5;
	public final int SOUTH_WEST_NEIGHBOR = 6;
	public final int SOUTH_EAST_NEIGHBOR = 7;

	public Controller(int height, int width) {	
		grid = new State[height + VALUE_OF_TWO][width + VALUE_OF_TWO];
		mirrorGrid = new State[height + VALUE_OF_TWO][width + VALUE_OF_TWO];
		originalGridPane = new GridPane();
		generateGrid(originalGridPane);
	}

	/** updateGrid
	 * 
	 * The update grid method updates the grid by redrawing the states in the grid double array
	 * @param grid
	 */
	public void updateGrid(GridPane gridPane) {
		for(int i = 0; i < grid.length; i++)	{
			for(int j = 0; j < grid[i].length; j++) {
				mirrorGrid[i][j] = grid[i][j];
				mirrorGrid[i][j] = grid[i][j].act(i, j);
			}
		}
		for(int i = 0; i < grid.length; i++)	{
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = mirrorGrid[i][j];
				Rectangle cell = (Rectangle) grid[i][j].getRectangle();
				gridPane.add(cell, i+GRID_DISPLACEMENT, j+GRID_DISPLACEMENT);
			}
		}
	}

	/** generateGrid
	 * 
	 * the generate forest method begins the instantiation of the 2D forest array
	 */
	public void generateGrid(GridPane gridPane) {
		for (int i = 0; i < grid.length; i++) 	{
			for (int j = 0; j < grid[VALUE_OF_ONE].length; j++)	{
				placeEdgeOrCell(i,j);
				gridPane.add(grid[i][j].getRectangle(), i+GRID_DISPLACEMENT, j+GRID_DISPLACEMENT);
			}
		}
	}

	/** placeEdgeOrCell
	 * 
	 * The placeEdgeOrCell method checks if the current index is the border of the
	 * forest, in which case it places an edge, otherwise a tree is setup via the
	 * setupTrees method
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	protected void placeEdgeOrCell(int currentRow, int currentColumn) {
		if ((currentRow == VALUE_OF_ZERO || currentRow == grid.length - VALUE_OF_ONE )
				|| (currentColumn == VALUE_OF_ZERO || currentColumn == grid[VALUE_OF_ONE].length - VALUE_OF_ONE )) {
			State edge = new Edge();
			grid[currentRow][currentColumn] = edge;
		}
		else {
			setupCells(currentRow, currentColumn);
		}
	}

	/** setUpCells
	 * 
	 * The set up cell method sets up the cells in the inner grid that are manipulated by the user and either of the simulations rules
	 * 
	 */
	protected abstract void setupCells(int currentRow, int currentColumn);

	/** toListNeighbors
	 * This method creates an array list of neighbors for a mutable state
	 * 
	 * @param currentStateRow - the current row for the particular state, used to find neighbors
	 * @param currentStateColumn - the current column for the particular state, used to find neighbors
	 * @return - returns a list of neighbors which are defined in inherited methods
	 */
	public abstract List<State> getNeighbors(int currentStateRow, int currentStateColumn);

}
