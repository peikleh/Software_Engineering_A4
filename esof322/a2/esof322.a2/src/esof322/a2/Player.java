
/*Modified for esoff322.a2 by Nevin Leh, Aaron Newhall and  Tim Wegher
 * 
 */
package esof322.a2;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/


public interface Player {
  public void setRoom(Room r);
  public String look();
  public void go(int direction);
  public void pickUp(Item i);
  public boolean haveItem(Item itemToFind);
  public void drop(int itemNum);
  public void setLoc(Room r);
  public Room getLoc();
  public String showMyThings();
  public boolean handsFull();
  public boolean handsEmpty();
  public int numItemsCarried();
  public Item[] getMyThings();//Added this so I could print where I needed to. 

}
    



