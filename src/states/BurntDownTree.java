package states;

import javafx.scene.paint.Color;

public class BurntDownTree extends ImmutableState{

	public BurntDownTree() {
		super();
		cellColor = Color.YELLOW;
	}

	@Override
	public String getType() {
		return this.BURNT_DOWN_TREE;
	}

}
