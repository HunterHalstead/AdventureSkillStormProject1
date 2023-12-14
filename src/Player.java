import java.util.Arrays;

public class Player {
	private String name;
	private int hp;
	private int maxHp;
	private int baseAttackPower = 2;
	private int baseMagicalAttackPower = 2;
	private int charisma = 2;
	private int stamina = 2;
	private int luck = 2;
	private int coins = 0;
	private String[] inventory;
	private boolean isAlive;
		
	
//	public Player() {
//		this.name = "Generic Name";
//		this.maxHp = 20;
//		this.hp = this.maxHp;
//		this.isAlive = true; 
//		this.inventory = new String[1]; //Check array
//	}
//	
//	public Player(String name, int maxHp) {
//		this.name = name;
//		this.maxHp= maxHp;
//		this.hp = this.maxHp;
//		this.isAlive = true; 
//		this.inventory = new String[1];
//	}
	
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

//	public Player(String name, int hp, String[] inventory, int maxHp) {
//		this.name = name;
//		this.hp = hp;
//		this.maxHp= maxHp;
//		this.inventory = inventory;
//	}

	@Override
	public String toString() {
		return "\nPlayer Name = " + name + "\nHP = " + hp + "/" + maxHp + 
				"\nAttack = " + baseAttackPower + 
				"\nMagic = " + baseMagicalAttackPower + 
				"\nCharisma = " + charisma + 
				"\nStamina = " + stamina + 
				"\nLuck = " + luck + 
				"\ninventory = " + Arrays.toString(inventory) + 
				"\nCoins = " + coins + 
				"\nisAlive = " + isAlive;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getBaseAttackPower() {
		return baseAttackPower;
	}

	public int getBaseMagicalAttackPower() {
		return baseMagicalAttackPower;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getStamina() {
		return stamina;
	}

	public int getLuck() {
		return luck;
	}

	public int getCoins() {
		return coins;
	}

	public String[] getInventory() {
		return inventory;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setBaseAttackPower(int baseAttackPower) {
		this.baseAttackPower = baseAttackPower;
	}

	public void setBaseMagicalAttackPower(int baseMagicalAttackPower) {
		this.baseMagicalAttackPower = baseMagicalAttackPower;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public void setInventory(String[] inventory) {
		this.inventory = inventory;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

}


