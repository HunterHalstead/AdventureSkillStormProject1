import java.util.ArrayList;
import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
//		Scanner keyB = new Scanner(System.in);
		int numberOfScenesToWin = 10;
		int currentScenarioNum = 1;
		ArrayList<Scene> arrayOfScenes = new ArrayList<Scene>();
		System.out.println("Welcome to a Roguelike Text Adventure Game");
		Player playerCharacter = createNewPlayer();
		System.out.println(playerCharacter);
		
		Scene urScene = new Scene();
		urScene.setPlayer(playerCharacter);
		
		arrayOfScenes = craftJourney(arrayOfScenes, numberOfScenesToWin);
		for(Scene currentScene : arrayOfScenes) {
			System.out.printf("\nScenario: %d", currentScenarioNum);
			currentScene.playScene();
			currentScenarioNum++;
			System.out.println("\n");
		}
		
		System.out.println("You did it!!! Congratulations");
//		testScene2.playScene();
//		System.out.println(playerCharacter);
		
		
	}

	

	private static ArrayList<Scene> craftJourney(ArrayList<Scene> arrayOfScenes, int numberOfScenesToWin) {
		int randomSceneChoice = 0;
			do {
				randomSceneChoice = (int) ((Math.random() * 5) + 1);
				switch(randomSceneChoice) {
					case 1:
						arrayOfScenes.add(new MonsterScene());
						break;
					case 2:
						arrayOfScenes.add(new MonsterScene());
						break;
					case 3:
						arrayOfScenes.add(new MonsterScene());
						break;
					case 4:
						arrayOfScenes.add(new MonsterScene());
						break;
					case 5:
						arrayOfScenes.add(new MonsterScene());
						break;
				}
			}
			while(arrayOfScenes.size() < numberOfScenesToWin);
		return arrayOfScenes;
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
		int randomStatChoice = 0;
		int remainingStatPoints = 10;
		int[] arrayOfStats = new int[5];
		
		
		System.out.println("What's your name?");
		name = keyB.nextLine();
		
		System.out.println("Do you want to play on Easy/Medium/Hard? (This changes starting health)");
		difficulty = keyB.nextLine();
		difficulty = difficulty.toLowerCase();		
		
		while (remainingStatPoints > 0) {
			System.out.println("Your current adjustable stats are:"
					+ "\nAttack Power - " + baseAttackPower
					+ "\nMagical Attack Power - " + baseMagicalAttackPower
					+ "\nCharisma - " + charisma
					+ "\nStamina - " + stamina
					+ "\nLuck - " + luck
					);
			System.out.println("You have " + remainingStatPoints + " stat points to augment those stats.");
			
			while (!statChoice.contains("att") && !statChoice.contains("mag") && 
					!statChoice.contains("cha") && !statChoice.contains("sta") && !statChoice.contains("luc") && !statChoice.contains("ran")) {
				System.out.println("Which stat do you want to increase? Att/Mag/Char/Sta/Luc/Random");
				statChoice = keyB.nextLine().toLowerCase();		
			}
			statChoice = statChoice.toLowerCase();
			
			while ((statIntChoice < 0 || statIntChoice > 10) && !statChoice.contains("ran")) {
				System.out.println("How many points do you want to spend?");
				statIntChoice = keyB.nextInt();
				keyB.nextLine();
			}
			
			while(remainingStatPoints > 0   && statChoice.contains("ran")) {
				randomStatChoice = (int) ((Math.random() * 5) + 1);
//				System.out.println(randomStatChoice);
				switch(randomStatChoice) {
					case 1:
						baseAttackPower++;
						remainingStatPoints--;
						break;
					case 2:
						baseMagicalAttackPower++;
						remainingStatPoints--;
						break;
					case 3:
						charisma++;
						remainingStatPoints--;
						break;
					case 4:
						stamina++;
						remainingStatPoints--;
						break;
					case 5:
						luck++;
						remainingStatPoints--;
						break;
				}
				statIntChoice = 0;
			}
			
			remainingStatPoints -= statIntChoice;
			if (statChoice.contains("att") && !statChoice.contains("mag")) {
				baseAttackPower += statIntChoice;				
			}
			else if (statChoice.contains("mag")) {
				baseMagicalAttackPower += statIntChoice;				
			}
			else if (statChoice.contains("cha")) {
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
//		System.out.println("Your current stats are:"
//				+ "\nAttack Power - " + baseAttackPower
//				+ "\nMagical Attack Power - " + baseMagicalAttackPower
//				+ "\nCharisma - " + charisma
//				+ "\nStamina - " + stamina
//				+ "\nLuck - " + luck);

		arrayOfStats = new int[] {baseAttackPower, baseMagicalAttackPower, charisma, stamina, luck};
		newPlayer = new Player(name, difficulty, arrayOfStats);
		
		
//		keyB.close();
		return newPlayer;
	}
}
