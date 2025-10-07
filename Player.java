/*
Riley and Peyton Howardsmith
5/9/2022
This is the class to create players.
*/
import javax.swing.*;

public class Player extends Character
{
  private String nameF, nameL, house;
  //can we not set it here, maybe?
  private int num, galleon = 20,chocFrog = 0, bertieBeans = 0, pumpPasties = 0, cauldronCake = 0, licoriceWand = 0, droobleGum = 0, jellySlug = 0, healPotion = 0, beans = 0, fruitcake = 0, houseRole, strength, constitution, wisdom, dexterity, protect = 0;
  private static int playerNum = 1;

  public Player(String f, String l){
    nameF = f;
    nameL = l;
    name = f+" "+l;
    num = playerNum;
    initiative = d6(1,0,20);
    //set initial inventory
    galleon = 20;
    chocFrog = 0;
    bertieBeans = 0;
    pumpPasties = 0;
    cauldronCake = 0;
    licoriceWand = 0;
    droobleGum = 0;
    jellySlug = 0;
    healPotion = 0;
    beans = 0;
    fruitcake = 0;
    
    protect = 0;
    
    playerNum++; //increases so that each player
            //has a different number
  }

  public String getName() {
	return nameF+" "+nameL;
}
  public int getBeans() {
	return beans;
}
  public int getBertieBeans() {
	return bertieBeans;
}
  public int getCauldronCake() {
	return cauldronCake;
}
  public int getChocFrog() {
	return chocFrog;
}
  public int getConstitution() {
	return constitution;
}
  public int getDexterity() {
	return dexterity;
}
  public int getDroobleGum() {
	return droobleGum;
}
  public int getFruitcake() {
	return fruitcake;
}
  public int getGalleon() {
	return galleon;
}
  public int getHealPotion() {
	return healPotion;
}
  public int getHouseRole() {
	return houseRole;
}
  public int getJellySlug() {
	return jellySlug;
}
  public int getLicoriceWand() {
	return licoriceWand;
}
  public String getNameF() {
	return nameF;
}
  public String getNameL() {
	return nameL;
}
  public int getNum() {
	return num;
}
  public static int getPlayerNum() {
	return playerNum;
}
  public int getPumpPasties() {
	return pumpPasties;
}
  public int getStrength() {
	return strength;
}
  public int getWisdom() {
	return wisdom;
}
  public void setBeans(int beans) {
	this.beans = beans;
}
  public void setBertieBeans(int bertieBeans) {
	this.bertieBeans = bertieBeans;
}
  public void setCauldronCake(int cauldronCake) {
	this.cauldronCake = cauldronCake;
}
  public void setChocFrog(int chocFrog) {
	this.chocFrog = chocFrog;
}
  public void setConstitution(int constitution) {
	this.constitution = constitution;
}
  public void setDexterity(int dexterity) {
	this.dexterity = dexterity;
}
  public void setDroobleGum(int droobleGum) {
	this.droobleGum = droobleGum;
}
  public void setFruitcake(int fruitcake) {
	this.fruitcake = fruitcake;
}
  public void setGalleon(int galleon) {
	this.galleon = galleon;
}
  public void setHealPotion(int healPotion) {
	this.healPotion = healPotion;
}
  public void setHouseRole(int houseRole) {
	this.houseRole = houseRole;
  if(houseRole == 0) house = "Gryffindor";
  if(houseRole == 1) house = "Hufflepuff";
  if(houseRole == 2) house = "Ravenclaw";
  if(houseRole == 3) house = "Slytherin";
}
  public void setJellySlug(int jellySlug) {
	this.jellySlug = jellySlug;
}
  public void setLicoriceWand(int licoriceWand) {
	this.licoriceWand = licoriceWand;
}
  public void setNameF(String nameF) {
	this.nameF = nameF;
}
  public void setNameL(String nameL) {
	this.nameL = nameL;
}
  public void setNum(int num) {
	this.num = num;
}
  public static void setPlayerNum(int playerNum) {
	Player.playerNum = playerNum;
}
  public void setPumpPasties(int pumpPasties) {
	this.pumpPasties = pumpPasties;
}
  public void setStrength(int strength) {
	this.strength = strength;
}
  public void setWisdom(int wisdom) {
	this.wisdom = wisdom;
}
  public void addBeans(int b) {
	this.beans += b;
}
  public void addBertieBeans(int b) {
	this.bertieBeans += b;
}
  public void addCauldronCake(int c) {
	this.cauldronCake += c;
}
  public void addChocFrog(int c) {
	this.chocFrog += c;
}
  public void addDroobleGum(int d) {
	this.droobleGum += d;
}
  public void addFruitcake(int f) {
	this.fruitcake += f;
}
  public void addGalleon(int g) {
	this.galleon += g;
}
  public void addHealPotion(int h) {
	this.healPotion += h;
}
  public void addHp(int hp) {
	this.hp += hp;
}
  public void addHpTotal(int hpTotal) {
	this.hpTotal += hpTotal;
}
  public void addJellySlug(int j) {
	this.jellySlug += j;
}
  public void addLicoriceWand(int l) {
	this.licoriceWand += l;
}
  public void addPumpPasties(int p) {
	this.pumpPasties += p;
}

  public void loseBeans(int b) {
	this.beans -= b;
}
  public void loseBertieBeans(int b) {
	this.bertieBeans -= b;
}
  public void loseCauldronCake(int c) {
	this.cauldronCake -= c;
}
  public void loseChocFrog(int c) {
	this.chocFrog -= c;
}
  public void loseDroobleGum(int d) {
	this.droobleGum -= d;
}
  public void loseFruitcake(int f) {
	this.fruitcake -= f;
}
  public void loseGalleon(int g) {
	this.galleon -= g;
}
  public void loseHealPotion(int h) {
	this.healPotion -= h;
}
  public void loseHp(int hp) {
	this.hp -= hp;
}
  public void loseHpTotal(int hpTotal) {
	this.hpTotal -= hpTotal;
}
  public void loseJellySlug(int j) {
	this.jellySlug -= j;
}
  public void loseLicoriceWand(int l) {
	this.licoriceWand -= l;
}
  public void losePumpPasties(int p) {
	this.pumpPasties -= p;
}  

  //if protego is used & wisdom check succeeds, protect becomes 1 (shield goes up)
  //if protego is used & wisdom check fails, protect is 2 (shield is partially up)
  public void protegoUp(int p)
  {
    protect = p;
  }

  //if the shield casted by protego is attacked, protect becomes 0 (shield is lowered)
  public void protegoDown()
  {
    protect = 0;
  }

  //returns 0 is protego has not been used / the shield is down
  //returns 1 if protego is used and shield is up
  //returns 2 if protego partially protects
  public int usedProtego()
  {
    return protect;
  }

//*****************************************************ABILITY SCORES*****************************************************
//This sets the values of the ability scores:
//strength, constitution, wisdom, dexterity
//It also sets HP
//it's partly random, partly based on role
public void abilityScore()
{
   strength = d6(4,1, 6);
   constitution = d6(4,1, 6);
   wisdom = d6(4,1, 6);
   dexterity = d6(4,1, 6);
   if(houseRole == 0){
   strength += 3;
   }//end if Gryffindor
   if(houseRole == 1){
   constitution += 3;
   }//end if Hufflepuff
   if(houseRole == 2){
   wisdom += 3;
   }//end if Ravenclaw
   if(houseRole == 3){
   dexterity += 3;
   }//end if Slytherin
  
   hp = 20 + constitution;
   hpTotal = hp;
  
}//end abilityScore function

  
  //this shows the same message as stats functions
  //expect houseRole is no longer         
                       //sortHouse[houseRole]
  //what is shown when click "see stats" in task
  public String toString(){
    return "Your character description is:\n"+nameF+" "+nameL+
  "\nHouse: "+house+
  "\nStrength: "+strength+
  "\nDexterity: "+dexterity+
  "\nWisdom: "+wisdom+
  "\nConstitution: "+constitution+
  "\nHP: "+super.hp+"/"+super.hpTotal;
  }

  
}//end class