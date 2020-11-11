package view;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class GameOfLife {

	GridPane setUpLifeScene = new GridPane();
	public static final int SIZE = 600;
	public static final String TITLE = "Game Of Life Simulator";
	public static final int COLUMNSPAN = 20;
	private boolean paused = false;		
	private Button pauseButton;

	InputParser validateUserInput = new InputParser();
	public GameOfLife(int i, int j) {
	

	}

	
	/** setUpGameOfLifeScene
	 * 
	 * Creates each button need for the game of life simulation
	 * and adds them to the grid pane to be displayed to the user
	 * @returns scene for game of life visuals
	 * 
	 */
	public Scene setUpGameOfLifeScene(Paint background) {

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
			setUpNewSimulation();

		});

		Button pauseButton = new Button("Pause Simulation");
		GridPane.setConstraints(pauseButton, 0, 3);
		setUpLifeScene.getChildren().add(pauseButton);
		pauseButton.setOnAction((ActionEvent e) -> {
			pressPause();

		});
		
		Scene scene = new Scene(setUpLifeScene, SIZE, SIZE, background);
		return scene;

	}

	/** setUpNewSimulation
	 * 
	 * Sets up a new simulation with inputs from gridWith and gridHeight
	 */
	private void setUpNewSimulation() {
		// TODO Auto-generated method stub

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
		if(!paused) {
			doOneStep(elapsedTime);
		}
	}
	
	/*doOneStep
	 * 
	 * Does a step in the search regardless of pause status. Uses controller to make step
	 */
	public void doOneStep(double elapsedTime){
		//controller.makeStep();
	}



}
