package view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

/***
 * 
 * @author Chris  and Jazz
 * SimulationSelector - Set up for view hierarchy to choose between simulations
 *
 */
public class SimulationSelector  {

	
	GridPane setupGrid = new GridPane();
	public static final int SIZE = 600;
	public static final String TITLE = "Cell Simulator";
	public static final int COLUMNSPAN = 20;
	InputParser parser = new InputParser();
	
	
	
	public Scene setupScene(Paint background) {
		setupGrid.setPadding(new Insets(10, 10, 10, 10));
		setupGrid.setVgap(10);
		setupGrid.setHgap(10);
		

		
		Button wildFire = new Button("WildFire");
		GridPane.setConstraints(wildFire, 1, 0);
		setupGrid.getChildren().add(wildFire);

		Button gameOfLife = new Button("Game Of Life");
		GridPane.setConstraints(gameOfLife, 2, 0);
		setupGrid.getChildren().add(gameOfLife);
		
		wildFire.setOnAction((ActionEvent e) -> {
			WildfireSimulation wildFireSim = new WildfireSimulation(0, 0);
			wildFireSim.setUpWildFireScene(background);
		});
		
		gameOfLife.setOnAction((ActionEvent e) -> {
			GameOfLifeSimulationView gameOfLifeSimulation = new GameOfLifeSimulationView(0,0);
			gameOfLifeSimulation.setUpGameOfLifeScene(background);
			
		});
		
		
		
		Scene scene = new Scene(setupGrid, SIZE, SIZE, background);
		return scene;
	}
}
