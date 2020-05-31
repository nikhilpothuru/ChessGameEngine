package pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import board.GameBoard;
import board.Tile;

class PawnTest {
	
	Tile[][] board; 
	Tile tileBottomLeft;
	Tile tileBottomMiddle;
	Tile tileBottomRight;
	Tile tileMiddleLeft;
	Tile tileMiddleMiddle;
	Tile tileMiddleRight;
	Tile tileTopLeft;
	Tile tileTopMiddle;
	Tile tileTopRight;
	
	@BeforeEach
	void init() {
		board = GameBoard.getInstance().getBoard();
		tileBottomLeft = new Tile(new Pawn(true), 0, 0);
		tileBottomMiddle = new Tile(new Pawn(true), 0, 1);
		tileBottomRight = new Tile(new Pawn(true), 0, 2);
		tileMiddleLeft = new Tile(null, 1, 0);
		tileMiddleMiddle = new Tile(null, 1, 1);
		tileMiddleRight = new Tile(null, 1, 2);
		tileTopLeft = new Tile(new Pawn(false), 2, 0);
		tileTopMiddle = new Tile(new Pawn(false), 2, 1);
		tileTopRight = new Tile(new Pawn(false), 2, 2);
	}
	
	@Nested
	class isValidMove{
		
		@Test
		@DisplayName("Pawn Up - No obstruction")
		void checkIsValidUp_1_1() {
			GameBoard.getInstance().setBoard();
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[2][i]);
				assertEquals(true, check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp + " is valid, but it returns false.");
			}
			// Black - Move up one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[5][i]);
				assertEquals(true, check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp + " is valid, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up - Obstruction (Same Color)")
		void checkIsValidUp_1_2() {
			GameBoard.getInstance().setBoard();
			// Set row 2 to all white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(true));
				
			}
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[2][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp + " is invalid, but it returns true.");
			}
			
			// Set row 5 to all black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Black - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[5][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp + " is invalid, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up - Obstruction (Different Color)")
		void checkIsValidUp_1_3() {
			GameBoard.getInstance().setBoard();
			// Set row 2 to all white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(false));
				
			}
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[2][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp + " is invalid, but it returns true.");
			}
			
			// Set row 5 to all black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Black - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[5][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp + " is invalid, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down - No obstruction")
		void checkIsValidUp_1_4() {
			GameBoard.getInstance().setBoard();
			// White - Move down one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[0][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp + " is invalid, but it returns true.");
			}
			// Black - Move down one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[7][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp + " is invalid, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down - Obstruction (Same Color)")
		void checkIsValidUp_1_5() {
			GameBoard.getInstance().setBoard();
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(true));
				
			}
			// White - Move down one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[0][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp + " is invalid, but it returns true.");
			}
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Black - Move down one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[7][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp + " is invalid, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down - Obstruction (Different Color)")
		void checkIsValidUp_1_6() {
			GameBoard.getInstance().setBoard();
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(false));
				
			}
			// White - Move down one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[0][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp + " is invalid, but it returns true.");
			}
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Black - Move down one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[7][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp + " is invalid, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Right - No obstruction")
		void checkIsValidUp_2_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			GameBoard.getInstance().setBoard();
			// Standard move up diagonal one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is invalid due to same color obstruction, but it returns true.");
			}
			
			// Standard move up diagonal one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is invalid due to same color obstruction, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Left - No obstruction")
		void checkIsValidUp_2_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			GameBoard.getInstance().setBoard();
			// Standard move up one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is invalid due to same color obstruction, but it returns false.");
			}
			
			/*
			 * Check the Black side
			 */
			// Standard move up one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is invalid due to same color obstruction, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Right - Obstruction (same color)")
		void checkIsValidUp_3_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Make all row 2 white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move up one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is invalid due to same color obstruction, but it returns true.");
			}
			
			/*
			 * Check the Black side
			 */
			// Make all row 5 black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move up one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is invalid due to same color obstruction, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Left - Obstruction (same color)")
		void checkIsValidUp_3_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Make all row 2 white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move up one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is invalid due to same color obstruction, but it returns false.");
			}
			
			/*
			 * Check the Black side
			 */
			// Make all row 5 black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move up one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is invalid due to same color obstruction, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Right - Obstruction (different color)")
		void checkIsValidUp_4_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Make all row 2 white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move up one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i+1]);
				assertEquals(true, check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is valid due to different color obstruction, but it returns false.");
			}
			
			/*
			 * Check the Black side
			 */
			// Make all row 5 black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move up one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i-1]);
				assertEquals(true, check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is valid due to different color obstruction, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Diagonal Left - Obstruction (different color)")
		void checkIsValidUp_4_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Make all row 2 white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move up one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[2][i-1]);
				assertEquals(true, check, 
						() -> "Pawn move from 1, " + temp + " to 2, " + temp2 + " is valid due to different color obstruction, but it returns false.");
			}
			
			/*
			 * Check the Black side
			 */
			// Make all row 5 black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move up one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[6][i], board[5][i+1]);
				assertEquals(true, check, 
						() -> "Pawn move from 6, " + temp + " to 5, " + temp2 + " is valid due to different color obstruction, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Right - No obstruction")
		void checkIsValidUp_5_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Standard move down one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Left - No obstruction")
		void checkIsValidUp_5_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Standard move down one space
			for(int i = 0; i < board[6].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Right - Obstruction (Same Color)")
		void checkIsValidUp_6_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move down one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Left - Obstruction (Same Color)")
		void checkIsValidUp_6_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move down one space
			for(int i = 0; i < board[6].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Right - Obstruction (Different Color)")
		void checkIsValidUp_7_1() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move down one space
			for(int i = 0; i < board[1].length-1; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i+1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
		}
		
		@Test
		@DisplayName("Pawn Down Diagonal Left - Obstruction (Different Color)")
		void checkIsValidUp_7_2() {
			GameBoard.getInstance().setBoard();
			/*
			 * Check the White side
			 */
			// Set row 0 to white
			for(int i = 0; i < board[0].length; i++) {
				Tile tile = board[0][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Standard move down one space
			for(int i = 1; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[1][i], board[0][i-1]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 0, " + temp2 + " is invalid due to moving backwards, but it returns " + check);
			}
			
			/*
			 * Check the Black side
			 */
			// Set row 7 to black
			for(int i = 0; i < board[7].length; i++) {
				Tile tile = board[7][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Standard move down one space
			for(int i = 0; i < board[6].length-1; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				int temp2 = i-1;
				boolean check = pawn.isValidMove(board[6][i], board[7][i+1]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 7, " + temp2 + " is invalid due to moving backwards, but it returns true.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Two - First Row, No obstruction")
		void checkIsValidUp_8_1() {
			GameBoard.getInstance().setBoard();
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[3][i]);
				assertEquals(true, check, 
						() -> "Pawn move from 1, " + temp + " to 3, " + temp + " is valid, but it returns false.");
			}
			// Black - Move up one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[4][i]);
				assertEquals(true, check, 
						() -> "Pawn move from 6, " + temp + " to 4, " + temp + " is valid, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Two - First Row, Obstruction (Same Color)")
		void checkIsValidUp_8_2() {
			GameBoard.getInstance().setBoard();
			// Set row 2 to all white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(true));
				
			}
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[3][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 3, " + temp + " is valid, but it returns false.");
			}
			// Set row 5 to all black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(false));
				
			}
			// Black - Move up one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[4][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 4, " + temp + " is valid, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Two - First Row, Obstruction (Different Color)")
		void checkIsValidUp_8_3() {
			GameBoard.getInstance().setBoard();
			// Set row 2 to all white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(false));
				
			}
			// White - Move up one space
			for(int i = 0; i < board[1].length; i++) {
				Piece pawn = board[1][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[1][i], board[3][i]);
				assertFalse(check, 
						() -> "Pawn move from 1, " + temp + " to 3, " + temp + " is valid, but it returns false.");
			}
			// Set row 5 to all black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(true));
				
			}
			// Black - Move up one space
			for(int i = 0; i < board[6].length; i++) {
				Piece pawn = board[6][i].getPiece();
				int temp = i;
				boolean check = pawn.isValidMove(board[6][i], board[4][i]);
				assertFalse(check, 
						() -> "Pawn move from 6, " + temp + " to 4, " + temp + " is valid, but it returns false.");
			}
		}
		
		@Test
		@DisplayName("Pawn Up Two - Not From First Row")
		void checkIsValidUp_8_4() {
			GameBoard.getInstance().setBoard();
			// Set row 2 to all white pawns
			for(int i = 0; i < board[2].length; i++) {
				Tile tile = board[2][i];
				tile.setPiece(new Pawn(true));
				
			}
			boolean check = board[2][0].getPiece().isValidMove(board[2][0], board[4][0]);
			assertFalse(check, 
					() -> "Pawn move from 2, 0 to 4, 0 is valid, but it returns false.");
			
			// Set row 5 to all black pawns
			for(int i = 0; i < board[5].length; i++) {
				Tile tile = board[5][i];
				tile.setPiece(new Pawn(true));
				
			}
			boolean check2 = board[5][0].getPiece().isValidMove(board[5][7], board[3][7]);
			assertFalse(check2, 
					() -> "Pawn move from 6, 7 to 4, 7 is valid, but it returns false.");
		}
	}
}
