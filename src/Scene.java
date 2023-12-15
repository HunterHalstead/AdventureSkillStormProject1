
public class Scene {
	public static Player player;
	
	public void setPlayer(Player player) {
		Scene.player = player;
	}
	
	public void rewardPlayer() {
		int coinsFound = 3;
		System.out.println("A glint flashes on the ground...");
		System.out.println("You reach down to pick it up...");
		System.out.printf("It's %d coin.\n", coinsFound);
		int coinsAfterReward = (Scene.player.getCoins() + coinsFound);
		Scene.player.setCoins(coinsAfterReward);
	}

	public void playScene() {
		
	}
}

	