package states;

public abstract class GameOfLifeMutables extends MutableState {

	public GameOfLifeMutables(int currentStateRow, int currentStateColumn, int burnTime, State[][] allStates) {
		super(currentStateRow, currentStateColumn, allStates);
		// TODO Auto-generated constructor stub
	}

	@Override
	void toListNeighbors(int currentStateRow, int currentStateColumn, State[][] allStates) {
		// TODO Auto-generated method stub
		
	}

}
