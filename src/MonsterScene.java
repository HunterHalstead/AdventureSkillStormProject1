import java.util.Scanner;

public class MonsterScene extends Scene {
	private String monsterSpecies = "random office worker";
	private String monsterBlurb = "walks in with a confused look, but hostility clouds his gaze and he attacks";
	private String monsterPrefix = "A weak ";
	private int monsterBaseStrength = 5;
	private int monsterMaxHp = 10;
	private int monsterCurrentHp = monsterMaxHp;
	private int physicalDefence = 2;
	private int magicalDefence = 0;
	private boolean sceneIsActive = true;
//	public static Scanner keyB = new Scanner(System.in);

	public MonsterScene() {
		randomizeMonster();
		randomizeStrength();
		randomizeDefenseSpecialty();
	}
	
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
		System.out.format("The %s is no longer a threat", monsterSpecies);
		Scene.player.gainRandomStat();
		Scene.player.endOfBattleHeal();
		Scene.player.setUsedStamina(Scene.player.getStamina());
		System.out.println("You gained a random stat point");
		System.out.println(player);

//		keyB.close();
	}

	public void randomizeMonster() {
		int randomMonsterNum = (int) ((Math.random() * 5) + 1);
		switch (randomMonsterNum) {
			case 1:
				monsterSpecies = "Twisted Eagle";
				monsterBlurb = "swoops downs with claws, too many claws, that aim for your life.";
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
		switch (randomMonsterNum) {
			case 3:
				monsterPrefix = "An elite ";
				monsterBaseStrength = 5;
				monsterMaxHp = 15;
				break;
			case 2:
				monsterPrefix = "A ";
				monsterBaseStrength = 4;
				monsterMaxHp = 13;
				break;
			default:
				monsterPrefix = "A weak ";
				monsterBaseStrength = 3;
				monsterMaxHp = 8;
				break;
		}
		monsterCurrentHp = monsterMaxHp;
	}
	
	public void randomizeDefenseSpecialty() {
		int randomMonsterNum = (int) ((Math.random() * 2) + 1);
		switch (randomMonsterNum) {
			case 2:
				physicalDefence = 2;
				magicalDefence = 0;
				break;
			default:
				physicalDefence = 0;
				magicalDefence = 2;
				break;
		}
		monsterCurrentHp = monsterMaxHp;
	}

	public void offerPlayerActions(Scanner keyB) {
//		Scanner keyB = new Scanner(System.in);
		boolean choiceIsPending = true;
		while (choiceIsPending) {
			System.out.printf("Your Stamina: %d/%d  Your HP: %d/%d\n", Scene.player.getUsedStamina(), Scene.player.getStamina(),
															 Scene.player.getHp(), Scene.player.getMaxHp());
			System.out.println("Do you want to ATTACK? (You must have 2 stamina to spend)\n"
							 + "Do you want to DEFEND? (You will gain 2 temp defense and 3 stamina)");
			String action = keyB.nextLine();
			if (action.contains("att")) {
				attackMonster(keyB);
				Scene.player.decrementStamina(2);
				choiceIsPending = false;
			}
			else if (action.contains("def")) {
				Scene.player.setTempDefend();
				Scene.player.incrementStamina(3);
				choiceIsPending = false;
			}
		}
//		keyB.close();
	}

	public void attackMonster(Scanner keyB) {
		boolean choiceIsPending = true;
		int damage = 0;
		while (choiceIsPending) {
			System.out.println("Physical or Magical attack?");
			String type = keyB.nextLine();
			if (type.contains("phy") && !type.contains("mag")) {
				damage = Scene.player.getBaseAttackPower() - physicalDefence;
				choiceIsPending = false;
			}
			else if (!type.contains("phy") && type.contains("mag")) {
				damage = Scene.player.getBaseMagicalAttackPower() - magicalDefence;				
				choiceIsPending = false;
			}
			if (damage < 0) {
				damage = 0;
			}
			
		}
		monsterCurrentHp -= damage;
		System.out.printf("you dealt %s points of damage to the %s.\n", damage, monsterSpecies);
	}

	
	public void monsterAction() {
		int healAmount = 3;
		int staminaLost = 1;
		int randomMonsterNum = (int) ((Math.random() * 3) + 1);
		switch (randomMonsterNum) {
			case 4:
				
				this.monsterCurrentHp += healAmount;
				System.out.printf("The %s healed itself by %s.\n", this.monsterSpecies, healAmount);
				break;
			case 3:
				Scene.player.decrementStamina(staminaLost);
				System.out.printf("The %s stole %d stamina from you.\n", this.monsterSpecies, staminaLost);
				break;
			case 2:
				Scene.player.damageHP(monsterBaseStrength);								
				break;
			default:
				Scene.player.damageHP(monsterBaseStrength);				
				break;
		}
	}
	
	// befriend if charisma is hig enough and hp is low enough
}
