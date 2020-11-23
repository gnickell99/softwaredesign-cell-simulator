package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

	GridPane setUpRpsScene = new GridPane();
	private final int MILLISECOND_DELAY = 150;
	public static final int SIZE = 600;
	private static final String TITLE = "Rock Paper Scissor Simulation ";
	public static final int COLUMNSPAN = 20;
	
	

	public RPSView(int gridHeight, int gridWidth)
	{
		
	}
	
	public void setUpRpsScene(Paint background) {

		Scene secondScene = setUpScene(setUpRpsScene);
		Stage newWindow = new Stage();
		newWindow.setTitle(TITLE);
		newWindow.setScene(secondScene);

		Button newSimulationButton = new Button("New Simulation");
		GridPane.setConstraints(newSimulationButton, 0 , 6);
		setUpRpsScene.getChildren().add(newSimulationButton);
		newSimulationButton.setOnAction((ActionEvent e) -> {

		int height = Integer.parseInt(gridHeightText.getText());
		int width = Integer.parseInt(gridWidthText.getText());
		//gameOfLifeController = new GameOfLife(height, width);

		//setUpNewSimulation(gameOfLifeController);

		});


		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();

		newWindow.show();

	}
	
	
	@Override
	public void doOneStep(double elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
