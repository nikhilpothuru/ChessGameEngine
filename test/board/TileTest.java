package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pieces.Pawn;

class TileTest {
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
	
	@Test
	@DisplayName("Check Tile toString() method")
	void checkToString() {
		System.out.print(tileTopLeft.toString());
		System.out.print(tileTopMiddle.toString());
		System.out.println(tileTopRight.toString());
		System.out.print(tileMiddleLeft.toString());
		System.out.print(tileMiddleMiddle.toString());
		System.out.println(tileMiddleRight.toString());
		System.out.print(tileBottomLeft.toString());
		System.out.print(tileBottomMiddle.toString());
		System.out.println(tileBottomRight.toString());
	}

}
