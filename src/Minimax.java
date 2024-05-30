
/*
 * The University of North Carolina at Charlotte
 * ITCS 3153 - Intro to Artificial Intelligence
 * 
 * Programming Assignment 2 - Adversarial Search
 * 
 * Based on code from Dilip Kumar Subramanian
 * 
 * Modified by Julio C. Bahamon
 */

import java.util.ArrayList;

public class Minimax {
	private static String AI_LETTER = "O";
	private static String PLAYER_LETTER = "X";

	/**
	 *
	 * This will recursively call Minimax depending on the current player, if the
	 * current player is O, the algorithm will find the MAX available board and if
	 * the current player is X, the algorithm will find the MIN avaiLable board.
	 * 
	 * We assume that the human player is X and that the AI is O
	 * 
	 * The terminal state check is done at the start before recursively calling
	 * Minimax, the terminal checks are checkWinner for player X(Human) and O(AI)
	 * and if the board state is full, if either of the conditions gets satisfied
	 * then it will return the value as decided if winner is AI(O), assign +1, if
	 * winner is User(X) assign -1 and if the state is draw assign 0 and return
	 *
	 * @param state  board for which the Minimax will be called recursively
	 * @param player player for whom the game state should be generated
	 * @return boolean true/false
	 **/
	public static int miniMax(GameState state, String player) {
		GameAI.setTotalCount(GameAI.getTotalCount() + 1);

		String[] array1 = state.getBoardState();

		if (player.equalsIgnoreCase(AI_LETTER) && state.checkWinner(array1, AI_LETTER)) {
			return -1;
		} else if (player.equalsIgnoreCase(PLAYER_LETTER) && state.checkWinner(array1, PLAYER_LETTER)) {
			return 1;
		} else if (state.boardFullCheck(array1) == true) {

			return 0;
		}

		if (player.equalsIgnoreCase(PLAYER_LETTER)) {
			int best = (int) Double.NEGATIVE_INFINITY;
			ArrayList<GameState> arrayList1 = state.generateSuccessors(state, player);
			for (GameState childState : arrayList1) {
				int tempBest = miniMax(childState, AI_LETTER);
				best = Math.max(best, tempBest);

			}
			return best;
		} else {
			int best = (int) Double.POSITIVE_INFINITY;
			ArrayList<GameState> arrayList2 = state.generateSuccessors(state, player);
			for (GameState childState : arrayList2) {
				int tempBest = miniMax(childState, PLAYER_LETTER);
				best = Math.min(best, tempBest);
			}
			return best;
		}

		// for(GameState gs1 : arrayList1) {
		// if (state.boardFullCheck(array1) == false) {

		// }
		// if (state.boardFullCheck(array1) == true )
		// if (player.equalsIgnoreCase(AI_LETTER)) {

		// best = miniMax(state, PLAYER_LETTER);
		// }
		// else {
		// best = miniMax(state, AI_LETTER);
		// }
		// }
		// for(state.) {
		// best = miniMax(state, "X");
		// return (int)best;

		// }
		// TODO: Implement the minimax function

		/*
		 * HINTS:
		 * 
		 * Use Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY for the
		 * initialization values
		 * 
		 * Use the checkWinner method in GameState to check leaf nodes
		 * 
		 * Use boardFullCheck method in GameState to check for tied games
		 * 
		 * Use the printBoardStateMax to produce debug output
		 * 
		 */

//		DEBUG OUTPUT CODE
//		Log.debug("Inside maxValue " + " " + value);
//		Log.debug("Inside minValue " + " " + best);

	}
}