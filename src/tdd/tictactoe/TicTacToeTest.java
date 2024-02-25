package tdd.tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

	@Test(expected = RuntimeException.class)
    public void testPlayOutOfBoundsX() {
        TicTacToe game = new TicTacToe();
        // Essayer de jouer à une coordonnée en dehors de la grille (par exemple, -1)
        game.play(-1, 1);
    }
	 @Test(expected = RuntimeException.class)
	    public void testPlayOutOfBoundsY() {
	        TicTacToe game = new TicTacToe();
	        // Essayer de jouer à une coordonnée en dehors de la grille (par exemple, 4)
	        game.play(1, 4);
	    }
	 @Test
	    public void testPlayerStartingWithX() {
	        TicTacToe game = new TicTacToe();
	        assertEquals('X', game.getCurrentPlayer());
	    }

	    @Test
	    public void testPlayerAlternation() {
	        TicTacToe game = new TicTacToe();
	        assertEquals('X', game.getCurrentPlayer());
	        game.play(0, 0); // Player X's turn
	        assertEquals('O', game.getCurrentPlayer());
	        game.play(1, 0); // Player O's turn
	        assertEquals('X', game.getCurrentPlayer());
	    }
	    @Test
	    public void testGameInProgress() {
	        TicTacToe game = new TicTacToe();
	        game.play(0, 0); // Player X plays
	        assertEquals("Game in progress", game.play(1, 0));
	    }

	    @Test
	    public void testHorizontalWin() {
	        TicTacToe game = new TicTacToe();
	        game.play(0, 0); // X
	        game.play(1, 0); // O
	        game.play(0, 1); // X
	        game.play(1, 1); // O
	        assertEquals("X wins!", game.play(0, 2));
	    }

	    @Test
	    public void testVerticalWin() {
	        TicTacToe game = new TicTacToe();
	        game.play(0, 0); // X
	        game.play(0, 1); // O
	        game.play(1, 0); // X
	        game.play(1, 1); // O
	        game.play(2, 0); // X
	        assertEquals("X wins!", game.play(2, 1));
	    }

	    @Test
	    public void testFirstDiagonalWin() {
	        TicTacToe game = new TicTacToe();
	        game.play(0, 0); // X
	        game.play(0, 1); // O
	        game.play(1, 1); // X
	        game.play(0, 2); // O
	        assertEquals("O wins!", game.play(2, 2));
	    }

	    @Test
	    public void testSecondDiagonalWin() {
	        TicTacToe game = new TicTacToe();
	        game.play(0, 2); // X
	        game.play(0, 0); // O
	        game.play(1, 1); // X
	        game.play(0, 1); // O
	        assertEquals("O wins!", game.play(2, 0));
	    }
	    
	    
	    
	    
	    
	    
	    
	    
}