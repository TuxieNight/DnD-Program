/*
Riley Howardsmith and Peyton Howardsmith
  */
import javax.swing.*;
import java.util.*;

public class Character
{
//speed is in number of feet one can move per round; a random number is placed here to avoid errors
//speed2 remembers the original speed
protected int initiative, hp, hpTotal, hpTotal2, strength, stunned = 0, exhaustion, speed = 10, speed2 = 10;
protected String name, nameMid; //name is the name used at the beginning of the sentence, but nameEnd is used in the case that the first letter isn't a capital in the middle of the sentence (ie "the plant")
protected boolean toothed, vomit; //toothed is true if the character has teeth (allows densaugeo, which grows teeth, to work); vomit is true if the character can vomit (allows slugulus erecto, which causes one to vomit slugs, to work)
//****************CONSTRUCTORS*********************
  public Character()
  {
  }//end default constructor
  public Character(String n, int h)
  {
	name = n;
	hpTotal = h;
	hpTotal2 = hpTotal;
	hp = h;
	initiative = d6(1,0,20);
	exhaustion = 0;
  }//set health & name
  public Character(String n, int h, boolean t, boolean v)
  {
	name = n;
	hpTotal = h;
	hpTotal2 = hpTotal;
	hp = h;
	toothed = t;
	vomit = v;
	initiative = d6(1,0,20);
	exhaustion = 0;
  }//set health & name & has teeth or not (determines the effect of densaugeo)
  public Character(String n, String nM, int h, boolean t, boolean v)
  {
	name = n;
	nameMid = nM;
	hpTotal = h;
	hpTotal2 = hpTotal;
	hp = h;
	toothed = t;
	vomit = v;
	initiative = d6(1,0,20);
	exhaustion = 0;
  }//set health & name & nameMid & has teeth or not (determines the effect of densaugeo)
  public Character(String n, String nM, int h, boolean t, boolean v, int e)
  {
	name = n;
	nameMid = nM;
	hpTotal = h;
	hpTotal2 = hpTotal;
	hp = h;
	toothed = t;
	vomit = v;
	initiative = d6(1,0,20);
	exhaustion = e;
  } //allow the level of exhaustion to be set

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

  public String getNameMid()
  {
	return nameMid;
  }

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

  public boolean canVomit()
  {
	return vomit;
  }//end canVomit

  public boolean hasExhaustionImmunity()
  {
	if(exhaustion == -1)
	{
  	return true;
	}
	return false;
  }

  public int getStun()
  {
	return stunned;
  }


//*********SETTERS**************
  public void setName(String n){
	this.name = n;
  }

  public void setNameMid(String nM){
	this.nameMid = nM;
  }
 
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

  public void setCanVomit(boolean v)
  {
	vomit = v;
  }//end setCanVomit

  //stunning an enemy makes its stunned value go back to 1
  public void stun()
  {
	stunned = 1;
  }
 
  //as rounds of being stunned go up, the value of stunned increases. Once stunned = 3, it is reset to 0, and mobility is regained.
  public void stunRoundUp()
  {
	if(stunned == 1 || stunned == 2) stunned++;
	if(stunned == 3) stunned = 0;
  }

  //Exhaustion levels go up by one until you reach 6, at which case the individual dies
  //Some individuals are immune to exhaustion, or at least temporarily (ie taking the form of a monster immune to exhaustion)
  public void exhaustionIncrease()
  {
	if(!hasExhaustionImmunity())
	{
  	exhaustion++;
	//LEVEL 1 exhaustion gives a disadvantage to skill check rolls
  	if(exhaustion == 1)
  	{
   	 
  	}
  	//LEVEL 2 exhaustion halves one's movement speed
  	else if(exhaustion == 2)
  	{
    	speed = speed / 2;
  	}
  	//LEVEL 3 exhaustion gives a disadvantage to attack and saving throw rolls (including death saving throws)
  	else if(exhaustion == 3)
  	{
   	 
  	}
  	//LEVEL 4 exhaustion halves one's max HP
  	else if(exhaustion == 4)
  	{
    	hpTotal = hpTotal / 2;
    	//ensure that the current hp is equal to or less than the max hp
    	if(hp > hpTotal) hp = hpTotal;
  	}
  	//LEVEL 5 exhaustion results in no movement speed
  	else if(exhaustion == 5)
  	{
    	speed = 0;
  	}
  	//LEVEL 6 exhaustion results in death
  	else if(exhaustion == 6)
  	{
   	 
  	}
 	 
	}//end of if character has no immunity to exhaustion
  }

  //Exhaustion levels go down by one until you reach 0
  //Some individuals are immune to exhaustion, or at least temporarily (ie taking the form of a monster immune to exhaustion), so no change would occur
  public void exhaustionDecrease()
  {
	if(!hasExhaustionImmunity())
	{
  	exhaustion--;
  	if(exhaustion == 0)
  	{
   	 
  	}
	//LEVEL 1 exhaustion gives a disadvantage to skill check rolls
	//Remove level 2's stat change
  	if(exhaustion == 1)
  	{
    	speed = speed2; //return to normal speed
  	}
  	//LEVEL 2 exhaustion halves one's movement speed
  	//Remove level 3's stat change
  	else if(exhaustion == 2)
  	{
   	 
  	}
  	//LEVEL 3 exhaustion gives a disadvantage to attack and saving throw rolls (including death saving throws)
  	//remove level 4's stat change
  	else if(exhaustion == 3)
  	{
    	hpTotal = hpTotal2
  	}
  	//LEVEL 4 exhaustion halves one's max HP
  	//remove level 5's stat change
  	else if(exhaustion == 4)
  	{
    	hpTotal = hpTotal / 2;
    	//ensure that the current hp is equal to or less than the max hp
    	if(hp > hpTotal) hp = hpTotal;
  	}
  	//LEVEL 5 exhaustion results in no movement speed
  	//remove level 6's stat change
  	else if(exhaustion == 5)
  	{
   	 
  	}
  	//LEVEL 6 exhaustion results in death
  	else if(exhaustion == 6)
  	{
   	 
  	}
 	 
	}
  }
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
