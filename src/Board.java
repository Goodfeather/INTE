
/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board {

    private String[][] matris;
    private final int columns = 3;
    private final int rows = 3;
    private final String PLAYER1 = "X";
    private final String PLAYER2 = "O";
    private String freeCell = " ";

    public Board(){
        matris = new String[rows][columns];
        fillBoard();
    }
    public void fillBoard(){
        for(int i = 0; i < rows; i++ )
            for(int j = 0; j < columns; j++ )
                matris[i][j] = freeCell;
    }

    public boolean add(String player, int row, int column){
        if(row < 0 || row > rows-1 || column < 0 || column > columns-1)
            throw new IndexOutOfBoundsException("Row and column-number must be between 0 and : "+rows + " for rows, 0 and "+ columns+ " for columns.");
        if(!player.equals(PLAYER1) && !player.equals(PLAYER2) )
            throw new IllegalArgumentException("Player must be X or O");
        if(matris[row][column].equals(freeCell) ){
            matris[row][column] = player;
            return true;
        }else return false;
    }
    public String get(int row, int column){
        return matris[row][column];
    }
    public Boolean checkWin(String player){
        if(!player.equals(PLAYER1) && !player.equals(PLAYER2) )
            throw new IllegalArgumentException("Player must be X or O");

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
    public String printRow(int row){
        if(row < 0 || row > rows-1)
            throw new IndexOutOfBoundsException("Rownumber must be between 0 and "+rows);
        return  get(row, 0)+"|"+get(row,1)+ "|"+get(row, 2);
    }
    public String printBoard(){
        String str = "";
        for(int i = 0; i < rows; i++){
            str += printRow(i) + "\n";
        }
        return str;
    }
    public String getPlayer1(){
        return PLAYER1;
    }
    public String getPlayer2(){
        return PLAYER2;
    }

    }
