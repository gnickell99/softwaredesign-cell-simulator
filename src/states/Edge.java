package states;

import javafx.scene.paint.Color;

/***
 * 
 * @author Grant Nickell
 * 
 * The edge state is placed along the perimeter of the grid
 * As an immutable state, it cannot change to another state
 *
 */

public class Edge extends ImmutableState{

	public Edge() {
		super();
		cellColor = Color.BLACK;
	}
	
}
