import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: peter
 * Date: 9/10/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class tictacGame {

    public static void main(String[] args){
        Board game = new Board();
        String currentPlayer = game.getPlayer1();
        String otherPlayer = game.getPlayer2();
        System.out.print(game.printBoard());
        boolean gameOn = true;

        while(gameOn){
            while(!input(game, currentPlayer));

            System.out.print(game.printBoard());
            if(game.checkWin(currentPlayer)){
                System.out.println(currentPlayer + " is the winner!");
                gameOn = false;
            }
            String tempPlayer = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer =  tempPlayer;
        }



    }
    public static boolean input(Board game, String player){
        Scanner scan = new Scanner(System.in);

        for(;;){
            try{
                System.out.println("Enter two numbers between 0-2:  ");
                int col=Integer.parseInt(scan.next());
                int row = Integer.parseInt(scan.next());
                if(col < 0 || col > 2 || row < 0 || row > 2){
                    System.out.println("You must enter two numbers between 0 and 2!");
                    return false;
                }
                else if(game.add(player, row, col )){
                    return true;
                }
                else{
                    System.out.println("Spot is full");
                    return false;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Must be a number");
                return false;
            }catch(IndexOutOfBoundsException e){
                System.out.println("Must be a number between 0-2!");
                return false;
            }catch(IllegalArgumentException e){
                System.out.println("Unknown playerformat!");
                return false;
            }
        }
    }
}
