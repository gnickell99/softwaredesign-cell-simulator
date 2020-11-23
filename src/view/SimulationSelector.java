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

	/**setUpGrid
	 * 
	 * Displays the inital loading screen to choose any of the simulations
	 */

	GridPane setupGrid = new GridPane();
	public static final int SIZE = 600;
	public static final String TITLE = "Cell Simulator";
	public static final int COLUMNSPAN = 20;

	public Scene setupScene(Paint background) {
		// Setting the padding  
		setupGrid.setPadding(new Insets(10, 10, 10, 10));

		// Setting the vertical and horizontal gaps between the columns 
		setupGrid.setVgap(10);
		setupGrid.setHgap(10);


		// Set up for the WildFire Button that choose the WildFire simulation
		Button wildFire = new Button("WildFire");
		GridPane.setConstraints(wildFire, 1, 0);
		setupGrid.getChildren().add(wildFire);

		// Set up for the game of life Button that choose the game of life simulation
		Button gameOfLife = new Button("Game Of Life");
		GridPane.setConstraints(gameOfLife, 2, 0);
		setupGrid.getChildren().add(gameOfLife);

		// Set up for the rock paper scissors Button that choose the rock paper scissors simulation
		Button rockPaperScissors = new Button("Rock Paper Scissors");
		GridPane.setConstraints(rockPaperScissors, 3, 0);
		setupGrid.getChildren().add(rockPaperScissors);



		// Set up for the rock paper scissors Button that choose the rock paper scissors simulation
		Button waterWorld = new Button("Water World");
		GridPane.setConstraints(waterWorld, 4, 0);
		setupGrid.getChildren().add(waterWorld);


		// Sets up the wildfire simulation view when button is pressed
		wildFire.setOnAction((ActionEvent e) -> {

			WildfireSimulation wildFireSim = new WildfireSimulation(10,10);

			wildFireSim.setUpWildFireScene(background);
		});

		// Sets up the game of life simulation view when button is pressed
		gameOfLife.setOnAction((ActionEvent e) -> {

			GameOfLifeSimulationView gameOfLifeSimulation = new GameOfLifeSimulationView(10,10);

			gameOfLifeSimulation.setUpGameOfLifeScene(background);

		});

		// Sets up the rock paper scissors simulation view when button is pressed
		rockPaperScissors.setOnAction((ActionEvent e) -> {

			RPSView rpsSimulation = new RPSView(10,10);

			rpsSimulation.setUpRpsScene(background);

		});

		// Sets up the water world simulation view when button is pressed
		waterWorld.setOnAction((ActionEvent e) -> {

			WaterWorldView waterWorldSimulation = new WaterWorldView();

			waterWorldSimulation.setUpWaterScene(background);

		});



		//Returns the scene
		Scene scene = new Scene(setupGrid, SIZE, SIZE, background);
		return scene;
	}
}
