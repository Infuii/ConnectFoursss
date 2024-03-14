package APCSA;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
    public static void dropPiece(char[][] board, int col, char player) {
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] == ' ') {
                board[i][col] = player;
                break;
            }
        }
    }
    public static boolean checkBoardFull(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkIfColumnIsFull(char[][] board, int col) {
        return board[0][col] != ' ';
    }
    public static boolean checkingWinner(char[][] board, char player) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == player) {
                    if(j + 3 < board[i].length && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player) {
                        return true;
                    }
                    if(i + 3 < board.length) {
                        if(board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player) {
                            return true;
                        }
                        if(j + 3 < board[i].length && board[i+1][j+1] == player && board[i+2][j+2] == player && board[i+3][j+3] == player) {
                            return true;
                        }
                        if(j - 3 >= 0 && board[i+1][j-1] == player && board[i+2][j-2] == player && board[i+3][j-3] == player) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = new char[6][7];
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
        printBoard(board);
        boolean player1 =true;
        while(true) {
            System.out.println("Player " + (player1 ? 1 : 2) + ", enter a column (0 - 6): ");
            int col = input.nextInt();
            dropPiece(board, col, player1 ? 'X' : 'O');
            printBoard(board);
            if(checkingWinner(board, player1 ? 'X' : 'O')) {
                System.out.println("Player " + (player1 ? 1 : 2) + " wins! they got 4 in a row! GG!");
                break;
            }
            if(checkBoardFull(board)) {
                System.out.println("It's a tie! how did that happen? bruh!");
                break;
            }

            player1 = !player1;
        }
        input.close();
    }
}

