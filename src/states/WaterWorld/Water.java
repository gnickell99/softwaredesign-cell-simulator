package states.WaterWorld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Water extends WaterWorldMutables {

	public Water() {
		super();
		cellColor = Color.BLUE;
	}

	@Override
	public State act(List<State> neighbors) {
		return this;
	}

}
