package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.scene.layout.GridPane;

public class RPSControllerTest {

	//static RockPaperScissors rpsControl; //not yet added

	static int testGridSize = 4;
	static int firstRow = 0;
	static int lastRow = 5;
	
	static GridPane gp = new GridPane();
	
	@BeforeClass
	public void test() {
		//rpsControl = new RockPaperScissors(testGridSize,testGridSize); //Make object
		//rpsControl.generateGrid(gp); //Make a new Grid
	}

	//Test for rock below:
	
	//Paper beats rock
	//Test 1: Current cell should white
	//rock at point (1,1) paper at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest1() {
		fail("Not yet implemented");
	}
	
	//threshold not met
	//Test 2: Current cell should stay red
	//rock at point (1,1),(1,2) paper at point (2,1),(2,2)
	@Test
	public void rockTest2() {
		fail("Not yet implemented");
	}
	
	//threshold not weakness
	//Test 3: Current cell should stay red
	//rock at point (1,1) scissors at point (2,1),(2,2),(1,2)
	@Test
	public void rockTest3() {
		fail("Not yet implemented");
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
