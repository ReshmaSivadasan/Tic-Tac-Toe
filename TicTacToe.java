import java.util.Scanner;

public class TicTacToe {

	static final int EMPTY = 0;

	static final int NONE = 0;

	static final int USER = 1;

	static final int COMPUTER = 2;

	static final int STALEMATE = 3;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int turn = USER;

		int[][] board = new int[3][3];

		int move;

		int winner;

		char input = '\0';
		System.out.println("Welcome to TicTacToe game :)");
		System.out.println("You are playing against the computer!");
		System.out.println("It's your move! Enter any position from 0-8");

		print_board(board, input);

		//game not over
		while (true) {
			if (turn == USER) {
				System.out.println("Your move");
				move = -1;
				while (move < 0 || move > 9 || board[move / 3][move % 3] != EMPTY) {
					System.out.println("Please enter your move(0-8): ");
					move = in.nextInt();
					input = in.next().charAt(0);
				}
			} else {
				move = computer_move(board);
				System.out.println("Computer's move! " + move);
			}

			board[(int) (move / 3)][move % 3] = turn;

			print_board(board, input);

			winner = checkWinner(board);

			if (winner != NONE)
				break;

			if (turn == USER) {
				turn = COMPUTER;
			} else {
				turn = USER;
			}

		}
		// game over
		switch (winner) {
		case USER:
			System.out.println("You won!!!!");
			break;
		case COMPUTER:
			System.out.println("Computer won!!");
			break;
		default:
			System.out.println("It's a Tie! Play Again");
			break;
		}
	}

	public static void print_board(int[][] board, char input) {
		System.out.print(printChar(board[0][0], input));
		System.out.print("|");
		System.out.print(printChar(board[0][1], input));
		System.out.print("|");
		System.out.println(printChar(board[0][2], input));
		System.out.println("-----");
		System.out.print(printChar(board[1][0], input));
		System.out.print("|");
		System.out.print(printChar(board[1][1], input));
		System.out.print("|");
		System.out.println(printChar(board[1][2], input));
		System.out.println("-----");
		System.out.print(printChar(board[2][0], input));
		System.out.print("|");
		System.out.print(printChar(board[2][1], input));
		System.out.print("|");
		System.out.println(printChar(board[2][2], input));
	}

	public static char printChar(int b, char input) {
		switch (b) {
		case EMPTY:
			return ' ';
		case USER:
			return input;
		case COMPUTER:
			if (input == 'O') {
				return 'X';
			} else {
				return 'O';
			}
		}
		return ' ';
	}

	public static int checkWinner(int[][] board) {

		if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
			return board[0][0];

		if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
			return board[1][0];

		if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
			return board[2][0];

		if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
			return board[0][0];

		if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
			return board[0][1];

		if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
			return board[0][2];

		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
			return board[0][0];

		if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
			return board[0][2];

		if (board[0][0] == EMPTY || board[0][1] == EMPTY || board[0][2] == EMPTY || board[1][0] == EMPTY || board[1][1] == EMPTY || board[1][2] == EMPTY
				|| board[2][0] == EMPTY || board[2][1] == EMPTY || board[2][2] == EMPTY)
			return NONE;

		return STALEMATE;
	}

	//generate random math value
	public static int computer_move(int[][] board) {
		int move = (int) (Math.random() * 9);

		while (board[move / 3][move % 3] != EMPTY)
			move = (int) (Math.random() * 9);

		return move;
	}

}
