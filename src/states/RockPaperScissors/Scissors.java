package states.RockPaperScissors;

import java.util.List;

import javafx.scene.paint.Color;
import states.State;

public class Scissors extends RPSMutables {

	public Scissors(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn, threshold);
		cellColor = Color.BLUE;
	}

	@Override
	public State act(List<State> neighbors) {
		// TODO Auto-generated method stub
		return null;
	}

}
