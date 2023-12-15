import java.util.Scanner;

public class BossMonsterScene extends MonsterScene {
	boolean bossSuppressed = false;
	
	public void playScene() {
		Scanner keyB = new Scanner(System.in);
		System.out.println("\n" + monsterPrefix + monsterSpecies + " " + monsterBlurb);
		while (sceneIsActive) {
			System.out.println("The " + monsterSpecies + " has " + monsterCurrentHp + " HP.");
			offerPlayerActions(keyB);
			if(monsterCurrentHp > 0 ) {
				monsterAction();
				Scene.player.incrementStamina(1);
			}
			if(monsterCurrentHp <= 0 ) {
				sceneIsActive = false;
			}
			if(Scene.player.getHp() <= 0) {
				Scene.player.setAlive(false);
				sceneIsActive = false;
				return;
			}
		}
		if (!bossSuppressed) {
			System.out.format("The %s is no longer a threat.\nBut you are now lost in the darkness", monsterSpecies);
			
		}

//		keyB.close();
	}
	
	public void offerPlayerActions(Scanner keyB) {
//		Scanner keyB = new Scanner(System.in);
		boolean choiceIsPending = true;
		while (choiceIsPending) {
			System.out.printf("Your Stamina: %d/%d  Your HP: %d/%d\n", Scene.player.getUsedStamina(), Scene.player.getStamina(),
															 Scene.player.getHp(), Scene.player.getMaxHp());
			System.out.println("Do you want to ATTACK? (You must have 1 stamina to spend)\n"
							 + "Do you want to DEFEND? (You will gain 2 temp defense and 4 stamina)\n"
							 + "Do you want to SUPPRESS? (Charisma needs to be high enough)\n");
			String action = keyB.nextLine();
			if (action.contains("att")) {
				attackMonster(keyB);
				Scene.player.decrementStamina(1);
				choiceIsPending = false;
			}
			else if (action.contains("def")) {
				Scene.player.setTempDefend();
				Scene.player.incrementStamina(4);
				choiceIsPending = false;
			}
			else if (action.contains("sup")) {
				suppress();
				choiceIsPending = false;
			}
		}
//		keyB.close();
	}

	
	private void suppress() {
		if ((player.getCharisma() > 10)) {
			monsterCurrentHp = 0;
			this.bossSuppressed = true;
			System.out.println("\nYou suppressed the %s.\n"
					+ "Thank you so much Hero\n"
					+ "I never thought I would be free of the mind control!\n"
					+ "I'll guide you out and show you how to destroy this place.\n...\n"
					+ "As the labyrinthine den of monsters crumbles behind you,\n"
					+ "You finally feel peace.\n");
		}
		else {
			System.out.println("\nIt didn't work");
		}
	}
	
	public BossMonsterScene() {
		randomizeMonster();
		randomizeStrength();
		randomizeDefenseSpecialty();
	}
	
	public void randomizeMonster() {
		int randomMonsterNum = 1; //(int) ((Math.random() * 5) + 1);
		switch (randomMonsterNum) {
			case 1:
				monsterSpecies = "Masked Man";
				monsterBlurb = "appears. You prepare to buy his wares but he laughs"
						+ "\nThis is the end of the line for you."
						+ "\nYou won't make it out of my dungeon alive";
				break;
			case 2:
				monsterSpecies = "Writhing Peat Moss";
				monsterBlurb = "shifts underneath you and begins to tangle you...no...strangle you.";
				break;
			case 3:
				monsterSpecies = "Carrion Turtle";
				monsterBlurb = "turns to you, it's maw dripping with putrid blood.";
				break;
			case 4:
				monsterSpecies = "White Cat of Misfortune";
				monsterBlurb = "strolls in. Not in silence but with footsteps that shriek it's disdain for the natural order.";
				break;
			case 5:
				monsterSpecies = "Corporeal Incarnation of a Mildly Catchy Tune";
				monsterBlurb = "overstays it's welcome.";
				break;
		}
	}
	
	public void randomizeStrength() {
		int randomMonsterNum = (int) ((Math.random() * 3) + 1);
		monsterPrefix = "A ";
		switch (randomMonsterNum) {
			case 3:
				monsterBaseStrength = 4;
				monsterMaxHp = 50;
				break;
			case 2:
				monsterBaseStrength = 4;
				monsterMaxHp = 49;
				break;
			default:
				monsterBaseStrength = 4;
				monsterMaxHp = 48;
				break;
		}
		monsterCurrentHp = monsterMaxHp;
	}
	
	public void randomizeDefenseSpecialty() {
		int randomMonsterNum = (int) ((Math.random() * 2) + 1);
		switch (randomMonsterNum) {
			case 2:
				physicalDefence = 2;
				magicalDefence = 2;
				break;
			default:
				physicalDefence = 2;
				magicalDefence = 2;
				break;
		}
	}
}
