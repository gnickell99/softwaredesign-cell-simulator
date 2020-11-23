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
		
		Button rockPaperScissors = new Button("Rock Paper Scissors");
		GridPane.setConstraints(rockPaperScissors, 3, 0);
		setupGrid.getChildren().add(rockPaperScissors);

		wildFire.setOnAction((ActionEvent e) -> {

			WildfireSimulation wildFireSim = new WildfireSimulation(10,10);

			wildFireSim.setUpWildFireScene(background);
		});

		gameOfLife.setOnAction((ActionEvent e) -> {

			GameOfLifeSimulationView gameOfLifeSimulation = new GameOfLifeSimulationView(10,10);

			gameOfLifeSimulation.setUpGameOfLifeScene(background);

		});
		
		rockPaperScissors.setOnAction((ActionEvent e) -> {

			RPSView rpsSimulation = new RPSView(10,10);

			rpsSimulation.setUpRpsScene(background);

		});



		Scene scene = new Scene(setupGrid, SIZE, SIZE, background);
		return scene;
	}
}
