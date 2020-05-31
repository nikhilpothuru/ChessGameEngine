package gamemaker;

import board.Tile;
import pieces.Piece;

public class Player {
	// Instance Variables
	private boolean whiteSide;
	// Constructor
	public Player(boolean whiteSide) {
		this.whiteSide = whiteSide;
	}
	// Getters & Setters for white side
	public boolean isWhiteSide() {
		return whiteSide;
	}
	public void setWhiteSide(boolean whiteSide) {
		this.whiteSide = whiteSide;
	}
	
	public boolean movePiece(Tile start, Tile end) {
		Piece piece = start.getPiece();
		if(piece == null) return false;
		boolean color = start.getPiece().isWhite();
		if(color != this.isWhiteSide()){
			return false;
		}
		if(start.getPiece().isValidMove(start, end)) {
			end.setPiece(start.getPiece());
			start.setPiece(null);
			return true;
		}
		return false;
	}

}
