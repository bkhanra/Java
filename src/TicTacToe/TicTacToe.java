package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1, player2;
	private Board board;
	private int numPlayers;
	
	public static void main(String args[]) {
		TicTacToe t = new TicTacToe();
		t.startGame();
		
	}
	
	private Player takePlayerInput(int num) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Player" + num + " name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Player" + num + " symbol: ");
		char symbol = sc.next().charAt(0);
		
		Player p = new Player(name, symbol);
		
		return p;
		
	}

	//This will start the game
	public void startGame() {
		Scanner sc = new Scanner(System.in);
		//take player input
		Player player1 = takePlayerInput(++numPlayers);
		Player player2 = takePlayerInput(++numPlayers);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("This symbol was already taken. Please add a different symbol!");
			player2.setSymbol(sc.next().charAt(0));
		}
		//create the board
		board = new Board(player1.getSymbol(),player2.getSymbol());
		//play the game
		boolean player1Turn = true;
		
		int status = Board.INCOMPLETE;
		
		while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
		    if (player1Turn) {
		        System.out.println("Player 1: " + player1.getName() + "'s turn!");
		        System.out.print("Please enter X coordinate: ");
		        int x = sc.nextInt();
		        System.out.print("Please enter Y coordinate: ");
		        int y = sc.nextInt();
		        status = board.move(player1.getSymbol(), x, y);
		        if (status == Board.INVALIDMOVE) {
		            System.out.println("Invalid move, please try again!!");
		            continue;
		        }
		    } else {
		        System.out.println("Player 2: " + player2.getName() + "'s turn!");
		        System.out.print("Please X coordinate: ");
		        int x = sc.nextInt();
		        System.out.print("Please Y coordinate: ");
		        int y = sc.nextInt();
		        status = board.move(player2.getSymbol(), x, y);
		        if (status == Board.INVALIDMOVE) {
		            System.out.println("Invalid move, please try again!!");
		            continue;
		        }
		    }
		    board.print();  
		    player1Turn = !player1Turn;
		}

		
		if (status == Board.PLAYER1WINS) {
		    System.out.println("Player 1: " + player1.getName() + " has won!!");
		} else if (status == Board.PLAYER2WINS) {
		    System.out.println("Player 2: " + player2.getName() + " has won!!");
		} else if (status == Board.DRAW) {
		    System.out.println("It's a DRAW!!");
		}

	}
}
