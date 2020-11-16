package states.Waterworld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Fish extends WaterWorldMutables {

	public Fish(int currentStateRow, int currentStateColumn, double starveTime, double breedTime) {
		super(currentStateRow, currentStateColumn, starveTime, breedTime);
		cellColor = Color.GREEN;
	}

	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.BLUE)) {
				
			}
		}
		return this;
	}

}
