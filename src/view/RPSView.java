package view;


import controller.RockPaperScissors;
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
 * RockPaperScissors - Set up for RPS display
 *
 */
public class RPSView extends View {
	
	private static final int GRID_INDEX_START = 10;
	GridPane setUpRpsScene = new GridPane();
	private final int MILLISECOND_DELAY = 150;
	public static final int SIZE = 600;
	private static final String TITLE = "Rock Paper Scissor Simulation ";
	public static final int COLUMNSPAN = 20;
	private RockPaperScissors rpsController = new RockPaperScissors(0, 0, 0);
	

	public RPSView(int gridHeight, int gridWidth)
	{
		
	}
	
	public void setUpRpsScene(Paint background) {

		Scene secondScene = setUpScene(setUpRpsScene);
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);
		
		TextField winThresholdText = new TextField();
		winThresholdText.setPromptText("(1.0 = Default) Enter Win Threshold.");
		GridPane.setConstraints(winThresholdText, 0, 2);
		GridPane.setColumnSpan(winThresholdText, COLUMNSPAN);
		setUpRpsScene.getChildren().add(winThresholdText);

		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 7);
		setUpRpsScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {

		int height = Integer.parseInt(gridHeightText.getText());
		int width = Integer.parseInt(gridWidthText.getText());
		int winThreshold = Integer.parseInt(winThresholdText.getText());
		rpsController = new RockPaperScissors(height, width, winThreshold);

		setUpNewSimulation(rpsController);

		});
		
		//This only works when the simulation is paused, but clears any current simulation on the scene
				Button clearButton = new Button("Clear Simulation");

				GridPane.setConstraints(clearButton, 2, 7);


				setUpRpsScene.getChildren().add(clearButton);
				clearButton.setOnAction((ActionEvent e) -> {
				setUpRpsScene.getChildren().remove(GRID_INDEX_START, setUpRpsScene.getChildren().size());
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
	 * @param rpsController 
	 */
	public void setUpNewSimulation(RockPaperScissors rpsController) {
		rpsController.generateGrid(setUpRpsScene);

	}
	
	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	@Override
	public void doOneStep(double elapsedTime) {
		rpsController.updateGrid(setUpRpsScene);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
