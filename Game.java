package tic_tac_toe;

public class Game {

	public static void main(String[] args) {
		System.out.println("\nTIC-TAC-TOE\n");

		//Initialize and display the board
		char[][] board = new char[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
		
		boolean gameOver = false;
		char currentPlayer = 'X';

		while (!gameOver) {
			Methods.displayBoard(board);
			int[] move = Methods.playerMove(board, currentPlayer);
			int row = move[0];
			int col = move[1];
			board[row][col] = currentPlayer; //Write the symbol of the player on the board

			if (Methods.checkWin(board, currentPlayer)) {
				Methods.displayWinner(board, currentPlayer);
				gameOver = true;
			} else if (Methods.boardFull(board)) {
				Methods.displayDraw(); //When the board is Full but nobody wins
				gameOver = true;
			} else {
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
				// Changes the player
			}
		}
		Methods.replay(); {
			//Methods.resetGame(board);
			gameOver = false;
			}
			
		
	}

}
