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

	//Controller
	static RockPaperScissors rpsControl;
	static GridPane gp = new GridPane();

	//Constants
	static final int TEST_GRID_SIZE = 2;
	static final int FIRST_ROW = 0;
	static final int LAST_ROW = 4;
	static final int WIN_THRESHOLD = 3;
	//Colors
	static final Color ROCK = Color.RED;
	static final Color PAPER = Color.WHITE;
	static final Color SCISSORS = Color.BLUE;
	//Coordinates
	static int ROW1 = 1;
	static int COL1 = 1;
	static int ROW2 = 2;
	static int ROW3 = 3;
	static int COL2 = 2;
	static int COL3 = 3;
	

	@BeforeClass
	public static void test() {
		rpsControl = new RockPaperScissors(TEST_GRID_SIZE,TEST_GRID_SIZE, WIN_THRESHOLD); //Make object
		rpsControl.generateGrid(gp); //Make a new Grid
	}

	//Test for rock below - surrounded by weakness:
	public void setUpTest1a() {
		rpsControl.makeRock(ROW1,COL1); //rock
		rpsControl.makePaper(ROW1,COL2);//paper
		rpsControl.makePaper(ROW2,COL1);//paper
		rpsControl.makePaper(ROW2,COL2);//paper
	}

	//Test for rock below - threshold not met:
	public void setUpTest1b() {
		rpsControl.makeRock(ROW1,COL1); //rock
		rpsControl.makeRock(ROW1,COL2); //rock
		rpsControl.makePaper(ROW2,COL1); //paper
		rpsControl.makePaper(ROW2,COL2); //paper
	}

	//Test for rock below - surrounded by other:
	public void setUpTest1c() {
		rpsControl.makeRock(ROW1,COL1); //rock
		rpsControl.makeScissor(ROW1,COL2); //scissor
		rpsControl.makeScissor(ROW2,COL1); //scissor
		rpsControl.makeScissor(ROW2,COL2); //scissor
	}

	//Test for Paper below - surrounded by weakness:
	public void setUpTest2a() {
		rpsControl.makePaper(ROW1,COL1); //paper
		rpsControl.makeScissor(ROW1,COL2);//scissor
		rpsControl.makeScissor(ROW2,COL1);//scissor
		rpsControl.makeScissor(ROW2,COL2);//scissor
	}

	//Test for Paper below - threshold not met:
	public void setUpTest2b() {
		rpsControl.makePaper(ROW1,COL1); //paper
		rpsControl.makePaper(ROW1,COL2);//paper
		rpsControl.makeScissor(ROW2,COL1);//scissor
		rpsControl.makeScissor(ROW2,COL2);//scissor
	}

	//Test for Paper below - surrounded by other:
	public void setUpTest2c() {
		rpsControl.makePaper(ROW1,COL1); //paper
		rpsControl.makeRock(ROW1,COL2);//rock
		rpsControl.makeRock(ROW2,ROW1);//rock
		rpsControl.makeRock(ROW2,COL2);//rock
	}

	//Test for Scissors below - threshold not met:
	public void setUpTest3a() {
		rpsControl.makeScissor(ROW1,COL1); //scissor
		rpsControl.makeRock(ROW1,COL2);//rock
		rpsControl.makeRock(ROW2,COL1);//rock
		rpsControl.makeRock(ROW2,COL2);//rock
	}

	//Test for Scissors below - threshold not met:
	public void setUpTest3b() {
		rpsControl.makeScissor(ROW1,COL1); //scissor
		rpsControl.makeRock(ROW1,COL2);//rock
		rpsControl.makeScissor(ROW2,COL1);//scissor
		rpsControl.makeRock(ROW2,COL2);//rock
	}

	//Test for Scissors below - surrounded by other:
	public void setUpTest3c() {
		rpsControl.makeScissor(ROW1,COL1); //scissor
		rpsControl.makePaper(ROW1,COL2);//paper
		rpsControl.makePaper(ROW2,COL1);//paper
		rpsControl.makePaper(ROW2,COL2);//paper
	}

	//Paper beats rock
	//Test 1: Current cell should white - good
	//rock at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest1() {
		setUpTest1a();// set up

		//call act on start
		rpsControl.grid[ROW1][COL1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should turn white
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(PAPER));
	}

	//threshold not met
	//Test 2: Current cell should stay red - good
	//rock at point (1,1),(1,2) paper at point (2,1),(2,2)
	@Test
	public void rockTest2() {
		setUpTest1b(); //set up

		//call act on start
		rpsControl.grid[ROW1][COL1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should stay red
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(PAPER));
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
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(SCISSORS));
	}

	//Test for paper below:

	//Scissors beats paper
	//Test 1: Current cell should turn blue - good
	//paper at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest1() {
		setUpTest2a();// set up

		//call act on start
		rpsControl.grid[ROW1][COL1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should turn blue
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(SCISSORS));
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
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(SCISSORS));
	}

	//threshold not weakness
	//Test 3: Current cell should stay white
	//paper at point (1,1) rocks at point (2,1),(2,2),(1,2)
	@Test
	public void paperTest3() {
		setUpTest2c(); //set up

		//call act on start
		rpsControl.grid[ROW1][COL1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should stay white
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(ROCK));
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
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(ROCK));
	}

	//threshold not met
	//Test 2: Current cell should stay blue
	//scissors at point (1,1),(2,1) rock at point (1,2),(2,2)
	@Test
	public void scissorTest2() {
		setUpTest3b(); //set up

		//call act on start
		rpsControl.grid[1][1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should stay blue
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(ROCK));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(ROCK));
	}

	//threshold not weakness
	//Test 3: Current cell should stay blue
	//scissor at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void scissorTest3() {
		setUpTest3c(); //set up

		//call act on start
		rpsControl.grid[ROW1][COL1] = rpsControl.grid[ROW1][COL1].act(rpsControl.getNeighbors(ROW1, COL1));	

		//check - should stay blue
		assertTrue(rpsControl.grid[ROW1][COL1].cellColor.equals(SCISSORS));
		assertTrue(rpsControl.grid[ROW1][COL2].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL1].cellColor.equals(PAPER));
		assertTrue(rpsControl.grid[ROW2][COL2].cellColor.equals(PAPER));
	}

}
