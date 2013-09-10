/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    private String[][] matris;

    public Board(){
        matris = new String[3][3];
    }

    public boolean add(String player, int col, int row){
        if(col < 0 || col > 2 || row < 0 || row > 2)
            throw new IndexOutOfBoundsException("");
        if(matris[col][row] == null){
            matris[col][row] = player;
            return true;
        }else return false;
    }
    public String get(int col, int row){
        return matris[col][row];
    }
    public Boolean checkWin(String player){

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
        //Check \
        else if(matris[0][0] == player && matris[1][1] == player && matris[2][2] == player)
            return true;
        //Check /
        else if(matris[2][0] == player && matris[1][1] == player && matris[0][2] == player)
            return true;
        else return false;
    }
    public String printRow(){
        //if (matris[0][0] == null)

        return  " | |"+matris[0][0];
    }

}
