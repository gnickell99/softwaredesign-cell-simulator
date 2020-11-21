package states.Waterworld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Shark extends WaterWorldMutables {
	
	int starveTimer;

	public Shark(int starveTime) {
		super();
		cellColor = Color.YELLOW;
		starveTimer = starveTime;
	}

	@Override
	public State act(List<State> neighbors) {
		// TODO Auto-generated method stub
		return null;
	}

}
