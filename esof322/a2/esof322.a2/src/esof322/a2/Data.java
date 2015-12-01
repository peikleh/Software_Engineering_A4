package esof322.a2;

public class Data implements java.io.Serializable {
	private Room r ;
	private Player p;
	private Adventure a;
	
	public Data( Player p1, Adventure a1){
		p=p1;
		a=a1;
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public Adventure getAdventure(){
		return a;
	}
	
	
	
	
}
