import java.util.Scanner;

public class ShopScene extends Scene {
	//offer items
	
	//sell items?
	public void playScene() {
		Scanner keyB = new Scanner(System.in);
		String userInput = " ";
		boolean happyToShop = true;
		int coinsAfterShopping;
		
		System.out.println("\nAn ominous cloaked figure appears from the mist.\n...\n"
						 + "Would you like to look at my wares? YES/NO");
		if(player.getCoins() < 1) {
			System.out.println("wait. nevermind. you have no money.");
			return;
		}
		userInput = keyB.nextLine();
		userInput = userInput.toLowerCase();
		if(userInput.contains("y")) {
			happyToShop = true;
		}
		else {
			happyToShop = false;
		}
		while(happyToShop) {
			System.out.printf("\nYour coins: %d\n", player.getCoins());
			System.out.println("I sell stat boosts. RANDOM/SPECIFIC/EXIT"
					+ "\nRANDOM boosts cost 1 coin each."
					+ "\nSPECIFIC boosts cost 3 coins and boost by 2.");
			userInput = keyB.nextLine();
			userInput = userInput.toLowerCase();
			if(userInput.contains("x")) {
				happyToShop = false;
			}
			if(userInput.contains("ran")) {
				player.gainRandomStat();;
				System.out.println(player);
				coinsAfterShopping = player.getCoins() - 1;
				Scene.player.setCoins(coinsAfterShopping);
				if (player.getCoins() < 1) {
					happyToShop = false;
				}
			}
			if(userInput.contains("spe") && player.getCoins() >= 3) {
				while (!userInput.contains("phy") && !userInput.contains("mag") && 
						!userInput.contains("cha") && !userInput.contains("sta") && !userInput.contains("luc")) {
					System.out.println("Which stat do you want to increase? PHYSICAL/MAGIC/CHARISMA/STAMINA/LUCK");
					userInput = keyB.nextLine().toLowerCase();
				}
				if (userInput.contains("phy") && !userInput.contains("mag")) {
					player.setBaseAttackPower(player.getBaseAttackPower() + 3);;
					player.setCoins(player.getCoins()-3);
				}
				else if (userInput.contains("mag")) {
					player.setBaseMagicalAttackPower(player.getBaseMagicalAttackPower() + 3);;				
					player.setCoins(player.getCoins()-3);
				}
				else if (userInput.contains("cha")) {
					player.setCharisma(player.getCharisma() + 3);				
					player.setCoins(player.getCoins()-3);
				}
				else if (userInput.contains("sta")) {
					player.setStamina(player.getStamina() + 3);
					player.setCoins(player.getCoins()-3);
				}
				else if (userInput.contains("luc")) {
					player.setLuck(player.getLuck() + 3);				
					player.setCoins(player.getCoins()-3);
				}
			}
		}
	}
}
