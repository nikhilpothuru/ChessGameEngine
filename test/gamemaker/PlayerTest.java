package gamemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import board.GameBoard;
import board.Tile;
import pieces.Pawn;

class PlayerTest {
	
	Player player1;
	Player player2;
	
	@BeforeEach
	void init() { 
		player1 = new Player(true);
		player2 = new Player(false);
	}
	
	@Nested
	class PawnMovementCheck{
		
		@Test
		@DisplayName("Players Move Opposite Color Pawn")
		void check_0_1(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			boolean check = player2.movePiece(board[1][0], board[2][0]);
			assertFalse(check);
			// Check Black Pawn
			boolean check2 = player1.movePiece(board[6][0], board[5][0]);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
			assertFalse(check2);
		}
		
		@Test
		@DisplayName("Move Pawn Up - +1 from Start")
		void check_1_1(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			boolean check = player1.movePiece(board[1][0], board[2][0]);
			assertEquals(true, check);
			// Check Black Pawn
			boolean check2 = player2.movePiece(board[6][0], board[5][0]);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
			assertEquals(true, check2);
		}
		
		@Test
		@DisplayName("Move Pawn Up - +2 from Start")
		void check_1_2(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			boolean check = player1.movePiece(board[1][0], board[3][0]);
			assertEquals(true, check);
			// Check Black Pawn
			boolean check2 = player2.movePiece(board[6][0], board[4][0]);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
			assertEquals(true, check2);
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Right - No Obstruction")
		void check_2_1(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard();
			// Check White Pawn
			boolean check = player1.movePiece(board[1][0], board[2][1]);
			assertFalse(check);
			// Check Black Pawn
			boolean check2 = player2.movePiece(board[6][1], board[5][0]);
			assertFalse(check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Left - No Obstruction")
		void check_2_2(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			boolean check = player1.movePiece(board[1][1], board[2][0]);
			assertFalse(check);
			// Check Black Pawn
			boolean check2 = player2.movePiece(board[6][1], board[5][2]);
			assertFalse(check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Right - Obstruction (Same Color)")
		void check_3_1(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			board[2][1].setPiece(new Pawn(true));
			boolean check = player1.movePiece(board[1][0], board[2][1]);
			assertFalse(check);
			// Check Black Pawn
			board[5][0].setPiece(new Pawn(false));
			boolean check2 = player2.movePiece(board[6][1], board[5][0]);
			assertFalse(check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Left - Obstruction (Same Color)")
		void check_3_2(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard();
			// Check White Pawn
			board[2][0].setPiece(new Pawn(true));
			boolean check = player1.movePiece(board[1][1], board[2][0]);
			assertFalse(check);
			// Check Black Pawn
			board[5][2].setPiece(new Pawn(false));
			boolean check2 = player2.movePiece(board[6][1], board[5][2]);
			assertFalse(check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Right - Obstruction (Different Color)")
		void check_4_1(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			// Check White Pawn
			board[2][1].setPiece(new Pawn(false));
			boolean check = player1.movePiece(board[1][0], board[2][1]);
			assertEquals(true, check);
			// Check Black Pawn
			board[5][0].setPiece(new Pawn(true));
			boolean check2 = player2.movePiece(board[6][1], board[5][0]);
			assertEquals(true, check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
		
		@Test
		@DisplayName("Move Pawn Diagonal Left - Obstruction (Different Color)")
		void check_4_2(TestInfo testInfo, TestReporter testReporter) {
			GameBoard.getInstance().setBoard();
			Tile[][] board = GameBoard.getInstance().getBoard(); 
			board[2][0].setPiece(new Pawn(false));
			boolean check = player1.movePiece(board[1][1], board[2][0]);
			assertEquals(true, check);
			// Check Black Pawn
			board[5][2].setPiece(new Pawn(true));
			boolean check2 = player2.movePiece(board[6][1], board[5][2]);
			assertEquals(true, check2);
			testReporter.publishEntry("\n" + GameBoard.getInstance().toString() + "\n");
		}
	}
}
