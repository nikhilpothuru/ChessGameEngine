package pieces;

public class PieceFactory {
	public static Piece getPiece(int row, int col) {
		switch(row) {
			case 0:
			case 7:
				boolean color = (row == 0) ? true : false;
				switch(col) {
					// Return Rook
					case 0:
					case 7:
						return new Pawn(color);
					// Return Knight
					case 1:
					case 6:
						return new Pawn(color);
					// Return Bishop
					case 2:
					case 5:
						return new Pawn(color);
					// Return Queen
					case 3:
						return new Pawn(color);
					// Return King
					case 4:
						return new Pawn(color);
					default:
						return null;
				}
			case 1:
			case 6:
				boolean color1 = (row == 1) ? true : false;
				return new Pawn(color1);
			default:
				return null;
		}
	}
}
