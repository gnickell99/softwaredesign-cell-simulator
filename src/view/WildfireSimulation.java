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

public class WildfireSimulation extends View {

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
		//this.gridWidth = gridWidth;
		//this.gridHeight = gridHeight;
	}

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
		GridPane.setConstraints(newSimulationButton, 0 , 6);
		setUpFireScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {
			
			int height = Integer.parseInt(gridHeightText.getText());
			int width = Integer.parseInt(gridWidthText.getText());
			int burnTimeForTrees = Integer.parseInt(burnTime.getText());
			double spreadProbabilityForTrees = Double.parseDouble(spreadProbability.getText());
			int forestDensityOfTrees = Integer.parseInt(forestDensity.getText());
			int rateOfBurningTrees = Integer.parseInt(burningTreesNumber.getText());
			
//			this.gridHeight = validator.parseIntValue(gridHeight);
//			this.gridWidth = validator.parseIntValue(gridWidth);
//			this.burningTrees = validator.parseIntValue(burningTreesNumber);
//			this.spreadProbability = validator.parseDoubleValue(spreadProbability);
//			this.burnTime = validator.parseIntValue(burnTime);
//			this.forestDensity = validator.parseDoubleValue(forestDensity);
			
			wildFireController = new Wildfire(height, width, burnTimeForTrees, spreadProbabilityForTrees, forestDensityOfTrees, rateOfBurningTrees);
			setUpNewSimulation(wildFireController);

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
	public void doOneStep(double elapsedTime){
		wildFireController.updateGrid(setUpFireScene);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
