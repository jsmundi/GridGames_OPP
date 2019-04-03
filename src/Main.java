import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        TicTacToe game = new TicTacToe();

        String userName;
        int gameStatus = 0;
        int userPlayer;
        int compPlayer;
        int turn;
        int xCord;
        int yCord;

        while(gameStatus != 1) {

            System.out.println("Welcome to Tic Tac Toe Game!");
            System.out.println("Please enter Gamer Name (Example: FlyingCat)");
            userName = myObj.nextLine();

            while (true) {
                System.out.println("Please select your Mark X or Y. Press 1 for X and 2 for Y");
                userPlayer = myObj.nextInt();
                if (userPlayer == 1 || userPlayer == 2) {
                    break;
                }
            }

            if (userPlayer == 1) {
                System.out.println(userName + " You have selected X");
                turn = 1;
                compPlayer = 2;
            } else {
                System.out.println(userName + " You have selected Y");
                turn = 1;
                compPlayer = 1;
            }

            System.out.println("Coordinate layout");
            System.out.println("(0,0) (0,1) (0,2)\n(1,0) (1,1) (1,2)\n(2,0) (2,1) (2,2)");
            System.out.println("Starting new game. Good luck " + userName);
            game.initializeBoard();

            while (game.getStatus() != 1 && game.getStatus() != 2 && game.getStatus() != 3) {
                if (turn == 1) {
                    turn = 2;
                    while (true) {
                        System.out.println(userName+" it is your turn now.");
                        System.out.println("Enter Row Number: ");
                        xCord = myObj.nextInt();
                        System.out.println("Enter Column Number: ");
                        yCord = myObj.nextInt();
                        if (xCord == 0 || xCord == 1 || xCord == 2 || yCord == 0 || yCord == 1 || yCord == 2) {
                            if (!game.placeMark(xCord, yCord, userPlayer)) {
                                System.out.println("Invalid move try again");
                            } else {
                                break;
                            }
                        }
                    }
                    game.printGrid();
                } else {
                    turn = 1;
                    System.out.println("Computer's turn");
                    game.placeMark(compPlayer);
                    game.printGrid();
                }
            }


            if (game.getStatus() == userPlayer) {
                System.out.println(userName + " wins!");
            } else if (game.getStatus() == 3) {
                System.out.println("Its a tie!");
            } else {
                System.out.println("Computer wins!");
            }

            System.out.println("Enter 0 for new game and 1 to exit");
            gameStatus = myObj.nextInt();
        }

    }
}
