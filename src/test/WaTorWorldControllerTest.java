package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


import javafx.scene.layout.GridPane;

public class WaTorWorldControllerTest {
	
	//static WaterWorld wwControl; //not yet added

	static int testGridSize = 4;
	static int firstRow = 0;
	static int lastRow = 5;
	
	static GridPane gp = new GridPane();

	@BeforeClass
	public static void test() {
		//wwControl = new WaterWorld(testGridSize,testGridSize); //Make object
		//wwControl.generateGrid(gp); //Make a new Grid
	}
	
	//Helper methods to setup
	
	//Make 1st cell green and all neighbors blue
	public static void setUpRule1() {
//		wwControl.plantFish(1, 1); //green
//		wwControl.makeWater(1, 2); // blue
//		wwControl.makeWater(2, 1); // blue
//		wwControl.makeWater(2, 2); // blue
	}
	
	//Make 1st cell green and 2 neighbors edges
	public static void setUpRule2() {
//		wwControl.plantFish(1, 1); //green
//		wwControl.makeWater(1, 2); // blue
//		wwControl.makeWater(2, 1); // blue
//		wwControl.makeWater(2, 2); // blue
	}
	

	//Test for fish below:
	
	//Movement test
	//Test Plan
	//Test 1: Current cell should turn blue and fish should move to either: (2,1),(2,2),(1,2) (Color will be green)
	//Fish at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void fishTest1() {
		setUpRule1();
		
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		fail("Not yet implemented");
		//Check rule 1 worked
//		assertTrue(wwControl.grid[1][1].getType().equals("dead cell"));
//		assertTrue(wwControl.grid[1][2].getType().equals("dead cell"));
//		assertTrue(wwControl.grid[2][1].getType().equals("dead cell"));
//		assertTrue(wwControl.grid[2][2].getType().equals("dead cell"));
	}
	
	//Test 2: Current cell should turn blue and fish should move to: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest2() {
		fail("Not yet implemented");
	}
	
	//Breeding test
	//Test 2: Current cell stay green and fish should give birth at either: (1,2), (2,1), (2,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void fishTest3() {
		fail("Not yet implemented");
	}
	
	//Test 3: Current cell stay green and fish should give birth at either: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest4() {
		fail("Not yet implemented");
	}
	
	//Test for sharks below:
	
	//Movement test
	//Test 1: Current cell should turn blue and shark should move to either: (2,1),(2,2),(1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void sharkTest1() {
		fail("Not yet implemented");
	}
	
	//Test 2: Current cell should turn blue and shark should move to either: (1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void sharkTest2() {
		fail("Not yet implemented");
	}
	
	//Eating test
	//Test 3: Current cell should stay yellow and fish should turn blue 
	//shark at point (1,1) Water at point (1,2),(2,2) fish at point (2,2)
	@Test
	public void sharkTest3() {
		fail("Not yet implemented");
	}
	
	//Test 4: Current cell should stay yellow and one fish should turn blue 
	//shark at point (1,1) Water at point (1,2) fish at point (2,2),(2,2)
	@Test
	public void sharkTest4() {
		fail("Not yet implemented");
	}
	
	//Breeding test
	//Test 4: Current cell should stay yellow and should give birth at either: (2,1),(2,2),(1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void sharkTest5() {
		fail("Not yet implemented");
	}
	
	//Test 5: Current cell should stay yellow and should give birth at either: (1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2) edges at point (2,1), (2,2)
	@Test
	public void sharkTest6() {
		fail("Not yet implemented");
	}
	
	//Death test
	//Test 4: Current cell should die (Color will be blue)
	//shark at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void sharkTest7() {
		fail("Not yet implemented");
	}
	
}
