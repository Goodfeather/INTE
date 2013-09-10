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

    public boolean add(Cell player, int col, int row){
        if(col < 0 || col > 2 || row < 0 || row > 2)
            throw new IndexOutOfBoundsException("");
        if(matris[col][row] == null){
            matris[col][row] = player;
            return true;
        }else return false;
    }
    public Cell get(int col, int row){
        return matris[col][row];
    }
    public Boolean checkWin(Cell player){

        //check horizontal
        if(matris[0][0] == player && matris[0][1] == player && matris[0][2] == player ||
            matris[1][0] == player && matris[1][1] == player && matris[1][2] == player ||
            matris[2][0] == player && matris[2][1] == player && matris[2][2] == player
        )
            return true;
        //check vertical
        else if(matris[0][0] == player && matris[1][0] == player && matris[2][0] == player ||
                matris[0][1] == player && matris[1][1] == player && matris[2][1] == player ||
                matris[0][2] == player && matris[1][2] == player && matris[2][2] == player
                )
            return true;
        else if(matris[0][0] == player && matris[1][1] == player && matris[2][2] == player)
            return true;
        else return false;
    }
}
