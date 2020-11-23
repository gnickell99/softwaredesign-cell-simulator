package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField; 


/***
 * 
 * @author  Jazz
 * View class that acts as a superclass - Set up for view hierarchy to sub class to individual game simulations
 *
 */

public abstract class View extends Application  {

	// Constants
	public static final int WINDOW_SIZE = 600;
	public static final String WINDOW_TITLE = "Cell Simulator";
	public static final int WINDOW_COLUMNSPAN = 20;
	public static final int DEFAULT_GRID_SIZE = 10;
	private boolean paused = false;
	private Button pauseButton;
	private Color BACKGROUND = Color.LIGHTSLATEGRAY;
	private final int MILLISECOND_DELAY = 150;
	protected TextField gridWidthText;
	protected TextField gridHeightText;

	//Sets up the inital display for all simulations to be displayed off of
	GridPane setUpGrid = new GridPane();


	public Scene setUpScene(GridPane setUpGrid) {


		//Setting size for the pane  
		setUpGrid.setMinSize(400, 200); 

		//Setting the padding  
		setUpGrid.setPadding(new Insets(10, 10, 10, 10)); 

		//Setting the vertical and horizontal gaps between the columns 
		setUpGrid.setVgap(5); 
		setUpGrid.setHgap(5);       

		//Setting the Grid alignment 
		setUpGrid.setAlignment(Pos.TOP_LEFT); 

		gridWidthText = new TextField();
		gridWidthText.setPromptText("(4.0 = Default) Enter Grid Width.");
		GridPane.setConstraints(gridWidthText, 0, 0);
		GridPane.setColumnSpan(gridWidthText, WINDOW_COLUMNSPAN);
		setUpGrid.getChildren().add(gridWidthText);



		gridHeightText = new TextField();
		gridHeightText.setPromptText("(4.0 = Default) Enter Grid Height.");
		GridPane.setConstraints(gridHeightText, 0, 1);
		GridPane.setColumnSpan(gridHeightText, WINDOW_COLUMNSPAN);
		setUpGrid.getChildren().add(gridHeightText);


		pauseButton = new Button("Pause Simulation");
		GridPane.setConstraints(pauseButton, 1,6);
		setUpGrid.getChildren().add(pauseButton);
		pauseButton.setOnAction((ActionEvent e) -> {
			pressPause();

		});


		Button stepButton = new Button("Step");
		GridPane.setConstraints(stepButton, 3, 6);
		setUpGrid.getChildren().add(stepButton);

		stepButton.setOnAction((ActionEvent e) -> {


			this.doOneStep(MILLISECOND_DELAY);

		});


		Scene scene = new Scene(setUpGrid, WINDOW_SIZE, WINDOW_SIZE, BACKGROUND);
		return scene;


	}

	/**getHeigthInput
	 * 
	 * returns the height input from the user's input
	 */
	public TextField getHeightInput(TextField gridHeightText) {

		return gridHeightText;

	}

	/**getWidthInput
	 * 
	 * returns the width input from the user's input
	 */
	public TextField getWidthInput(TextField gridWidthText) {

		return gridWidthText;

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
	/** pauseIt
	 * 
	 * Pause the animation (regardless of current state of pause button)
	 * @param pauseButton 
	 */
	public void pauseIt(Button pauseButton){
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

	abstract public void doOneStep(double elapsedTime);






}

