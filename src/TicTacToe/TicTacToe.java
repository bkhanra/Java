package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1, player2;
	private Board board;
	
	public static void main(String args[]) {
		TicTacToe t = new TicTacToe();
		t.startGame();
		
		takeInput("Hi");
		
		System.out.println("Hello Game");
	}
	
	public static String takeInput(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + ": ");
		System.out.println();
		return sc.next();
	}

	//This will start the game
	public void startGame() {
		//take player input
		//create the board
		//play the game
		
		
	}
}
