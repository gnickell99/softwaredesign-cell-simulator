package view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class SimulationSelector {

	
	GridPane setupGrid = new GridPane();
	public static final int SIZE = 600;
	public static final String TITLE = "Cell Simulator";
	public static final int COLUMNSPAN = 20;
	
	public Scene setupScene(Paint background) {
		setupGrid.setPadding(new Insets(10, 10, 10, 10));
		setupGrid.setVgap(10);
		setupGrid.setHgap(10);
		InputParser parser = new InputParser();
		
		final TextField gridWidth = new TextField();
		gridWidth.setPromptText("(4.0 = Default) Enter Grid Width.");
		GridPane.setConstraints(gridWidth, 0, 0);
		GridPane.setColumnSpan(gridWidth, COLUMNSPAN);
		setupGrid.getChildren().add(gridWidth);

		final TextField gridHeight = new TextField();
		gridHeight.setPromptText("(4.0 = Default) Enter Grid Height.");
		GridPane.setConstraints(gridHeight, 0, 1);
		GridPane.setColumnSpan(gridHeight, COLUMNSPAN);
		setupGrid.getChildren().add(gridHeight);
		
		Button wildFire = new Button("WildFire");
		GridPane.setConstraints(wildFire, 0, 3);
		setupGrid.getChildren().add(wildFire);

		Button gameOfLife = new Button("Game Of Life");
		GridPane.setConstraints(gameOfLife, 0, 4);
		setupGrid.getChildren().add(gameOfLife);
		
		wildFire.setOnAction((ActionEvent e) -> {
			//WildFireSimulation wildFireSim = new WildFireSimulation(parser.parseIntegerValue(gridWidth), parser.parseIntegerValue(gridHeight));
		});
		
		gameOfLife.setOnAction((ActionEvent e) -> {
			//GameOfLIfe gameOfLifeSim = new GameOfLife(parser.parseIntegerValue(gridWidth), parser.parseIntegerValue(gridHeight));
		});
		
		Scene scene = new Scene(setupGrid, SIZE, SIZE, background);
		return scene;
	}
}
