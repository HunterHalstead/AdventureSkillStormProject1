import java.util.Arrays;

public class Player {
	private String name;
	private int hp;
	private int maxHp;
	int baseAttackPower = 2;
	int baseMagicalAttackPower = 2;
	int charisma = 2;
	int stamina = 2;
	int luck = 2;
	private String[] inventory;
	private boolean isAlive;
		
	
	public Player() {
		this.name = "Generic Name";
		this.maxHp = 20;
		this.hp = this.maxHp;
		this.isAlive = true; 
		this.inventory = new String[1]; //Check array
	}
	
	public Player(String name, int maxHp) {
		this.name = name;
		this.maxHp= maxHp;
		this.hp = this.maxHp;
		this.isAlive = true; 
		this.inventory = new String[1];
	}
	
	public Player(String name, String difficulty, int[] arrayOfStats) {
		this.name = name;
		switch (difficulty.toLowerCase()) {
			case "hard":
				this.maxHp= 5;
				this.hp = maxHp;
				break;
			case "medium":
				this.maxHp= 10;
				this.hp = maxHp;
				break;				
			default:
				this.maxHp= 20;
				this.hp = maxHp;
				break;
		}
		this.baseAttackPower = arrayOfStats[0];
		this.baseMagicalAttackPower = arrayOfStats[1];
		this.charisma = arrayOfStats[2];
		this.stamina = arrayOfStats[3];
		this.luck = arrayOfStats[4];
		this.isAlive = true; 
		this.inventory = new String[1];
	}

	public Player(String name, int hp, String[] inventory, int maxHp) {
		this.name = name;
		this.hp = hp;
		this.maxHp= maxHp;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "\nPlayer Name = " + name + "\nHP = " + hp + "/" + maxHp + 
				"\nAttack = " + baseAttackPower + 
				"\nMagic = " + baseMagicalAttackPower + 
				"\nCharisma = " + charisma + 
				"\nStamina = " + stamina + 
				"\nLuck = " + luck + 
				"\ninventory = " + Arrays.toString(inventory) + 
				"\nisAlive = " + isAlive;
	}

}


