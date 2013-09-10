import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardTest {

    @Test
    public void testAdd(){
        Board game = new Board();
        assertEquals(true, game.add(Board.Cell.X, 2, 2));
        assertEquals(false, game.add(Board.Cell.X, 2, 2));
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addAfter(){
        Board game = new Board();
        game.add(Board.Cell.X, 2, 3);
        game.add(Board.Cell.X, 3, 2);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addBefore(){
        Board game = new Board();
        game.add(Board.Cell.X, -1, 2);
        game.add(Board.Cell.X, 2, -1);
    }
    @Test
    public void testGet(){
        Board game = new Board();

        game.add(Board.Cell.X, 2, 2);
        assertEquals(Board.Cell.X, game.get(2, 2));

    }
    public void testHorWin(){
        Board game = new Board();
        game.add(Board.Cell.X, 0, 0);
        game.add(Board.Cell.X, 0, 1);
        game.add(Board.Cell.X, 0, 2);
        game.checkWin();
    }


}
