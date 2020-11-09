package main;


import java.awt.Point;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

/***
 * 
 * @author Kim Jones and Jazz Harris
 * Grid - superclass that will hold basic info for what a grid is
 * Based on MazeLabMVC Lab code
 *
 */
public class Grid {

	//Constants
	public static final int EMPTY_GRID = 0;	// If cell is empty its 0
	public  final int BLOCK_SIZE = 15; 
	Group mainGridDrawing = new Group();
	protected Rectangle[][] mainGrid;
	protected Rectangle[][] mirrorGrid;


	public Grid(double userNumRows, double userNumCols){
		assert(userNumRows > EMPTY_GRID && userNumCols > EMPTY_GRID);
	}

	/*
	 * Setup the basic of the grid for drawing. In particular,
	 * make the mirrorGrid.
	 */
	public Group setupGrid(double userNumRows, double userNumCols){
		
		mainGrid = new Rectangle[(int) userNumRows][(int) userNumCols];
		mirrorGrid = new Rectangle[(int) userNumRows][(int) userNumCols];
		
		for(int i = 0; i< userNumRows; i++){
			for(int j = 0; j < userNumCols; j++){
				Rectangle mainGrid = new Rectangle(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);

				mirrorGrid[i][j] = mainGrid;
				mainGridDrawing.getChildren().add(mainGrid);
			}	
		}
		return mainGridDrawing;
	}

	// returns length of rows within grid. Uses inner grid's dimensions
	public int getNumRows(){
		assert(mirrorGrid!=null);
		return mirrorGrid.length;
	}

	// returns of length of columns within grid. Uses inner grid's dimensions
	public int getNumCols(){
		assert(mirrorGrid!=null);
		return mirrorGrid[EMPTY_GRID].length;
	}


	/*
	 * Check to see if the square is inside the outer walls of the maze. Uses the inner grid's dimensions
	 */
	public boolean inMainGridBounds(Point p){
		return (p!=null && p.x < mirrorGrid.length && p.x >= EMPTY_GRID && p.y < mirrorGrid[EMPTY_GRID].length && p.y >= EMPTY_GRID);
	}


	/*
	 * get - returns a cell state at the given position.
	 */
	public Rectangle getCellState(Point square){
		assert(validPointInMainGrid(square));
		return mirrorGrid[square.x][square.y];
	}
	
	/*
	 * Check to see if the point is in bounds (won't cause out-of-bounds or null errors). Uses The background grid's dimensions
	 */
	public boolean validPointInMainGrid(Point p){
		return false;
//		return (p!=null && p.x < BackgroundGrid.mirrorBKGrid.length && p.x >= 0 && p.y < BackgroundGrid.mirrorBKGrid[0].length && p.y >= 0);
	}

}

