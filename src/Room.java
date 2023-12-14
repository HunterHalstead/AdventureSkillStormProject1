
public class Room {
	private static Player player;
	
	public Room(Player player) {
		Room.player = player;
	}
	
	public void rewardPlayer() {
		int coinsAfterReward = (Room.player.getCoins() + 1);
		Room.player.setCoins(coinsAfterReward);
	}
}

	