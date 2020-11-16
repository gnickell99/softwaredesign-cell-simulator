package states;

import java.util.ArrayList;
import java.util.List;

public abstract class WildFireMutables extends MutableState {
	
	int burnTimer;
	double chanceToBurn;
	
	public WildFireMutables(int currentStateRow, int currentStateColumn, int burnTime) {
		super(currentStateRow, currentStateColumn);
		burnTimer = burnTime;
	}

}
