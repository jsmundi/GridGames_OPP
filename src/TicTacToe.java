import java.util.Random;

public class TicTacToe extends GridGame {

    private Grid newGame;
    private int gridN = 3;

    @Override
    public void initializeBoard() {
        newGame = new Grid(gridN);
    }

    @Override
    public int checkCol() {

        for (int i = 0; i < gridN; i++) {
            if ((newGame.getCell(0, i) == 1 && newGame.getCell(1, i) == 1 && newGame.getCell(2, i) == 1)) {
                return 1;

            } else if ((newGame.getCell(0, i) == 2 && newGame.getCell(1, i) == 2 && newGame.getCell(2, i) == 2)) {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public int checkRow() {

        for (int i = 0; i < gridN; i++) {
            if ((newGame.getCell(i, 0) == 1 && newGame.getCell(i, 1) == 1 && newGame.getCell(i, 2) == 1)) {
                return 1;

            } else if ((newGame.getCell(i, 0) == 2 && newGame.getCell(i, 1) == 2 && newGame.getCell(i, 2) == 2)) {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public int checkDig() {
        if (newGame.getCell(0, 0) == 1 && newGame.getCell(1, 1) == 1 && newGame.getCell(2, 2) == 1
                || (newGame.getCell(0, 2) == 1 && newGame.getCell(1, 1) == 1 && newGame.getCell(2, 0) == 1)) {
            return 1;
        } else if (newGame.getCell(0, 0) == 2 && newGame.getCell(1, 1) == 2 && newGame.getCell(2, 2) == 2
                || (newGame.getCell(0, 2) == 2 && newGame.getCell(1, 1) == 2 && newGame.getCell(2, 0) == 2)) {
            return 2;
        }
        return 0;
    }

    @Override
    public Boolean isDraw() {

        for (int row = 0; row < gridN; row++) {
            for (int column = 0; column < gridN; column++) {
                if (!newGame.isSet(row, column)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int getStatus() {
        if (checkCol() == 1 || checkRow() == 1 || checkDig() == 1) {
            return 1;
        } else if (checkCol() == 2 || checkRow() == 2 || checkDig() == 2) {
            return 2;
        } else {
            if (isDraw()) {
                return 3;
            }
        }
        return 0;
    }

    @Override
    public Boolean placeMark(int row, int col, int player) {

        if ((row >= 0) && (row < gridN)) {
            if ((col >= 0) && (col < gridN)) {
                if (!newGame.isSet(row, col)) {
                    newGame.setCell(row, col, player);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void placeMark(int player) {

        int temp = 0;

        for (int row = 0; row < gridN; row++) {
            for (int column = 0; column < gridN; column++) {

                if(!newGame.isSet(row,column)) {

                    newGame.setCell(row,column,player);
                    if (getStatus() == 1 || getStatus() == 2 || getStatus() == 3) {
                        newGame.setCell(row,column,0);
                        placeMark(row,column,player);
                        return;
                    } else {
                        newGame.setCell(row, column, 0);
                    }

                    if (player == 1)
                    {
                        temp = 2;
                    }
                    else {
                        temp = 1;
                    }

                    newGame.setCell(row,column,temp);
                    if (getStatus() == 1 || getStatus() == 2 || getStatus() == 3) {
                        newGame.setCell(row,column,0);
                        placeMark(row,column,player);
                        return;
                    } else {
                        newGame.setCell(row, column, 0);
                    }
                }
            }
        }

        while (true) {

            if(placeMark(1,1,player))
            {
                return;
            }
            else {
                Random rand = new Random();
                int x = rand.nextInt(3);
                int y = rand.nextInt(3);

                if (newGame.getCell(x, y) == 0) {   //Check if spot is empty
                    placeMark(x, y, player);
                    return;
                }
            }
        }

    }

    @Override
    public void printGrid() {

        System.out.println("-------------");
        for (int row = 0; row < gridN; row++) {
            System.out.print("|");

            for (int column = 0; column < gridN; column++) {
                if (newGame.getCell(row, column) == 1) {
                    System.out.print(" X ");
                } else if (newGame.getCell(row, column) == 2) {
                    System.out.print(" Y ");
                } else if (newGame.getCell(row, column) == 0) {
                    System.out.print(" - ");
                }
                System.out.print("|");

            }
            System.out.print("\n");

        }
        System.out.println("-------------");
    }

    @Override
    public void restart() {
        newGame.clear();
    }
}
