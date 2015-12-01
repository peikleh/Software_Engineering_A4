package esof322.a2;

public abstract class adventureFactory {
	public abstract Player createPlayer();
	public abstract Room createRoom();
	public abstract Door createDoor(Room r1, Room r2, Key k);
	public abstract Key createKey();
	public abstract Treasure createTreasure();
}
