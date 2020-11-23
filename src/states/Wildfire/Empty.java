package states.Wildfire;

import javafx.scene.paint.Color;
import states.ImmutableState;

/***
 * 
 * @author Grant Nickell
 *
 * The Empty state is generated randomly depending on the forest density
 * 
 */

public class Empty extends ImmutableState{

	public Empty() {
		super();
		cellColor = Color.SADDLEBROWN;
	}

}

