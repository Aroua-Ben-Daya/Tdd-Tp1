package tdd.tictactoe;
public class TicTacToe {
    private static final int SIZE = 3;
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
    	initializeBoard(); // Initialiser la grille
        currentPlayer = 'X'; // Player X starts the game
    }
    
 // Méthode pour initialiser la grille avec des cellules vides
    private void initializeBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public String play(int x, int y) {
        if (isOutOfBounds(x, y)) {
            throw new RuntimeException("Invalid coordinates");
        }
        if (isCellOccupied(x, y)) {
            throw new RuntimeException("Cell already occupied");
        }
        placePiece(x, y, currentPlayer);
        if (isWinner(currentPlayer)) {
            return currentPlayer + " wins!";
        } else if (isBoardFull()) {
            return "It's a draw!";
        } else {
            switchPlayer();
            return "Game in progress";
        }
    }

    private boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= SIZE || y < 0 || y >= SIZE;
    }

    private boolean isCellOccupied(int x, int y) {
        return board[x][y] != ' ';
    }

    private void placePiece(int x, int y, char symbol) {
        board[x][y] = symbol;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean isWinner(char player) {
        // Check horizontal lines
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check vertical lines
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
