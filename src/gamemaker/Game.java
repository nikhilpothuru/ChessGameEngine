package gamemaker;


import java.util.Scanner;

import board.GameBoard;
import board.Tile;

public class Game {
	// Instance Variables
	private boolean whiteTurn; 
	// Create Players
	private final Player player1;
	private final Player player2; 
	
	// Constructor
	public Game() {
		player1 = new Player(true);
		player2 = new Player(false); 
	}
	
	// Setters & Getters 
	public boolean isWhiteTurn() {
		return whiteTurn;
	}
	public void setWhiteTurn(boolean whiteTurn) {
		this.whiteTurn = whiteTurn;
	}
	
	// Getter for Player 1
	public Player getPlayer1() {
		return player1;
	}
	// Getter for Player 2
	public Player getPlayer2() {
		return player2;
	}
	
	// Check User Input
	public boolean checkUserInput(boolean trackPlayer, String s, String e) {
		Player player = (trackPlayer) ? this.player1 : this.player2;
		if(s.length() == 2 && e.length() == 2) {
			int sCol = ((int)s.charAt(0)) - 65;
			int sRow = ((int)s.charAt(1)) - 49;
			int eCol = ((int)e.charAt(0)) - 65;
			int eRow = ((int)e.charAt(1)) - 49;
			/*System.out.println(sCol);
			System.out.println(sRow);
			System.out.println(eCol);
			System.out.println(eRow);*/
			if(sCol < 0 || sCol > 7) {
				return false;
			}
			if(sRow < 0 || sRow > 7) {
				return false;
			}
			if(eCol < 0 || eCol > 7) {
				return false;
			}
			if(eRow < 0 || eRow > 7) {
				return false;
			}
			Tile[][] board = GameBoard.getInstance().getBoard();
			if(!player.movePiece(board[sRow][sCol], board[eRow][eCol])) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// Use Scanner to get input from the user
		Scanner in = new Scanner(System.in); 
		boolean quit = false;
		// true - Player 1, false - Player 2 
		boolean trackPlayer = true;
		System.out.println("Welcome to the Chess Game Engine! \n"
				+ "Players will take turns moving pieces. A player may only move a piece of their respective color. \n"
				+ "The player will be prompted to give a the tile of the piece and the tile to which the piece should move to. \n"
				+ "To indicate a tile, the player must provide a column letter and row number. (Column letters: A-H, Row numbers: 1-7) \n"
				+ "An example of indicating a tile is as follows: A1, which indicates the bottom leftmost tile. \n"
				+ "When prompted for a start tile, provide a letter followed by a number. The same goes for the end tile. \n"
				+ "If the user does not provide a tile with a proper piece, you will be prompted to provide a proper piece. \n"
				+ "If you wish to leave the game, please type the character Q. \n"
				+ "Click ENTER to continue. ");
		in.nextLine(); 
		System.out.println();
		
		Game game = new Game();
		GameBoard gameBoard = GameBoard.getInstance(); 
		//Tile[][] board = gameBoard.getBoard();
		
		while(!quit) {
			System.out.println(gameBoard);
			System.out.println();
			String player = (trackPlayer) ? "Player 1's (White)" : "Player 2's (Black)";
			System.out.println("It is " + player + " move.");
			System.out.println("Input the start tile: ");
			String s = in.nextLine().trim().toUpperCase();
			if(s.length() == 1 && s.charAt(0) == 'Q') {
				quit = true;
				System.out.println();
				System.out.println("Thank you for playing. Have a great day!");
				break;
			}
			System.out.println("Your start tile is: " + s);
			System.out.println("Input the end tile: ");
			String e = in.nextLine().trim().toUpperCase();
			if(e.length() == 1 && e.charAt(0) == 'Q') {
				quit = true;
				System.out.println();
				System.out.println("Thank you for playing. Have a great day!");
				break;
			}
			System.out.println("Your end tile is: " + e);
			if(!game.checkUserInput(trackPlayer, s, e)) {
				System.out.println("Invalid input. Please try again.");
				System.out.println();
				continue;
			}
			System.out.println();
			
			trackPlayer = !trackPlayer;
			System.out.println("-------------------------------------------------------------- \n");
		}
		
		in.close();
	}
}
