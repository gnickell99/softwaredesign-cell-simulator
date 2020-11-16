package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.MutableState;
import states.State;
import states.GameOfLife.DeadCell;

public abstract class RPSMutables extends MutableState {

	int winThreshold;
	
	public RPSMutables(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn);
		winThreshold = threshold;
	}
	
	
	@Override
	public State act(List<State> neighbors) {
		int weaknessCount = 0;
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(Color.LIGHTBLUE)) {
				weaknessCount++;
			}
		}
		return this;
	}

}
