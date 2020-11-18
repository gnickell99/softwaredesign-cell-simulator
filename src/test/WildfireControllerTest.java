package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.Wildfire;
import javafx.scene.layout.GridPane;

public class WildfireControllerTest {

	static Wildfire wildfireControl;
	static GridPane gp = new GridPane();
	
	@BeforeClass
	public static void getController() {
		wildfireControl = new Wildfire(4,4, 1, 1, 1, 2);
		wildfireControl.setBurningTrees(2);
		wildfireControl.generateGrid(gp);
		System.out.println(wildfireControl.grid[0][0].getType());
	}
	
	@Test
	public void edgeTest() {
		System.out.println(wildfireControl.grid[0][0].getType());
		
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals("edge", wildfireControl.grid[0][i].getType());
		}
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			assertEquals("edge", wildfireControl.grid[5][i].getType());
		}
	}
	
	@Test
	public void burningTreeNumTest() {
		int burningTreeCount = 0;
		for(int i = 0; i < wildfireControl.grid.length; i++) {
			for(int j = 0; j < wildfireControl.grid[0].length; j++) {
				if(wildfireControl.grid[i][j].getType().equals("BurningTree")) {
					burningTreeCount++;
				}
			}
		}
		assert(burningTreeCount == wildfireControl.burningTrees);
	}


}
