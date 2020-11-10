package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

public class SimulationSelector {

	
	GridPane setupGrid = new GridPane();
	public static final int SIZE = 600;
	public static final String TITLE = "Cell Simulator";
	
	public Scene setupScene(Paint background) {
		setupGrid.setPadding(new Insets(10, 10, 10, 10));
		setupGrid.setVgap(10);
		setupGrid.setHgap(10);
		
		Scene scene = new Scene(setupGrid, SIZE, SIZE, background);
		return scene;
	}

}
