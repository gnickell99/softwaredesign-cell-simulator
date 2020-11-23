
package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

public class WildfireSimulation extends View {

	// constants
	private static final int GRID_INDEX_START = 10;
	GridPane setUpFireScene = new GridPane();
	public static final int SIZE = 600;
	private final int MILLISECOND_DELAY = 150;
	public double spreadProbability;
	public double forestDensity;
	public int burningTrees;
	public int burnTime;
	private static final String TITLE = "WildFire Simulator";
	public static final int COLUMNSPAN = 20;
	InputParser validator = new InputParser();
	private Wildfire wildFireController = new Wildfire(0, 0, 0, 0, 0, 0);

	public WildfireSimulation(int gridWidth, int gridHeight)	{
		
	}
	
	/** setUpWildFireScene
	 * 
	 * Creates each button needed for the wildfire simulation
	 * and adds them to the grid pane to be displayed to the user
	 * @param gridHeightText 
	 * @param gridHeight 
	 * @param gridWidth 
	 * @returns scene for wild fire visuals
	 * 
	 */
	public void setUpWildFireScene(Paint background) {
		Scene secondScene = setUpScene(setUpFireScene);
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);

		
		TextField burnTime = new TextField();
		burnTime.setPromptText("(1.0 = Default) Enter Burn Time.");
		GridPane.setConstraints(burnTime, 0, 2);
		GridPane.setColumnSpan(burnTime, COLUMNSPAN);
		setUpFireScene.getChildren().add(burnTime);

		TextField spreadProbability = new TextField();
		spreadProbability.setPromptText("(0.4 = Default) Enter Spread Probability.");
		GridPane.setConstraints(spreadProbability, 0, 3);
		GridPane.setColumnSpan(spreadProbability, COLUMNSPAN);
		setUpFireScene.getChildren().add(spreadProbability);

		TextField forestDensity = new TextField();
		forestDensity.setPromptText("(1.0 = Default) Enter Forest Density.");
		GridPane.setConstraints(forestDensity, 0, 4);
		GridPane.setColumnSpan(forestDensity, COLUMNSPAN);
		setUpFireScene.getChildren().add(forestDensity);

		TextField burningTreesNumber = new TextField();
		burningTreesNumber.setPromptText("(1.0 = Default) Enter Burning Tree Number.");
		GridPane.setConstraints(burningTreesNumber, 0, 5);
		GridPane.setColumnSpan(burningTreesNumber, COLUMNSPAN);
		setUpFireScene.getChildren().add(burningTreesNumber);


		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 7);
		setUpFireScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {
			int height = validator.parseIntValue(gridHeightText);
			int width = validator.parseIntValue(gridWidthText);
			int burnTimeForTrees = validator.parseIntValue(burnTime);
			double spreadProbabilityForTrees = validator.parseDoubleValue(spreadProbability);
			double forestDensityOfTrees = validator.parseDoubleValue(forestDensity);
			int rateOfBurningTrees = validator.parseIntValue(burningTreesNumber);
			
			wildFireController = new Wildfire(height, width, burnTimeForTrees, spreadProbabilityForTrees, forestDensityOfTrees, rateOfBurningTrees);
			setUpNewSimulation(wildFireController);
		});
		
		//This only works when the simulation is paused
		Button clearButton = new Button("Clear Simulation");
		GridPane.setConstraints(clearButton, 2, 7);
		setUpFireScene.getChildren().add(clearButton);
		clearButton.setOnAction((ActionEvent e) -> {
			setUpFireScene.getChildren().remove(GRID_INDEX_START, setUpFireScene.getChildren().size());
		});

		
		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();

		newWindow.show();



	}


	/** setUpNewSimulation
	 * 
	 * Sets up a new simulation with inputs from gridWith and gridHeight
	 * @param wildFireController 
	 */
	private void setUpNewSimulation(Wildfire wildFireController) {
		wildFireController.generateGrid(setUpFireScene);
	}

	
	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	@Override
	public void doOneStep(double elapsedTime){
		wildFireController.updateGrid(setUpFireScene);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

