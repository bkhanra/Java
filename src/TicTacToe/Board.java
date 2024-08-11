package TicTacToe;

public class Board {
	
	private char[][] board;
	private int boardSize;
	private char p1Symbol, p2Symbol;
	private int count;
	private static final char EMPTY = ' ';
	
	public Board(char p1Symbol, char p2Symbol) {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				board[i][j]=EMPTY;
			}
		}
		
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
}
