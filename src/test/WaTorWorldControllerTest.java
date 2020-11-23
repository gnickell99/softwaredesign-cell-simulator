package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.WaterWorld;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/*
 * @author Kim Jones
 * This class test the Water world methods, it makes sure rules are accurate
 * 
 * */

public class WaTorWorldControllerTest {
	
	//Controller
	static WaterWorld wwControl; //not yet added
	static GridPane gp = new GridPane();
	
	//Constants
	static final int TEST_GRID_SIZE = 2;
	static final int FIRST_ROW = 0;
	static final int LAST_ROW = 4;
	//Colors
	static final Color EDGE_COLOR = Color.BLACK;
	static final Color FISH_COLOR = Color.GREEN;
	static final Color SHARK_COLOR = Color.YELLOW;
	static final Color EMPTY_WATER = Color.BLUE;
	//Coordinates
	static int ROW1 = 1;
	static int ROW2 = 2;
	static int ROW3 = 3;
	static int COL1 = 1;
	static int COL2 = 2;
	static int COL3 = 3;

	@BeforeClass
	public static void test() {
		wwControl = new WaterWorld(TEST_GRID_SIZE, TEST_GRID_SIZE, 1,1,1,1,1); //Make object
		wwControl.generateGrid(gp); //Make a new Grid
	}
	
	//Helper methods to setup
	
	//Set up fish rules below:
	//Make 1st cell green and all neighbors blue (Fish with 3 options - movement test)
	public static void setUpRule1() {
		wwControl.plantFish(ROW1, COL1); //green
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeWater(ROW2, COL1); // blue
		wwControl.makeWater(ROW2, COL2); // blue
	}
	
	//Make 1st cell green and 2 neighbors edges (Fish with only 1 option - movement test)
	public static void setUpRule2() {
		wwControl.plantFish(ROW1, COL1); //green
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeEdge(ROW2, COL1); // black
		wwControl.makeEdge(ROW2, COL2); // black
	}
	
	//Make 1st cell green and 2 neighbors edges (Fish with only 1 breeding option - breeding test)
	public static void setUpRule3() {
		wwControl.plantFish(ROW1, COL1); //green
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeEdge(ROW2, COL1); // black
		wwControl.makeEdge(ROW2, COL2); // black
	}
	
	//Set up shark rules below:
	//Make 1st cell yellow and all neighbors blue (Shark with 3 options - movement test)
	public static void setUpRule4() {
		wwControl.plantShark(ROW1, COL1); //yellow
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeWater(ROW2, COL1); // blue
		wwControl.makeWater(ROW2, COL2); // blue
	}

	//Make 1st cell yellow and 2 neighbors edges (Shark with only 1 option - movement test)
	public static void setUpRule5() {
		wwControl.plantShark(ROW1, COL1); //yellow
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeEdge(ROW2, COL1); // black
		wwControl.makeEdge(ROW2, COL2); // black
	}

	//Make 1st cell yellow and 2 neighbors water, 1 neighbor fish (Shark with only 1 choice - eating test)
	public static void setUpRule6() {
		wwControl.plantShark(ROW1, COL1); //yellow
		wwControl.makeWater(ROW1, COL2); // blue
		wwControl.makeWater(ROW2, COL1); // blue
		wwControl.plantFish(ROW2, COL2); // green
	}
	
	//Make 1st cell yellow and 1 neighbor water, 2 neighbors fish (Shark with 2 options - eating test)
	public static void setUpRule7() {
		wwControl.plantShark(ROW1, COL1); //yellow
		wwControl.plantFish(ROW1, COL2); // green
		wwControl.makeWater(ROW2, COL1); // blue
		wwControl.plantFish(ROW2, COL2); // green
	}
	
	//Make 1st cell yellow and 1 neighbor water, 2 neighbors fish (Shark with 2 options - eating test)
	public static void setUpRule8() {
		wwControl.plantShark(ROW1, COL1); //yellow
		wwControl.plantFish(ROW1, COL2); // green
		wwControl.makeWater(ROW2, COL1); // blue
		wwControl.plantFish(ROW2, COL2); // green
	}
	
	
	//Test for fish below:
	
	//Movement test
	//Test Plan
	//Test 1: Current cell should turn blue and fish should move to either: (2,1),(2,2),(1,2) (Color will be green)
	//Fish at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void fishTest1() {
		setUpRule1();
		
		//run act method
		wwControl.grid[ROW1][COL1] = wwControl.grid[ROW1][COL1].act(wwControl.getNeighbors(ROW1, COL1));	
		
//		System.out.println(wwControl.grid[ROW1][COL1].cellColor); //should be blue
//		System.out.println(wwControl.grid[ROW1][COL2].cellColor); //could be a fish
//		System.out.println(wwControl.grid[ROW2][COL1].cellColor); //could be a fish
//		System.out.println(wwControl.grid[ROW2][COL2].cellColor); //should be water
		
		//Check rule
		//Make sure start is now water
		assertTrue(wwControl.grid[ROW1][COL1].cellColor.equals(EMPTY_WATER));
		//Make sure one of neighbors is a fish
		assertTrue(wwControl.grid[ROW1][COL2].cellColor.equals(FISH_COLOR) || wwControl.grid[ROW2][COL1].cellColor.equals(FISH_COLOR));

	}
	
	//Test 2: Current cell should turn blue and fish should move to: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest2() {
		setUpRule2();
		
		//run act method
		wwControl.grid[ROW1][COL1] = wwControl.grid[ROW1][COL1].act(wwControl.getNeighbors(ROW1, COL1));	
		
//		System.out.println(wwControl.grid[ROW1][COL1].cellColor); //should be blue
//		System.out.println(wwControl.grid[ROW1][COL2].cellColor); //should be a fish
//		System.out.println(wwControl.grid[ROW2][COL1].cellColor); //should be water
//		System.out.println(wwControl.grid[ROW2][COL2].cellColor); //should be water
		
		//Check rule
		assertTrue(wwControl.grid[ROW1][COL1].cellColor.equals(EMPTY_WATER));
		assertTrue(wwControl.grid[ROW1][COL2].cellColor.equals(FISH_COLOR));
		assertTrue(wwControl.grid[ROW2][COL1].cellColor.equals(EDGE_COLOR));
		assertTrue(wwControl.grid[ROW2][COL2].cellColor.equals(EDGE_COLOR));
		
	}
	
	//Breeding test
	//Test 3: Current cell stay green and fish should give birth at either: (1,2), (2,1), (2,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void fishTest3() {
		setUpRule2();
		
		//run act method - fish shouldn't breed - should move (1,2)
		wwControl.grid[ROW1][COL1] = wwControl.grid[ROW1][COL1].act(wwControl.getNeighbors(ROW1, COL1));	
		//fish should breed - new fish at (1,1)
		wwControl.grid[ROW1][COL1] = wwControl.grid[ROW1][COL1].act(wwControl.getNeighbors(ROW1, COL1));
		
//		System.out.println(wwControl.grid[ROW1][COL1].cellColor); //should be a fish
//		System.out.println(wwControl.grid[ROW1][COL2].cellColor); //should be a fish
//		System.out.println(wwControl.grid[ROW2][COL1].cellColor); //should be edge
//		System.out.println(wwControl.grid[ROW2][COL2].cellColor); //should be edge
		
		//Make sure start is fish
		assertTrue(wwControl.grid[ROW1][COL1].cellColor.equals(FISH_COLOR));
		//Make sure other space is fish
		wwControl.grid[ROW1][COL2].cellColor.equals(FISH_COLOR);
	}
	
	//Test 4: Current cell stay green and fish should give birth at: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest4() {
		setUpRule2();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("fish cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("fish cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("edge cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("edge cell"));
	}
	
	//Test for sharks below:
	
	//Movement test
	//Test 1: Current cell should turn blue and shark should move to either: (2,1),(2,2),(1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void sharkTest1() {
		setUpRule4();
		
		//run act method
		wwControl.grid[ROW1][COL1] = wwControl.grid[ROW1][COL1].act(wwControl.getNeighbors(ROW1, COL1));		
				
		//Check rule
		//Make sure start is now water
		assertTrue(wwControl.grid[ROW1][COL1].cellColor.equals(EMPTY_WATER));
		//Make sure one of neighbors is a shark
		assertTrue(wwControl.grid[ROW1][COL2].cellColor.equals(SHARK_COLOR) || wwControl.grid[ROW2][COL1].cellColor.equals(SHARK_COLOR));	}
	
	//Test 2: Current cell should turn blue and shark should move to: (1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void sharkTest2() {
		setUpRule4();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("water cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("shark cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("edge cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("edge cell"));
	}
	
	//Eating test
	//Test 3: Current cell should stay yellow and fish should turn blue 
	//shark at point (1,1) Water at point (1,2),(2,2) fish at point (2,2)
	@Test
	public void sharkTest3() {
		setUpRule5();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("shark cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("water cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("water cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("water cell"));
	}
	
	//Test 4: Current cell should stay yellow and one fish should turn blue 
	//shark at point (1,1) Water at point (1,2) fish at point (2,2),(2,2)
	@Test
	public void sharkTest4() {
		setUpRule6();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("shark cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("water cell") || golControl.grid[2][2].getType().equals("water cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("water cell"));
	}
	
	//Breeding test
	//Test 4: Current cell should stay yellow and should give birth at either: (2,1),(2,2),(1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void sharkTest5() {
		setUpRule3();
		setUpRule5();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("shark cell"));
		
		//Make sure one of neighbors is a shark
//		assertTrue(wwControl.grid[1][2].getType().equals("shark cell") || wwControl.grid[2][1].getType().equals("shark cell") || wwControl.grid[2][2].getType().equals("shark cell"));

	}
	
	//Test 5: Current cell should stay yellow and should give birth at: (1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2) edges at point (2,1), (2,2)
	@Test
	public void sharkTest6() {
		setUpRule4();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("shark cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("shark cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("edge cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("edge cell"));
	}
	
	//Death test
	//Test 4: Current cell should die (Color will be blue)
	//shark at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void sharkTest7() {
		setUpRule3();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("water cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("water cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("water cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("water cell"));
	}
	
}
