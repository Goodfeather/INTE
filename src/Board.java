/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    private Cell[][] matris;

    public enum Cell {
        O, X
    }
    public Board(){
        matris = new Cell[3][3];
    }

    public boolean add(Cell cell, int col, int row){
        if(col < 0 || col > 2 || row < 0 || row > 2)
            throw new IndexOutOfBoundsException("");
        if(matris[col][row] == null){
            matris[col][row] = cell;
            return true;
        }else return false;
    }
    public Cell get(int col, int row){
        return matris[col][row];
    }
}
