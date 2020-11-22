package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.Wildfire;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class WildfireControllerTest {

	static Wildfire wildfireControl;
	static GridPane gp = new GridPane();
	static final Color EDGE_COLOR = Color.BLACK;
	static final Color BURNING_TREE_COLOR = Color.RED;
	static final Color BURNT_TREE_COLOR = Color.YELLOW;
	static final Color EMPTY_COLOR = Color.SADDLEBROWN;
	static final Color LIVE_COLOR = Color.GREEN;
	
	//types are:
	//edge
	//burning tree
	//live tree

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
		wildfireControl.setBurningTree(2, 1);//Make cell (2,1) burning
	}

	//Prints out current status of the grid
	public static void printGrid() {
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			for(int j = 0; j < wildfireControl.grid.length; j++) {
				System.out.println(wildfireControl.grid[i][j].cellColor.toString());
			}
		}
	}
	
	//Set up rule 1 test

	//Test to make sure the grid is set up properly - good
	@Test
	public void edgeTest() {

		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals(EDGE_COLOR, wildfireControl.grid[0][i].cellColor);
		}
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals(EDGE_COLOR, wildfireControl.grid[4][i].cellColor);
		}
	}

	//Test 1: make sure the fire is spreading correctly
	//Points (1,1), (2,2), (3,1) should turn red. (2,1) should stay red
	@Test
	public void testFireSpread() {
		//Setting up grid correctly
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[1][1] = wildfireControl.grid[1][1].act(wildfireControl.getNeighbors(1, 1)); //turns red
		wildfireControl.grid[2][2] = wildfireControl.grid[2][2].act(wildfireControl.getNeighbors(2,2)); //turns red
		wildfireControl.grid[3][1] = wildfireControl.grid[3][1].act(wildfireControl.getNeighbors(2, 1)); //turns red
		
		//printGrid();
		assertTrue(wildfireControl.grid[2][1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[1][1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[2][2].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[3][1].cellColor.equals(BURNING_TREE_COLOR));
	}
	
	@Test
	public void burnTimeTest() {
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[1][1] = wildfireControl.grid[1][1].act(wildfireControl.getNeighbors(1, 1)); //turns red
		wildfireControl.grid[2][2] = wildfireControl.grid[2][1].act(wildfireControl.getNeighbors(2,2)); //turns red
		wildfireControl.grid[3][1] = wildfireControl.grid[3][1].act(wildfireControl.getNeighbors(2, 1)); //turns red
		
//		printGrid();
		System.out.println();
		
		
		wildfireControl.grid[2][1] = wildfireControl.grid[2][1].act(wildfireControl.getNeighbors(2, 1)); //turns yellow
		assertTrue(wildfireControl.grid[2][1].cellColor.equals(BURNT_TREE_COLOR));
		assertTrue(wildfireControl.grid[1][1].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[2][2].cellColor.equals(BURNING_TREE_COLOR));
		assertTrue(wildfireControl.grid[3][1].cellColor.equals(BURNING_TREE_COLOR));
	}
	
}