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
	 * Creates each button need for the game of life simulation
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
		GridPane.setConstraints(newSimulationButton, 0 , 6);
		setUpLifeScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {

		int height = validator.parseIntValue(gridHeightText);
		int width = validator.parseIntValue(gridWidthText);
		gameOfLifeController = new GameOfLife(height, width);

		setUpNewSimulation(gameOfLifeController);

		});


		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();

		newWindow.show();

	}


	@Override
	public void doOneStep(double elapsedTime) {
		gameOfLifeController.updateGrid(setUpLifeScene);

	}


	public void setUpNewSimulation(GameOfLife gameOfLifeController) {
		gameOfLifeController.generateGrid(setUpLifeScene);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}







}

