package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameOfLife;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/*
 * @author Kim Jones
 * This class test the Game of Life methods, it makes sure everything gets set up properly
 * 
 * */

public class GameOfLifeControllerTest {
	static GameOfLife golControl;
	static int testGridSize = 4;
	static int firstRow = 0;
	static int lastRow = 5;
	
	static GridPane gp = new GridPane();
	
	@BeforeClass
	public static void getController() {
		golControl = new GameOfLife(testGridSize,testGridSize); //Make object
		golControl.generateGrid(gp); //Make a new Grid
		
		//Manually make a testing scenario
		System.out.println("Color: " + golControl.grid[1][1].cellColor + " type: " + golControl.grid[1][1].getType());
		golControl.grid[1][1].cellColor = Color.WHITE;
		//golControl.grid[1][1].getType();
		System.out.println("Color: " + golControl.grid[1][1].cellColor + " type: " + golControl.grid[1][1].getType());
		
		//Print out all cells for confirmation
//		System.out.println(golControl.grid[1][1].getType());
//		for(int i = 0; i < golControl.grid.length; i++) {
//			for(int j = 0; j < golControl.grid.length; j++) {
//				System.out.println(i +"," + j + ": " + golControl.grid[i][j].getType());
//			}
//		}
		
		//Test prints:
//		System.out.println(golControl.grid[0][1].getType());
//		System.out.println(golControl.grid[0][0].getType());
//		for(int i = 0; i < golControl.grid.length; i++) {
//			System.out.println(golControl.grid[i][lastRow].getType());
//		}
		
		
	}

	//Make sure the top row is all edge cells
	@Test
	public void topEdgeTest() {
		String expected = "edge";
		
		//Loop through all cells in first row and make sure they are type edge
		for(int i = 0; i < golControl.grid.length; i++) {
			assertEquals(expected, golControl.grid[firstRow][i].getType());
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
	
	//Make sure the left column is all edge cells
	@Test
	public void leftEdgeTest() {
		String expected = "edge";
		
		//Loop through all cells in last row and make sure they are type edge
		for(int i = 0; i < golControl.grid.length; i++) {
			assertEquals(expected, golControl.grid[i][firstRow].getType());
		}
	}
	
	//Make sure the right column is all edge cells
	@Test
	public void rightEdgeTest() {
		String expected = "edge";
		
		//Loop through all cells in last row and make sure they are type edge
		for(int i = 0; i < golControl.grid.length; i++) {
			assertEquals(expected, golControl.grid[i][lastRow].getType());
		}
	}
	
	//Make sure there are not edge pieces inside the grid
	

}
