package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameOfLife;

/*
 * @author Kim Jones and Camryn Williams
 * 
 * */

public class GameOfLifeControllerTest {
	static GameOfLife golControl;
	
	@BeforeClass
	public static void getController() {
		golControl = new GameOfLife(4,4); //Make object
		golControl.generateGrid(); //Make a new Grid
		
		//Manually make a testing scenario
		golControl.grid[0][0].getType();
	}

	@Test
	public void edgeTest() {
		fail("Not yet implemented");
	}

}
