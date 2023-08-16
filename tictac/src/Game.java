import java.util.Random;
import java.util.Scanner;

public class Game {
    Board board;
    Player human;
    ComputerPlayer computer;
    boolean turn;


    public Game() {
        board = new Board();
        Random random = new Random();
        turn = random.nextBoolean();
    }

    public int rotateBoard(int numOfRotation) {
        char temp;
        char tempEdges;
        for (int i = 0; i < numOfRotation; i++) {
            temp = board.board[0][1];
            board.board[0][1] = board.board[1][0];
            board.board[1][0] = board.board[2][1];
            board.board[2][1] = board.board[1][2];
            board.board[1][2] = temp;
            tempEdges = board.board[0][0];
            board.board[0][0] = board.board[2][0];
            board.board[2][0] = board.board[2][2];
            board.board[2][2] = board.board[0][2];
            board.board[0][2] = tempEdges;
        }
        return 4 - numOfRotation;
    }

    public void chooseSymbol() {
        if (turn) {
            human = new Player('X', board);
            computer = new ComputerPlayer('O', board);
        } else {
            human = new Player('O', board);
            computer = new ComputerPlayer('X', board);
        }
    }

    public void runGame() {

        chooseSymbol();
        if (!turn) { // computer starts
            int option;
            System.out.println(computer.symbol);
            board.board[0][0] = 'X';
            board.printBoard();
            playTurn(human);
            board.printBoard();
            if (board.board[0][1] != ' ' || board.board[0][2] != ' ' || board.board[1][2] != ' '|| board.board[2][2] != ' ') {
                board.board[2][0] = 'X';
                option = 1;
            }
            else if (board.board[1][1] != ' ') {
                board.board[2][2] = 'X';
                option = 2;
            }

            else{
                board.board[0][2] = 'X';
                option = 3;
            }

            board.printBoard();
            playTurn(human);
            int block = computer.blockWin();
            if(block == -1)
            switch(option){
//                 /*
//                    x | (O)  |(O)
//                    --|----|---
//                    __|____|_(O)__
//                      |    |
//                     */
                case 1:
                   if(board.board[0][2] == 'O' || board.board[2][2] == 'O')
                       board.board[2][2] = 'X';
                    else board.board[1][1] = 'X';
                    break;
                case 2:
                    if(computer.combineMove() != -1)
                        playTurn(computer);
                    break;



                case 3:
                    if(board.board[2][0] == 'O')
                        board.board[2][2] = 'X';
                    else{
                        board.board[1][1] = 'X';
                    }
                    break;

                default:

            board.printBoard();
            }else{
                playTurn(computer);
            }
            board.printBoard();
            turn = true;


        } else {// human starts
            int rotateBack;
            int place;
            board.printBoard();
            playTurn(human);
            if (board.board[1][0] == 'X' || board.board[2][0] == 'X') {
                rotateBack = rotateBoard(1);// second part after
            }else if (board.board[2][2] == 'X' || board.board[2][1] == 'X')
                rotateBack = rotateBoard(2);
            else if (board.board[1][2] == 'X' || board.board[0][2] == 'X')
                rotateBack = rotateBoard(3);
            else rotateBack = 0;
            /*
            in this situation no matter what the player played it will always see as
            x |    |
            --|----|---
            __|____|___
              |    |
            or
              | x  |
            --|----|---
            __|____|___
              |    |

             */
            if (board.board[1][1] == ' ')
                board.board[1][1] = 'O';
            else playTurn(computer);
            rotateBoard(rotateBack);
            board.printBoard();
            playTurn(human);
            board.printBoard();
            place = computer.blockWin();
            if(board.board[1][1] == 'X') {
                turn =! turn;
                basicGame();
            }
            if (place == -1) {
                rotateBoard(4 - rotateBack);
                board.printBoard();

                //case 1: player played in the middle of thr row or col
                if (board.board[0][1] == 'X') {
                    if (board.board[1][0] == 'X' || board.board[2][0] == 'X')
                        board.board[0][0] = 'O';
                    else if (board.board[2][2] == 'X' || board.board[1][2] == 'X')
                        board.board[0][2] = 'O';
                    else
                        playTurn(computer);
                    rotateBoard(rotateBack);
                    board.printBoard();
                }
                // case 2: player played in one of the corners
                else if (board.board[0][0] == 'X') {
                    if (board.board[2][1] == 'X')
                        board.board[1][0] = 'O';
                    else if (board.board[1][2] == 'X')
                        board.board[0][1] = 'O';
                    else if (board.board[2][2] == 'X')
                        board.board[1][0] = 'O';
                    else playTurn(computer);
                    rotateBoard(rotateBack);
                    board.printBoard();
                }
                turn = true;
            } else {
                playTurn(computer);
            }
        }
        basicGame();
        }

    public void basicGame(){
        while (!endGame()) {
            if (turn)
                playTurn(human);
            else
                playTurn(computer);
            board.printBoard();
            turn = !turn;
        }
    }


    public void playTurn(Player p) {
        int place = p.playTurn();
        if (place != -1) {
            int col = place / 3;
            int row = place % 3;
            board.board[col][row] = p.symbol;
        }
    }

    public boolean endGame() {
        if (board.checkWinner()) {
            if (turn)
                System.out.println("Computer Won");
            else
                System.out.println("Human Won");
            return true;
        }
        return board.endGame();
    }
}

