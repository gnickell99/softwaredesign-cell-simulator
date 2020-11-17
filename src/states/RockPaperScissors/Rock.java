package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Rock extends RPSMutables {

	public Rock(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn, threshold);
		cellColor = Color.RED;
	}

	@Override
	public State act(List<State> neighbors) {
		if (countEnemyNeighbors(neighbors) >= winThreshold) {
			return new Paper(this.currentRow, this.currentColumn, this.winThreshold);
		}
		return this;
	}

	@Override
	String getType() {
		return "rock";
	}

}
