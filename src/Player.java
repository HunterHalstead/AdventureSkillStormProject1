import java.util.Arrays;

public class Player {
	private String name;
	private int hp;
	private int maxHp;
	private int baseAttackPower = 2;
	private int baseMagicalAttackPower = 2;
	private int charisma = 2;
	private int stamina = 2;
	private int usedStamina = 2;
	private int luck = 2;
	private int sumOfEquipmentDefense = 0;
	private int tempDefense = 0;	
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
				this.maxHp= 18;
				this.hp = maxHp;
				break;
			case "medium":
				this.maxHp= 24;
				this.hp = maxHp;
				break;				
			default:
				this.maxHp= 30;
				this.hp = maxHp;
				break;
		}
		this.baseAttackPower = arrayOfStats[0];
		this.baseMagicalAttackPower = arrayOfStats[1];
		this.charisma = arrayOfStats[2];
		this.stamina = arrayOfStats[3];
		this.usedStamina = this.stamina;
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
	
	public int getUsedStamina() {
		return usedStamina;
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
	
	public void healHp(int healAmount) {
		if(this.hp + healAmount > this.maxHp) {
			this.hp = this.maxHp;
			System.out.println("You fully healed!");
		}
		else {
			this.hp += healAmount;
			System.out.printf("You healed bt %d.\n", healAmount);
		}
	}
	
	public void endOfBattleHeal() {
		int healAmount = (this.maxHp / 3) * 2;
		healHp(healAmount);
	}

	public void damageHP(int monsterDamage) {
		int damage = 0;
		damage = ((monsterDamage - sumOfEquipmentDefense) - tempDefense);
		if(damage < 0) {
			damage = 0;
		}
		this.hp -= damage;
		System.out.format("You took %s points of damage. You now have %s HP.\n", damage, this.hp);
		tempDefense = 0;
		if (this.hp <= 0) {
			this.setAlive(false);
		}
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
	
	public void setTempDefend() {
		this.tempDefense = 2;
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

	public void setUsedStamina(int usedStamina) {
		this.usedStamina = usedStamina;
	}
	
	public void decrementStamina(int staminaLost) {
		if((this.getUsedStamina() - staminaLost) < 1) {
			this.setUsedStamina(0);
			System.out.println("You have no stamina");
		}
		else {
			this.setUsedStamina(this.getUsedStamina() - staminaLost);
			System.out.printf("You lost %d stamina.\n", staminaLost);
		}
		if (this.getUsedStamina() > this.getStamina()) {
			this.setUsedStamina(0);
			System.out.println("You have no stamina");
		}
	}
	
	public void incrementStamina(int staminagained) {
		if((this.getUsedStamina() + staminagained) > this.stamina) {
			this.setUsedStamina(this.stamina);
			System.out.println("You have full stamina");
		}
		else {
			this.setUsedStamina(this.getUsedStamina() + staminagained);
			System.out.printf("You gained %d stamina.\n", staminagained);
		}
	}

	public void gainRandomStat() {
		int randomStatChoice = (int) ((Math.random() * 5) + 1);
//		System.out.println(randomStatChoice);
		switch(randomStatChoice) {
			case 1:
				baseAttackPower++;
				break;
			case 2:
				baseMagicalAttackPower++;
				break;
			case 3:
				charisma++;
				break;
			case 4:
				stamina++;
				break;
			case 5:
				luck++;
				break;
		}
	}

}


