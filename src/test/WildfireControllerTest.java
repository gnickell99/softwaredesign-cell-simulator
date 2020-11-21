package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.Wildfire;
import javafx.scene.layout.GridPane;

public class WildfireControllerTest {

	static Wildfire wildfireControl;
	static GridPane gp = new GridPane();
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
				if(!wildfireControl.grid[i][j].getType().equals("edge")) {
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
				System.out.println(wildfireControl.grid[i][j].getType());
			}
		}
	}
	
	//Set up rule 1 test

	//Test to make sure the grid is set up properly - good
	@Test
	public void edgeTest() {

		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals("edge", wildfireControl.grid[0][i].getType());
		}
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals("edge", wildfireControl.grid[4][i].getType());
		}
	}

	//Test 1: make sure the fire is spreading correctly
	//Points (1,1), (2,2), (3,1) should turn red. (2,1) should stay red
	@Test
	public void testFireSpread() {
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[1][1] = wildfireControl.grid[1][1].act(1, 1); //turns red
		wildfireControl.grid[2][2] = wildfireControl.grid[2][2].act(2,2); //turns red
		wildfireControl.grid[3][1] = wildfireControl.grid[3][1].act(2, 1); //turns red
		
		//printGrid();
		assertTrue(wildfireControl.grid[2][1].getType().equals("burning tree"));
		assertTrue(wildfireControl.grid[1][1].getType().equals("burning tree"));
		assertTrue(wildfireControl.grid[2][2].getType().equals("burning tree"));
		assertTrue(wildfireControl.grid[3][1].getType().equals("burning tree"));
	}
	
	@Test
	public void burnTimeTest() {
		setUpRule1();
		System.out.println();
		
		//Calls act on neighbor cells
		wildfireControl.grid[1][1] = wildfireControl.grid[1][1].act(1, 1); //turns red
		wildfireControl.grid[2][2] = wildfireControl.grid[2][1].act(2,2); //turns red
		wildfireControl.grid[3][1] = wildfireControl.grid[3][1].act(2, 1); //turns red
		
//		printGrid();
		System.out.println();
		
		
		wildfireControl.grid[2][1] = wildfireControl.grid[2][1].act(2, 1); //turns yellow
		assertTrue(wildfireControl.grid[2][1].getType().equals("burnt down tree"));
//		printGrid();
	}
	
}
