package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.Wildfire;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/*
 * @author Kim Jones 
 * This class test the Wildfire methods, it makes sure everything gets set up properly and rules are accurate
 * 
 * */

public class WildfireControllerTest {

	//Controller
	static Wildfire wildfireControl;
	static GridPane gp = new GridPane();
	
	//Constants
	//Colors
	static final Color EDGE_COLOR = Color.BLACK;
	static final Color BURNING_TREE_COLOR = Color.RED;
	static final Color BURNT_TREE_COLOR = Color.YELLOW;
	static final Color EMPTY_COLOR = Color.SADDLEBROWN;
	static final Color LIVE_COLOR = Color.GREEN;
	//Grid max and min
	static final int MIN = 0;
	static final int MAX = 4;
	//Coordinates
	static int ROW1 = 1;
	static int COL1 = 1;
	static int ROW2 = 2;
	static int ROW3 = 3;
	static int COL2 = 2;
	static int COL3 = 3;

	@BeforeClass
	public static void getController() {
		wildfireControl = new Wildfire(3,3, 1, 1, 1, 1); //set everything to 1 for start
		wildfireControl.generateGrid(gp);
	}
	
	//Makes every tree a live tree
	public static void makeAllLiveTrees() {
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			for(int j = 0; j < wildfireControl.grid.length; j++) {
				if(!wildfireControl.grid[i][j].cellColor.equals(EDGE_COLOR)) {
					wildfireControl.setLiveTree(i, j);
				}
			}
		}
	}
	
	//Set up rule1 test
	//Make 1 cell burning and the rest live
	public static void setUpRule1() {
		makeAllLiveTrees();//Makes all trees live
		wildfireControl.setBurningTree(ROW2, COL1);//Make cell (2,1) burning
	}

	//Prints out current status of the grid
	public static void printGrid() {
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			for(int j = 0; j < wildfireControl.grid.length; j++) {
				System.out.println(wildfireControl.grid[i][j].cellColor.toString());
			}
		}
	}
	

	//Test to make sure the grid is set up properly - good
	@Test
	public void edgeTest() {

		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals(EDGE_COLOR, wildfireControl.grid[MIN][i].cellColor);
		}
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals(EDGE_COLOR, wildfireControl.grid[MAX][i].cellColor);
		}
	}

	//Test 1: make sure the fire is spreading correctly - good
	//Points (1,1), (2,2), (3,1) should turn red. (2,1) should stay red
	@Test
	public void testFireSpread() {
		//Setting up grid correctly
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[ROW1][COL1] = wildfireControl.grid[ROW1][COL1].act(wildfireControl.getNeighbors(ROW1, COL1)); //turns red
		wildfireControl.grid[ROW2][COL2] = wildfireControl.grid[ROW2][COL2].act(wildfireControl.getNeighbors(ROW2,ROW2)); //turns red
		wildfireControl.grid[ROW3][COL1] = wildfireControl.grid[ROW3][COL1].act(wildfireControl.getNeighbors(ROW2, ROW1)); //turns red
		
		//printGrid();
		assertTrue(wildfireControl.grid[ROW2][COL1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW1][ROW1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW2][COL2].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW3][ROW1].cellColor.equals(BURNING_TREE_COLOR));
	}
	
	//Test 2: make sure the burn time is adding up correctly - good
	@Test
	public void burnTimeTest() {
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[ROW1][COL1] = wildfireControl.grid[ROW1][COL1].act(wildfireControl.getNeighbors(ROW1, COL1)); //turns red
		wildfireControl.grid[ROW2][COL2] = wildfireControl.grid[ROW2][COL1].act(wildfireControl.getNeighbors(ROW2,COL2)); //turns red
		wildfireControl.grid[ROW3][COL1] = wildfireControl.grid[ROW3][COL1].act(wildfireControl.getNeighbors(ROW2, COL1)); //turns red
		
//		printGrid();
		System.out.println();
		
		wildfireControl.grid[ROW2][COL1] = wildfireControl.grid[ROW2][COL1].act(wildfireControl.getNeighbors(ROW2, COL1)); //stays red - time not at 0
		assertTrue(wildfireControl.grid[ROW2][COL1].cellColor.equals(BURNING_TREE_COLOR));
		wildfireControl.grid[ROW2][COL1] = wildfireControl.grid[ROW2][COL1].act(wildfireControl.getNeighbors(ROW2, COL1)); //turns yellow
		
		assertTrue(wildfireControl.grid[ROW2][COL1].cellColor.equals(BURNT_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW1][COL1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW2][COL2].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[ROW3][COL1].cellColor.equals(BURNING_TREE_COLOR));
	}
	
}
