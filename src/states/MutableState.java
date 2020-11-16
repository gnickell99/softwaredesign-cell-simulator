package states;

import java.util.ArrayList;
import java.util.List;

//import controller.Controller;

/***
 * 
 * @author Grant Nickell
 * 
 * The abstract MutableState class inherits from a standard state
 * and adds functionality for states that are able to change to a new state.
 *
 */

public abstract class MutableState extends State{
	
	protected int currentRow;
	protected int currentColumn;
	
	public MutableState(int currentStateRow, int currentStateColumn) {
		super();
		currentRow = currentStateRow;
		currentColumn = currentStateColumn;
	}

	/** toListNeighbors
	 * This method creates an array list of neighbors for a mutable state
	 * 
	 * @param currentStateRow - the current row for the particular state, used to find neighbors
	 * @param currentStateColumn - the current column for the particular state, used to find neighbors
	 * @param allStates - the 2D array of all other states
	 */
	//abstract List<State> toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates);
	
}
