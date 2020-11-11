package tests;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import main.*;
import states.*;

public class WildfireControllerTest {
	static Wildfire wildfireControl;
	//private State[][] controlBoard;
	
	@BeforeClass
	public static void getController() {
		wildfireControl = new Wildfire(4,4);
		wildfireControl.setBurningTrees(2);
		wildfireControl.generateGrid();
		//controlBoard = 
	}
	
	@Test
	public void edgeTest() {
		for(int i = 0; i < wildfireControl.board[0].length; i++) {
			assert(wildfireControl.board[0][i].getType().equals("Edge"));
		}
		for(int i = 0; i < wildfireControl.board[0].length; i++) {
			assert(wildfireControl.board[5][i].getType().equals("Edge"));
		}
	}
	
	@Test
	public void burningTreeNumTest() {
		int burningTreeCount = 0;
		for(int i = 0; i < wildfireControl.board.length; i++) {
			for(int j = 0; j < wildfireControl.board[0].length; j++) {
				if(wildfireControl.board[i][j].getType().equals("BurningTree")) {
					burningTreeCount++;
				}
			}
		}
		assert(burningTreeCount == wildfireControl.burningTrees);
	}
	
	
}
