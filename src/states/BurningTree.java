package states;

//import controller.Controller;
import javafx.scene.paint.Color;

/***
 * 
 * @author Grant Nickell
 *
 * The BurningTree Class is a state that inherits from MutableState,
 * When found as a neighbor can spread the fire to a living tree,
 * the burning tree itself will continue to burn until burn time runs out
 *
 */

public class BurningTree extends WildFireMutables{

	public BurningTree(int currentStateRow, int currentStateColumn, int burnTime, State[][] allStates) {
		super(currentStateRow, currentStateColumn, burnTime, allStates);
		cellColor = Color.RED;
	}

	@Override
	public State act(int currentStateRow, int currentStateColumn) {
		if (burnTimer == 0) {
			return new BurntDownTree();
		}
		this.burnTimer--;
		return this;
		
	}

	@Override
	public String getType() {
		return "burning tree";
	}

}