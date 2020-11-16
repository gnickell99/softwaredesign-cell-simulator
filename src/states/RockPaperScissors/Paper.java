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
		// TODO Auto-generated method stub
		return null;
	}

}
