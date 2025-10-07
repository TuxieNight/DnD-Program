/*
Riley and Peyton are awesome
5/11/2022
This class helps creates the monsters, including their stats
*/
public class Monster extends Character
{
private int monsterStrength, monsterAttack, monsterHarm, stunned = 0;
  
//*****************Monster Constructors***************
  public Monster()
  {
    initiative = d6(1,0,20);
  }//end Monster default constructor

  public Monster(String n, int hp, int strength)
  {
    super(n, hp); //call to superclass
    monsterStrength = strength;
    initiative = d6(1,0,20);
  }//end Monster all filled out constructor

public int getStrength()
  {
      return monsterStrength;
  }//get strength

public void setStrength(int s)
  {
    strength = s;
  }//set strength
  
  public String toString()
  {
    return "Monster Facts:\n"+super.name+
  "\nStrength: "+monsterStrength+
  "\nHP: "+super.hp+"/"+super.hpTotal;
  }  
}//end Monster class