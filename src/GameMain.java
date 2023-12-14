import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		System.out.println("Welcome to a Roguelike Text Adventure Game");
		Player playerCharacter = createNewPlayer();
		System.out.println(playerCharacter);
	}

	public static Player createNewPlayer() {
		Scanner keyB = new Scanner(System.in);
		String name = "Arthur";
		Player newPlayer;
		String difficulty = "easy";
		String statChoice = "none";
		int baseAttackPower = 2;
		int baseMagicalAttackPower = 2;
		int charisma = 2;
		int stamina = 2;
		int luck = 2;
		int statIntChoice = -1; 
		int remainingStatPoints = 10;
		int[] arrayOfStats = new int[5];
		
		
		System.out.println("What's your name?");
		name = keyB.nextLine();
		
		System.out.println("Do you want to play on Easy/Medium/Hard? (This changes starting health)");
		difficulty = keyB.nextLine();
		
		while (remainingStatPoints > 0) {
			System.out.println("Your current stats are:"
					+ "\nAttack Power - " + baseAttackPower
					+ "\nMagical Attack Power - " + baseMagicalAttackPower
					+ "\nCharisma - " + charisma
					+ "\nStamina - " + stamina
					+ "\nLuck - " + luck
					);
			System.out.println("You have " + remainingStatPoints + " stat points to augment those stats.");
			
			while (!statChoice.contains("att") && !statChoice.contains("mag") && 
					!statChoice.contains("char") && !statChoice.contains("stam") && !statChoice.contains("luc")) {
				System.out.println("Which stat do you want to increase? Att/Mag/Char/Sta/Luc");
				statChoice = keyB.nextLine().toLowerCase();		
			}
			statChoice = statChoice.toLowerCase();
			
			while (statIntChoice < 0 || statIntChoice > 10) {
				System.out.println("How many points do you want to spend?");
				statIntChoice = keyB.nextInt();
				keyB.nextLine();
			}			
			
			remainingStatPoints -= statIntChoice;
			if (statChoice.contains("att") && !statChoice.contains("mag")) {
				baseAttackPower += statIntChoice;				
			}
			else if (statChoice.contains("mag")) {
				baseMagicalAttackPower += statIntChoice;				
			}
			else if (statChoice.contains("char")) {
				charisma += statIntChoice;				
			}
			else if (statChoice.contains("sta")) {
				stamina += statIntChoice;				
			}
			else if (statChoice.contains("luc")) {
				luck += statIntChoice;				
			}
			
			statIntChoice = -1;			
			statChoice = "none";			
		}
		System.out.println("Your current stats are:"
				+ "\nAttack Power - " + baseAttackPower
				+ "\nMagical Attack Power - " + baseMagicalAttackPower
				+ "\nCharisma - " + charisma
				+ "\nStamina - " + stamina
				+ "\nLuck - " + luck);

		arrayOfStats = new int[] {baseAttackPower, baseMagicalAttackPower, charisma, stamina, luck};
		newPlayer = new Player(name, difficulty, arrayOfStats);
		
		
		keyB.close();
		return newPlayer;
	}
}
