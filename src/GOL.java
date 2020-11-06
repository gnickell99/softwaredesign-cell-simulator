
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.scene.paint.Paint;
 
/***
 * 
 * @author Kim Jones and Jazz Harris
 * GOL - class that will hold the rules for the Game of Life simulation and how it will work
 * Based on MazeLabMVC Lab code
 *
 */
public class GOL {
	// Grid rule1Grid = new Grid(10,10);	
		// Group grid = rule1Grid.setupGrid(10,10);

		Grid grid = new Grid(1, 1);		


		//The grid for displaying


		public Point currentCellPoint; 				//Current point being examined



		//Constants for rules
		public static final int RULE_1 = 1;
		public static final int RULE_2 = 2;
		public static final int RULE_3 = 3;
		public static final int RULE_4 = 4;

		public static final int INDEX_RULE_4 = 3;

		public static final int INDEX_WHITE = 0;
		public static final int INDEX_LIGHTBLUE = 1;
		public static final int INDEX_RULE_2 = 1;
		public static final int INDEX_RULE_3 = 2;

		String [] cellColorOptions = {"white","lightblue"};
		int currentCellColor;
		int newColorIndex ;

		// mappings:
		// rule 1: A location that has zero or one neighbors will be empty in the next generation. If a bacteria was in that location, it dies of loneliness. 
		//  rule 2: A location with two neighbors is stableâ€”that is, if it contained a bacteria, it still contains a bacteria. If it was empty, it's still empty. 
		// rule 3: A location with three neighbors will contain a bacteria in the next generation. If it was unoccupied before, a new bacteria is born.
		// If it currently contains a bacteria, it remains. 
		// rule 4: A location with four or more neighbors will be empty in the next generation. If there was a bacteria in that location, it dies of overcrowding. 

		int[][] gridColorChangesOffRules = {

				{INDEX_WHITE, INDEX_WHITE},

				{INDEX_LIGHTBLUE, INDEX_LIGHTBLUE},
				
				{INDEX_WHITE, INDEX_LIGHTBLUE},

				{INDEX_LIGHTBLUE, INDEX_WHITE}

		};


		//Constructor - sets up grid and start based on input
		public GOL(Grid gridBlocks) {
			this.grid = gridBlocks;

		}

		/*
		 * This method defines which "neighbors" or next points can be reached in the grid from
		 * the current point.  
		 * 
		 * In this method, the neighbors are defined as the eight surrounding cells squares immediately 
		 * of the current point, but only if they are in the bounds of the maze.  It does 
		 * NOT check to see if the point is a wall.
		 * Any other definition of "neighbor" indicates the search subclass should override this method.
		 */
		public Collection<Point> getCurrentCellsNeighbors(){

			List<Point> maybeNeighbors = new ArrayList<>();
			maybeNeighbors.add(new Point(currentCellPoint.x-1,currentCellPoint.y)); //Cell to left of current point
			maybeNeighbors.add(new Point(currentCellPoint.x-1,currentCellPoint.y+1));//Cell to top left of current point
			maybeNeighbors.add(new Point(currentCellPoint.x,currentCellPoint.y+1));//Cell on top of current point
			maybeNeighbors.add(new Point(currentCellPoint.x+1,currentCellPoint.y+1));//Cell to the top right of current point
			maybeNeighbors.add(new Point(currentCellPoint.x+1,currentCellPoint.y));//Cell to the right of current point
			maybeNeighbors.add(new Point(currentCellPoint.x-1,currentCellPoint.y-1));//Cell to bottom left of current point
			maybeNeighbors.add(new Point(currentCellPoint.x,currentCellPoint.y-1));//Cell underneath current point
			maybeNeighbors.add(new Point(currentCellPoint.x+1,currentCellPoint.y-1));//Cell to bottom right of current point


			return maybeNeighbors;

		}

		/*
		 *  This methods loops through to see if the neighbors are alive or dead if in bounds and adds them to a new list of all the infected cells
		 */
		public Collection<Point> getCurrentCellsStates(Collection<Point> maybeNeighbors){
			List<Point> knownNeighbors = new ArrayList<>();
			for(Point p: maybeNeighbors){//Only neighbors are the blue or infected cells
				if(grid.inMainGridBounds(p) && grid.getCellState(p).getFill().equals(Paint.valueOf("lightblue"))){
					knownNeighbors.add(p);
				}
			}
			return knownNeighbors;
		}

		/*
		 * This method grabs the cells state and adds the correct index color accordingly
		 */	
		public int gridColorIndexOptions(){
			
			
			if(isCellColorWhite(currentCellPoint)) {
				currentCellColor = INDEX_WHITE;}

			return currentCellColor;

		}

		
		/*
		 * This method defines the rule that gets chosen based on neighbors size.
		 * 
		 */
		
		public Point chooseRuleForCells(Collection<Point> neighbors){
			
			//HashMap<Boolean, Integer> gridColorToRules = new HashMap<Boolean, Integer>();
			
			//gridColorToRules.put(neighbors.size() <= 1 , newColorIndex = gridColorChangesOffRules[0][currentCellColor]);
			//gridColorToRules.put(neighbors.size() == 3,newColorIndex = gridColorChangesOffRules[gridColorChangesOffRules.length-1][currentCellColor]);
			//gridColorToRules.put(neighbors.size() > 0 , newColorIndex =  gridColorChangesOffRules[neighbors.size()-8][currentCellColor]);
			
			
			if(neighbors.size() <= 1 ) {
				newColorIndex = gridColorChangesOffRules[0][currentCellColor];
			}else if (neighbors.size() > 3){
				newColorIndex = gridColorChangesOffRules[gridColorChangesOffRules.length-1][currentCellColor];
			}else {
				newColorIndex = gridColorChangesOffRules[neighbors.size()-1][currentCellColor];
			}
			
			String newColor = cellColorOptions[newColorIndex];
			grid.getCellState(currentCellPoint).setFill(Paint.valueOf(newColor));


			return currentCellPoint;

		}

		
		//Tells if point is white (healthy cell)
		public boolean isCellColorWhite(Point currentCell) {
			return grid.getCellState(currentCell).getFill().equals(Paint.valueOf("white"));
		}

		//Turns a cell blue (Infects the cell)
		public void infectCurrentCellColorToBlue(Point currentCell) {
			grid.getCellState(currentCell).setFill(Paint.valueOf("lightblue"));
		}

		//Turns a cell white (Cures the cell)
		public void cureCurrentCellColorToWhite(Point currentCell) {
			grid.getCellState(currentCell).setFill(Paint.valueOf("white"));
		}

		/***
		 * 
		 * Step method - does one step in the simulation. Finds each point's neighbors and 
		 * determines which rule applies to it.
		 * @param  
		 * 
		 * ***/
		public void step() {

			for(int i = 0; i < grid.getNumRows(); i++) {
				for(int j = 0; j < grid.getNumCols(); j++) {
					currentCellPoint = new Point(i,j);//Update current point so each cell gets updated
					Collection<Point> maybeNeighbors = getCurrentCellsNeighbors();
					Collection<Point> infectedNeighbors = getCurrentCellsStates(maybeNeighbors);
					//System.out.println("Point " + current + "'s neighbors: " + neighbors);//Testing print statement
					chooseRuleForCells(infectedNeighbors);
				}
			}

		}
}

