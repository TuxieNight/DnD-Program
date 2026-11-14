package dnd;

import javax.swing.JOptionPane;
import static dnd.Main.*;

public class Spells {
    //************************************************alohomora**************************************************
   public static void alohomora()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Alohomora opens locks.\nSTATS:__________\nWould you like to use it?", nameF + " " + nameL, -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function alohomora

   //************************************************accio**************************************************
   public static void accio()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Accio summons objects to you.\nSTATS:\nThe target takes 1d20 damage.\nYou must make a dexterity check to catch the object and avoid getting hit.\nIf you fail, you lose 5 HP.\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }      
   }//end function accio   

   //************************************************sectumsempra**************************************************
   public static void sectumsempra()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Sectumsempra creates gashes in your opponent.\nSTATS:\nThe target takes 2d8 slashing damage.\nThe target attempts a Constitution saving throw, taking 1d6 slashing damage on a failed save.\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }      
   }//end function sectumsempra
   
  //************************************************diffindo**************************************************
  public static void diffindo()
  {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Diffindo cuts the object or person it is directed at.\nSTATS:\nThe target attempts a Dexterity saving throw.\nIt takes 4d4 damage if the save fails.\nIt takes half as much damage if the save succeeds.\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }     
  }//end function diffindo
   
   //************************************************stupefy**************************************************
   public static void stupefy()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Stupefy stuns the enemy.\nSTATS: The target makes a Wisdom saving throw.\nIf it fails, it is stunned for one round.\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function stupefy

   //************************************************protego**************************************************
   public static void protego()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Protego blocks attacks.\nSTATS: \nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function protego

   //************************************************wingardiumLeviosa**************************************************
   public static void wingardiumLeviosa()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Wingardium Leviosa lifts objects.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function wingardiumLeviosa

   //************************************************lumos**************************************************
   public static void lumos()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Lumos creates a bright light.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function lumos

   //************************************************densaugeo**************************************************
   public static void densaugeo()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Densaugeo grows the target's two front teeth.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function densaugeo

   //************************************************flipendo**************************************************
   public static void flipendo()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Flipendo throws the target to the ground.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function flipendo

   //************************************************slugulusErecto**************************************************
   public static void slugulusErecto()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Slugulus Erecto causes the victim to vomit slugs.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function slugulusErecto       

   //************************************************saggitario**************************************************
   public static void saggitario()
   {
      //debugging the error where the spells comes up after defeating the monster
      if(monsterHP == 0)
      {
        return;
      }//end if the monster is defeated
      int spellChoice = JOptionPane.showOptionDialog(null, "Saggitario conjures an arrow that strikes the target.\nSTATS:__________\nWould you like to use it?", (players.get(i)).getName(), -1, 1, null, choice, choice[0]);
      if(spellChoice == 0)
      {
         spells();
      }      
      if(spellChoice == 1)
      {
         battle();
      }
   }//end function saggitario
}
