package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.scene.paint.Color;

import controller.RockPaperScissors;
import javafx.scene.layout.GridPane;

/*
 * @author Kim Jones 
 * This class test the Rock Paper Scissors methods, it makes sure everything gets set up properly and rules are accurate
 * 
 * */

public class RPSControllerTest {

	static RockPaperScissors rpsControl; //not yet added

	static int testGridSize = 2;
	static int firstRow = 0;
	static int lastRow = 5;
	static int threshold = 3;

	static GridPane gp = new GridPane();

	@BeforeClass
	public static void test() {
		rpsControl = new RockPaperScissors(testGridSize,testGridSize, threshold); //Make object
		rpsControl.generateGrid(gp); //Make a new Grid
	}

	//Test for rock below - surrounded by weakness:
	public void setUpTest1a() {
		rpsControl.makeRock(1,1); //rock
		rpsControl.makePaper(1,2);//paper
		rpsControl.makePaper(2,1);//paper
		rpsControl.makePaper(2,2);//paper
	}

	//Test for rock below - threshold not met:
	public void setUpTest1b() {
		rpsControl.makeRock(1,1); //rock
		rpsControl.makeRock(1,2); //rock
		rpsControl.makePaper(2,1); //paper
		rpsControl.makePaper(2,2); //paper
	}

	//Test for rock below - surrounded by other:
	public void setUpTest1c() {
		rpsControl.makeRock(1,1); //rock
		rpsControl.makeScissor(1,2); //scissor
		rpsControl.makeScissor(2,1); //scissor
		rpsControl.makeScissor(2,2); //scissor
	}

	//Test for Paper below - surrounded by weakness:
	public void setUpTest2a() {
		rpsControl.makePaper(1,1); //paper
		rpsControl.makeScissor(1,2);//scissor
		rpsControl.makeScissor(2,1);//scissor
		rpsControl.makeScissor(2,2);//scissor
	}

	//Test for Paper below - threshold not met:
	public void setUpTest2b() {
		rpsControl.makePaper(1,1); //paper
		rpsControl.makePaper(1,2);//paper
		rpsControl.makeScissor(2,1);//scissor
		rpsControl.makeScissor(2,2);//scissor
	}

	//Test for Paper below - surrounded by other:
	public void setUpTest2c() {
		rpsControl.makePaper(1,1); //paper
		rpsControl.makeRock(1,2);//rock
		rpsControl.makeRock(2,1);//rock
		rpsControl.makeRock(2,2);//rock
	}

	//Test for Scissors below - threshold not met:
	public void setUpTest3a() {
		rpsControl.makeScissor(1,1); //scissor
		rpsControl.makeRock(1,2);//rock
		rpsControl.makeRock(2,1);//rock
		rpsControl.makeRock(2,2);//rock
	}

	//Test for Scissors below - threshold not met:
	public void setUpTest3b() {
		rpsControl.makeScissor(1,1); //scissor
		rpsControl.makeRock(1,2);//rock
		rpsControl.makeScissor(2,1);//scissor
		rpsControl.makeRock(2,2);//rock
	}

	//Test for Scissors below - surrounded by other:
	public void setUpTest3c() {
		rpsControl.makeScissor(1,1); //scissor
		rpsControl.makePaper(1,2);//paper
		rpsControl.makePaper(2,1);//paper
		rpsControl.makePaper(2,2);//paper
	}

	//Paper beats rock
	//Test 1: Current cell should white - good
	//rock at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest1() {
		setUpTest1a();// set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should turn white
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.WHITE));
	}

	//threshold not met
	//Test 2: Current cell should stay red - good
	//rock at point (1,1),(1,2) paper at point (2,1),(2,2)
	@Test
	public void rockTest2() {
		setUpTest1b(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should stay red
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.WHITE));
	}

	//threshold not weakness
	//Test 3: Current cell should stay red - good
	//rock at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest3() {
		setUpTest1c(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.BLUE));
	}

	//Test for paper below:

	//Scissors beats paper
	//Test 1: Current cell should turn blue - good
	//paper at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest1() {
		setUpTest2a();// set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should turn blue
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.BLUE));
	}

	//threshold not met
	//Test 2: Current cell should stay white - good
	//paper at point (1,1),(1,2) scissors at point (2,1),(2,2)
	@Test
	public void paperTest2() {
		setUpTest2b();// set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should stay white
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.BLUE));
	}

	//threshold not weakness
	//Test 3: Current cell should stay white
	//paper at point (1,1) rocks at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest3() {
		setUpTest2c(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should stay white
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.RED));
	}

	//Test for Scissors below:

	//rock beats scissors
	//Test 1: Current cell should turn red
	//scissor at point (1,1) rock at point (2,1),(2,2),(1,2)
	@Test
	public void scissorTest1() {
		setUpTest3a(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should turn red
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.RED));
	}

	//threshold not met
	//Test 2: Current cell should stay blue
	//scissors at point (1,1),(2,1) rock at point (1,2),(2,2)
	@Test
	public void scissorTest2() {
		setUpTest3b(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should stay blue
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.RED));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.RED));
	}

	//threshold not weakness
	//Test 3: Current cell should stay blue
	//scissor at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void scissorTest3() {
		setUpTest3c(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[1][1].act(rpsControl.getNeighbors(1, 1));	

		//check - should stay blue
		assertTrue(rpsControl.grid[1][1].cellColor.equals(Color.BLUE));
		assertTrue(rpsControl.grid[1][2].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][1].cellColor.equals(Color.WHITE));
		assertTrue(rpsControl.grid[2][2].cellColor.equals(Color.WHITE));
	}

}
