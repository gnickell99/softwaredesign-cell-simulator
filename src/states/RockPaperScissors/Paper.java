package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 * 
 * The Paper class is a state for the rock paper scissors cell simulator
 * It is beaten by scissors and will change to the scissors state when it loses
 * to too many of its neighbors
 *
 */

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
	boolean losesTo(State state) {
		return state.cellColor.equals(Color.BLUE);
	}

}
