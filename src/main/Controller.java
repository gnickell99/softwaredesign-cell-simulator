package main;

import java.util.Random;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import states.*;

public abstract class Controller {
	public State[][] board;
	public GridPane orig;
	public GridPane mirror;
	
	
	public Controller(int height, int width) {	
		board = new State[height + 2][width + 2];
		orig = new GridPane();
	}
	
  /**
   * Updates the board by redrawing the states in the board double array
   * @param grid
   */
  public void updateGrid(GridPane grid) {
	  for(int i = 0; i < board.length; i++)	{
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = board[i][j].act(i, j);
				Rectangle cell = (Rectangle) board[i][j].getRectangle();
				grid.add(cell, i, j);
			}
		}
	}
	
	/** generateGrid
	 * the generate forest method begins the instantiation of the 2D forest array
	 */
	public void generateGrid() {
		for (int i = 0; i < board.length; i++) 	{
			for (int j = 0; j < board[0].length; j++)	{
				placeEdgeOrCell(i,j);
			}
		}
	}
	
	/**
	 * placeEdgeOrCell
	 * 
	 * The placeEdgeOrTree method checks if the current index is the border of the
	 * forest, in which case it places an edge, otherwise a tree is setup via the
	 * setupTrees method
	 * 
	 * @param currentRow
	 * @param currentColumn
	 */
	protected void placeEdgeOrCell(int currentRow, int currentColumn) {
		if ((currentRow == 0 || currentRow == board.length - 1)
				|| (currentColumn == 0 || currentColumn == board[0].length - 1)) {
			State edge = new Edge();
			board[currentRow][currentColumn] = edge;
		} else {
			setupCells(currentRow, currentColumn);
		}
	}
	
	protected abstract void setupCells(int currentRow, int currentColumn);
	
}
	
