package view;

import controller.GameOfLife;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
/***
 * 
 * @author Jazz 
 * GameOfLifeSimulationView - Set up for Game of Life Simulation display
 *
 */
public class GameOfLifeSimulationView extends View {

	// constants
	private static final int GRID_INDEX_START = 6;
	GridPane setUpLifeScene = new GridPane();
	private final int MILLISECOND_DELAY = 150;
	public static final int SIZE = 600;
	private static final String TITLE = "Game Of Life Simulator";
	public static final int COLUMNSPAN = 20;
	private GameOfLife gameOfLifeController = new GameOfLife(0, 0);
	InputParser validator = new InputParser();

	public GameOfLifeSimulationView(int gridHeight, int gridWidth)
	{
		
	}

	/** setUpGameOfLifeScene
	 * 
	 * Creates each button needed for the game of life simulation
	 * and adds them to the grid pane to be displayed to the user
	 * @param gridHeightText 
	 * @param gridHeight 
	 * @param gridWidth 
	 * @returns scene for game of life visuals
	 * 
	 */
	public void setUpGameOfLifeScene(Paint background) {

		Scene secondScene = setUpScene(setUpLifeScene);
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);

		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 7);
		setUpLifeScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {

		int height = validator.parseIntValue(gridHeightText);
		int width = validator.parseIntValue(gridWidthText);
		gameOfLifeController = new GameOfLife(height, width);

		setUpNewSimulation(gameOfLifeController);

		});
		
		//This only works when the simulation is paused, but clears any current simulation on the scene
		Button clearButton = new Button("Clear Simulation");


		GridPane.setConstraints(clearButton, 2, 7);


		setUpLifeScene.getChildren().add(clearButton);
		clearButton.setOnAction((ActionEvent e) -> {
		setUpLifeScene.getChildren().remove(GRID_INDEX_START, setUpLifeScene.getChildren().size());
				});


		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();

		newWindow.show();

	}

	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	@Override
	public void doOneStep(double elapsedTime) {
		gameOfLifeController.updateGrid(setUpLifeScene);

	}

	/**setUpNewSimulation
	 * 
	 * sets up a new scene for the game of life simulation
	 */
	public void setUpNewSimulation(GameOfLife gameOfLifeController) {
		gameOfLifeController.generateGrid(setUpLifeScene);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}







}

