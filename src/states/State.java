package states;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/***
 * 
 * @author Grant Nickell
 * 
 * This is the State abstract class at the top of the hierarchies of states
 * It sets up a constructor for states that gives it the size, shape, and color
 * This class also has the logic for neighbors
 *
 */

public abstract class State {
	Shape state;
	public Paint cellColor;
	private static final int CELL_SIZE = 10;

	public final int NORTH_NEIGHBOR = 0;
	public final int SOUTH_NEIGHBOR = 1;
	public final int WEST_NEIGHBOR = 2;
	public final int EAST_NEIGHBOR = 3;
	
	public State() {
		state = new Rectangle(CELL_SIZE, CELL_SIZE);
		state.setFill(cellColor);
	}
	
	/** act
	 * this is the abstract method that mutable states will use to change to a different state
	 * immutable states will do nothing
	 * 
	 * @param currentStateRow - the current row for the particular state, used to find neighbors
	 * @param currentStateColumn - the current column for the particular state, used to find neighbors
	 * @param allStates - the 2D array of all other states
	 * @return act will return a new state if the conditions for a change are met, otherwise it will return the current state
	 */
	public abstract State act(int currentStateRow, int currentStateColumn);
	
	/** getType
	 * 
	 * @return - returns the name of the state as a string, see constants above
	 */
	public abstract String getType();

	public Node getState() {
		return state;
	}
	
	/** getState
	 * 
	 * @return - returns the state as a node so it can be used in java fx
	 */
	public Node getRectangle() {
		return new Rectangle(CELL_SIZE, CELL_SIZE, this.cellColor);
	}
	
}
