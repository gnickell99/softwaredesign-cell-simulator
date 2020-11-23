package view;

import controller.WaterWorld;
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
/***
 * 
 * @author Jazz 
 * WaterWorldSimulation - Set up for WaterWorld Simulation display
 *
 */
public class WaterWorldView extends View {
	// constants
	private static final int GRID_INDEX_START = 10;
	GridPane setUpWaterScene = new GridPane();
	public static final int SIZE = 600;
	private final int MILLISECOND_DELAY = 150;
	public double sharkDensity;
	public double waterDensity;
	public int burningTrees;
	public int fishDensity;
	private static final String TITLE = "WaterWorld Simulator";
	public static final int COLUMNSPAN = 20;
	InputParser validator = new InputParser();
	private WaterWorld waterWorldController = new WaterWorld(0, 0, 0, 0, 0, 0, 0);


	public  WaterWorldView()	{
	}
	/** setUpWildFireScene
	 * 
	 * Creates each button needed for the wildfire simulation
	 * and adds them to the grid pane to be displayed to the user
	 * @param gridHeightText 
	 * @param gridHeight 
	 * @param gridWidth 
	 * @returns scene for wild Water visuals
	 * 
	 */
	public void setUpWaterScene(Paint background) {
		Scene secondScene = setUpScene(setUpWaterScene);
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);


		TextField fishDensity = new TextField();
		fishDensity.setPromptText("(1.0 = Default) Enter Fish Denisty.");
		GridPane.setConstraints(fishDensity, 0, 2);
		GridPane.setColumnSpan(fishDensity, COLUMNSPAN);
		setUpWaterScene.getChildren().add(fishDensity);

		TextField sharkDensity = new TextField();
		sharkDensity.setPromptText("(0.4 = Default) Enter Shark Density.");
		GridPane.setConstraints(sharkDensity, 0, 3);
		GridPane.setColumnSpan(sharkDensity, COLUMNSPAN);
		setUpWaterScene.getChildren().add(sharkDensity);

		TextField waterDensity = new TextField();
		waterDensity.setPromptText("(1.0 = Default) Enter Water Density.");
		GridPane.setConstraints(waterDensity, 0, 4);
		GridPane.setColumnSpan(waterDensity, COLUMNSPAN);
		setUpWaterScene.getChildren().add(waterDensity);

		TextField starveTime = new TextField();
		starveTime.setPromptText("(1.0 = Default) Enter Starve Time.");
		GridPane.setConstraints(starveTime, 0, 5);
		GridPane.setColumnSpan(starveTime, COLUMNSPAN);
		setUpWaterScene.getChildren().add(starveTime);
		
		TextField breedTime = new TextField();
		breedTime.setPromptText("(1.0 = Default) Enter Breed Time.");
		GridPane.setConstraints(breedTime, 0, 6);
		GridPane.setColumnSpan(breedTime, COLUMNSPAN);
		setUpWaterScene.getChildren().add(breedTime);


		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 7);
		setUpWaterScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {
			int height = validator.parseIntValue(gridHeightText);
			int width = validator.parseIntValue(gridWidthText);
			double fishDensityAmount = validator.parseIntValue(fishDensity);
			double sharkDensityAmount = validator.parseDoubleValue(sharkDensity);
			double waterDensityAmount = validator.parseDoubleValue(waterDensity);
			int starveTimeAmount = validator.parseIntValue(starveTime);
			int breedTimeAmount = validator.parseIntValue(breedTime);
			
			waterWorldController = new WaterWorld(height,width,fishDensityAmount,sharkDensityAmount, waterDensityAmount, starveTimeAmount, breedTimeAmount);
			setUpNewSimulation(waterWorldController);
		});

		//This only works when the simulation is paused
		Button clearButton = new Button("Clear Simulation");
		GridPane.setConstraints(clearButton, 2, 7);
		setUpWaterScene.getChildren().add(clearButton);
		clearButton.setOnAction((ActionEvent e) -> {
			setUpWaterScene.getChildren().remove(GRID_INDEX_START, setUpWaterScene.getChildren().size());
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
	private void setUpNewSimulation(WaterWorld waterWorldController) {
		waterWorldController.generateGrid(setUpWaterScene);
	}
	
	@Override
	public void doOneStep(double elapsedTime) {
		 waterWorldController.updateGrid(setUpWaterScene);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}
