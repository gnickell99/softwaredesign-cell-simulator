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
//		wwControl.makeEdge(2, 1); // black
//		wwControl.makeEdge(2, 2); // black
	}
	
	//Make 1st cell yellow and all neighbors blue
	public static void setUpRule3() {
//		wwControl.plantShark(1, 1); //yellow
//		wwControl.makeWater(1, 2); // blue
//		wwControl.makeWater(2, 1); // blue
//		wwControl.makeWater(2, 2); // blue
	}
	
	//Make 1st cell yellow and 2 neighbors edges
	public static void setUpRule4() {
//		wwControl.plantShark(1, 1); //yellow
//		wwControl.makeWater(1, 2); // blue
//		wwControl.makeEdge(2, 1); // black
//		wwControl.makeEdge(2, 2); // black
	}

	//Make 1st cell yellow and 2 neighbors water, 1 neighbor fish
	public static void setUpRule5() {
//		wwControl.plantShark(1, 1); //yellow
//		wwControl.makeWater(1, 2); // blue
//		wwControl.makeWater(2, 1); // blue
//		wwControl.makeFish(2, 2); // green
	}
	
	//Make 1st cell yellow and 1 neighbor water, 2 neighbors fish
	public static void setUpRule6() {
//		wwControl.plantShark(1, 1); //yellow
//		wwControl.makeFish(1, 2); // green
//		wwControl.makeWater(2, 1); // blue
//		wwControl.makeFish(2, 2); // green
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
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
		//Make sure start is now water
//		assertTrue(wwControl.grid[1][1].getType().equals("water cell"));
		//Make sure one of neighbors is a fish
//		assertTrue(wwControl.grid[1][2].getType().equals("fish cell") || wwControl.grid[2][1].getType().equals("fish cell") || wwControl.grid[2][2].getType().equals("fish cell"));

	}
	
	//Test 2: Current cell should turn blue and fish should move to: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest2() {
		setUpRule2();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Check rule
//		assertTrue(golControl.grid[1][1].getType().equals("water cell"));
//		assertTrue(golControl.grid[1][2].getType().equals("fish cell"));
//		assertTrue(golControl.grid[2][1].getType().equals("edge cell"));
//		assertTrue(golControl.grid[2][2].getType().equals("edge cell"));
		
	}
	
	//Breeding test
	//Test 3: Current cell stay green and fish should give birth at either: (1,2), (2,1), (2,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2), (2,1), (2,2)
	@Test
	public void fishTest3() {
		setUpRule1();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
		
		//Make sure start is still fish
//		assertTrue(wwControl.grid[1][1].getType().equals("fish cell"));
//		/Make sure one of neighbors is a fish
//		assertTrue(wwControl.grid[1][2].getType().equals("fish cell") || wwControl.grid[2][1].getType().equals("fish cell") || wwControl.grid[2][2].getType().equals("fish cell"));
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
		setUpRule3();
		
		//run act method
		//wwControl.grid[1][1] = wwControl.grid[1][1].act(wwControl.grid);	
				
		//Check rule
		//Make sure start is now water
//		assertTrue(wwControl.grid[1][1].getType().equals("water cell"));
		//Make sure one of neighbors is a shark
//		assertTrue(wwControl.grid[1][2].getType().equals("shark cell") || wwControl.grid[2][1].getType().equals("shark cell") || wwControl.grid[2][2].getType().equals("shark cell"));
	}
	
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
