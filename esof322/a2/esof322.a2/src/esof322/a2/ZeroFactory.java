package esof322.a2;

public class ZeroFactory extends adventureFactory {

	@Override
	public Room createRoom() {
		return new Room();
	}

	@Override
	public Door createDoor(Room r1, Room r2, Key k) {
		return new Door(r1, r2, k);
		
	}

	@Override
	public Key createKey() {
		return new Key();
	}

	@Override
	public Treasure createTreasure() {
		return new Treasure();
	}

	@Override
	public Player createPlayer() {
		return new zeroPlayer();
	}

	@Override
	public Adventure createAdventure() {
		return new ZeroAdventure();
	}



}
