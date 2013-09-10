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
    @Test
    public void testHorWin(){
        Board game = new Board();
        Random rand = new Random();
        int  cell = rand.nextInt(2);
        game.add(Board.Cell.X, cell, 0);
        game.add(Board.Cell.X, cell, 1);
        game.add(Board.Cell.X, cell, 2);
        assertEquals(true, game.checkWin(Board.Cell.X));
    }
    @Test
    public void testVerWin(){
        Board game = new Board();
        Random rand = new Random();
        int  cell = rand.nextInt(2);
        game.add(Board.Cell.O, 0, cell);
        game.add(Board.Cell.O, 1, cell);
        game.add(Board.Cell.O, 2, cell);
        assertEquals(true, game.checkWin(Board.Cell.O));
    }
    @Test
    public void testWin1(){   // test \ win
        Board game = new Board();
        game.add(Board.Cell.O, 0, 0);
        game.add(Board.Cell.O, 1, 1);
        game.add(Board.Cell.O, 2, 2);
        assertEquals(true, game.checkWin(Board.Cell.O));
    }
    @Test
    public void testWin2(){   // test / win
        Board game = new Board();
        game.add(Board.Cell.X, 0, 2);
        game.add(Board.Cell.X, 1, 1);
        game.add(Board.Cell.X, 2, 0);
        assertEquals(true, game.checkWin(Board.Cell.X));
    }
    @Test
    public void testPrint(){
        Board game = new Board();
        assertEquals(" | | ", game.printRow());
    }



}
