package states.Waterworld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Fish extends WaterWorldMutables {
	
	int breedTimer;

	public Fish(int breedTime) {
		super();
		cellColor = Color.GREEN;
		breedTimer = breedTime;
	}

	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			WaterWorldMutables waterNeighbor = (WaterWorldMutables)neighbor;
			if (waterNeighbor.cellColor.equals(Color.BLUE)) {
				waterNeighbor.setNext(new Fish(this.breedTimer));
				return new Water();
			}
		}
		return this;
	}

}
