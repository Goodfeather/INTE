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
    public void testAdd() throws Exception {
        Board game = new Board();
        assertEquals(true, game.add(2, 2));
        assertEquals(false, game.add(2, 2));
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addAfter(){
        Board game = new Board();
        game.add(2, 3);
        game.add(3, 2);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addBefore(){
        Board game = new Board();
        game.add(-1, 2);
        game.add(2, -1);
    }


}
