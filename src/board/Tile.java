package board;

import pieces.Pawn;
import pieces.Piece;

public class Tile {
	
	private Piece piece;
	private int x;
	private int y;
	
	public Tile(Piece piece, int y, int x) {
		this.setPiece(piece);
		this.setY(y);
		this.setX(x);
	}
	
	// Getters & Setters for Piece
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	// Getters & Setters for x
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	// Getter & Setters for y
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		if(piece instanceof Pawn) {
			if(piece.isWhite()) {
				return " W[P] ";
			}
			else {
				return " B[P] ";
			}
		}
		else {
			return "  --  ";	
		}
	}
}
