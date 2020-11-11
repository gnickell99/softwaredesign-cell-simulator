package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameOfLife;

/*
 * @author Kim Jones and Camryn Williams
 * 
 * */

public class GameOfLifeControllerTest {
	static GameOfLife golControl;
	static int testGridSize = 4;
	static int lastRow = 5;
	
	@BeforeClass
	public static void getController() {
		golControl = new GameOfLife(testGridSize,testGridSize); //Make object
		golControl.generateGrid(); //Make a new Grid
		
		//Manually make a testing scenario
		
		
		//Test prints:
//		System.out.println(golControl.grid[5][0].getType());
//		System.out.println(golControl.grid[0][0].getType());
//		for(int i = 0; i < golControl.grid.length; i++) {
//			System.out.println(golControl.grid[0][i].getType());
//		}
		
		
		
	}

	//Make sure the top row is all edge cells
	@Test
	public void topEdgeTest() {
		String expected = "edge";
		
		//Loop through all cells in first row and make sure they are type edge
		for(int i = 0; i < golControl.grid.length; i++) {
			assertEquals(expected, golControl.grid[0][i].getType());
		}
	}
	
	//Make sure the bottom row is all edge cells
	@Test
	public void bottomEdgeTest() {
		String expected = "edge";
		
		//Loop through all cells in last row and make sure they are type edge
		for(int i = 0; i < golControl.grid.length; i++) {
			assertEquals(expected, golControl.grid[lastRow][i].getType());
		}
	}
	
	

}
