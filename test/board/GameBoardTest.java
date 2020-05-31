package board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import pieces.Pawn;

class GameBoardTest {
	 
	Tile[][] board; 
	
	@BeforeEach
	void init() { 
		board = GameBoard.getInstance().getBoard();
	}
	
	@Test
	@DisplayName("Test Board setUp() method")
	void checkSetUp() {
		GameBoard.getInstance().setBoard();
		// Check if row 1 has all Pawns
		for(int i = 0; i < board[1].length; i++) {
			boolean checkInstance = board[1][i].getPiece() instanceof Pawn;
			boolean checkColor = board[1][i].getPiece().isWhite();
			int temp = i;
			assertEquals(true, checkInstance, 
					() -> "y: 1, x: " + temp + ", is does not have a Pawn on setup");
			assertEquals(true, checkColor, 
					() -> "y: 1, x: " + temp + ", is not a white Pawn on setup");
		}
		// Check if row 6 has all Pawns
		for(int i = 0; i < board[6].length; i++) {
			boolean checkInstance = board[6][i].getPiece() instanceof Pawn;
			boolean checkColor = board[6][i].getPiece().isWhite();
			int temp = i;
			assertEquals(true, checkInstance, 
					() -> "y: 1, x: " + temp + ", is does not have a Pawn on setup");
			assertFalse(checkColor, 
					() -> "y: 1, x: " + temp + ", is not a black Pawn on setup");
		}
	}

	@Test
	@DisplayName("Test Board toString() Method")
	void checkToString(TestReporter testReporter) { 
		GameBoard.getInstance().setBoard();
		testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
	}

}
