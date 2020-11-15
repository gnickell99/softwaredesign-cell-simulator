package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameOfLife;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import states.AliveCell;

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
	}
	
	//Make 1st cell blue and all neighbors white
	public static void setUpRule1() {
		golControl.infectCell(1, 1); //blue
		golControl.killCell(1, 2); // white
		golControl.killCell(2, 1); // white
		golControl.killCell(2, 2); // white
	}
	
	//Make 1st cell blue and 2 neighbors blue
	public static void setUpRule2() {
		golControl.infectCell(1, 1); //blue
		golControl.infectCell(1, 2); // blue
		golControl.killCell(2, 1); // white
		golControl.infectCell(2, 2); // blue
	}
	
	//Make 1st cell blue and 3 neighbors blue
	public static void setUpRule3() {
		golControl.infectCell(1, 1); //blue
		golControl.infectCell(1, 2); // blue
		golControl.infectCell(2, 1); // blue
		golControl.infectCell(2, 2); // blue
	}
	
	//Test of edge pieces:
	
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
	@Test
	public void noEdgeInside() {
		for(int i = 1; i < golControl.grid.length-1; i++) {
			for(int j = 1; j < golControl.grid.length-1; j++) {
				assertTrue(!golControl.grid[i][j].getType().equals("edge"));
			}
		}
	}
	
	//Test of the rules:
	
	//Rule 1: wip
	@Test
	public void rule1preTest() {
		setUpRule1(); //Set up cells
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 1 is set up correctly
		assertTrue(golControl.grid[1][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[1][2].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][1].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][2].getType().equals("dead cell"));
	}
	
	@Test
	public void rule1Test() {
		//Set up cells
		setUpRule1();
		
		//Call act method
		golControl.grid[1][1].act(1, 1);		
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 1 worked
		assertTrue(golControl.grid[1][1].getType().equals("dead cell")); //Fails- should be killed
		assertTrue(golControl.grid[1][2].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][1].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][2].getType().equals("dead cell"));
	}
	
	//Rule 2: good
	@Test
	public void rule2preTest() {
		setUpRule2(); //Set up cells
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 1 is set up correctly
		assertTrue(golControl.grid[1][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[1][2].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][1].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule2Test() {
		//Set up cells
		setUpRule2(); 
		
		//Call act method
		golControl.grid[1][1].act(1, 1);	
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 2 is set up correctly - should be same
		assertTrue(golControl.grid[1][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[1][2].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][1].getType().equals("dead cell"));
		assertTrue(golControl.grid[2][2].getType().equals("alive cell"));
	}
	
	//Rule 3: 
	@Test
	public void rule3preTest() {
		setUpRule3(); //Set up cells
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 1 is set up correctly
		assertTrue(golControl.grid[1][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[1][2].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule3Test() {
		//Set up cells
		setUpRule3(); 
		
		//Call act method
		golControl.grid[1][1].act(1, 1);	
		
//		System.out.println(golControl.grid[1][1].getType());
//		System.out.println(golControl.grid[1][2].getType());
//		System.out.println(golControl.grid[2][1].getType());
//		System.out.println(golControl.grid[2][2].getType());
		
		//Check rule 2 is set up correctly - should be same
		assertTrue(golControl.grid[1][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[1][2].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][1].getType().equals("alive cell"));
		assertTrue(golControl.grid[2][2].getType().equals("alive cell"));
	}
	
	
}
