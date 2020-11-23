package states.Wildfire;

import java.util.List;

//import controller.Controller;
import javafx.scene.paint.Color;
import states.State;

/***
 * 
 * @author Grant Nickell
 *
 * The BurningTree Class is a state that inherits from MutableState,
 * When found as a neighbor can spread the fire to a living tree,
 * the burning tree itself will continue to burn until burn time runs out
 *
 */

public class BurningTree extends WildFireMutables {
	
	public BurningTree(int burnTime) {
		super(burnTime);
		cellColor = Color.RED;
	}

	/**
	 * If the burn timer has reached 0, the burning tree will burn down
	 * (enter the burnt down tree state) and no longer be able to spread fire
	 */
	@Override
	public State act(List<State> neighbors) {
		if (burnTimer == 0) {
			return new BurntDownTree();
		}
		this.burnTimer--;
		return this;
		
	}

}
