package pieces;

import board.GameBoard;
import board.Tile;

public class Pawn extends Piece {
	
	public Pawn(boolean color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		
		Piece startPiece = start.getPiece();
		boolean color = startPiece.isWhite();
		
		int xDist = Math.abs(end.getX() - start.getX());
		int yDist = end.getY() - start.getY();
		
		boolean UpOneCheck = false;
		boolean UpTwoCheck = false;
		
		if(color) {
			UpOneCheck = (yDist == 1) ? true : false;
			UpTwoCheck = (yDist == 2 && start.getY() == 1) ? true : false;
		}
		else {
			UpOneCheck = (yDist == -1) ? true : false;
			UpTwoCheck = (yDist == -2 && start.getY() == 6) ? true : false;
		}
		
		// Check if the move on the y-axis is allowed, before even checking the x-axis
		if(!UpOneCheck && !UpTwoCheck) {
			return false;
		}
		
		// Handle x-axis movement for move Pawn up 2
		if(UpTwoCheck && xDist == 0) {
			Tile[][] board = GameBoard.getInstance().getBoard();
			if(color) {
				if(board[start.getY()+1][start.getX()].getPiece() != null) {
					return false;
				}
				
			}
			else {
				if(board[start.getY()-1][start.getX()].getPiece() != null) {
					return false;
				}
			}
			return true;
		}
		
		// Move x-axis movement for move Pawn up 1
		if(UpOneCheck) {
			// Moving Pawn Diagonally only if there exists an opposing piece on the diagonal
			if(xDist !=0 && end.getPiece() != null) {
				// If the piece on the end is the same color, then don't move
				if(end.getPiece().isWhite() == this.isWhite()) return false;
				return true;
			}
			// Moving Pawn Up
			if(UpOneCheck && xDist ==0 && end.getPiece() == null) {
				return true;
			}
		}
		return false;	
	}
}
