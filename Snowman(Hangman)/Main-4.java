/* 
Author Name: Kylie Hall
Date Created: 1/14/2021
Date Last Modified:

General description of the code: //This code will run the snowman(hangman) game. There will be a randomly generated word out of 20 with lengths from 4 to 12 letters long and the user will have to input possible characters for the secret word until they either win or input 6 incorrect guesses in which the user will lose. The user will get the option to play again.


See a full project Description here. https://docs.google.com/document/d/1NIs9ORg_9E8Z3v8vMCliga-rmm5fnzd70Hi9kyXCcC8/edit?usp=sharing
*/

public class Main {
  public static void main(String[] args) {
    // Make sure to fully comment your code
    // This should be done for every milestone not just the final submission
    
   
   RandomWord rgen = new RandomWord();

   rgen.wordGen();
   //Calls for method wordGen in class rgen.
  
   
  }
}