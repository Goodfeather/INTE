import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

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
        assertEquals(true, game.add("X", 2, 2));
        assertEquals(true, game.add("X", 0, 0));
        assertEquals(false, game.add("X", 2, 2));
        assertEquals(false, game.add("O", 2, 2));
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addAfter(){
        Board game = new Board();
        game.add("X", 2, 3);
        game.add("X", 3, 2);
    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void addBefore(){
        Board game = new Board();
        game.add("X", -1, 2);
        game.add("X", 2, -1);
    }
    @Test(expected=IllegalArgumentException.class)
    public void illegalAdd(){
        Board game = new Board();
        game.add("FEL", 0, 0);
    }
    @Test
    public void testGet(){
        Board game = new Board();
        game.add("X", 0, 0);
        assertEquals("X", game.get(0, 0));
        game.add("X", 2, 2);
        assertEquals("X", game.get(2, 2));

    }
    @Test
    public void testHorWin(){
        Board game = new Board();
        Random rand = new Random();
        int  cell = rand.nextInt(2);
        game.add("X", cell, 0);
        game.add("X", cell, 1);
        game.add("X", cell, 2);
        assertEquals(true, game.checkWin("X"));
    }
    @Test
    public void testVerWin(){
        Board game = new Board();
        Random rand = new Random();
        int  cell = rand.nextInt(2);
        game.add("O", 0, cell);
        game.add("O", 1, cell);
        game.add("O", 2, cell);
        assertEquals(true, game.checkWin("O"));
    }
    @Test
    public void testWin1(){   // test \ win
        Board game = new Board();
        game.add("O", 0, 0);
        game.add("O", 1, 1);
        game.add("O", 2, 2);
        assertEquals(true, game.checkWin("O"));
    }
    @Test
    public void testWin2(){   // test / win
        Board game = new Board();
        game.add("X", 0, 2);
        game.add("X", 1, 1);
        game.add("X", 2, 0);
        assertEquals(true, game.checkWin("X"));
    }
    @Test(expected=IllegalArgumentException.class)
    public void illegalWin(){
        Board game = new Board();
        game.checkWin("FEL!");
    }
    @Test
    public void fillBoardTest(){
        Board game = new Board();
        game.fillBoard();

        assertEquals(" ", game.get(0, 2));
        assertEquals(" ", game.get(2, 0));
        assertEquals(" ", game.get(2, 1));
        assertEquals(" ", game.get(1, 2));
        assertEquals(" ", game.get(0, 0));

    }
    @Test(expected=IndexOutOfBoundsException.class)
    public void printOutOfBounds(){
        Board game = new Board();
        game.printRow(4);
    }
    @Test
    public void testPrint(){
        Board game = new Board();
        //assertEquals(" | | ", game.printRow());
        game.add("X", 0, 0);
        assertEquals("X| | ", game.printRow(0));
        game.add("O", 1, 1);
        assertEquals(" |O| ", game.printRow(1));
        game.add("X", 2, 2);
        assertEquals(" | |X", game.printRow(2));
        game.add("X", 1, 2);
        assertEquals(" |O|X", game.printRow(1));
    }
    @Test
    public void testPlayer(){
        Board game = new Board();
        assertEquals("X", game.getPlayer1());
        assertEquals("O", game.getPlayer2());
    }

}
