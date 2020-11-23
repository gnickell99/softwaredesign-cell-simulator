package states.WaterWorld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Fish extends WaterWorldMutables {

	int breedTimer;
	int currentBreedTime;
	
	public Fish(int breedTime) {
		super();
		cellColor = Color.GREEN;
		breedTimer = breedTime;
		currentBreedTime = breedTimer;
		
	}

	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			//If it's not an edge
			if (!neighbor.cellColor.equals(Color.BLACK)) {
				WaterWorldMutables waterNeighbor = (WaterWorldMutables) neighbor;
				if (waterNeighbor.cellColor.equals(Color.BLUE) ) {
					if (currentBreedTime == 0) {
						waterNeighbor.setNext(new Fish(this.breedTimer));
						return new Fish(this.breedTimer);
					}
					else {
						waterNeighbor.setNext(new Fish(this.currentBreedTime-1));
						return new Water();
					}
				}
			}
		}
		currentBreedTime--;
		return this;
	}

}
