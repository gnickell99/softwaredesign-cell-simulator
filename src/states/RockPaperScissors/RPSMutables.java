package states.RockPaperScissors;

import java.util.HashMap;
import java.util.List;

import javafx.scene.paint.Color;
import states.MutableState;
import states.State;

public abstract class RPSMutables extends MutableState {

	int winThreshold;
	private HashMap<String, Color> weaknessColors = new HashMap<String, Color>();
	
	public RPSMutables(int currentStateRow, int currentStateColumn, int threshold) {
		super(currentStateRow, currentStateColumn);
		winThreshold = threshold;
		setupWeaknessColors();
	}
	
	
	int countEnemyNeighbors(List<State> neighbors) {
		int weaknessCount = 0;
		for (State neighbor : neighbors) {
			if (neighbor.cellColor.equals(this.weaknessColors.get(this.getType()))) {
				weaknessCount++;
			}
		}
		return weaknessCount;
	}
	
	
	void setupWeaknessColors() {
		weaknessColors.put("rock", Color.WHITE);
		weaknessColors.put("paper", Color.BLUE);
		weaknessColors.put("scissors", Color.RED);
	}
	
	
	abstract String getType();

}
