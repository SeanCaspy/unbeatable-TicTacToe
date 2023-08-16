import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);
    char symbol;
    Board board;

    public Player(char symbol, Board board){
        this.symbol = symbol;
        this.board = board;

    }
    public int playTurn(){
        return sc.nextInt();
    }
}
