import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Test class for testiing the validity of the implementation.
 */
public class TestExample {
    @Test
    public void testNewGame() {
        TicTacToe game = new TicTacToe();
        assertEquals (1, game.player);
        assertEquals (9, game.movesLeft);
    }

    @Test
    public void testModel() {
        TicTacToe game = new TicTacToe();
        game.blocks[0][0].doClick();
        game.blocks[1][1].doClick();
        assertEquals (7, game.movesLeft);
        assertEquals (1, game.player);
        game.blocks[2][2].doClick();
        game.blocks[1][2].doClick();
        game.blocks[0][2].doClick();
        assertEquals (4, game.movesLeft);
        assertEquals (2, game.player);
        game.blocks[0][1].doClick();
        game.blocks[1][0].doClick();
        assertEquals (2, game.movesLeft);
        assertEquals (2, game.player);
        game.blocks[2][0].doClick();
        game.blocks[2][1].doClick();
    }

    @Test
    public void testView() {
        TicTacToe game = new TicTacToe();
        game.blocks[0][0].doClick();
        game.blocks[1][1].doClick();
        game.blocks[2][2].doClick();
        assertEquals ("X", game.blocks[0][0].getText());
        assertEquals ("O", game.blocks[1][1].getText());
        assertEquals ("X", game.blocks[2][2].getText());
        assertEquals ("'O': Player 2", game.playerturn.getText());
        game.resetGame();
        assertEquals ("", game.blocks[0][0].getText());
        assertEquals ("", game.blocks[1][1].getText());
        assertEquals ("", game.blocks[2][2].getText());
        assertEquals ("Player 1 to play 'X'", game.playerturn.getText());
    }

    @Test
    public void testController() {
        TicTacToe game = new TicTacToe();
        for(int r = 0; r < 3; r++) {
        	for(int c = 0; c < 3; c++) {
        		assertEquals (true, game.blocks[r][c].isEnabled());
        	}
        }
        for(int r = 0; r < 3; r++) {
        	for(int c = 0; c < 3; c++) {
        		game.blocks[r][c].doClick();
        		assertEquals (false, game.blocks[r][c].isEnabled());
        	}
        }
        game.resetGame();
        game.blocks[0][0].doClick();
        game.blocks[1][1].doClick();
        game.blocks[1][0].doClick();
        game.blocks[2][2].doClick();
        game.blocks[2][0].doClick();
        assertEquals ("Player 1 wins!", game.playerturn.getText());
    }
}
