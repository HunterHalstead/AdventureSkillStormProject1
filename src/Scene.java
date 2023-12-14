
public class Scene {
	private static Player player;
	
	public void setPlayer(Player player) {
		Scene.player = player;
	}
	
	public void rewardPlayer() {
		int coinsAfterReward = (Scene.player.getCoins() + 1);
		Scene.player.setCoins(coinsAfterReward);
	}
}

	