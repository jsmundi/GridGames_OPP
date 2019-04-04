Jaiteg Mundi

## Tic Tac Toe Game 3x3

The game is classic game of tic Tac Toe. A user inputs their username and after that selects X or O. User always go first regardless of their choice. Prompt to enter row and column is provided to place a mark on the grid after that computer makes a move using place mark algorithm. The game goes on until win, loss or tie is reached. 

Win: Place either X or O consecutively in row, column or diagonally. The first to do so will win. 
Tie: No body is able to achieve win status and no more grid space is available. 

## Connect 4

The game is basically classic game of tic Tac Toe on 4x4 grid. A user inputs their username and after that selects B or Y. User always go first regardless of their choice. Prompt to enter row and column is provided to place a mark on the grid after that computer makes a move using place mark algorithm. The game goes on until win, loss or tie is reached. 

Win: Place either B or Y consecutively in row, column or diagonally. The first to do so will win. 
Tie: No body is able to achieve win status and no more grid space is available. 


## Computer Algorithm

The computer algorithm runs a for loop over the entire game board grid. First, the algorithm places a mark in each cell and then check if that would result in a win for the computer. If the move results in a win the mark is placed in that cell and the program returns back to main resulting in a win for the computer. If the winning move is not available for the computer, algorithm runs another loop on the game board grid placing opponents mark, if that results in a win for opponent the algorithm places a mark there blocking the win. This is one of the weakness of the algorithm it only checks for one possible win and exits. Blocking one win possibility can still leave another option open. Second, if the very first check results in no winning for opponent or the computer a random mark is placed on the grid in an empty cell. 

## Directory Tree 
```
.
├── 3Grid
│   ├── Grid.java
│   ├── GridGame.java
│   ├── Main.java
│   └── TicTacToe.java
└── 4Grid
    ├── ConnectFour.java
    ├── Grid.java
    ├── GridGame.java
    └── Main.java

2 directories, 8 files
```

## Compile

The 3Grid contains a Tic Tac Toe game which can be compiled using terminal on Unix machines which have Java (Tested on java version "1.8.0_201”) 

Run the ```Make``` command in the 3Grid or 4Grid directory. 

## Run the game

```Make run```  in the 3Grid or 4Grid directory. 

