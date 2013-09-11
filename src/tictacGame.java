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




        System.out.print(game.printBoard());


    }
    public boolean input(Board game, String player){
        Scanner scan = new Scanner(System.in);

        for(;;){
            try{
                int col=Integer.parseInt(scan.nextLine());
                int row = 1;
                if(col < 0 || col > 2 || row < 0 || row > 2)
                    System.out.println("You must enter two numbers between 0 and 2!");
                else if(!game.add(player, col, row))
                    System.out.println("Spot is full");
                else return false;
            }
            catch (NumberFormatException e){
                System.out.println("Must be a number");
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Must be a number between 0-2!");
            }
        }
    }
}
