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

	public Paper(int threshold) {
		super(threshold);
		cellColor = Color.WHITE;
	}

	@Override
	public State act(List<State> neighbors) {
		if (countEnemyNeighbors(neighbors) >= winThreshold) {
			return new Scissors(this.winThreshold);
		}
		return this;
	}

	@Override
	boolean losesTo(State state) {
		return state.cellColor.equals(Color.BLUE);
	}

}
