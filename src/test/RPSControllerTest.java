package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.scene.layout.GridPane;

/*
 * @author Kim Jones
 * This class test the Rock Paper Scissors methods, it makes sure everything gets set up properly and rules are accurate
 * 
 * */

public class RPSControllerTest {

	//static RockPaperScissors rpsControl; //not yet added

	static int testGridSize = 2;
	static int firstRow = 0;
	static int lastRow = 5;
	static int threshold = 3;
	
	static GridPane gp = new GridPane();
	
	@BeforeClass
	public void test() {
		//rpsControl = new RockPaperScissors(testGridSize,testGridSize); //Make object
		//rpsControl.generateGrid(gp); //Make a new Grid
	}

	//Test for rock below - surrounded by weakness:
	public void setUpTest1a() {
		//rpsControl.makeRock(1,1); //rock
		//rpsControl.makePaper(1,2);//paper
		//rpsControl.makePaper(2,1);//paper
		//rpsControl.makePaper(2,2);//paper
	}
	
	//Test for rock below - threshold not met:
	public void setUpTest1b() {
		//rpsControl.makeRock(1,1); //rock
		//rpsControl.makeRock(1,2); //rock
		//rpsControl.makePaper(2,1); //paper
		//rpsControl.makePaper(2,2); //paper
	}
	
	//Test for rock below - surrounded by other:
	public void setUpTest1c() {
		//rpsControl.makeRock(1,1); //rock
		//rpsControl.makeRock(1,2); //scissor
		//rpsControl.makePaper(2,1); //scissor
		//rpsControl.makePaper(2,2); //scissor
	}
	
	//Test for Paper below - surrounded by weakness:
	public void setUpTest2a() {
		//rpsControl.makePaper(1,1); //paper
		//rpsControl.makeScissor(1,2);//scissor
		//rpsControl.makeScissor(2,1);//scissor
		//rpsControl.makeScissor(2,2);//scissor
	}
	
	//Test for Paper below - threshold not met:
	public void setUpTest2b() {
		//rpsControl.makePaper(1,1); //paper
		//rpsControl.makePaper(1,2);//paper
		//rpsControl.makeScissor(2,1);//scissor
		//rpsControl.makeScissor(2,2);//scissor
	}
	
	//Test for Paper below - surrounded by other:
	public void setUpTest2c() {
		//rpsControl.makePaper(1,1); //paper
		//rpsControl.makeRock(1,2);//rock
		//rpsControl.makeRock(2,1);//rock
		//rpsControl.makeRock(2,2);//rock
	}
	
	//Test for Scissors below - threshold not met:
	public void setUpTest3a() {
		//rpsControl.makeScissor(1,1); //scissor
		//rpsControl.makeRock(1,2);//rock
		//rpsControl.makeRock(2,1);//rock
		//rpsControl.makeRock(2,2);//rock
	}
	
	//Test for Scissors below - threshold not met:
	public void setUpTest3b() {
		//rpsControl.makeScissor(1,1); //scissor
		//rpsControl.makeRock(1,2);//rock
		//rpsControl.makeScissor(2,1);//scissor
		//rpsControl.makeRock(2,2);//rock
	}
	
	//Test for Scissors below - surrounded by other:
	public void setUpTest3c() {
		//rpsControl.makeScissor(1,1); //scissor
		//rpsControl.makePaper(1,2);//paper
		//rpsControl.makePaper(2,1);//paper
		//rpsControl.makePaper(2,2);//paper
	}

	//Paper beats rock
	//Test 1: Current cell should white
	//rock at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest1() {
		setUpTest1a();// set up
		
		//call act on start
		//rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.grid);	
		
		//check - should turn white
		//assertEquals(rpsControl.grid[1][1].getColor.equals(Color.white));
		//assertEquals(rpsControl.grid[2][1].getColor.equals(Color.white));
		//assertEquals(rpsControl.grid[2][2].getColor.equals(Color.white));
		//assertEquals(rpsControl.grid[2][3].getColor.equals(Color.white));
	}
	
	//threshold not met
	//Test 2: Current cell should stay red
	//rock at point (1,1),(1,2) paper at point (2,1),(2,2)
	@Test
	public void rockTest2() {
		setUpTest1b(); //set up
		
		//call act on start
		//rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.grid);	
		
		//check - should stay red
		//assertEquals(rpsControl.grid[1][1].getColor.equals(Color.red));
		//assertEquals(rpsControl.grid[2][1].getColor.equals(Color.red));
		//assertEquals(rpsControl.grid[2][2].getColor.equals(Color.white));
		//assertEquals(rpsControl.grid[2][3].getColor.equals(Color.white));
	}
	
	//threshold not weakness
	//Test 3: Current cell should stay red
	//rock at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest3() {
		setUpTest1c(); //set up
		
		//call act on start
		//rpsControl.grid[1][1] = rpsControl.grid[1][1].act(1, 1);	
		
		//check
		//assertEquals(rpsControl.grid[1][1].getColor.equals(Color.red));
		//assertEquals(rpsControl.grid[2][1].getColor.equals(Color.blue));
		//assertEquals(rpsControl.grid[2][2].getColor.equals(Color.blue));
		//assertEquals(rpsControl.grid[2][3].getColor.equals(Color.blue));
	}
	
	//Test for paper below:
	
	//Scissors beats paper
	//Test 1: Current cell should turn blue
	//paper at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest1() {
		fail("Not yet implemented");
	}
	
	//threshold not met
	//Test 2: Current cell should stay white
	//paper at point (1,1),(1,2) scissors at point (2,1),(2,2)
	@Test
	public void paperTest2() {
		fail("Not yet implemented");
	}
	
	//threshold not weakness
	//Test 3: Current cell should stay white
	//paper at point (1,1) rocks at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest3() {
		fail("Not yet implemented");
	}
	
	//Test for Scissors below:
	
	//rock beats scissors
	//Test 1: Current cell should turn red
	//scissor at point (1,1) rock at point (2,1),(2,2),(1,2)
	@Test
	public void scissorTest1() {
		fail("Not yet implemented");
	}
	
	//threshold not met
	//Test 2: Current cell should stay blue
	//scissors at point (1,1),(1,2) rock at point (2,1),(2,2)
	@Test
	public void scissorTest2() {
		fail("Not yet implemented");
	}
	
	//threshold not weakness
	//Test 3: Current cell should stay blue
	//scissor at point (1,1) rocks at point (2,1),(2,2),(1,2)
	@Test
	public void scissorTest3() {
		fail("Not yet implemented");
	}
	
}
