package states.RockPaperScissors;

import java.util.List;
import states.*;

/***
 * 
 * @author Grant Nickell
 * 
 * RPSMutables is an abstract super class inheriting from MutableState
 * that is used by the mutable states in rock paper scissors
 * 
 * When the inheriting states act, they change state when the number
 * of neighboring weaknesses exceeds the win threshold described by the user
 *
 */

public abstract class RPSMutables extends State {
	int winThreshold;
	
	public RPSMutables(int threshold) {
		super();
		winThreshold = threshold;
	}
	
	/** countEnemyNeighbors
	 * 
	 * This method loops through the neighbors and increases the weakness count
	 * whenever the neighbor beats the current cell
	 * 
	 * This is used for logic in determining when to change states
	 * 
	 * @param neighbors
	 * @return weaknessCount - an integer count of the neighbors that the current cell loses to
	 */
	int countEnemyNeighbors(List<State> neighbors) {
		int weaknessCount = 0;
		for (State neighbor : neighbors) {
			if (this.losesTo(neighbor)) {
				weaknessCount++;
			}
		}
		return weaknessCount;
	}
	
	/** losesTo
	 * 
	 * This method simply returns the state that the current state loses to
	 * i.e. rock -> paper; paper -> scissors; scissors -> rock
	 * This is used in countEnemyNeighbors to determine if the neighbor
	 * is the weakness of the current cell
	 * 
	 * @param state - the state to be compared to
	 * @return - boolean value of interaction between a cell and its neighbor in rock paper scissors
	 */
	abstract boolean losesTo(State state);

}
