package states;

import javafx.scene.paint.Color;

public class Empty extends ImmutableState{

	public Empty() {
		super();
		cellColor = Color.BROWN;
	}

	@Override
	public String getType() {
		return this.EMPTY_CELL;
	}


}

