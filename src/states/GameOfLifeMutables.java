package states;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.GameOfLife;

public abstract class GameOfLifeMutables extends MutableState {
	Random RNG = new Random();
	GameOfLife golController;
	
	public GameOfLifeMutables(int currentStateRow, int currentStateColumn) {
		super(currentStateRow, currentStateColumn);
	}

}
