package states.Waterworld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Shark extends WaterWorldMutables {

	public Shark(int currentStateRow, int currentStateColumn, double starveTime, double breedTime) {
		super(currentStateRow, currentStateColumn, starveTime, breedTime);
		cellColor = Color.YELLOW;
	}

	@Override
	public State act(List<State> neighbors) {
		// TODO Auto-generated method stub
		return null;
	}

}
