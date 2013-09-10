/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    public Board(){}

    public boolean add(int col, int row){
        if(col < 0 || col > 2 || row < 0 || row > 2)
            throw new IndexOutOfBoundsException("");
        return true;

    }
}
