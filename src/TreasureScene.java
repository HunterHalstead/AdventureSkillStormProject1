
public class TreasureScene extends Scene {
	
	public void playScene() {
		rewardPlayer();
	}
	
	public void rewardPlayer() {
		int coinsFound = player.getLuck();
		System.out.println("A glint flashes on the ground...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You reach down to pick it up...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("It's %d coin.\n", coinsFound);
		int coinsAfterReward = (Scene.player.getCoins() + coinsFound);
		Scene.player.setCoins(coinsAfterReward);
	}
}
