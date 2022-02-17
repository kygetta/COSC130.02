/* 
Author Name: Kylie Hall
Date Created:4/5/21
Date Last Modified:4/29/21

General description of the code:
Milestone 1: The code will scan in a file and then find the amount of rows and columns in the file. It will then put in values at each index of a declared 2d int array MazeBoard so the file matches the 2d int array. The array will then be printed out and be the same as the file chosen.

MileStone 2: The code will now recursively scan through the maze to find all path(s) and change each element of the path to '2'. The code will print out the end coordinate of the path and if there isn't an end the code will print "no end found".

Final Submission: The code will now backtrack through the maze to find the SHORTEST path int the maze. The maze will then be printed out showing this shortest path apart from the rest of the maze. This new array will then be printed into the .txt file SolvedMaze. 
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import java.io.File; 

import java.io.FileWriter;


class Main {

  //Below are the GLOBAL variables of the code.
  int Distance = 0; //Distance is used in the SolveMaze method to find the shortest path

  //starting position of maze is below [1,0]
int travelCol = 0; //Col 0
int travelRow = 1; //Row 0

//These variables will be used to find the exit of a maze.
int tRow = 0; //row begins at index 0 
int tCol = 0; //col begins at index 0



  public static void main(String[] args) throws IOException {
    Scanner scan = null;//Initialize scan to null to read in files
    ArrayList Row = new ArrayList();//Initialize ArrayList Row
    String Column = " ";//Initialize Column
    int increment = 0;//Initialize increment 
    int index = 0;//Initialize index

//These variables are used to find the end coordinate and to print if there is no end found where applicable.
  int end = 0;//Initialize end
  int end2 = 0;//Initialize end2
  int End = 0;//Initialize End
  boolean endfound = true;//Initialize as true

    Main M = new Main();//Creates instance of main

    M.Arrayfile(scan, Row, index, Column, increment, End, end, end2);//Calls for Arrayfile method


//This for loop will find the amount of columns in the 2d array
Column = (String)Row.get(0); //Column = the first row in the arraylist to then find how many characters are in that row (which is the amount of columns)
for(int a=0;a<Column.length();a++){
  if(Column.charAt(a)=='1'){//if the character is equal to one then add 1 value to the index to find the amount of columns
   index++;//makes progress
  }
}
  M.MakeArray(Row, index, endfound, End, end, end2);//Call for the MakeArray method
  
  }

//MethodDescription: This method will find the amount of rows in the 2d array scanned in from a file recursively 
  public void Arrayfile(Scanner scan, ArrayList Row, int index, String Column, int increment, int End, int end, int end2) {

    try {
      if (Row.size() == 0) {//if the row size is 0, the file will be scanned in.. this ensures the file will only be scanned in once.
        scan = new Scanner(new FileReader("Split.txt"));
      }
      if (scan.hasNext()) {

        String Line = scan.nextLine();//String line is scanned in and stored for each line of the 2d array file
        Row.add(Line);//This line is then added to the arraylist Row.


       Arrayfile(scan, Row, index,  Column, increment+1, End, end, end2);//Recursive statement 
      }

    } catch (IndexOutOfBoundsException e) {//Catch exceptions for try block
      System.out.println("Exception: "+e);

    }catch (Exception e) {//Catch exceptions for try block
      System.out.println("Exception: "+e);

    } finally {//finally statement 
      if (scan != null) {
        scan.close();
      }
    }
  }
  //MethodDescription: This method will create the 2d int array MazeBoard with the row and column found in past methods. It will then put values into each space of the 2d array MazeBoard and print it out.
  public void MakeArray(ArrayList Row, int index, boolean endfound,int End, int end, int end2){

    String ArrayValues = " "; //Holds value in array, passed on
    int[][] MazeBoard = new int[Row.size()][index];//Declares int MazeBoard 2d array

//This nested for loop will find when the index equals 1 in the file string, then it will set those values equal to the one in the MazeBoard 2d array.
    for(int a=0;a<Row.size();a++){
      for(int b=0;b<index;b++){
      ArrayValues = (String)Row.get(a);//Array values is looping through each row in the 2d array

      //Source used for replace all https://www.geeksforgeeks.org/java-lang-string-replace-method-java/
      ArrayValues = ArrayValues.replaceAll(" ", "");
      
      //if the placement equals 1 or 0 in the string then place that into the mazeboard

if(ArrayValues.charAt(b) == '1' ){//if at row a and column b, the index is equal to 1...
MazeBoard[a][b] = 1;//..then Mazeboard at this index is also 1 (puts in the value of 1 at this space)
}else {
  MazeBoard[a][b] = 0;//otherwise, that index is equal to 0
}
      }
    }

    //This nested for loop prints out the 2d int array MazeBoard
for(int i=0;i<MazeBoard.length;i++){
  for(int j=0;j<MazeBoard[0].length;j++){
    System.out.print(MazeBoard[i][j]);
    System.out.print(" ");
  }
  System.out.println();
}

//Calls for SolveMaze Method
SolveMaze(MazeBoard, travelCol, travelRow, end, end2, tRow, tCol, endfound, End);

//calls for the printArray method which will print the 2D array with all spaces = 2 to show the entire maze has been discovered.
printArray(MazeBoard, end, end2, End, endfound);

//Calls for ShortestPath method
//ShortestPath(MazeBoard, sRow, sCol);

//Calls for printArray method to print the 2D array with the SHORTEST path
//printArray(MazeBoard, end, end2, End, endfound);

//This method must be called with the try catch to avoid error because it is using filewrite.
try{
  //Calls for WritetoFile method.
 WritetoFile(MazeBoard);
}catch(IOException error){
}

  }


//MethodDescription: This method will first scan through the maze and change the path to have each element = '2'. There are if statments that have different recursive calls that changes what makes progress depending on which if statement is triggered.
//After this, there are then a series of if statements that will find the exit to the maze and if there is no exit, the variable will be printed out as initialized "No end found".
  public boolean SolveMaze(int[][] MazeBoard, int travelCol, int travelRow, int end, int end2, int tRow, int tCol, boolean endfound, int End){
    boolean success = false;

try{
//base case to ensure all int variables are not out of bounds
if(travelCol<MazeBoard[0].length-1 && travelRow<MazeBoard.length-1 &&travelCol>=0 &&travelRow>=0){

//Entry place will be equal to 2 everytime it loops
  MazeBoard[travelRow][travelCol] = 2;

//checks to the left of the current 0
if(travelCol-1>=0 && travelRow>=0 && MazeBoard[travelRow][travelCol-1] == 0 ){
  //If this space is equal to 0 then this is a new place in the path.
  MazeBoard[travelRow][travelCol-1] = 2;
  //sets this place equal to 2

 Distance = Distance + 1;//Distance is used to find how long the path is. If the path continues, add 1 to length!

  SolveMaze(MazeBoard, travelCol-1, travelRow, end, end2, tRow, tCol, endfound, End);
  //recursive call
   
}
//checks to the right of the current 0
if(travelCol+1>=0 &&travelRow>=0 && MazeBoard[travelRow][travelCol+1] == 0 ){
  //If this space is equal to 0 then this is a new place in the path
  MazeBoard[travelRow][travelCol+1] = 2;
  //sets this place equal to 2

 Distance = Distance + 1;//Distance is used to find how long the path is. If the path continues, add 1 to length!

  SolveMaze(MazeBoard, travelCol+1, travelRow, end, end2, tRow, tCol, endfound, End);
  //recursive call

}
//checks below the current 0
if(travelRow-1>=0 && travelCol>=0 && MazeBoard[travelRow-1][travelCol] == 0 ){
  //If this space is equal to 0 then this is a new place in the path
  MazeBoard[travelRow-1][travelCol] = 2;
  //sets this place equal to 2

 Distance = Distance + 1;//Distance is used to find how long the path is. If the path continues, add 1 to length!

  SolveMaze(MazeBoard, travelCol, travelRow-1, end, end2, tRow, tCol, endfound, End);
  //recursive call

}
//checks above the current 0  
if(travelRow+1>=0 &&travelCol>=0 && MazeBoard[travelRow+1][travelCol] == 0 ){
  //If this space is equal to 0 then this is a new place in the path
  MazeBoard[travelRow+1][travelCol] = 2;
  //sets this place equal to 2

 Distance = Distance + 1;//Distance is used to find how long the path is. If the path continues, add 1 to length!

  SolveMaze(MazeBoard, travelCol, travelRow+1, end, end2, tRow, tCol, endfound, End);
  //recursive call
  
}

//The below section of if statements will find the exit point in the maze.

//if an element in the last row is 2 then this is an exit
if( MazeBoard[MazeBoard.length-1][tCol] == 2  ){

//If there is an end, stop scanning through if statements and return true.
if(!endfound){
  success = true;
  
}

//if endfound is true (meaning there has not been a found exit then the if statement will be triggered.
  if(endfound){
    //prints the exit coordinate if it is in the last row
  System.out.println("Exit Coordinate: "+(MazeBoard.length-1) + "," + tCol);
  }

//if an element in the last column is 2 then this is an exit
}else if( MazeBoard[tRow][MazeBoard[0].length-1] == 2){
  
  if(endfound){
    //prints end coordinate if it is in the last col
  System.out.println("End Coordinate: "+tRow+ "," + (MazeBoard[0].length-1));
  return !endfound;
  }

//if no end was found it will keep looping (base case keeps it in range).
}else if(MazeBoard[tRow][MazeBoard[0].length-1] != 2 && MazeBoard[MazeBoard.length-1][tCol] != 2){
   if(endfound){
     //recursive statement 
  SolveMaze(MazeBoard, travelCol, travelRow, end, end2, tRow+1, tCol+1, true, End);
}
}
}
//Catch statements for try catch block
}catch(ArrayIndexOutOfBoundsException e){
}catch(Exception e){
}
return false;
  }

//MethodDescription: This method will find the SHORTEST path in the maze by backtracking through the 2D array and finding the length of each path.
  public boolean ShortestPath(int[][] MazeBoard, int sRow, int sCol){

try{
  //base case to make sure the variables stay within the boundaries of index.
  if(sCol<MazeBoard[0].length-1 && sRow<MazeBoard.length-1 &&sCol>=0 &&sRow>=0){

    MazeBoard[sRow][sCol] = 3;//sets current place equal to 3 to keep track of what is scanned.

//if this is a scanned/current spot...
    if(MazeBoard[5][6] == 3){
      
      //return true.
            return true;
        }
        //Checks to the right of the current spot
            if( MazeBoard[sRow][sCol+1] == 2){
              //If it is the next spot in the path then set this equal to 3
              MazeBoard[sRow][sCol+1] = 3;
              ShortestPath(MazeBoard, sRow, sCol+1);
        //Checks below current spot
                return true;
            } if ( MazeBoard[sRow+1][sCol] == 2 ){
              //If it is the next spot in the path then set this equal to 3
                MazeBoard[sRow+1][sCol] = 3;
                ShortestPath(MazeBoard, sRow+1, sCol);
        //Checks to left of current spot       
                return true;
            } if (MazeBoard[sRow][sCol-1] == 2  ){
              //If it is the next spot in the path then set this equal to 3
                MazeBoard[sRow][sCol-1] = 3;
                ShortestPath(MazeBoard,sRow, sCol-1);
        //Checks above current spot        
                return true;
            } if ( MazeBoard[sRow-1][sCol] == 2 ){
              //If it is the next spot in the path then set this equal to 3
                MazeBoard[sRow-1][sCol] = 3;
                ShortestPath(MazeBoard, sRow-1, sCol);
               return true;
            }
        }else {
          //if there is no path next, the rest of the path should be equal to 0
          MazeBoard[sRow][sCol] = 0;
            return false;
        }
  //if the beginning of path is reached, then set that equal to 3 and stop scanning
   if(sRow == 1 && sCol == 0) {
          MazeBoard[sRow][sCol] = 3;
            return false;
   }
}catch(Exception e){
  }
  return false;
  }
  

//MethodDescription: This method will write to the SolveMaze.txt file and it will print the final maze with the shortest path.
public void WritetoFile(int[][] MazeBoard) throws IOException{
  
   FileWriter output = new FileWriter("SolvedMaze.txt");//Instance of filewriter. .txt file is SolveMaze

   //We are adding each element in the 2D array MazeBoard so there needs to be a nested for loop.
  for(int i=0;i<MazeBoard.length;i++){
  for(int j=0;j<MazeBoard[0].length;j++){
    //This will write to the txt file each element in the array.
    output.write(MazeBoard[i][j]+ " ");
  }
  //This will print to a new line to make sure the array prints in the correct format.
  output.write("\n");
  }
  //close filewriter after the array is added to txt file.
    output.close();
}


//MethodDescription: This method will print the final maze.
  public void printArray(int[][] MazeBoard, int end, int end2, int End, boolean endfound){
    
    //prints 2d MazeBoard array.
for(int i=0;i<MazeBoard.length;i++){
  for(int j=0;j<MazeBoard[0].length;j++){
    System.out.print(MazeBoard[i][j]);
    System.out.print(" ");
  }
  System.out.println();
}
  }
}