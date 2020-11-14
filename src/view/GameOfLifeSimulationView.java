package view;

import controller.GameOfLife;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
/***
 * 
 * @author Jazz 
 * GameOfLifeSimulationView - Set up for Game of Life Simulation display
 *
 */
public class GameOfLifeSimulationView {

	GridPane setUpLifeScene = new GridPane();
	private final int MILLISECOND_DELAY = 150;
	public static final int SIZE = 600;
	public static final String TITLE = "Game Of Life Simulator";
	public static final int COLUMNSPAN = 20;
	private boolean paused = false;		
	private Button pauseButton;
	public int gridWidth;
	public int gridHeight;
	private Color BACKGROUND = Color.LIGHTSLATEGRAY;
	InputParser validator = new InputParser();
	private GameOfLife gameOfLifeController = new GameOfLife(0, 0);

	InputParser validateUserInput = new InputParser();
	public GameOfLifeSimulationView(int gridWidth, int gridHeight) {
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;

	}


	/** setUpGameOfLifeScene
	 * 
	 * Creates each button need for the game of life simulation
	 * and adds them to the grid pane to be displayed to the user
	 * @returns scene for game of life visuals
	 * 
	 */
	public void setUpGameOfLifeScene(Paint background ) {



		Scene secondScene = setupWindow();
		Stage newWindow = new Stage();
		newWindow.setTitle("GameOfLife Simulation");
		newWindow.setScene(secondScene);

		final TextField gridWidth = new TextField();
		gridWidth.setPromptText("(4.0 = Default) Enter Grid Width.");
		GridPane.setConstraints(gridWidth, 0, 0);
		GridPane.setColumnSpan(gridWidth, COLUMNSPAN);
		setUpLifeScene.getChildren().add(gridWidth);

		final TextField gridHeight = new TextField();
		gridHeight.setPromptText("(4.0 = Default) Enter Grid Height.");
		GridPane.setConstraints(gridHeight, 0, 1);
		GridPane.setColumnSpan(gridHeight, COLUMNSPAN);
		setUpLifeScene.getChildren().add(gridHeight);


		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 3);
		setUpLifeScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {
			this.gridHeight = validator.parseIntegerValue(gridHeight);
			this.gridWidth = validator.parseIntegerValue(gridWidth);
			gameOfLifeController = new GameOfLife(this.gridHeight, this.gridWidth);
			setUpNewSimulation(gameOfLifeController);

		});

		pauseButton = new Button("Pause Simulation");
		GridPane.setConstraints(pauseButton, 0, 4);
		setUpLifeScene.getChildren().add(pauseButton);
		pauseButton.setOnAction((ActionEvent e) -> {
			pressPause();

		});

		Button stepButton = new Button("Step");
		GridPane.setConstraints(stepButton, 0, 5);
		setUpLifeScene.getChildren().add(stepButton);

		stepButton.setOnAction((ActionEvent e) -> {


			this.doOneStep(MILLISECOND_DELAY);

		});

		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();

		newWindow.show();

	}


	/**
	 * 
	 * Toggle the pause button
	 */
	private void pressPause() {
		this.paused = !this.paused;
		if(this.paused){
			pauseButton.setText("Resume");
		}
		else{
			pauseButton.setText("Pause");
		}

	}

	/** setUpNewSimulation
	 * 
	 * Sets up a new simulation with inputs from gridWith and gridHeight
	 * @param wildFireController 
	 */
	private void setUpNewSimulation(GameOfLife gameOfLifeController ) {
		gameOfLifeController.generateGrid(setUpLifeScene);
	}


	/** pauseIt
	 * 
	 * Pause the animation (regardless of current state of pause button)
	 */
	public void pauseIt(){
		this.paused = true;
		pauseButton.setText("Resume");
	}

	/** step
	 * 
	 * Does a step in the search only if not paused.
	 */
	public void step(double elapsedTime){
		if(!paused) {
			doOneStep(elapsedTime);
		}
	}

	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	public void doOneStep(double elapsedTime){
		gameOfLifeController.updateGrid(setUpLifeScene);
	}


	/*
	 * sets up a new window when Game of Life simulation button is first pressed and whenever the new simulation button is pressed withing ame of life
	 */
	public Scene setupWindow() {
		setUpLifeScene.setPadding(new Insets(10, 10, 10, 10));
		setUpLifeScene.setVgap(10);
		setUpLifeScene.setHgap(10);

		Scene scene = new Scene(setUpLifeScene, SIZE, SIZE, BACKGROUND);
		return scene;
	}



}

