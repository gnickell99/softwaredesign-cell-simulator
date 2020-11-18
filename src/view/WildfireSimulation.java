package view;

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
import controller.*;

/***
 * 
 * @author Chris 
 * WildfireSimulation - Set up for Wildfire Simulation display
 *
 */

public class WildfireSimulation {

	GridPane setUpFireScene = new GridPane();
	public static final int SIZE = 600;
	private final int MILLISECOND_DELAY = 150;
	public int gridWidth;
	public int gridHeight;
	public double spreadProbability;
	public double forestDensity;
	public int burningTrees;
	public int burnTime;
	public static final String TITLE = "WildFire Simulator";
	public static final int COLUMNSPAN = 20;
	private boolean paused = false;		
	private Button pauseButton;
	private Color BACKGROUND = Color.LIGHTSLATEGRAY;
	InputParser validator = new InputParser();
	private Wildfire wildFireController = new Wildfire(0, 0, 0, 0, 0, 0);

	public WildfireSimulation(int gridWidth, int gridHeight)	{
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
	}

	public void setUpWildFireScene(Paint background) {
		Scene secondScene = setupWindow();
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);

		final TextField gridWidth = new TextField();
		gridWidth.setPromptText("(4.0 = Default) Enter Grid Width.");
		GridPane.setConstraints(gridWidth, 0, 0);
		GridPane.setColumnSpan(gridWidth, COLUMNSPAN);
		setUpFireScene.getChildren().add(gridWidth);

		final TextField gridHeight = new TextField();
		gridHeight.setPromptText("(4.0 = Default) Enter Grid Height.");
		GridPane.setConstraints(gridHeight, 0, 1);
		GridPane.setColumnSpan(gridHeight, COLUMNSPAN);
		setUpFireScene.getChildren().add(gridHeight);
		final TextField burnTime = new TextField();

		burnTime.setPromptText("(1.0 = Default) Enter Burn Time.");
		GridPane.setConstraints(burnTime, 0, 2);
		GridPane.setColumnSpan(burnTime, COLUMNSPAN);
		setUpFireScene.getChildren().add(burnTime);

		final TextField spreadProbability = new TextField();
		spreadProbability.setPromptText("(0.4 = Default) Enter Spread Probability.");
		GridPane.setConstraints(spreadProbability, 0, 3);
		GridPane.setColumnSpan(spreadProbability, COLUMNSPAN);
		setUpFireScene.getChildren().add(spreadProbability);

		final TextField forestDensity = new TextField();
		forestDensity.setPromptText("(1.0 = Default) Enter Forest Density.");
		GridPane.setConstraints(forestDensity, 0, 3);
		GridPane.setColumnSpan(forestDensity, COLUMNSPAN);
		setUpFireScene.getChildren().add(forestDensity);

		final TextField burningTreesNumber = new TextField();
		burningTreesNumber.setPromptText("(1.0 = Default) Enter Burning Tree Number.");
		GridPane.setConstraints(burningTreesNumber, 0, 4);
		GridPane.setColumnSpan(burningTreesNumber, COLUMNSPAN);
		setUpFireScene.getChildren().add(burningTreesNumber);


		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 5);
		setUpFireScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {
			this.gridHeight = validator.parseIntegerValue(gridHeight);
			this.gridWidth = validator.parseIntegerValue(gridWidth);
			this.burningTrees = validator.parseIntegerValue(burningTreesNumber);
			this.spreadProbability = validator.parseDoubleValue(spreadProbability);
			this.burnTime = validator.parseIntegerValue(burnTime);
			this.forestDensity = validator.parseDoubleValue(forestDensity);
			wildFireController = new Wildfire(this.gridHeight, this.gridWidth, this.burnTime, this.spreadProbability, this.forestDensity, this.burningTrees);
			setUpNewSimulation(wildFireController);

		});

		pauseButton = new Button("Pause Simulation");
		GridPane.setConstraints(pauseButton, 0, 6);
		setUpFireScene.getChildren().add(pauseButton);
		pauseButton.setOnAction((ActionEvent e) -> {
			pressPause();

		});

		Button step = new Button("Step");
		GridPane.setConstraints(step, 0, 7);
		GridPane.setColumnSpan(step, 3);
		setUpFireScene.getChildren().add(step);

		step.setOnAction((ActionEvent s) -> {
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

	public Scene setupWindow() {
		setUpFireScene.setPadding(new Insets(10, 10, 10, 10));
		setUpFireScene.setVgap(10);
		setUpFireScene.setHgap(10);

		Scene scene = new Scene(setUpFireScene, SIZE, SIZE, BACKGROUND);
		return scene;
	}

	/** setUpNewSimulation
	 * 
	 * Sets up a new simulation with inputs from gridWith and gridHeight
	 * @param wildFireController 
	 */
	private void setUpNewSimulation(Wildfire wildFireController) {
		wildFireController.generateGrid(setUpFireScene);
	}

	/** pressPause
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
		if(!paused && wildFireController != null) {
			doOneStep(elapsedTime);
		}
	}

	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	public void doOneStep(double elapsedTime){
		wildFireController.updateGrid(setUpFireScene);
	}

}
