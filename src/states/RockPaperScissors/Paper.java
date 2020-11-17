package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Paper extends RPSMutables {

	public Paper(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn, threshold);
		cellColor = Color.WHITE;
	}

	@Override
	public State act(List<State> neighbors) {
		if (countEnemyNeighbors(neighbors) >= winThreshold) {
			return new Scissors(this.currentRow, this.currentColumn, this.winThreshold);
		}
		return this;
	}

	@Override
	String getType() {
		return "paper";
	}

}
