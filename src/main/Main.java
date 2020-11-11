package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import view.SimulationSelector;

public class Main extends Application {

	
	public static final Paint BACKGROUND = Color.LIGHTSLATEGREY;
	private Scene simulationScene;
	public static final String TITLE = "Cell Simulator";
	
	
	/*
	 * Starts the program that simulates Conway's Game of Life.  
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		SimulationSelector selector = new SimulationSelector();
		simulationScene = selector.setupScene(BACKGROUND);
		stage.setScene(simulationScene);
		stage.setTitle(TITLE);
		stage.show();
	}
	
}
