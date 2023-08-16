public class Board {
    char board[][];

    Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }
    public boolean endGame(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(board[i][j] == ' ')
                    return false;
        return true;
    }

    public boolean checkWinner() {
        if (board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != ' ')
            return true;
        else if (board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != ' ')
            return true;
        else if (board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != ' ')
            return true;
        else if (board[0][0] ==  board[1][0] &&  board[0][0] ==  board[2][0] && board[0][0] != ' ')
            return true;
        else if (board[0][1] ==  board[1][1] &&  board[0][1] ==  board[2][1] && board[0][1] != ' ')
            return true;
        else if (board[0][2] ==  board[1][2] &&  board[0][2] ==  board[2][2] && board[2][2] != ' ')
            return true;
        else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ')
            return true;
        else if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[2][0] != ' ')
            return true;
        else return false;
    }

    public void printBoard(){
        System.out.printf("\n0           |1                  |2             \n" +
                         "       %s    |          %s        |        %s       \n" +
                "____________|___________________|________________\n" +
                " 3          |4                  |5                 \n" +
                "      %s     |         %s         |    %s      \n" +
                "____________|___________________|________________\n" +
                " 6          |7                  |8              \n" +
                "    %s       |        %s          |         %s          \n" +
                "            |                   |               ", board[0][0], board[0][1], board[0][2],board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
    }
}
