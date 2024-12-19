import java.util.*;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        

        while (!gameOver) {
            printBoard(board);
            System.out.println("player: " + player + ": Enter the position: like(1,1): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (row >= board.length || col >= board[0].length || row < 0 || col < 0) {
                System.out.println("Enter the valid position");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = hasWon(board, player);
                if (gameOver) {
                    System.out.println(player + " has won.");
                } else {
                    player = (player == 'X') ? 'O': 'X';
                }
            } else {
                System.out.println("invalid position.try again");
            }
                        
        }
    }
            
    private static void printBoard(char[][] board) {
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean hasWon(char[][] board, char player) {
        for (int i = 0;i < board.length;i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) 
            return true;
        }

        for (int j = 0;j < board[0].length;j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) 
            return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }


        return false;
    }
}