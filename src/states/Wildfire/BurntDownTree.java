package states.Wildfire;

import javafx.scene.paint.Color;
import states.ImmutableState;

/***
 * 
 * @author Grant Nickell
 *
 * This is an immutable state that can only be reached when
 * a burning tree's burn timer has reached 0
 * At which point it is no longer able to spread fire
 *
 */

public class BurntDownTree extends ImmutableState{

	public BurntDownTree() {
		super();
		cellColor = Color.YELLOW;
	}

}
