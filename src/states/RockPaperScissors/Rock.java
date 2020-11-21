package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 * 
 * The Rock class is a state for the rock paper scissors cell simulator
 * It is beaten by paper and will change to the paper state when it loses
 * to too many of its neighbors
 *
 */

public class Rock extends RPSMutables {

	public Rock(int threshold) {
		super(threshold);
		cellColor = Color.RED;
	}

	@Override
	public State act(List<State> neighbors) {
		if (countEnemyNeighbors(neighbors) >= winThreshold) {
			return new Paper(this.winThreshold);
		}
		return this;
	}

	@Override
	boolean losesTo(State state) {
		return state.cellColor.equals(Color.WHITE);
	}

}
