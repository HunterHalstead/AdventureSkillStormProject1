
public class Scene {
	public static Player player;
	
	public void setPlayer(Player player) {
		Scene.player = player;
	}
	
	public void rewardPlayer() {
		System.out.println("A glint flashes on the ground...");
		System.out.println("You reach down to pick it up...");
		System.out.println("It's a single coin.");
		int coinsAfterReward = (Scene.player.getCoins() + 1);
		Scene.player.setCoins(coinsAfterReward);
	}

	public void playScene() {
		
	}
}

	