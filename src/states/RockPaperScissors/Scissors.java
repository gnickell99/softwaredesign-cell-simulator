package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 * 
 * The Scissors class is a state for the rock paper scissors cell simulator
 * It is beaten by rock and will change to the rock state when it loses
 * to too many of its neighbors
 *
 */

public class Scissors extends RPSMutables {

	public Scissors(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn, threshold);
		cellColor = Color.BLUE;
	}

	@Override
	public State act(List<State> neighbors) {
		if (countEnemyNeighbors(neighbors) >= winThreshold) {
			return new Rock(this.currentRow, this.currentColumn, this.winThreshold);
		}
		return this;
	}

	@Override
	boolean losesTo(State state) {
		return state.cellColor.equals(Color.RED);
	}

}
