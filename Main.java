
/* 
Author Name:Kylie Hall
Date:3/15/21

General description of the code: This code will create a minesweeper board with 2D arrays! It will ask the user for 2 dimensions for the row and column of the 2D array and then it will print out an Array with randomly generated mines and values around each following the rules of minesweeper.

*/
import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("What is the first dimension you would like for the board?");
    int Dimension1 = input.nextInt();
    // Store user input for the amount of rows in the Array as Dimension1

    System.out.println("What is the second dimension you would like for the board?");
    int Dimension2 = input.nextInt();
    // Stores user input for the amount of columns in the Array as Dimension2

    int[][] MineSweepBoard = new int[Dimension1][Dimension2];
    // Creates 2D array with user input as row and columns

    // This statement will set the number of mines that there are.
    int NumberofMines = (Dimension1 + Dimension2) / 2;
    System.out.println("Number of mines: " + NumberofMines);

    Main M = new Main();
    M.Generator(NumberofMines, Dimension1, Dimension2, MineSweepBoard);
    // Calls for the Generator method
  }

  // MethodDescription: This method will call for randomly generated placements in
  // the 2D array to be set to 9 for the amount of mines.
  public void Generator(int NumberofMines, int Dimension1, int Dimension2, int[][] MineSweepBoard) {
    Random rgen = new Random();// initialize random
    int counter = -1;

    while (counter < NumberofMines) {
      // This will loop for the number of Mines there are in the array
      int randomRow = rgen.nextInt(Dimension1);
      // random number from 0-dimension1

      int randomColumn = rgen.nextInt(Dimension2);
      // random number from 0-dimension2

      // checks for any coordinates that may have been generated more than once and will then create a new coordinate.
      while (MineSweepBoard[randomRow][randomColumn] != 0 && MineSweepBoard[randomRow][randomColumn] != 9) {
        randomRow = rgen.nextInt(Dimension1);// random number from 0-dimension1
        randomColumn = rgen.nextInt(Dimension2);// random number from 0-dimension2
      }
      MineSweepBoard[randomRow][randomColumn] = 9;
      //Sets the coordinate equal to 9

      counter++;//makes progress with the loop and adds 1 to the value of counter
    }
    System.out.println();

//Nested for loop to read each element of the 2D array
    for (int a = 0; a < MineSweepBoard.length; a++) {
      for (int b = 0; b < MineSweepBoard[0].length; b++) {

        if (MineSweepBoard[a][b] == 9) {// The cell is 9, so add 1 to all adjacent cells

          if (a - 1 >= 0 && a + 1 < MineSweepBoard.length) {// if a-1 is not 0 and a+1 is less than length (check to
            // avoid index error)
            if (b - 1 >= 0 && b + 1 < MineSweepBoard[0].length) {

              if (MineSweepBoard[a][b - 1] != 9) {
                MineSweepBoard[a][b - 1] = MineSweepBoard[a][b - 1] + 1;
                // checks to the left of the mine
              }
              if (MineSweepBoard[a - 1][b] != 9) {
                MineSweepBoard[a - 1][b] = MineSweepBoard[a - 1][b] + 1;
                // checks above the mine
              }
              if (MineSweepBoard[a + 1][b - 1] != 9) {
                MineSweepBoard[a + 1][b - 1] = MineSweepBoard[a + 1][b - 1] + 1;
                // checks the bottom left corner of the mine
              }
              if (MineSweepBoard[a - 1][b + 1] != 9) {
                MineSweepBoard[a - 1][b + 1] = MineSweepBoard[a - 1][b + 1] + 1;
                // checks top right corner of the mine
              }
              if (MineSweepBoard[a - 1][b - 1] != 9) {
                MineSweepBoard[a - 1][b - 1] = MineSweepBoard[a - 1][b - 1] + 1;
                // checks upper left corner of the mine
              }
              if (MineSweepBoard[a + 1][b + 1] != 9) {
                MineSweepBoard[a + 1][b + 1] = MineSweepBoard[a + 1][b + 1] + 1;
                // checks lower right corner of the mine
              }
              if (MineSweepBoard[a][b + 1] != 9) {
                MineSweepBoard[a][b + 1] = MineSweepBoard[a][b + 1] + 1;
                // checks to the right of the mine
              }
              if (MineSweepBoard[a + 1][b] != 9) {
                MineSweepBoard[a + 1][b] = MineSweepBoard[a + 1][b] + 1;
                // checks one below the mine
              }
            } else {
              //This checks all values that will be against the top of the array
              if (b == 0) {

                MineSweepBoard[a - 1][b]++;
                MineSweepBoard[a - 1][b + 1]++;
                MineSweepBoard[a + 1][b + 1]++;
                MineSweepBoard[a][b + 1]++;
                MineSweepBoard[a + 1][b]++;
                // b - 1 doesn't happen
                // It is against the top
              } else {
              //This checks all of the values that will be against the bottom of the array 
                MineSweepBoard[a][b - 1]++;
                MineSweepBoard[a + 1][b - 1]++;
                MineSweepBoard[a - 1][b]++;
                MineSweepBoard[a + 1][b]++;
                MineSweepBoard[a - 1][b - 1]++;

                // b + 1 doesn't happen
                // It is against the bottom
              }
              // the cell is against the top or bottom, but not against a side.
            }

          } else {
            //This will check all values that are against the left side of the array
            if (b - 1 >= 0 && b + 1 < MineSweepBoard[0].length) {
              if (a == 0) {
                MineSweepBoard[a][b - 1]++;
                MineSweepBoard[a + 1][b - 1]++;
                MineSweepBoard[a + 1][b + 1]++;
                MineSweepBoard[a][b + 1]++;
                MineSweepBoard[a + 1][b]++;
                // a-1 doesn't happen
                // it is against the left side.
              } else {
                //This will check all values on the right side of the array
                MineSweepBoard[a][b - 1]++;
                MineSweepBoard[a][b - 1]++;
                MineSweepBoard[a - 1][b]++;
                MineSweepBoard[a - 1][b + 1]++;
                MineSweepBoard[a - 1][b - 1]++;
                MineSweepBoard[a][b + 1]++;

                // a+1 doesn't happen.
                // it is against the right side.
              }
              // the cell is not against the top or bottom, but is against a side.
            } else {
              // this is a corner in the array.
              if (a == 0) {
                if (b == 0) {

                  MineSweepBoard[a + 1][b + 1]++;
                  MineSweepBoard[a][b + 1]++;
                  MineSweepBoard[a + 1][b]++;
                  // a-1 doesn't happen AND b-1 doesn't happen.
                } else {
                  MineSweepBoard[a][b - 1]++;
                  MineSweepBoard[a + 1][b - 1]++;
                  MineSweepBoard[a + 1][b]++;
                  // a-1 doesn't happen AND b+1 doesn't happen.
                }
              } else {
                if (b == 0) {
                  MineSweepBoard[a][b + 1]++;
                  MineSweepBoard[a - 1][b]++;
                  MineSweepBoard[a - 1][b + 1]++;

                  // a+1 AND b-1 doesnt happen
                } else {

                  MineSweepBoard[a - 1][b]++;
                  MineSweepBoard[a - 1][b - 1]++;
                  MineSweepBoard[a][b - 1]++;

                  // a+1 AND b+1 doesnt happen
                }

              }
              // the cell is against the top or bottom and a side.

            }

          }
        }
        System.out.println();//Prints a space

        // prints 2D array with a nested for loop that prints each value
        for (int c = 0; c < MineSweepBoard.length; c++) {
          for (int d = 0; d < MineSweepBoard[0].length; d++) {

            System.out.print(MineSweepBoard[c][d]);
            //Prints each value of the 2D array
          }
          System.out.println();
        }

      }
    }
  }
}
