package states;

/***
 * 
 * @author Grant Nickell
 * 
 * This abstract class is fairly simple, it removes immutable states' ability to act
 * These include edge, empty, and burnt down tree
 * 
 */

public abstract class ImmutableState extends State{

	final String BURNT_DOWN_TREE = "burnt down tree";
	final String EMPTY_CELL = "empty cell";
	final String EDGE = "edge";
	final String DEAD_CELL = "dead cell";
	
	public ImmutableState() {
		super();
	}
	
	@Override
	public State act(int currentStateRow, int currentStateColumn) {
		return this;
	}

}
