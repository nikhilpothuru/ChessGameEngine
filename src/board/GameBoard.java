package board;

import pieces.Piece;
import pieces.PieceFactory;

public class GameBoard {

	// Instance variables
	private final int x = 8;
	private final int y = 8;
	private final Tile[][] board;

	// Constructor
	private GameBoard() {
		board = new Tile[y][x];
		this.setBoard();
	}
	
	private static final GameBoard instance = new GameBoard();
	
	// Getter for instance
	public static GameBoard getInstance() {
		return instance;
	}
	
	// Getter for Board
	public Tile[][] getBoard() {
		return board;
	}
	
	// Setting up the board
	public void setBoard() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				Piece piece = PieceFactory.getPiece(i, j);
				board[i][j] = new Tile(piece, i, j);
			}
		}	
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for(int i = board.length-1; i >= 0; i--) {
			int rowIndicator = i+1;
			temp.append("   " + rowIndicator + "  ");
			for(int j = 0; j < board[0].length; j++) {
				temp.append(board[i][j].toString()); 
			}
			temp.append("\n");
		}
		temp.append("      ");
		for(int i = 0; i < board[0].length; i++) {
			char colIndicator = (char)(i+65);
			temp.append("   " + colIndicator + "  "); 
		}
		return temp.toString();
	}
}
