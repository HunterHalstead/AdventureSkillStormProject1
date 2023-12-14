
public class Player {
	private String name;
	private int hp;
	private int maxHp;
	private String[] inventory;
	private boolean isAlive;
		
	
	public Player() {
		this.name = "Generic Name";
		this.hp = 10;
		this.maxHp = 10;
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
	
	public Player(String name, String difficulty) {
		this.name = name;
		switch (difficulty) {
			case "Hard":
				this.maxHp= 5;
				this.hp = maxHp;
				break;
			case "Medium":
				this.maxHp= 10;
				this.hp = maxHp;
				break;				
			default:
				this.maxHp= 20;
				this.hp = maxHp;
				break;
		}
	}

	public Player(String name, int hp, String[] inventory, int maxHp) {
		this.name = name;
		this.hp = hp;
		this.maxHp= maxHp;
		this.inventory = inventory;
	}

}


