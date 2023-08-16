public class ComputerPlayer extends Player {
    Board b;

    public ComputerPlayer(char turn, Board b) {
        super(turn, b);
    }

    public int winGamer() {
        if (board.board[0][0] == symbol && board.board[0][1] == symbol && board.board[0][2] == ' ')
            return 2;
        else if (board.board[0][0] == symbol && board.board[0][2] == symbol && board.board[0][1] == ' ')
            return 1;
        else if (board.board[0][2] == symbol && board.board[0][1] == symbol && board.board[0][0] == ' ')
            return 0;
            //first row
        else if (board.board[1][0] == symbol && board.board[1][2] == symbol && board.board[1][1] == ' ')
            return 4;
        else if (board.board[1][0] == symbol && board.board[1][1] == symbol && board.board[1][2] == ' ')
            return 5;
        else if (board.board[1][1] == symbol && board.board[1][2] == symbol && board.board[1][0] == ' ')
            return 3;
            //second row
        else if (board.board[2][0] == symbol && board.board[2][1] == symbol && board.board[2][2] == ' ')
            return 8;
        else if (board.board[2][0] == symbol && board.board[2][2] == symbol && board.board[2][1] == ' ')
            return 7;
        else if (board.board[2][1] == symbol && board.board[2][2] == symbol && board.board[2][0] == ' ')
            return 6;
            // third row
        else if (board.board[0][0] == symbol && board.board[1][0] == symbol && board.board[2][0] == ' ')
            return 6;
        else if (board.board[0][0] == symbol && board.board[2][0] == symbol && board.board[1][0] == ' ')
            return 3;
        else if (board.board[1][0] == symbol && board.board[2][0] == symbol && board.board[0][0] == ' ')
            return 0;
            //first col
        else if (board.board[0][1] == symbol && board.board[1][1] == symbol && board.board[2][1] == ' ')
            return 7;
        else if (board.board[0][1] == symbol && board.board[2][1] == symbol && board.board[1][1] == ' ')
            return 4;
        else if (board.board[2][1] == symbol && board.board[1][1] == symbol && board.board[0][1] == ' ')
            return 1;
            // second col
        else if (board.board[0][2] == symbol && board.board[1][2] == symbol && board.board[2][2] == ' ')
            return 8;
        else if (board.board[0][2] == symbol && board.board[2][2] == symbol && board.board[1][2] == ' ')
            return 5;
        else if (board.board[2][2] == symbol && board.board[1][2] == symbol && board.board[0][2] == ' ')
            return 2;
            //third col
        else if (board.board[0][0] == symbol && board.board[1][1] == symbol && board.board[2][2] == ' ')
            return 8;
        else if (board.board[1][1] == symbol && board.board[2][2] == symbol && board.board[0][0] == ' ')
            return 0;
        else if (board.board[0][0] == symbol && board.board[2][2] == symbol && board.board[1][1] == ' ')
            return 4;
            //main dag
        else if (board.board[0][2] == symbol && board.board[1][1] == symbol && board.board[2][0] == ' ')
            return 6;
        else if (board.board[0][2] == symbol && board.board[2][0] == symbol && board.board[1][1] == ' ')
            return 4;
        else if (board.board[1][1] == symbol && board.board[2][0] == symbol && board.board[0][2] == ' ')
            return 2;
        else return -1;

    }

    public int blockWin() {
        if (board.board[0][0] == board.board[0][1] && board.board[0][1] != symbol && board.board[0][2] == ' ' && board.board[0][0] != ' ')
            return 2;
        else if (board.board[0][0] == board.board[0][2] && board.board[0][0] != symbol && board.board[0][1] == ' ' && board.board[0][0] != ' ')
            return 1;
        else if (board.board[0][2] == board.board[0][1] && board.board[0][2] != symbol && board.board[0][0] == ' ' && board.board[0][2] != ' ')
            return 0;
            //first row
        else if (board.board[1][0] == board.board[1][2] && board.board[1][0] != symbol && board.board[1][1] == ' ' && board.board[1][0] != ' ')
            return 4;
        else if (board.board[1][0] == board.board[1][1] && board.board[1][0] != symbol && board.board[1][2] == ' ' && board.board[1][0] != ' ')
            return 5;
        else if (board.board[1][1] == board.board[1][2] && board.board[1][1] != symbol && board.board[1][0] == ' ' && board.board[1][1] != ' ')
            return 3;
            //second row
        else if (board.board[2][0] == board.board[2][1] && board.board[2][0] != symbol && board.board[2][2] == ' ' && board.board[2][0] != ' ')
            return 8;
        else if (board.board[2][0] == board.board[2][2] && board.board[2][2] != symbol && board.board[2][1] == ' ' && board.board[2][0] != ' ')
            return 7;
        else if (board.board[2][1] == board.board[2][2] & board.board[2][2] != symbol && board.board[2][0] == ' ' && board.board[2][1] != ' ')
            return 6;
            // third row
        else if (board.board[0][0] == board.board[1][0] && board.board[0][0] != symbol && board.board[2][0] == ' ' && board.board[0][0] != ' ')
            return 6;
        else if (board.board[0][0] == board.board[2][0] && board.board[0][0] != symbol && board.board[1][0] == ' ' && board.board[0][0] != ' ')
            return 3;
        else if (board.board[1][0] == board.board[2][0] && board.board[1][0] != symbol && board.board[0][0] == ' ' && board.board[1][0] != ' ')
            return 0;
            //first col
        else if (board.board[0][1] == board.board[1][1] && board.board[0][1] != symbol && board.board[2][1] == ' ' && board.board[0][1] != ' ')
            return 7;
        else if (board.board[0][1] == board.board[2][1] && board.board[0][1] != symbol && board.board[1][1] == ' ' && board.board[0][1] != ' ')
            return 4;
        else if (board.board[2][1] == board.board[1][1] && board.board[1][1] != symbol && board.board[0][1] == ' ' && board.board[1][1] != ' ')
            return 1;
            // second col
        else if (board.board[0][2] == board.board[1][2] && board.board[0][2] != symbol && board.board[2][2] == ' ' && board.board[0][2] != ' ')
            return 8;
        else if (board.board[0][2] == board.board[2][2] && board.board[0][2] != symbol && board.board[1][2] == ' ' && board.board[0][2] != ' ')
            return 5;
        else if (board.board[2][2] == board.board[1][2] && board.board[2][2] != symbol && board.board[0][2] == ' ' && board.board[2][2] != ' ')
            return 2;
            //third col
        else if (board.board[0][0] == board.board[1][1] && board.board[0][0] != symbol && board.board[2][2] == ' ' && board.board[0][0] != ' ')
            return 8;
        else if (board.board[1][1] == board.board[2][2] && board.board[1][1] != symbol && board.board[0][0] == ' ' && board.board[1][1] != ' ')
            return 0;
        else if (board.board[0][0] == board.board[2][2] && board.board[0][0] != symbol && board.board[1][1] == ' ' && board.board[0][0] != ' ')
            return 4;
            //main dag
        else if (board.board[0][2] == board.board[1][1] && board.board[0][2] != symbol && board.board[2][0] == ' ' && board.board[0][2] != ' ')
            return 6;
        else if (board.board[0][2] == board.board[2][0] && board.board[0][2] != symbol && board.board[1][1] == ' ' && board.board[0][2] != ' ')
            return 4;
        else if (board.board[1][1] == board.board[2][0] && board.board[1][1] != symbol && board.board[0][2] == ' ' && board.board[1][1] != ' ')
            return 2;

        else return -1;
    }
    public int combineMove(){
        int place = -1;
        if(winGamer() != -1) return winGamer();
        if(blockWin() != -1) return blockWin();
        return -1;
    }

    public int playTurn() {
        int place = winGamer();
        if (place == -1)
        place = blockWin() != -1 ? blockWin() : randomMove();

        return place;
    }

    public int randomMove() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board.board[i][j] == ' ')
                    return i * 3 + j;
        return -1;
    }

}
