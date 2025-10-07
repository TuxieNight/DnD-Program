/* Riley Howardsmith and Peyton Howardsmith
Harry Potter Dungeons & Dragons Game
1/4/2022
*/
import javax.swing.*;
import java.util.*;
import java.lang.*;

public class dungeonsAndDragonsHP
{  
public static String name, nameF, nameL, monster, eat, trolleyChoice, spellPick, trolleySay;
public static boolean hadTurn;
public static int i, playerNum, galleon = 20, chocFrog = 0, bertieBeans = 0, pumpPasties = 0, cauldronCake = 0, licoriceWand = 0, droobleGum = 0, jellySlug = 0, healPotion = 0, beans = 0, fruitcake = 0, choiceRan, sortRan = (int)(Math.random()*4), houseRole, yesOrNo, strength, constitution, wisdom, dexterity, hp, hpTotal, rollValue = 0, totalRoll = 0, rollOutcome = 0, monsterInitiative, initiative, monsterHP, monsterHPTotal, monsterStrength, monsterAttack, monsterHarm, turn = 0, playerAttack, saveThrow, success = -1, stunned = 0, f = -2, wellLit = 0;
public static String[] trolley = {"Nothing","Chocolate Frog","Box of Bertie Bott's Every Flavor Beans","Pumpkin Pasties", "Cauldron Cake","Licorice Wands", "Drooble's Best Blowing Gum","Jelly Slugs"}, choiceOrRan = {"Choose Myself","Leave it to Chance"}, sortHouse = {"Gryffindor","Hufflepuff","Ravenclaw","Slytherin"}, yesNo = {"Yes","No"}, choice = {"Back", "Use"}, beansOr = {"Dusty Can of Beans","Bertie Bott's Every Flavor Beans"};
public static ArrayList <Player> players; //contains all players
public static ArrayList <Character> charInitiative = new ArrayList<Character>(); //contains all of the characters, including the monsters, on a battlefield at a given time and will be ordered by initiative
public static ArrayList <Monster> monsters = new ArrayList<Monster>(); //contains all monsters

//***********************************************INTRODUCING************************************************************
public static void introduce() //allows each player to pick their first and last name
{
  for(i = 1; i <= playerNum; i++)
  {
    boolean valid = false;
    while(!valid){
      try{
        nameF = JOptionPane.showInputDialog(null,"What first name do you use to introduce yourself?","PLAYER "+i,-1);
        if(nameF.isBlank()){
            JOptionPane.showMessageDialog(null, "Names are important, you know.","Name Not Detected",0); 
          }//end if null
        else{ 
          valid = true; 
          rileyFunctions.removeExtraSpace(nameF);
        }//end if not null
      }//end try
      catch(Exception e){
        JOptionPane.showMessageDialog(null, "Names are important, you know.","Name Not Detected",0);
      }//end catch
    }//end while
    valid = false;
    while(!valid){
      try{
        nameL = JOptionPane.showInputDialog(null, "And what last name do you use?","PLAYER "+i,-1);
        if(nameL.isBlank()){
          JOptionPane.showMessageDialog(null, "Your input was not accepted. Please try again.","ERROR",0);    
          }//end if null
        else{
          valid = true;
          rileyFunctions.removeExtraSpace(nameL);
        }//end if not null
      }//end try
      catch(Exception e){
        JOptionPane.showMessageDialog(null, "Your input was not accepted. Please try again.","ERROR",0);
      }//end catch
    }//end while 
    players.add(new Player(nameF, nameL));
  }//end for loop
}//end function introduce
  
//***********************************************HOGWARTS EXPRESS**********************************************
public static void hogwartsExpress()
{
JOptionPane.showMessageDialog(null,"You are sitting in the Hogwarts Express with other new witches and wizards\non your way to Hogwarts School of Witchcraft and Wizardry.","DUNGEONS & DRAGONS",-1);
introduce();
trolleyChoice = "nothing";
i = 0;  
JOptionPane.showMessageDialog(null,"The trolley witch enters your compartment with\nmany goodies for you to choose.\nEach costs one Galleon.","DUNGEONS & DRAGONS",-1);
  //Ask for the player to buy something
for(i = 0; i < playerNum; i++) //goes from 0 to playerNum-1 since array contains the players within those indexes
{  
try{
  trolleyChoice = JOptionPane.showInputDialog(null, "You have 20 Galleons to spend.\nWhat will you buy?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasty\nCauldron Cake\nLicorice Wands\nDrooble's Best Blowing Gum\nJelly Slugs", (players.get(i)).getName(), -1);

  
while(!trolleyChoice.equalsIgnoreCase("nothing"))
{
  String purchase = "";//what is said with regards to what someone bought
  String followUp = "Would you like something else?";//what is said depending on whether something is bought or not
  
//get number associated with food choice  
  f = matchFood(trolleyChoice);
//if they have only one Galleon left, the variable will be the singular "Galleon"; if they have more than one, it will be the plural "Galleons"
  String gold;
  if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
  
//if the phrase is incorrect or not specific  
if(f == -1)
{
    JOptionPane.showMessageDialog(null, "The phrase "+trolleyChoice+" is either spelled incorrectly or is not specific enough.\nPlease try again.", "ERROR", 0);

  if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
  
  /*
    //Allow them to buy more goodies
  
    try{
    trolleyChoice = JOptionPane.showInputDialog(null, "You have "+(players.get(i)).getGalleon()+" "+gold+". What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
    f = matchFood(trolleyChoice);    
  }//end try
  catch(Exception e){
    break;
  }//end catch
*/
  
}//end while no match
  
//Add the choice to the inventory
  
else if(f == 9) //everything
{
    String all = ""; //variable that will report whether you bought everything or not below
  
    //should double check that it's > 0
  
    if( (players.get(i)).getGalleon() < 7)
    {//can't buy everything if don't have enough money
      JOptionPane.showMessageDialog(null, "You don't have enough Galleons for that.",  
      (players.get(i)).getName(), -1);
    }//end if
    else{ //else if player successfully buys everything
      (players.get(i)).addChocFrog(1);
      (players.get(i)).addBertieBeans(1);
      (players.get(i)).addPumpPasties(1);
      (players.get(i)).addCauldronCake(1);
      (players.get(i)).addLicoriceWand(1);
      (players.get(i)).addDroobleGum(1);
      (players.get(i)).addJellySlug(1); 
      (players.get(i)).loseGalleon(7);
      purchase = "You bought one of everything!\n";
    }//end else
    //if the purchase made them run out of galleons, end their turn
  
    if((players).get(i).getGalleon() == 0){
      JOptionPane.showMessageDialog(null,"You bought one of everything and have used all of your Galleons.",(players.get(i)).getName(),-1);
      break;
    }
    //otherwise let them buy something else
    else{
      
      //determine whether to say Galleons or Galleon
    if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
      /*
      //Allow them to buy more goodies
      try{
        trolleyChoice = JOptionPane.showInputDialog(null, purchase+"You have "+(players.get(i)).getGalleon()+" "+gold+". What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
        f = matchFood(trolleyChoice);
      }//end try
      catch(Exception e){
        break;
      }//end catch
      */
    }//buy something
  }//end if everything

//if they ask for something but not everything
else{

 //before asking for the amount they want to buy, ask about the beans 
//BEANS; f = 7  
if(f == 7)
{
   //give a choice between dusty can of beans and every flavor beans
   beans = JOptionPane.showOptionDialog(null, "Did you mean a box of Bertie Bott's Every Flavor Beans\nor that dusty can of beans you noticed on the trolley?", (players.get(i)).getName(),-1,1,null,beansOr,beansOr[1]);
  
   //if they chose every flavor beans, allow the normal galleon reduction and choice of more goods to occur
   if(beans == 1){
     f = 1; //set f equal to one, so that the typical response to Bertie Bott's Every Flavor Beans is done
   }
  
   //if they chose dusty can of beans, they get that for free
   if(beans == 0){
     
      if((players.get(i)).getBeans() == 1){ //already have dusty beans

    //determine whether to say Galleons or Galleon
    if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
      JOptionPane.showMessageDialog(null, "The trolley witch eyes you with disgust.\nWhy would you want more?\nFor your own sanity, you won't get another.",(players.get(i)).getName(),-1);  
        //allow them to buy other goodies
/*
           try{
      trolleyChoice = JOptionPane.showInputDialog(null, "The trolley witch eyes you with disgust.\nWhy would you want more?\nFor your own sanity, you won't get another.\n\nYou have "+(players.get(i)).getGalleon()+" "+gold+". What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
      f = matchFood(trolleyChoice);
    }//end try
    catch(Exception e){
      break;
    }//end catch  
    */    
      }
      else{//do not have beans
        (players.get(i)).addBeans(1);

        //determine whether to say Galleon or Galleons
        if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
        JOptionPane.showMessageDialog(null, "The trolley witch hands over the dusty can of beans with relief.\nShe says you can have it for free.",(players.get(i)).getName(),-1);
        //Allow them to buy more goodies
        /*
        try{
      trolleyChoice = JOptionPane.showInputDialog(null, "The trolley witch hands over the dusty can of beans with relief.\nShe says you can have it for free.\n\nYou have "+(players.get(i)).getGalleon()+" "+gold+". What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
        f = matchFood(trolleyChoice);
          }//end try
        catch(Exception e){
          break;
        }//end catch 
        */
       }//end else if player has no beans already
     
     //debugging
     /*
     f = matchFood(trolleyChoice);
    */
    }//end if chose dusty beans not every flavor beans
  
}//end if trolley choice is beans

//*******************HOT-FOOTED FROG************************
  if(f == 10)
  {
  //if the name matches Zelda Hyrule
    if(players.get(i).getName().equalsIgnoreCase("Zelda Hyrule"))
    {
      JOptionPane.showMessageDialog(null,"Link looks horrified (if possible) and\nis relieved there are no frogs available.","EASTER EGG",-1);
    }
  //if the front name matches Link
    else if(players.get(i).getNameF().equalsIgnoreCase("Link"))
    {
      JOptionPane.showMessageDialog(null,"Zelda would be more than happy to give you a frog,\nbut sadly, there are no frogs available.","EASTER EGG",-1);
    }
  //if the name does not match Link or Zelda Hyrule
    else
    {
      JOptionPane.showMessageDialog(null,"Zelda agrees that having a frog would be fun,\nbut sadly, there are no frogs available", "Easter Egg", -1);
    }

    //determine whether to say Galleons or Galleon
    if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
      
      //Allow them to buy more goodies
/*
      try{
        trolleyChoice = JOptionPane.showInputDialog(null, "You have "+(players.get(i)).getGalleon()+" "+gold+". What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
      f = matchFood(trolleyChoice);
        }//end try
      catch(Exception e){
        break;
      }//end catch
*/  
  }//end if ask for hot-footed frogs
  
//ask the number wanted for all the food you have to pay for 
int num = -1; //how much someone wants of something
  
//only ask for the amount if it is not fruitcake, and if it is not a dusty can of beans (already must match a created food and is not everything)
//must have more than one galleon to get more than one item
  
if(f != 8 && f != 7 && f != 9 && f != 10 && (players.get(i)).getGalleon() > 1) { 
  while(num < 0)
  { 
  num = rileyFunctions.getValue("How many do you want?",players.get(i).getName(),-1);
  if(num < 0) JOptionPane.showMessageDialog(null,"Please enter a non-negative number.","ERROR",0);
  }//end while number is negative
  
  //make sure that the number they choose will not go over the amount they can afford
  if(num > (players.get(i)).getGalleon() )
  {
    JOptionPane.showMessageDialog(null,"The amount you want, "+num+", will exceed how many Galleons you have, "+(players.get(i)).getGalleon()+".\nYou will be given as much as you can afford.",(players.get(i)).getName(),-1);
    num = (players.get(i)).getGalleon();
  }//end if the number exceeds the amount of galleons one actually has
  
}//end if choice is something you have to buy
  
else num = 1;  

//CHOCOLATE FROGS; f = 0
if(f == 0)
  {
    (players.get(i)).addChocFrog(num);
    if(num!=1) trolleyChoice = "chocolate frogs";
    else trolleyChoice = "chocolate frog";
  }//end if chocfrog
  
//BERTIE BOTT'S EVERY FLAVOR BEANS; f = 1
else if(f == 1)
  {
    (players.get(i)).addBertieBeans(num);
    if(num!=1) trolleyChoice = "boxes of Bertie Bott's Every Flavor Beans";
    else trolleyChoice = "box of Bertie Bott's Every Flavor Beans";
  }//end if bertieBeans 
  
//PUMPKIN PASTIES; f = 2
else if(f == 2)
  {
    (players.get(i)).addPumpPasties(num);
    if(num!=1) trolleyChoice = "pumpkin pasties";
    else trolleyChoice = "pumpkin pasty";
  }//end if pumpPasties 
  
//CAULDRON CAKE; f = 3
else if(f == 3)
  {
    (players.get(i)).addCauldronCake(num);
    if(num!=1) trolleyChoice = "cauldron cakes";
    else trolleyChoice = "cauldron cake";
  }//end if cauldronCake 
  
//LICORICE WAND; f = 4
else if(f == 4)
  {
    (players.get(i)).addLicoriceWand(num);
    if(num!=1) trolleyChoice = "licorice wands";
    else trolleyChoice = "licorice wand";
  }//end if licoriceWand  
  
//DROOBLE'S BEST BLOWING GUM; f = 5
else if(f == 5)
  {
    (players.get(i)).addDroobleGum(num);
    if(num!=1) trolleyChoice = "boxes of Drooble's Best Blowing Gum";
    else trolleyChoice = "box of Drooble's Best Blowing Gum";
  }//end if droobleGum
  
//JELLY SLUGS; f = 6
else if(f == 6)
  {
    (players.get(i)).addJellySlug(num);
    if(num!=1) trolleyChoice = "packets of jelly slugs";
    else trolleyChoice = "packet of jelly slugs";      
  }//end if jellySlug  
  
//FRUITCAKE; f = 8 (NOT f = 7)
else if(f == 8)
{
  if(((players.get(i)).getName()).equals("Zelda Hyrule")) //only someone named Zelda Hyrule gets fruitcake
  {
    if((players.get(i)).getFruitcake() == 1){
      JOptionPane.showMessageDialog(null, "The trolley witch apologizes and says it would be\nunfair to give you another slice of fruitcake.", "EASTER EGG", -1);
    }//end if already got fruitcake
    else{
    JOptionPane.showMessageDialog(null, "The trolley witch gave you a slice of fruitcake for free,\nbecause you are the princess of Hyrule.", "EASTER EGG", -1);
    (players.get(i)).addFruitcake(1);
    trolleyChoice = "fruitcake";
    }//end else get fruitcake
  }
  else{
   JOptionPane.showMessageDialog(null, "Zelda sympathizes with your desire for fruitcake.\nHowever, you cannot purchase that here.", "EASTER EGG", 0);
    //Allow them to buy more goodies
  }
  /*  
  try{
    trolleyChoice = JOptionPane.showInputDialog(null, "You have "+(players.get(i)).getGalleon()+" Galleons. What would you like?\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
    f = matchFood(trolleyChoice);
  }//end try
  catch(Exception e){
    break;
  }//end catch
  */
}//end if trolley choice is fruit cake

  //pay a Galleon if it is not free dusty beans, free fruitcake, a frog easter egg message, or not a possible answer
if(f != 7 && f != 8 && f != 9 && f != 10 && f != -1)
{
  (players.get(i)).loseGalleon(num);
  purchase = "You bought "+num+" "+trolleyChoice+".\n";
  //Don't allow someone without money to buy goodies
  
  if((players.get(i)).getGalleon() == 0){
    JOptionPane.showMessageDialog(null,"You bought "+num+" "+trolleyChoice+".\nYou have used all of your Galleons.",(players.get(i)).getName(),-1);
    break;
  }//end if run out of galleons

  
  if((players.get(i)).getGalleon() == 1) gold = "Galleon"; //make Galleon singular as they only have one Galleon
  else gold = "Galleons"; //make Galleons plural as they don't have one Galleon
 /* 
  //Allow them to buy more goodies
  try{
    trolleyChoice = JOptionPane.showInputDialog(null, purchase+"\nYou have "+(players.get(i)).getGalleon()+" "+gold+" left. "+followUp+"\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
    f = matchFood(trolleyChoice);
  }//end try
  catch(Exception e){
    break;
  }//end catch
*/
  
}//end if they bought an actual treat from the trolley
else{
  followUp = "What would you like?"; 
  }//end if did not buy something
  
}//end if they got something but not everything

  
  //Allow them to buy more goodies
  try{
    trolleyChoice = JOptionPane.showInputDialog(null, purchase+"You have "+(players.get(i)).getGalleon()+" "+gold+" left. "+followUp+"\nType \"nothing\" to stop making purchases.\nChocolate Frog\nBertie Bott's Every Flavor Beans\nPumpkin Pasties\nCauldron Cake\nLicorice Wand\nDrooble's Best Blowing Gum\nJelly Slugs",(players.get(i)).getName(),-1);
    f = matchFood(trolleyChoice);
  }//end try
  catch(Exception e){
    break;
  }//end catch
  f = matchFood(trolleyChoice);
  
}//end while buying trolley goods
  
}//end try
catch(Exception e)
{
}//end catch


}//end forLoop that goes for each player
  
JOptionPane.showMessageDialog(null,"The trolley witch thanks you for your time\nand moves on to the next compartment.","DUNGEONS & DRAGONS",-1);
}//end function hogwartsExpress

//**********************************************SORTING*******************************************************
public static void sorting()
{
JOptionPane.showMessageDialog(null, "You finally arrive at Hogwarts School of Witchcraft and Wizardry!\nAfter exiting the Hogwarts Express, Caretaker and Keeper of the\nKeys and Grounds Rubeus Hagrid leads you on a boat ride to\nthe castle.","DUNGEONS & DRAGONS",-1);
JOptionPane.showMessageDialog(null, "Once you make it inside the castle and enter the Great Hall,\nyou file into a line with other first years and wait to be\ncalled on by Professor McGonagall to be sorted into one of\nfour houses: Gryffindor, Hufflepuff, Ravenclaw, or Slytherin.","DUNGEONS & DRAGONS",-1);
for(i = 0; i < playerNum; i++)
{
yesOrNo = 0;
//make sure the correct name is displayed
JOptionPane.showMessageDialog(null, "Professor McGonagall calls out, \""+(players.get(i)).getNameL()+", "+(players.get(i)).getNameF()+".\"\nYou walk to the front and sit on a stool.\nThe Sorting Hat is placed on your head.", (players.get(i)).getName(),-1);
while(yesOrNo == 0){
sortRan = (int)(Math.random()*4); //to reset sortRan
//let them choose if they want to have a random house or make their own choice; if they exit without choosing whether they want a choice or not, give them a choice
choiceRan = JOptionPane.showOptionDialog(null, "Do you wish to choose your house or leave it up to chance?\nNote: Your house affects your stats.",(players.get(i)).getName(),-1,1,null,choiceOrRan,choiceOrRan[0]);
//if they want to choose their house, give them a choice. Yet if they exit without choosing an option, have the choice be random (sortRan).
if(choiceRan == 0){
houseRole = JOptionPane.showOptionDialog(null, "Choose your house.\nGryffindors are brave, daring, and chivalrous.\nHufflepuffs are just, loyal, true, and unafraid of toil.\nRavenclaws have wit and ready minds.\nSlytherins are cunning.", (players.get(i)).getName() ,-1,1,null,sortHouse,sortHouse[sortRan]);
}//end give a choice
//make their role random
else{
houseRole = sortRan;
}//end random sorting
if(houseRole == 0){
JOptionPane.showMessageDialog(null, "You are a Gryffindor. You are brave, daring, and chivalrous.\nYou have greater strength than members of other houses.", (players.get(i)).getName(),-1);
}//end if Gryffindor
if(houseRole == 1){
JOptionPane.showMessageDialog(null, "You are a Hufflepuff. You are just, loyal, true, and unafraid of toil.\nYou have higher constitution than members of other houses.", (players.get(i)).getName(),-1);
}//end if Hufflepuff
if(houseRole == 2){
JOptionPane.showMessageDialog(null, "You are a Ravenclaw. You have wit and a ready mind.\nYou have greater wisdom than members of other houses.", (players.get(i)).getName(),-1);
}//end if Ravenclaw
if(houseRole == 3){
JOptionPane.showMessageDialog(null, "You are a Slytherin. You are cunning.\nYou have more dexterity than members of other houses.", (players.get(i)).getName(),-1);
}//end if Slytherin
//Allow a switch of houses if they desire
yesOrNo = JOptionPane.showOptionDialog(null, "Would you like to change your house?", (players.get(i)).getName(),-1,1,null,yesNo,yesNo[1]);
}//end choosing houses while loop
(players.get(i)).setHouseRole(houseRole);

//use Player abilityScore to fix the abilities of the player
( players.get(i) ).abilityScore();
//list out the ability scores
JOptionPane.showMessageDialog(null,players.get(i),(players.get(i)).getName(),-1);
  
}//end forloop
}//end function sorting

//*******************************************************herbology**************************************************************************************************
public static void herbology()
{
  wellLit = 0;//the place is well lit -- no need for lumos ( reference the playerTurn() and the lumos() functions )
  int plan; //variable for the choice of action 
  
  //the plant is a monster with 50 HP and 10 strength; initiative is determined with a 1d20 roll
   Monster plantMonster = new Monster("The plant",50,10);
  //add the monster to the monster arrayList
   monsters.add(plantMonster);

  //this is from the old code that I haven't deleted just yet because I think variables still use it in places... but maybe it's time to see if we have converted it all
  
   monster = "The plant";
   monsterInitiative = d6(1,"no",20);
   monsterHP = 50;
   monsterHPTotal = 50;
   monsterStrength = 10;
  

  String[] plant = {"Attack the plant", "Study the plant", "Nothing"};
   JOptionPane.showMessageDialog(null, "You enter your herbology classroom, but your herbology\nprofessor, Professor Sprout, is nowhere to be seen.\nHowever, there is a strange-looking plant at the front of the room.", "DUNGEONS & DRAGONS", -1);
  if(playerNum>1){ //it is called a group decision if there are multiple players
   plan = JOptionPane.showOptionDialog(null, "What do you do?", "GROUP DECISION", -1, 1, null,   plant, plant[0]);
    }
  else{
      i = 0;
       plan = JOptionPane.showOptionDialog(null, "What do you do?", (players.get(0)).getName(), -1, 1, null,   plant, plant[0]);
  }
   
   if(plan == 0)
   {
      plantMonster.setInitiative(plantMonster.getInitiative() + 1);
   }
   if(plan == 1)
   {
      if(playerNum > 1){ 
       //ask who wants to do the check if there are multiple players
       groupDecision("Who would like to study the plant?");
        }
     //do a wisdom check when studying the plant
      skillCheck("wisdom",(players.get(i)).getWisdom());
      //if you succeed, you learn about the plant
      if(rollOutcome == 1)
      {
        JOptionPane.showMessageDialog(null,"By studying the plant, you remembered it is \ncalled the Venomous Tentacula, a magical\nplant with vines that reach for living prey.\nYour wisdom grew a bit.",(players.get(i)).getName(),-1);

        for(int n = 0; n<playerNum; n++)
        {
          //increase wisdom by one
          ( players.get(n) ).setWisdom( players.get(n).getWisdom() + 1 );
        }//end increasing everyone's wisdom by one
      }//end if study outcome is success
     else
      {
        JOptionPane.showMessageDialog(null,"The grasping vines look vaguely familiar, as\nthough you glimpsed them once in a textbook\nas you flipped through pages at random.",(players.get(i)).getName(),-1);
      }//end if fail study
     
     String[] plan2 = {"Attack the plant", "Wait"};
     plan = JOptionPane.showOptionDialog(null,"Do you attack the plant or wait?","GROUP DECISION", -1, 1, null, plan2,plan2[1]);
     //if chose wait
     if(plan == 1){
       plan = 2;//to trigger the same scenario that doing nothing in the first plan would have triggered
     }
   }//end if want to study
  
   if(plan == 2) //doing nothing/waiting
   {
     plantMonster.setInitiative( plantMonster.getInitiative() - 1 );
     plantMonster.setStrength(plantMonster.getStrength() - 1);
     plantMonster.setHp(plantMonster.getHp() - 1);
     plantMonster.setHpTotal(plantMonster.getHpTotal() - 1);
     
     JOptionPane.showMessageDialog(null,"Professor Sprout finally arrives.\nShe explains that the class will focus on the Venomous Tentacula.\nShe gestures towards the plant you noticed.\nYou are told your task is to fight the plant.","DUNGEONS & DRAGONS",-1);
   }//end if doing nothing/waiting
  
  //sort the players and the monsters by initiative
  initiativeSort(charInitiative, players, monsters);
  //start battle task
  monster(plantMonster);
  
}//end function herbology

//*************************************GROUP DECISION**********************************
  public static void groupDecision(String question) //determines who does something
  {
    //only has an effect if there are multiple players
    if(playerNum > 1) //if there are many players
    {
    boolean correct = false;
    while(!correct){
     String input = JOptionPane.showInputDialog(null, question+"\n"+listPlayers(players),"GROUP DECISION",-1);
      for(int i = 0; i < players.size(); i++)
        {
          if(input.equalsIgnoreCase( (players.get(i)).getName() ) )
          {
            difPlayer(i);
            correct = true;
            return; //ends the function
          }//end if the input matches a player's name
        }//end for loop

      //if the name does not match any player's full name
      JOptionPane.showMessageDialog(null,input+" does not match any player's full name.\nTry again with both first and last name written correctly.","ERROR",0);
      }//end while loop
      
    }//end if it is multiplayer
    
  }//end group decision
  //*******************************************************d6****************************************************
public static int d6(int num, String high, int size) //XdY, X is number of times rolled, Y is type of dice
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
/* Another way, but one that only allows 4d6
//roll 4 random numbers from 1 to 6
int roll1 = (int)(Math.random()*6)+1;
int roll2 = (int)(Math.random()*6)+1;
int roll3 = (int)(Math.random()*6)+1;
int roll4 = (int)(Math.random()*6)+1;
//find the smallest value of the 4
int compare1&2 = (int)(Math.min(roll1,roll2));
int compare3 = (int)(Math.min(compare1&2,roll3));
int compare4 = (int)(Math.min(compare3,roll4));
//only add the highest three scores; subtract the smallest of the 4 scores from the total of the scores
int score = roll1 + roll2 + roll3 + roll4 - compare4;
*/

if(high.equalsIgnoreCase("high")){
//only use the highest scores
score -= compare;
}//end if you only take the highest ones
//return the value
return score;
}//end function d6

//*****************************************************SKILL CHECK******************************************************
public static void skillCheck(String skillName, int skill)
{
  String[] roll = {"Roll"};
  JOptionPane.showOptionDialog(null, "To perform this action, you must do a "+skillName+" check.\nYou will roll the d20 dice, a dice with numbers from 1 to 20.",(players.get(i)).getName(),-1,1,null,roll,roll[0]);
  rollValue = d6(1,"no",20);
  totalRoll = rollValue + skill;
  if(totalRoll >= 25){
    JOptionPane.showMessageDialog(null,"You rolled "+rollValue+", which, added to your\n"+skillName+" score of "+skill+" totals to a value of "+totalRoll+".\nYou succeed.",(players.get(i)).getName(),-1);
    rollOutcome = 1;
  }//if success
  else{
    JOptionPane.showMessageDialog(null,"You rolled "+rollValue+", which, added to your\n"+skillName+" score of "+skill+" totals to a value of "+totalRoll+".\nYou fail.",(players.get(i)).getName(),-1);
    rollOutcome = 0;
  }//if fail
}//end skillCheck function

//***************************************************SAVING THROW*********************************************************
public static void savingThrow(String skillName)
{
//Roll a saving throw
saveThrow = d6(1,"no",20);
//Compare the saving throw roll to the player's roll and modifier to determine the success
if(saveThrow >= playerAttack)
{
JOptionPane.showMessageDialog(null,monster+" did a successful "+skillName+" saving throw.",(players.get(i)).getName(),-1);
success = 1;
}//end if saveThrow was a success
else
{
JOptionPane.showMessageDialog(null,monster+" failed the "+skillName+" saving throw.",(players.get(i)).getName(),-1);
success = 0;
}//end if saveThrow was a success
}//end function savingThrow

//*****************************************************ABILITY SCORES*****************************************************
public static void abilityScore()
{
  houseRole = (players.get(i)).getHouseRole();
   strength = d6(4,"high", 6);
   constitution = d6(4,"high", 6);
   wisdom = d6(4,"high", 6);
   dexterity = d6(4,"high", 6);
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
  
  (players.get(i)).setStrength(strength);
  (players.get(i)).setConstitution(constitution);
  (players.get(i)).setWisdom(wisdom);
  (players.get(i)).setDexterity(dexterity);
  (players.get(i)).setHp(hp);
  (players.get(i)).setHpTotal(hpTotal);
  
}//end abilityScore function

//******************************************************stats************************************************
public static void stats()
{
  difPlayer("no");
  JOptionPane.showMessageDialog(null,"Your character description is:\n"+(players.get(i)).getName()+"\nHouse: "+sortHouse[houseRole]+"\nStrength: "+strength+"\nDexterity: "+dexterity+"\nWisdom: "+wisdom+"\nConstitution: "+constitution+"\nHP: "+hp+"/"+hpTotal, (players.get(i)).getName(),-1);
}//end stats function
  

  
//*********************************************difPlayer************************
public static void difPlayer(String next) //changes variables values based on the player; enables multiplayer
{
//changes to next player
if(next.equalsIgnoreCase("i")){
i++;
}//end if you need to increase i by one
//if you get to the end of the players, though, you need to go back!!!!!
if(i == playerNum){
  i = 0;
}//end if you need to start back at the original player
  strength = (players.get(i)).getStrength();
  constitution = (players.get(i)).getConstitution();
  wisdom = (players.get(i)).getWisdom();
  dexterity = (players.get(i)).getDexterity();
  hp = (players.get(i)).getHp();
  hpTotal = (players.get(i)).getHpTotal();
  houseRole = (players.get(i)).getHouseRole();
  nameF = (players.get(i)).getNameF();
  nameL = (players.get(i)).getNameL();
  name = (players.get(i)).getName();
  galleon = (players.get(i)).getGalleon();
  chocFrog = (players.get(i)).getChocFrog();
  bertieBeans = (players.get(i)).getBertieBeans();
  pumpPasties = (players.get(i)).getPumpPasties();
  cauldronCake = (players.get(i)).getCauldronCake();
  licoriceWand = (players.get(i)).getLicoriceWand();
  droobleGum = (players.get(i)).getDroobleGum();
  jellySlug = (players.get(i)).getJellySlug();
  fruitcake = (players.get(i)).getFruitcake();
  beans = (players.get(i)).getBeans();
  
}//end difPlayer
  //*********************************************difPlayer************************
public static void difPlayer(int x) //makes it a specific player
{
i = x;
//if you need to decrease i by one
  strength = (players.get(i)).getStrength();
  constitution = (players.get(i)).getConstitution();    
  wisdom = (players.get(i)).getWisdom();
  dexterity = (players.get(i)).getDexterity(); 
  hp = (players.get(i)).getHp();
  hpTotal = (players.get(i)).getHpTotal();
  houseRole = (players.get(i)).getHouseRole();
  nameF = (players.get(i)).getNameF();
  nameL = (players.get(i)).getNameL();
  name = (players.get(i)).getName();
  galleon = (players.get(i)).getGalleon();
  chocFrog = (players.get(i)).getChocFrog();
  bertieBeans = (players.get(i)).getBertieBeans();
  pumpPasties = (players.get(i)).getPumpPasties();
  cauldronCake = (players.get(i)).getCauldronCake();
  licoriceWand = (players.get(i)).getLicoriceWand();
  droobleGum = (players.get(i)).getDroobleGum();
  jellySlug = (players.get(i)).getJellySlug();
  fruitcake = (players.get(i)).getFruitcake();
  beans = (players.get(i)).getBeans();
}//end difPlayer

//*****************************************************tasks**************************************************
public static void tasks(Player p)
{
  hadTurn = true;
  
  if(monsterHP == 0)
  {
    return;
  }
   String[] task = {"Spells", "Inventory", "See Stats"};
   int taskPick = JOptionPane.showOptionDialog(null, "What would you like to use?", p.getName(), -1, 1, null, task, task[0]);
   if(taskPick == 0)
   {
      turn = 1;
      spells(p);
      return;
   }
   if(taskPick == 1)
   {
      turn = 0;
      inventory(p);
       return;
   }
   if(taskPick == 2)
   {
      JOptionPane.showMessageDialog(null, p, p.getName(), -1);
      tasks(p);
      return;
   }
}//end function tasks
//*****************************************matchSpell*****************************************
public static int matchSpell(String spell)
  {
    return 0; //for now until find a use for this method
  }//end matchSpell
  
//****************************************************spells**************************************************
public static void spells(Player p)
{
  try
  {
   spellPick = JOptionPane.showInputDialog(null, "What spell would you like to use? (Type \"Back\" if you want to go back to tasks.)\n-Alohomora                             -Accio                                  -Sectumsempra\n-Diffindo                                  -Stupefy                              -Protego\n-Wingardium Leviosa            -Lumos                                -Densaugeo\n-Flipendo                                 -Slugulus Erecto                -Saggitario", p.getName(), -1);

  
    if(spellPick.equalsIgnoreCase("Back") || spellPick.equalsIgnoreCase("\"Back\""))
    {
        tasks(p);
        return;
    }
    else if(spellPick.equalsIgnoreCase("Alohomora"))
    {
        alohomora(p);
    }
    else if(spellPick.equalsIgnoreCase("Accio"))
    {
        accio(p);
    }
    else if(spellPick.equalsIgnoreCase("Sectumsempra"))
    {
        sectumsempra(p);
    }   
    else if(spellPick.equalsIgnoreCase("Diffindo"))
    {
        diffindo(p);
    }
    else if(spellPick.equalsIgnoreCase("Stupefy"))
    {
        stupefy(p);
    }
    else if(spellPick.equalsIgnoreCase("Protego"))
    {
        protego(p);
    }
    else if(spellPick.equalsIgnoreCase("Wingardium Leviosa"))
    {
        wingardiumLeviosa(p);
    }
    else if(spellPick.equalsIgnoreCase("Lumos"))
    {
        lumos(p);
    }
    else if(spellPick.equalsIgnoreCase("Densaugeo"))
    {
        densaugeo(p);
    }
    else if(spellPick.equalsIgnoreCase("Flipendo"))
    {
        flipendo(p);
    }
    else if(spellPick.equalsIgnoreCase("Slugulus Erecto"))
    {
        slugulusErecto(p);
    }
    else if(spellPick.equalsIgnoreCase("Saggitario"))
    {
        saggitario(p);
    }
    else
    {
      JOptionPane.showMessageDialog(null, "The input \""+spellPick+"\" could not be understood. Please check your spelling and try again.", "ERROR", 0);
      spells(p);
    }
   }//end try
   catch(Exception e)
   {
     tasks(p);  
   }
}//end function spells

   //************************************************alohomora**************************************************
   public static void alohomora(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Alohomora opens locks.\nSTATS:__________\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function alohomora

   //************************************************accio**************************************************
   public static void accio(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Accio summons objects to you.\nSTATS:\nThe target takes 1d20 damage.\nYou must make a dexterity check to catch the object and avoid getting hit.\nIf you fail, you lose 5 HP.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }      
   }//end function accio   

   //************************************************sectumsempra**************************************************
   public static void sectumsempra(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Sectumsempra creates gashes in your opponent.\nSTATS:\nThe target takes 2d8 slashing damage.\nThe target attempts a Constitution saving throw, taking 1d6 slashing damage on a failed save.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }      
   }//end function sectumsempra
   
  //************************************************diffindo**************************************************
  public static void diffindo(Player p)
  {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Diffindo cuts the object or person it is directed at.\nSTATS:\nThe target attempts a Dexterity saving throw.\nIt takes 4d4 damage if the save fails.\nIt takes half as much damage if the save succeeds.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }     
  }//end function diffindo
   
   //************************************************stupefy**************************************************
   public static void stupefy(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Stupefy stuns the enemy.\nSTATS: The target makes a Wisdom saving throw.\nIf it fails, it is stunned for one round.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function stupefy

   //************************************************protego**************************************************
   public static void protego(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Protego blocks attacks.\nSTATS:\nYou make a Wisdom check. If you succeed, you are fully protected from damage for one round.\nIf you fail, you take half of the damage.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
        spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function protego

   //************************************************wingardiumLeviosa**************************************************
   public static void wingardiumLeviosa(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Wingardium Leviosa lifts objects.\nSTATS:__________\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function wingardiumLeviosa

   //************************************************lumos**************************************************
   public static void lumos(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Lumos creates a bright light.\nSTATS: This spell does not deal damage.\nUse it to illuminate a dark space.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
        spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function lumos

   //************************************************densaugeo**************************************************
   public static void densaugeo(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Densaugeo grows the target's two front teeth.\nSTATS:\nThe target takes 2d8 psychic damage\nand has disadvantage on their next attack roll\nbefore the end of their next turn.\nThe target must have teeth.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function densaugeo

   //************************************************flipendo**************************************************
   public static void flipendo(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Flipendo throws the target to the ground.\nSTATS:\nThe target makes a Strength saving throw.\nIf it fails, the target takes 1d10 bludgeoning damage.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function flipendo

   //************************************************slugulusErecto**************************************************
   public static void slugulusErecto(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Slugulus Erecto causes the victim to vomit slugs.\nSTATS:\nThe target takes 3d8 psychic damage and\ngains one level of exhaustion\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function slugulusErecto       

   //************************************************saggitario**************************************************
   public static void saggitario(Player p)
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Saggitario conjures an arrow that strikes the target.\nSTATS:The target takes piercing damage equal to\n1d8 + your spellcasting ability modifier.\nWould you like to use it?", p.getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
        spells(p);
        return;
      }      
      if(spellChoice == 1)
      {
        //will return to playerTurn
      }
   }//end function saggitario

//****************************************************inventory**************************************************
public static void inventory(Player p)
{
   String[] inv = {"Back", "Food", "Healing potion", "Galleons"};
   int invPick = JOptionPane.showOptionDialog(null, "What would you like to use?", p.getName(), -1, 1, null, inv, inv[0]);
   if(invPick == 0)//BACK*****
   {
      tasks(p);
      return;
   }//end if
   else if(invPick == 1)//FOOD*****
   {  
      if(p.getChocFrog()<1 && p.getBertieBeans()<1 && p.getPumpPasties()<1 && p.getCauldronCake()<1 && p.getLicoriceWand()<1 && p.getDroobleGum()<1 && p.getJellySlug()<1 && p.getBeans()<1 && p.getFruitcake()<1)
      {
        JOptionPane.showMessageDialog(null, "Sorry. You have no food.", p.getName(), -1);
        inventory(p);
        return;
      }//end nested if
      else
      {
        food(p);
      }//end nested else
     return;
   }//end if pick food
   else if(invPick == 2)//HEALING POTION*****
   {
     if(p.getHealPotion()<1)
     {
        JOptionPane.showMessageDialog(null, "Sorry. You have no healing potions.", p.getName(), -1);
        inventory(p);
       return;
     }
      else healingPotion(p);
      return;
   }//end if pick healing potion
   else if(invPick == 3)//GALLEONS****
   {
     String invGalleon = "You have "+p.getGalleon()+" galleon";
     if(p.getGalleon()!=1)
     {
       invGalleon += "s";
     }
     JOptionPane.showMessageDialog(null, invGalleon+"!", p.getName(), -1);
     inventory(p);
   }//else if pick galleons
}//end function inventory

//****************************************************matchFood*******************************************************
/* returns integers for each food
0 = chocFrog
1 = bertieBeans
2 = pumpPasties
3 = cauldronCake
4 = licoriceWand
5 = droobleGum
6 = jellySlug
7 = beans
8 = fruitcake
9 = everything
10 = frog
-1 = no match
*/
public static int matchFood(String f)
{
  if(f.equalsIgnoreCase("chocolate frog") || f.equalsIgnoreCase("chocolate frogs") || f.equalsIgnoreCase(" chocolate frogs") || f.equalsIgnoreCase(" chocolate frog") || f.equalsIgnoreCase("schokofrosch"))
      {
         return 0; 
      }//end if chocfrog
      else if(f.equalsIgnoreCase("Bertie Bott's Every Flavor Beans") || f.equalsIgnoreCase("Bertie Bott's") || f.equalsIgnoreCase("Every Flavor Beans") || f.equalsIgnoreCase(" Bertie Bott's Every Flavor Beans") || f.equalsIgnoreCase(" Bertie Bott's") || f.equalsIgnoreCase(" Every Flavor Beans"))
      {
         return 1; 
      }//end if bertieBeans 
      else if(f.equalsIgnoreCase("Pumpkin Pasty") || f.equalsIgnoreCase("Pumpkin Pasties") || f.equalsIgnoreCase(" Pumpkin Pasty") || f.equalsIgnoreCase(" Pumpkin Pasties") || f.equalsIgnoreCase("Pasty") || f.equalsIgnoreCase("Pasties") || f.equalsIgnoreCase(" Pasty") || f.equalsIgnoreCase(" Pasties"))
      {
         return 2;  
      }//end if pumpPasties 
      else if(f.equalsIgnoreCase("Cauldron Cake") || f.equalsIgnoreCase("Cauldron Cakes") || f.equalsIgnoreCase(" Cauldron Cake") || f.equalsIgnoreCase(" Cauldron Cakes") || f.equalsIgnoreCase("Cake") || f.equalsIgnoreCase("Cakes") || f.equalsIgnoreCase(" Cake") || f.equalsIgnoreCase(" Cakes") )
      {
         return 3; 
      }//end if cauldronCake 
      else if(f.equalsIgnoreCase("Licorice Wand") || f.equalsIgnoreCase("Licorice Wands") || f.equalsIgnoreCase(" Licorice Wand") || f.equalsIgnoreCase(" Licorice Wands"))
      {
         return 4;
      }//end if licoriceWand  
      else if(f.equalsIgnoreCase("Drooble's Best Blowing Gum") || f.contains("Gum") || f.contains("gum"))
      {
         return 5;
      }//end if droobleGum
      else if(f.equalsIgnoreCase("Jelly Slug") || f.equalsIgnoreCase("Jelly Slugs") || f.equalsIgnoreCase(" Jelly Slug") || f.equalsIgnoreCase(" Jelly Slugs") || f.equalsIgnoreCase("Slug") || f.equalsIgnoreCase("Slugs") || f.equalsIgnoreCase(" Slug") || f.equalsIgnoreCase(" Slugs"))
      {
         return 6;        
      }//end if jellySlug  
      else if(f.equalsIgnoreCase("beans") || f.equalsIgnoreCase("dusty can of beans") || f.equalsIgnoreCase(" beans") || f.equalsIgnoreCase(" dusty can of beans"))
      {
         return 7;        
      }//end if beans
      else if(f.equalsIgnoreCase("fruitcake") || f.equalsIgnoreCase("fruit cake") || f.equalsIgnoreCase("slice of fruitcake") || f.equalsIgnoreCase("slice of fruit cake"))
      {
         return 8;        
      }//end if fruitcake 
      else if (f.equalsIgnoreCase("everything") || f.equalsIgnoreCase("all") || f.equalsIgnoreCase(" everything") || f.equalsIgnoreCase(" all") ){
          return 9;
      } //end if everything/all
      else if(f.equalsIgnoreCase("real frog") || f.equalsIgnoreCase(" real frog") || f.equalsIgnoreCase("real frogs") || f.equalsIgnoreCase(" real frogs") || f.equalsIgnoreCase("actual frog") || f.equalsIgnoreCase(" actual frog") || f.equalsIgnoreCase("actual frogs") || f.equalsIgnoreCase(" actual frogs") ||  f.equalsIgnoreCase("hot-footed frog") || f.equalsIgnoreCase(" hot-footed frog") || f.equalsIgnoreCase("hot-footed frogs") || f.equalsIgnoreCase(" hot-footed frogs"))
      {
        return 10;
      }
  else return -1; //no match
}//end matchFood  
//****************************************************food*******************************************************
public static void food(Player p)
{
   if(p.getHp() == p.getHpTotal())
   {
      int yN = JOptionPane.showOptionDialog(null, "Your HP is already at its max. Are you sure you want to eat?", p.getName(), -1, 1, null, yesNo, yesNo[0]);
      if(yN == 1)
      {
         inventory(p);
          return;//to get out of the food method
      }
   }
   int heal = d6(4,"high", 4);
   String invFood = "";
   eat = "nothing";
   if(p.getChocFrog() >= 1)
   {
      invFood += "Chocolate Frog(s): "+p.getChocFrog()+"\n";
   }
   if(p.getBertieBeans() >= 1)
   {
      invFood += "Box(es) of Bertie Bott's Every Flavor Beans: "+p.getBertieBeans()+"\n";
   }   
   if(p.getPumpPasties() >= 1)
   {
      invFood += "Pumpkin Pasties: "+p.getPumpPasties()+"\n";
   }   
   if(p.getCauldronCake() >= 1)
   {
      invFood += "Cauldron Cake(s): "+p.getCauldronCake()+"\n";
   }   
   if(p.getLicoriceWand() >= 1)
   {
      invFood += "Licorice Wand(s): "+p.getLicoriceWand()+"\n";
   }   
   if(p.getDroobleGum() >= 1)
   {
      invFood += "Packet(s) of Drooble's Best Blowing Gum: "+p.getDroobleGum()+"\n";
   }   
   if(p.getJellySlug() >= 1)
   {
      invFood += "Packet(s) of Jelly Slugs: "+p.getJellySlug()+"\n";
   }   
  if(p.getBeans() >= 1)
   {
      invFood += "Dusty Can(s) of Beans: "+p.getBeans()+"\n";
   } 
  if(p.getFruitcake() >= 1)
   {
      invFood += "Slice(s) of Fruitcake: "+p.getFruitcake()+"\n";
   }   
   try
   {   
      eat = JOptionPane.showInputDialog(null, invFood +"What would you like to eat? (You will regain HP.)\nType \"nothing\" to go back to your inventory.", p.getName(), -1);
     int f = matchFood(eat);
      if(f == 0 && p.getChocFrog() > 0)
      {
         p.loseChocFrog(1);
        eat = "chocolate frog";
      }//end if chocfrog
      else if(f == 1 && p.getBertieBeans() > 0)
      {
         p.loseBertieBeans(1); 
        eat = "box of Bertie Bott's Every Flavor Beans";
      }//end if bertieBeans 
      else if(f == 2 && p.getPumpPasties() > 0)
      {
         p.losePumpPasties(1);  
        eat = "pumpkin pasty";
      }//end if pumpPasties 
      else if(f == 3 && p.getCauldronCake() > 0)
      {
         p.loseCauldronCake(1); 
        eat = "cauldron cake";
      }//end if cauldronCake 
      else if(f == 4 && p.getLicoriceWand() > 0)
      {
         p.loseLicoriceWand(1);
        eat = "licorice wand";
      }//end if licoriceWand  
      else if(f == 5 && p.getDroobleGum() > 0)
      {
         p.loseDroobleGum(1);
        eat = "box of Drooble's Best Blowing Gum";
      }//end if droobleGum
      else if(f == 6 && p.getJellySlug() > 0)
      {
         p.loseJellySlug(1);  
        eat = "packet of jelly slugs";
      }//end if jellySlug  
      else if(f == 7 && p.getBeans() > 0)
      {
         p.loseBeans(1);  
        eat = "can of beans";
      }//end if beans
      else if(f == 8 && p.getFruitcake() > 0)
      {
         p.loseFruitcake(1);
        eat = "slice of fruitcake";
      }//end if fruitcake            
      else if(eat.equalsIgnoreCase("nothing"))
      {
         inventory(p);
        return;
      }//end if nothing
      else
      {
         JOptionPane.showMessageDialog(null, "The food \""+eat+"\" is not an option.\nPlease try again.", "ERROR", 0);
         food(p);
        return;
      }//end if incorrect
   }//end try
   catch(Exception e)
   {
     JOptionPane.showMessageDialog(null, "There was an error.\nYou will be returned to your inventory.", "ERROR", 0);
      inventory(p);
     return;
   }
   
   if(p.getHp() < p.getHpTotal())
   {
      JOptionPane.showMessageDialog(null, "You ate "+eat+" and gained some HP!", p.getName(), -1);
   }//end if(hp<hpTotal)
   if(p.getHp() == p.getHpTotal())
   {
      JOptionPane.showMessageDialog(null, "You unnecessarily ate a "+eat+"...!", p.getName(), -1);  
   }//end if(hp==hpTotal)
   
   p.setHp(p.getHp() + heal);
        
   if(p.getHp() > p.getHpTotal())
   {
      p.setHp(p.getHpTotal());
   }//end if (hp > hpTotal)
   
   tasks(p);
}//end function food
//*************************************************healingPotion*************************************************     
public static void healingPotion(Player p)
{
  String invHeal = "The healing potion will heal you to your full health.";
  String invPotion = "Your health was restored to full HP!";
   if(p.getHp() == p.getHpTotal())
   {
      invHeal += "\nYour HP is already at its max. Are you sure you want to use the healing potion?";
      invPotion = "\nNo one knows why you wasted a perfectly good potion...";
   }
  int potion = JOptionPane.showOptionDialog(null, invHeal, p.getName(), -1, 1, null, choice, choice[0]);
  if(potion == 0)
  {
    inventory(p);
    return;
  }
  if(potion == 1)
  {
    JOptionPane.showMessageDialog(null, invPotion, p.getName(), -1);
    p.setHp(p.getHpTotal());
    p.setHealPotion(p.getHealPotion()-1);
    tasks(p);
    return;
  }
}//end of function healingPotion

//*****************************************whoseTurn*************************************************
//accepts different types of input; the type of input determines if it is the turn of the player or the turn of the monster
public static void whoseTurn(Character c){
  JOptionPane.showMessageDialog(null,listCharactersInitiatives(charInitiative)+"\n"+c.getName()+" is up next.", "BATTLE ORDER (BASED ON INITIATIVE)",-1);
  
  if(c instanceof Player)
  {
    //testing if for loop array matching works
    for(int i = 0; i < players.size(); i++)
        {
          if( players.get(i).equals(c) )
          {
            //makes sure their name and inventory is used
            difPlayer(i);
            //give them a turn
            playerTurn(players.get(i));
          }
        }
  }//end if instance of player 
//can it work if it is considered a character? we can try
  if(c instanceof Monster)
  {
    for(int i = 0; i < monsters.size(); i++)
    {
      if( monsters.get(i).equals(c) ) monsterTurn(monsters.get(i));
    }
  }//end if instance of monster   
}//end turn if input is a character
  //***********************************************player turn*************************************
public static void playerTurn(Player p)
{
  //checks if tasks was already called on elsewhere. If not, they are sent to tasks. Then whether the turn was done is reset.

  /*
  if(hadTurn!=true){
    tasks(p);
  }
  else hadTurn = false;
  */
  tasks(p);
  
  Monster m; //the monster they choose to attack
  //if the player chooses a spell (turn = 1)
  if(turn == 1)
  {
    //if there are multiple monsters, choose which monster to attack
    if(monsters.size() > 1) // if there are more than one monster, allow the player to choose what monster they attack.
    {
      //will need to list out all the monsters here; creating function to do so
      String allMon = listMonsters();
      String mon = ""; //name of monster inputted; needs to have a default to be considered initialized
      
      while(matchMonster(mon) == -1){ 

        //get input from the user on which monster they want to attack
        mon = JOptionPane.showInputDialog(null,"Which monster do you target?\n"+allMon,p.getName(),-1);
        
        if(matchMonster(mon) == -1)
        {
          JOptionPane.showMessageDialog(null,"Your input does not match the options.\nTry again.","ERROR",0);
        }
        
      }//end while loop

      //set the value of m given the user's input
      m = monsters.get( matchMonster(mon) );
      
    }//end choose the monster (if there are many) 
      
    //otherwise, if there is only one monster, get the first (and only element) from the monsters array
    else m = monsters.get(0);
    
    JOptionPane.showMessageDialog(null,"You take your turn.",p.getName(),-1);
  //******ALOHOMORA*********
   if(spellPick.equalsIgnoreCase("Alohomora"))
   {
      playerAttack = d6(1,"no",20) / 2 + p.getStrength();
      m.setHp( m.getHp() - playerAttack );
   }//end if used the alohomora charm
  //******ACCIO*************
   if(spellPick.equalsIgnoreCase("Accio"))
   {
      //do a skill check to see if the player catches or gets hit by their summoned bucket
      skillCheck("dexterity",p.getDexterity());
       if(rollOutcome == 1){
         JOptionPane.showMessageDialog(null,"You summon a water bucket so that it knocks\ninto your target as it flies towards you.\nYou catch the water bucket with ease.",p.getName(),-1);
         }//if success
       else{
         JOptionPane.showMessageDialog(null,"You summon a water bucket so that it knocks\ninto your target as it flies towards you.\nThe bucket hits your head. You lose 5 HP.",p.getName(),-1);
         p.setHp(p.getHp() - 5);
          if(p.getHp() <= 0)
          {
            JOptionPane.showMessageDialog(null,"Your HP has been fully depleted.",p.getName(),-1);
            restart();
          }//end if playerHealth is fully depleted
         }//end if fail
      //determine the damage to the monster
      playerAttack = d6(1,"no",20) / 2 + p.getWisdom();
      m.setHp( m.getHp() - playerAttack );
   }//end if used the accio charm
  //*********SECTUMSEMPRA*************
   if(spellPick.equalsIgnoreCase("Sectumsempra"))
   {
      JOptionPane.showMessageDialog(null,"You use the sectumsempra curse.",p.getName(),-1);
      JOptionPane.showMessageDialog(null,m.getName()+" is attempting a Constitution saving throw to your curse.\nIf it fails, it will take more damage.",p.getName(),-1);
      //determine the player's attack excluding whether or not the saving throw fails
      playerAttack = d6(2,"no",8) + p.getStrength();
      //determine the saving throw
      savingThrow("Constitution");
      //if the saving throw fails, add extra damage
      if(success == 0){
      playerAttack += d6(1,"no",6);
      }//end if the Constitution saving throw failed
      m.setHp( m.getHp() - playerAttack );
   }//end if used the sectumsempra curse  
  //**************DIFFINDO**********************
   if(spellPick.equalsIgnoreCase("Diffindo"))
   {
      playerAttack = d6(1,"no",20) / 2 + p.getStrength();
      m.setHp( m.getHp() - playerAttack );
   }//end if used the diffindo charm
  //************STUPEFY******************
   if(spellPick.equalsIgnoreCase("Stupefy"))
   {
     //have the monster make a wisdom saving throw
     savingThrow("Wisdom");
     //if the saving throw fails, stun the target
     if(success == 0)
     {
     stunned = 1;
     }//end if the monster is stunned
     playerAttack = 0;
   }//end if used the stupefy charm
  //*********PROTEGO******************
  if(spellPick.equalsIgnoreCase("Protego"))
  {
    skillCheck("wisdom",p.getWisdom());
    //if the wisdom skill check succeeds, the player is fully protected
    if(rollOutcome == 1)
    {
      p.protegoUp(1);
      JOptionPane.showMessageDialog(null,"A perfect silver shield appears before you.\nYour protection seems certain.",p.getName(),-1);
    }//if success
    //else because the wisdom skill check fails, the player is half protected
    else
    {
      p.protegoUp(2);
      JOptionPane.showMessageDialog(null,"A fuzzy silver shield fizzles before you.\nYou hope it will be enough.",p.getName(),-1);
    }//end if fail
  }//end if used the protego charm
  //***********WINGARDIUM LEVIOSA*********
  if(spellPick.equalsIgnoreCase("Wingardium Leviosa"))
  {
    playerAttack = 0;
  }//end if used the wingardium leviosa charm
  //*********LUMOS******************
  if(spellPick.equalsIgnoreCase("Lumos"))
  {
    if(wellLit == -1)
    {
      JOptionPane.showMessageDialog(null,"You lit up the tip of your wand.\nYou can see things more clearly.",p.getName(),-1);
    }
    else
    {
      JOptionPane.showMessageDialog(null,"You lit up the tip of your wand.\nHowever, the area was already well lit, so\nthis makes little difference.",p.getName(),-1);
    }
    playerAttack = 0;
  }//end if used the lumos charm
  //*********DENSAUGEO******************
  if(spellPick.equalsIgnoreCase("Densaugeo"))
  {
    JOptionPane.showMessageDialog(null,monster+"'s teeth grow.",p.getName(),-1);
    playerAttack = d6(2, "no", 8) + p.getStrength();
    m.setHp( m.getHp() - playerAttack );
  }//end if used the densaugeo charm
  //*********FLIPENDO******************
  if(spellPick.equalsIgnoreCase("Flipendo"))
  {
    savingThrow("Strength");
    //if the saving throw fails, the target takes 1d10 bludgeoning damage
     if(success == 0)
     {
     JOptionPane.showMessageDialog(null,monster+" gets flipped into the air\nby your spell and takes damage\nfrom the landing.",p.getName(),-1);
     playerAttack = d6(1,"no",8) + p.getStrength();
     m.setHp( m.getHp() - playerAttack );
     }//end if the monster is stunned
     //if the saving throw succeeds, the target takes 0 damage
     else
     {
       playerAttack = 0;
       JOptionPane.showMessageDialog(null,monster+" stays firmly on the ground.\nYour spell does nothing.",p.getName(),-1);
     } 
  }//end if used the flipendo charm
  //*********SLUGULUS ERECTO******************
  if(spellPick.equalsIgnoreCase("Slugulus Erecto"))
  {
    JOptionPane.showMessageDialog(null,monster+" began vomitting slugs!\nEww...\nPerhaps you're regretting your decision.",p.getName(),-1);
    playerAttack = d6(3, "no", 8) + p.getStrength();
    m.setHp( m.getHp() - playerAttack );
    
    //Add code here for: monster gains one level of exhaustion
    
  }//end if used the slugulus erecto charm
  //*********SAGGITARIO******************
  if(spellPick.equalsIgnoreCase("Saggitario"))
  {
    JOptionPane.showMessageDialog(null,"You conjured a magical arrow that flew towards your target.",p.getName(),-1);
    playerAttack = d6(1, "no", 8) + p.getStrength();
    m.setHp( m.getHp() - playerAttack );
  }//end if used the saggitario charm
    
  //if the monster takes enough damage that its health becomes less than zero, set it equal to zero
   if(m.getHp() < 0)
   {
     m.setHp(0);
   }
    String defeat = ""; //congratulate the players on the defeat of a monster if applicable
   //remove the monster from the arrayLists if it is defeated and have String defeat be congratulations on the defeat of a monster
   if(m.getHp() == 0)
   {
     monsters.remove(m); //remove the monster from monsters
     charInitiative.remove(m); //remove the monster from charInitiative
     defeat = "\n"+m.getName() + " has been defeated!"; //make the value of defeat be congratulations on the defeat of the monster
   }
     
   JOptionPane.showMessageDialog(null,"You did "+playerAttack+" damage. "+m.getName()+"'s HP is "+m.getHp()+"/"+m.getHpTotal()+"."+defeat,p.getName(),-1);

  }//end if they used a spell
  if(turn == 0)
  {

  }//end if they used their inventory
}//end playerTurn function
//*************************************************monster turn***********************************
public static void monsterTurn(Monster m) //this gives the monster an attacking turn
{
  String shield = ""; //this contains information on what the player's shield did to protect them (if applicable)

  //if the monster is stunned, tell the user so and have the monster do nothing
  if(stunned != 0)
  {
    stunned++;
    //after a few rounds have passed, give the monster mobility again
    if(stunned == 3)
    {
      stunned = 0;
      JOptionPane.showMessageDialog(null,m.getName()+" has regained mobility.","DUNGEONS & DRAGONS",-1);
    }//end if the monster regains mobility
    //if the monster is still stunned, say so
    else{
    JOptionPane.showMessageDialog(null, m.getName()+" is stunned and loses a turn.","DUNGEONS & DRAGONS",-1);
    }//end if the monster is still stunned
  }//end if the monster was stunned
  if(stunned == 0) //will allow a monster with recently regained mobility to attack
  {
  
  JOptionPane.showMessageDialog(null,monster+" takes a turn.","DUNGEONS & DRAGONS",-1);
  
  //Roll a random number and add it to the monster's strength
  monsterAttack = d6(1,"no",20) / 2 + m.getStrength();
  //Determine the attacked player by randomly choosing a number from 0 to the max index of players
  Player p = players.get((int)(Math.random()*playerNum));
  //The player's dexterity gives them protection from the monster's attack so that the harm received is less
  if(p.usedProtego() == 0 || p.usedProtego() == 2)
  {
    if(p.getDexterity() < monsterAttack)
    {
    monsterHarm = monsterAttack - p.getDexterity();

    //if the shield is partially constructed, halve the damage
    if(p.usedProtego() == 2)
    {
      monsterHarm = monsterHarm/2;
      if(monsterHarm == 0) shield = "Although your shield was only partially constructed,\nit was enough to protect you from all damage.\nCongrats.";
      shield = "Your partially formed shield protected you from some damage.\n";
    }
      
     //The player's HP decreases after getting harmed by the monster 
    p.setHp( p.getHp() - monsterHarm );
    if(p.getHp()<=0)
    {
     JOptionPane.showMessageDialog(null,"Your HP has been fully depleted.",p.getName(),-1);
     restart(); 
    }//end if no more hp
    //if the monsterHarm ends up being 0 (due to the partial shield), explain the scenario
    else if(monsterHarm == 0)
    {
      JOptionPane.showMessageDialog(null,shield,p.getName(),-1);
    }
    else
    {
    JOptionPane.showMessageDialog(null,shield+"You have taken "+monsterHarm+" damage. Your HP is "+p.getHp()+"/"+p.getHpTotal()+".",p.getName(),-1);
    }//end if only lost partial HP
    }//end if dexterity is less than monsterAttack to avoid gaining HP instead
    else
    {
      JOptionPane.showMessageDialog(null,"You dodged the attack. Your HP is "+p.getHp()+"/"+p.getHpTotal()+".",p.getName(),-1);
    }//end if dexterity is greater than monsterAttack, so you dodge
   }//end if no protego shield is up or a partial shield is up

  //if the shield is completely up, take no damage
  else
  {
    JOptionPane.showMessageDialog(null,"Thanks to your perfect shield,\nyou took no damage.",p.getName(),-1);
  }
  //lower the shield
  p.protegoDown();
    
  }//end if the monster is not stunned
  
}//end function monsterTurn
//**************************************************listMonsters********************************************************
//This function lists all of the monsters
public static String listMonsters(){
  String output = "";
  for(Monster m: monsters)
      {
      output += m.getName() + "\n";
      }
  return output;
}//end listMonsters
  //**************************************************matchMonster************************************************
//this function makes sure the chosen monster matches what the options are and returns the index of the matched monster. Otherwise, -1 is returned when there are no matches
public static int matchMonster(String m){
  //for loop goes through all of the monsters in the arrayList
  for(int i = 0; i < monsters.size(); i++)
    {
      if( monsters.get(i).getName().equalsIgnoreCase(m) ) return i; //the name must match for the index of the monster to be returned
    }//end comparing monsters with the input
  //if nothing matches, return false
  return -1;
}//end matchMonster

//************************************************LISTPLAYERS************************
 //lists players and their initiatives
public static String listPlayers(ArrayList<Player> p)
  {
    String output = "";
    for(Player c: p)
      {
        output += c.getName() +"\n"; //add the name of each player in the array
      }
    return output;
  }//end listCharactersInitiatives //************************************************LISTCHARACTERSINITIATIVES******************************************************
//lists characters and their initiatives
public static String listCharactersInitiatives(ArrayList<Character> chars)
  {
    String output = "";
    for(Character c: chars)
      {
        output += c.getName() +" (initiative: " + c.getInitiative() + ")\n"; //add the name of each character and their initiative in the array
      } 
    return output;
  }//end listCharactersInitiatives
  //***************************************************monster*****************************************************
public static void monster(Monster m) //this is for introducing the monster
{
   JOptionPane.showMessageDialog(null, m.getName()+" looms threateningly.\nIts stats are:\nHP: "+m.getHp()+"/"+m.getHpTotal()+"\nStrength: "+m.getStrength()+"\nInitiative: "+m.getInitiative(),"DUNGEONS & DRAGONS", 2);
   battle();
}// end function monster

//**************************************PLAYERSHEALTHY***********************************
  //Returns true if all players have hp over 0
  //Returns false if at least one player has lost all of their hp
  public static boolean playersHealthy(ArrayList<Player> p)
  {
    for(int i = 0; i < p.size(); i++)
      {
        if(p.get(i).getHp() <= 0) return false;
      }//end for loop
    return true;
  }//end playersHealthy

//**************************************MONSTERS DEFEATED***********************************
  //Returns false if at least one monster has hp over 0
  //Returns true if all monsters have lost their hp
  public static boolean monstersDefeated(ArrayList<Monster> m)
  {
    for(int i = 0; i < m.size(); i++)
      {
        if((m.get(i)).getHp() > 0) return false;
      }//end for loop
    return true;
  }//end monstersDefeated

//***************************************************battle*****************************************************
public static void battle() //this is for the rest of the battle after fighting the monster
{
    int nextTurn = 0;
  //as long as any monster has yet to be defeated and all of the players are not defeated, the battle continues
     while(!monstersDefeated(monsters) && playersHealthy(players))
     {
       whoseTurn( charInitiative.get(nextTurn) );
       
       //change whose turn is next
       nextTurn++;
      //go back to the first character if all characters have had a turn
       if(nextTurn == charInitiative.size()){
         nextTurn = 0;
       }//end reset whose turn it is
       
     }//end fighting while monster and players are still fighting
   
   //if the battle ended with the players' victory, say so
   if(monstersDefeated(monsters))
   {
   JOptionPane.showMessageDialog(null,"You won!","DUNGEONS & DRAGONS",-1);
   stunned = 0;
  //make the first player be first for the next non-battle section
   difPlayer(0);
   return;
   }//if the battle ended with the monster's defeat
  
}

//*********************************INITIATIVESORT*************
public static void initiativeSort(ArrayList<Character> ppl, ArrayList<Player> play, ArrayList<Monster> mon)
  {
    //fill in character arraylist with all of the players and then the monster
    for(int x = 0; x < play.size(); x++)
      {
        ppl.add(play.get(x));
      }//end for loop
    for(int x = 0; x < mon.size(); x++)
      {
        ppl.add(mon.get(x));
      }
    
    //an insertion sort for the characters in the ArrayList ppl; sorts by the initiative value
    for(int x = 1; x < ppl.size(); x++) //each of the elements is sorted with those before them (starts with the second element)
    {
      Character temp = ppl.get(x); //stores the value of the second Character element
      int possibleIndex = x; //stores the value of the possibleIndex where the Character element temp may be stored.
      //compare temp with the element(s) before it while it is less than the element(s) before it
      while(possibleIndex > 0 && temp.getInitiative() > (ppl.get(possibleIndex - 1)).getInitiative() )
      {
        ppl.set(possibleIndex, ppl.get(possibleIndex - 1) ); //makes the earlier but larger value at (possibleIndex - 1) be the value of the later element at possibleIndex
        possibleIndex--; //continues searching for the possible placement of temp
      }//end while temp value is less than the previous value
      ppl.set(possibleIndex,temp); //the appropriate placement for temp now has the value of temp
    }//end for loop
  }//end initiativeSort
  
  //***************************************************RESTART**************************************************
public static void restart()
{
//asks the players if they would like to restart the game; the default answer is no 
  yesOrNo = JOptionPane.showOptionDialog(null,"You have reached the end of your journey.\nWould you like to play again?","DUNGEONS & DRAGONS",-1,1,null,yesNo,yesNo[1]);
   if(yesOrNo == 0){
     //need to add something to start the game over
   }//end if restart
   if(yesOrNo == 1){
   System.exit(0); //exits the program
   }//end if game is ended
}//end restart function

//*******************************************************MAIN**************************************************
public static void main(String[]args)
{
  int correct = 1; //checks if the number of players is what the user(s) want
  while(correct == 1 || playerNum < 1)//*******
  {
    String p = "players"; //determines whether player(s) should be singular or plural when the number of players is checked
   //set up game - ask for number of players
   playerNum = rileyFunctions.getValue("How many players are there?", "DUNGEONS & DRAGONS", -1);
    if(playerNum < 1) //if have invalid player number
    {
      JOptionPane.showMessageDialog(null, "Sorry, you cannot have "+playerNum+ " players.", "INVALID NUMBER", 0);
    }//end if invalid player number
    //if they chose 1+ players, allow them to continue
    //check if the number of players they chose was what they intended
    else
    {
      if(playerNum == 1) p = "player";
      correct = JOptionPane.showOptionDialog(null, "You want "+playerNum+" "+p+", correct?","DUNGEONS & DRAGONS", -1, 1, null, yesNo, yesNo[1]);
    }
  }//end while getting playerNum****************
  
  players = new ArrayList<Player>(playerNum);
   //begin game
   hogwartsExpress();
   sorting();
   herbology();
  restart();
 
}//end main
}//end program dungeonsAndDragons