/*Modified for esoff322.a2 by Nevin Leh, Aaron Newhall and  Tim Wegher
 * 
 */

package esof322.a2;

/*Description of additions:For this class we essentially implemented the AdventureGame class for a GUI format. We added the 
 * Instance variable needed such as a Player, an Adventure, and a start Room. We called player.go() to move and implemented 
 * a grab and drop method.
 * 
 */
import java.io.*;
public class AdventureGameModelFacade {
	/*
	 * Created instance variables needed
	 */
	
	//Player thePlayer = new Player();
	
	Adventure theCave = new Adventure();
	ZeroFactory factory = new ZeroFactory();
	Player thePlayer = factory.createPlayer();
	Room startRm = theCave.createAdventure(factory);


	AdventureGameModelFacade() { // we initialize a start room
		thePlayer.setRoom(startRm);
	}

	public void goUp() {
		thePlayer.go(4);//map button call to correct player direction.
	}

	public void goDown() {
		thePlayer.go(5);//map button call to correct player direction.
	}

	public void goNorth() {
		thePlayer.go(0);//map button call to correct player direction.
	}

	public void goSouth() {
		thePlayer.go(1);//map button call to correct player direction.
	}

	public void goEast() {
		thePlayer.go(2);//map button call to correct player direction.
	}

	public void goWest() {
		thePlayer.go(3);//map button call to correct player direction.
	}
	
	public String getView() {
		return (thePlayer.look());//map button call to player method for getting room description
	}

	public String getItems() {
		return ("You are carrying: " + thePlayer.showMyThings());//map button call to player method for showing inventory
	}

	public String grab(int choice) {
		/*
		 *Method handles grabbing an item. If and Else statements are to handle invalid choice numbers and the players
		 *hands are full. After that we set a string to the selected item to pick up to be displayed in the gui. We call
		 *the player.pickup()method and then return the string from earlier.
		 */
		if (choice < 0 || choice > (thePlayer.getLoc().getRoomContents().length - 1)) {
			return "Not a valid item index";
		} else if (thePlayer.handsFull()) {
			return "Your hands are full";
		}
		String item = thePlayer.getLoc().getRoomContents()[choice].getDesc();
		thePlayer.pickUp(thePlayer.getLoc().getRoomContents()[choice]);

		return "You picked up a " + item;

	}

	public String drop(int choice) {
		/*
		 * This method handles dropping an item. The if and else if statements are to handle invalid index numbers and
		 * to handle if the player has nothing to drop. Again we set a string to the item and return it.
		 */
		if (choice < 0 || choice > (thePlayer.numItemsCarried() - 1)) {
			return "Not a valid item index";
		} else if (thePlayer.handsEmpty()) {
			return "You have nothing to drop";
		}
		String item = thePlayer.getMyThings()[choice].getDesc();
		thePlayer.drop(choice);
		return "You dropped a " + item;

	}
	//code adopted from http://www.tutorialspoint.com/java/java_serialization.htm
	public void saveGame(){
		Data d = new Data(thePlayer, theCave);
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/adventureGame.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(d);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/adventureGame.ser");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	//code adopted from http://www.tutorialspoint.com/java/java_serialization.htm
	public void loadGame(){
		Data d = null;
		 try
	      {
	         FileInputStream fileIn = new FileInputStream("/tmp/adventureGame.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         d = (Data) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
		 thePlayer = d.getPlayer();
		 theCave = d.getAdventure();
	}
	
	public void changeDifficulty(){
		
	}

	

}
