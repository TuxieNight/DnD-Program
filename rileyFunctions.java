/*
Riley Howardsmith
This is my program for while loops
11/12/2021
This program contains a function that we will get a
lot of use out of!!  Keep this forever!!
*/
import javax.swing.*;

public class rileyFunctions
{
   // This is a function we will start with
   // its job is to get a value (number) from the user
   // it will keep asking the user to enter a value until
   // a number is entered.
   public static int getValue(String question, String title, int icon)
   {
      String input;
      int numEntered = 0;
      boolean valid = false; //a boolean variable that starts as false
     
      
         //Your while loop will go here 
         while(valid == false) //OR (!valid) --- both are TRUE statements, you're doing it until valid IS TRUE.
         {
         // while the user enters something that is not valid
         // ask the user for a number
         input = JOptionPane.showInputDialog(null,question, title, icon);
         // try to parse it (if you can parse it change valid to true)
         try{
            numEntered = Integer.parseInt(input);
            valid = true;
         }
         // catch any errors and display a more user friendly message
         catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sorry. Your input, "+input+", could not be accepted. Try again.");
         }
         }//end of while loop
         return numEntered;
   }//end of get_value function************************************

  public static void removeExtraSpace(String s)
  {
    //gets rid of multiple spaces in a row
    for(int j = 0; j < s.length()-2; j++)
    {
      String str1 = s.charAt(j)+"";
      String str2 = s.charAt(j+1)+"";
      if(str1.equals(" ") && str2.equals(" "))
      {
        s = s.substring(0,j+1)+s.substring(j+2);
        j--;
      }
    }
    //gets rid of excess spaces at end that the previous loop can't reach
    for(int l = s.length()-1; l > 1; l--)
      {
        String str = s.charAt(l)+"";
        if(str.equals(" "))
        {
          s = s.substring(0, l);
        }
        //if a non-space character is reached, get out of the loop
        else
        {
          break;
        }
      }
  }
  /*
   public static void guessGame()
   {
     //declare variables
     int chosenNum = -1, secretNum = (int)(Math.random()*100)+1, numGuess = 0;
     //user is continually asked to guess the secret number until they get it right
     while(chosenNum != secretNum){
     chosenNum = getValue("I'm thinking of an integer between 1 and 100. Guess my number.", "GUESSING GAME", -1);
     if(chosenNum < 1 || chosenNum > 100){
     JOptionPane.showMessageDialog(null,chosenNum+" is an invalid number. Try again, you can do it!","MESSAGE FROM YOUR FRIENDLY COMPUTER",-1);
     }//end invalid number
     else if(chosenNum < secretNum){
     JOptionPane.showMessageDialog(null,chosenNum+" is less than my secret number. Try again, you can do it!","MESSAGE FROM YOUR FRIENDLY COMPUTER",-1);
     }//end less than
     else if(chosenNum > secretNum){
     JOptionPane.showMessageDialog(null,chosenNum+" is greater than my secret number. Try again, you can do it!","MESSAGE FROM YOUR FRIENDLY COMPUTER",-1);
     }//end greater than
     numGuess++; 
     }//end while
     JOptionPane.showMessageDialog(null,"Correct! My secret number is "+secretNum+"! You got it in " +numGuess+" guesses!","CORRECT!!!! CONGRATULATIONS!!!!",-1);
   }//end function guessGame

  //in main, we call on the methods
   public static void main(String[] args)
   {
     // I want to write a quadratic formula program
     // so i will need these three values to be entered
     // by the user, but I do not want to have to keep 
     // doing all those pesky try...catch statements!
     int a, b, c;
     
     //How can I get a value into a, b, and c from the function?
     a = getValue("Enter a value for a","QUADRATIC FORMULA", -1);
     //JOptionPane.showMessageDialog(null,"The value of a is "+a+".");
     b = getValue("Enter a value for b","QUADRATIC FORMULA", -1);
     //JOptionPane.showMessageDialog(null,"The value of b is "+b+".");
     c = getValue("Enter a value for c","QUADRATIC FORMULA", -1);
     //JOptionPane.showMessageDialog(null,"The value of c is "+c+".");
      //call on your guessing game here:
     guessGame();
   }//end of main method
*/
}//end entire program
/*
Your tasks:
1.  complete the getValue function
* start by making the function ask the user to enter an integer continuously until an integer is entered, then return the int value to the caller
* Add the feature that this function will allow the user to supply the question to be asked by putting the String value of the question as an argument. So the call will look like this:
a = getValue("Enter the 'a' value "); 
b = getValue("Enter the 'b' value ");
c = getValue("Enter the 'c' value ");

2. Write a full guessing game in the main section of this program
Ask the user to guess a number (you can ask them to enter the range or just get a number between 1-100). Then tell the user if the number is too high or too low and continue to do this until they get the number correct.
Remember, to generate a random number between 1 and 100 you can use this syntax:
int secretNumber = (int)(Math.random()*100) + 1;

*/