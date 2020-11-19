package states;

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
	
}
