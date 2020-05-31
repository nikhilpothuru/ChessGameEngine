package pieces;

import board.Tile;

public abstract class Piece {
	
	// Instance Variables
	private boolean removed;
	// White is true & Black is false
	private boolean white; 
	
	// Constructor
	public Piece(boolean color){
		this.setRemoved(false);
		this.setWhite(color);
	}
	
	// Getters & Setters for removed
	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	
	// Getters & Setters for Color
	public boolean isWhite() {
		return white;
	}
	public void setWhite(boolean color) {
		this.white = color;
	}
	
	// Check if move is valid
	public abstract boolean isValidMove(Tile start, Tile end);
	
}
