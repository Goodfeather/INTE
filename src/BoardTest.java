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

    }


}
