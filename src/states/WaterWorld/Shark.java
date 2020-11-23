package states.WaterWorld;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Shark extends WaterWorldMutables {
	
	int starveTimer;
	int currentStarveTime;
	int breedTimer;
	int currentBreedTime;

	public Shark(int breedTime, int starveTime) {
		super();
		cellColor = Color.YELLOW;
		starveTimer = starveTime;
		currentStarveTime = starveTimer;
		breedTimer = breedTime;
		currentBreedTime = breedTimer;
	}

	@Override
	public State act(List<State> neighbors) {
		for (State neighbor : neighbors) {
			WaterWorldMutables waTorNeighbor = (WaterWorldMutables) neighbor;
			if (waTorNeighbor.cellColor.equals(Color.BLUE)) {
				if (currentBreedTime == 0) {
					waTorNeighbor.setNext(new Shark(this.breedTimer, this.starveTimer));
					return new Shark(this.currentBreedTime-1, this.currentStarveTime-1);
				}
				else {
					waTorNeighbor.setNext(new Shark(this.currentBreedTime-1, currentStarveTime-1));
					return new Water();
				}
			}
			else if (waTorNeighbor.cellColor.equals(Color.GREEN)) {
				waTorNeighbor.setNext(new Water());
				return new Shark(this.currentBreedTime-1, this.starveTimer);
			}
		}
		currentBreedTime--;
		currentStarveTime--;
		return this;
	}

}
