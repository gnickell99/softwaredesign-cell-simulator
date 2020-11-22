package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameOfLife;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import states.AliveCell;
import states.State;

/*
 * @author Kim Jones
 * This class test the Game of Life methods, it makes sure everything gets set up properly and rules are accurate
 * 
 * */

public class GameOfLifeControllerTest {
	static GameOfLife golControl;
	
	//Constants
	static int testGridSize = 4;
	static int firstRow = 0;
	static int lastRow = 5;
	static int ROW1 = 1;
	static int COL1 = 1;
	static int ROW2 = 2;
	static int COL2 = 2;
	static int COL3 = 3;
	
	
	static GridPane gp = new GridPane();
	
	@BeforeClass
	public static void getController() {
		golControl = new GameOfLife(testGridSize,testGridSize); //Make object
		golControl.generateGrid(gp); //Make a new Grid
	}
	
	//Makes blue cells
	public static void makePattern1() {
		golControl.infectCell(ROW1, COL1); //blue
		golControl.infectCell(ROW1, COL2); // blue
		golControl.infectCell(ROW2, COL1); // blue
		golControl.infectCell(ROW2, COL2); // blue
	}
	
	//Makes 1st cell white and 2nd blue
	public static void  makePattern2() {
		golControl.killCell(ROW1, COL1); //white
		golControl.infectCell(ROW1, COL2); // blue
	}
	
	//Makes last 2 cells blue
	public static void makePattern3() {
		golControl.infectCell(ROW2, COL1); // blue
		golControl.infectCell(ROW2, COL2); // blue
	}
	
	//Methods for first round of testing
	//Make 1st cell blue and all neighbors white
	public static void setUpRule1() {
		golControl.infectCell(ROW1, COL1); //blue
		golControl.killCell(ROW1, COL2); // white
		golControl.killCell(ROW2, COL1); // white
		golControl.killCell(ROW2, COL2); // white
	}
	
	//Make 1st cell blue and 2 neighbors blue
	public static void setUpRule2() {
		golControl.infectCell(ROW1, COL1); //blue
		golControl.infectCell(ROW1, COL2); // blue
		golControl.killCell(ROW2, COL1); // white
		golControl.infectCell(ROW2, COL2); // blue
	}
	
	//Make 1st cell blue and 3 neighbors blue
	public static void setUpRule3() {
		makePattern1();
	}
	
	//Make 2nd cell blue and 4 neighbors blue
	public static void setUpRule4() {
		makePattern1();
		golControl.infectCell(ROW1, COL3); //blue
	}
	
	//Methods for second round of testing
	//Make 1st cell white and 1 neighbor blue, rest white
	public static void setUpRule1b() {
		makePattern2();
		golControl.killCell(ROW2, COL1); // white
		golControl.killCell(ROW2, COL2); // white
	}
	
	//Make 1st cell white and 2 neighbors blue, last one white
	public static void setUpRule2b() {
		makePattern2();
		golControl.infectCell(ROW2, COL1); // blue
		golControl.killCell(ROW2, COL2); // white
	}
	
	//Make 1st cell white and 3 neighbors blue
	public static void setUpRule3b() {
		makePattern2();
		makePattern3();
	}
	
	//Make 2nd cell white and 3 neighbors blue
	public static void setUpRule4b() {
		golControl.infectCell(ROW1, COL1); //blue
		golControl.killCell(ROW1, COL2); // white
		golControl.infectCell(ROW1, COL3); //blue
		makePattern3();
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
	
	//Test of the rules for blue cells:
	//These test look at how the rules affect blue cells:
	
	//Rule 1: good
	@Test
	public void rule1preTest() {
		setUpRule1(); //Set up cells
		
		//Check rule 1 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	@Test
	public void rule1Test() {
		//Set up cells
		setUpRule1();
		
		//Call act method and save the update
		//Note - after merge with refactoring change (1,1) to .act(golControl.grid)
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);	
		
		//Check rule 1 worked
		//Note - getType() -> cellColor.equals()
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	//Rule 2: good
	@Test
	public void rule2preTest() {
		setUpRule2(); //Set up cells
		
		//Check rule 2 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule2Test() {
		//Set up cells
		setUpRule2(); 
		
		//Call act method
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);	
		
		//Check rule 2 is set up correctly - should be same
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	//Rule 3: good
	@Test
	public void rule3preTest() {
		setUpRule3(); //Set up cells
		
		//Check rule 3 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule3Test() {
		//Set up cells
		setUpRule3(); 
		
		//Call act method
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);	
		
		//Check rule 3 is correct
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	//Rule 4: good
	@Test
	public void rule4preTest() {
		setUpRule4(); //Set up cells
		
		//Check rule 4 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL3].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
		
	@Test
	public void rule4Test() {
		//Set up cells
		setUpRule4(); 
		
		//Call act method
		golControl.grid[ROW1][COL2] = golControl.grid[ROW1][COL2].act(ROW1, COL2);	
		
		//Check rule 4 is correct
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("dead cell")); //Fails- should be killed
		assertTrue(golControl.grid[ROW1][COL3].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	//Test of rules for white cells:
	//These test look at how the rules affect white cells:
	
	//Rule 1: good
	@Test
	public void rule1bpreTest() {
		setUpRule1b(); //Set up cells
		
		//Check rule 1 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	@Test
	public void rule1bTest() {
		//Set up cells
		setUpRule1b();
		
		//Call act method and save the update
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);		
		
		//Check rule 1 worked
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	//Rule 2: good
	@Test
	public void rule2bpreTest() {
		setUpRule2b(); //Set up cells
		
		//Check rule 2 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	@Test
	public void rule2bTest() {
		//Set up cells
		setUpRule2b();
		
		//Call act method and save the update
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);		
		
		//Check rule 2 worked
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("dead cell"));
	}
	
	//Rule 3: good
	@Test
	public void rule3bpreTest() {
		setUpRule3b(); //Set up cells
		
		//Check rule 3 is set up correctly
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule3bTest() {
		//Set up cells
		setUpRule3b();
		
		//Call act method and save the update
		golControl.grid[ROW1][COL1] = golControl.grid[ROW1][COL1].act(ROW1, COL1);		
		
		//Check rule 3 worked
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	//Rule 4: good
	@Test
	public void rule4bpreTest() {
		setUpRule4b(); //Set up cells
		
		//Check rule 4 is set up correctly
//		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL1].cellColor.equals(Color.LIGHTBLUE));
//		assertTrue(golControl.grid[ROW1][COL2].getType().equals("dead cell"));
//		assertTrue(golControl.grid[ROW1][COL3].getType().equals("alive cell"));
//		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
//		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
	@Test
	public void rule4bTest() {
		//Set up cells
		setUpRule4b();
		
		//Call act method and save the update
		golControl.grid[ROW1][COL2] = golControl.grid[ROW1][COL2].act(ROW1, COL2);		
		
		//Check rule 4 worked
		assertTrue(golControl.grid[ROW1][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW1][COL2].getType().equals("dead cell"));
		assertTrue(golControl.grid[ROW1][COL3].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL1].getType().equals("alive cell"));
		assertTrue(golControl.grid[ROW2][COL2].getType().equals("alive cell"));
	}
	
}
