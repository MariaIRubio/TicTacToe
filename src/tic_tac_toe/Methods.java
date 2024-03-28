package tic_tac_toe;

import java.util.Scanner;

public class Methods {

	static void displayBoard(char[][] board) {

		System.out.println("\n0    | 1 | 2 |");
		System.out.println("---------------");

		for (int row = 0; row < 3; row++) {
			System.out.print(row + " ");
			for (int col = 0; col < 3; col++) {
				System.out.print(" " + board[row][col] + " ");
				if (col < 3) {
					System.out.print("|");
				}
			}

			System.out.println();
			if (row < 3) {
				System.out.println("---------------");
			}
		}
	}

	static int[] playerMove(char[][] board, char currentPlayer) {

		int[] move = new int[2];
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("\nPlayer " + currentPlayer + ", enter your move (row column): ");
			try {
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				if (isValidMove(board, row, col)) {
					move[0] = row;
					move[1] = col;
					break;
				} else {
					System.out.println("\nWrong move. Try again.");
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("\nInvalid input. Enter row and column as integers (e.g., 0 1).");
				scanner.nextLine();
			}
		}
		// scanner.close();
		return move;

	}

	private static boolean isValidMove(char[][] board, int row, int col) {
		return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
	}

	static boolean checkWin(char[][] board, char currentPlayer) {
		/*
		 * It checks if the currentPlayer match with the position of the symbol in the
		 * board
		 */
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
				return true; // 3 symbols in the whole Row
			}
			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
				return true; // 3 symbols in the whole Column
			}
		}
		if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
			return true; // 3 symbols in the whole Diagonal top-left bottom-right
		}
		if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
			return true; // 3 symbols in the whole Diagonal top-right bottom-left
		}
		return false;
	}

	static boolean boardFull(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false; // means when there is a space " " it is not full and return the statement false
				}
			}
		}
		return true; // the board is full
	}

	static void displayWinner(char[][] board, char currentPlayer) {
		displayBoard(board);
		System.out.println("\nThe winner is Player: " + currentPlayer + "\nCongratulations!");
	}

	static void displayDraw() {
		System.out.println("\nNobody Wins! Maybe you should try again!");
	}

	static void replay() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nDo you want to play again? (yes/no): ");
		String choice = scanner.nextLine().toLowerCase();
		System.out.println("Replay choice: " + choice);
		if (choice.equalsIgnoreCase("yes")) {
			char[][] board = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';
				}
			}

		}
		// scanner.close();
		//return choice.equals("yes");
	}

	static void resetGame(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}
}
