package states;

import javafx.scene.paint.Color;

public class DeadCell extends ImmutableState{
	
	public DeadCell() {
		super();
		cellColor = Color.WHITE;
	}

	@Override
	public String getType() {
		return this.DEAD_CELL;
	}

}
