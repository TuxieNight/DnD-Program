/*
Riley Howardsmith and Peyton Howardsmith
  */
import javax.swing.*;
import java.util.*;

public class Character
{
protected int initiative, hp, hpTotal, strength;
protected String name;
protected boolean toothed; //is true if the character has teeth (allows densaugeo, which grows teeth, to work)
//****************CONSTRUCTORS*********************
  public Character()
  {
  }//end default constructor
  public Character(String n, int h)
  {
    name = n;
    hpTotal = h;
    hp = h;
    initiative = d6(1,0,20);
  }//set health & name

//**********resetInitiative********
  public void resetInitiative()
  {
    initiative = d6(1,0,20);
  }
 
//***********GETTERS**************  
  public String getName()
  {
      return name;
  }//get name

  public int getHp()
  {
      return hp;
  }//get hp

  public int getHpTotal() {
	return hpTotal;
  }//get hpTotal
  
  public int getInitiative()
  {
      return initiative;
  }//get name  

  public boolean hasTeeth()
  {
    return toothed;
  }//end hasTeeth

//*********SETTERS**************
  public void setHp(int hp) {
	this.hp = hp;
}
  public void setHpTotal(int hpTotal) {
	this.hpTotal = hpTotal;
}  
  public void setInitiative()
  {
  this.initiative = d6(1,0,20); //roll a d20 dice once to get the initiative
  }//end setInitiative

  public void setInitiative(int i)
  {
    this.initiative = i;
  }

  public void setHasTeeth(boolean t)
  {
    toothed = t;
  }//end setHasTeeth
  //*******************************************************d6****************************************************
  public static int d6(int num, int high, int size) //XdY, X is number of times rolled (represented by num), Y is type of dice (represented by size)
  {
  int score = 0;
  int compare = 0;
  //Set the minimum as high as the dice can roll - relevant for the for loop later
  int min = size;
  //make the same number of rolls as indicated in the set value for num
  for(int i = 0; i < num; i++){
  //roll a random number from 1 to size (if size equals 6, then a number is rolled from 1 to 6)
  int roll = (int)(Math.random()*size)+1;
  //total roll score
  score += roll;
  //determine the smallest of the roll scores
  compare = (int)(Math.min(roll,min));
  //make the minimum the lowest roll
  min = compare;
  }//end rolling
  
  if(high == 1){
  //only use the highest scores
  score -= compare;
  }//end if you only take the highest ones
    
  //return the value
  return score;
  }//end function d6

}//end character