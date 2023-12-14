import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		System.out.println();
	}

	public static Player createNewPlayer() {
		Scanner keyB = new Scanner(System.in);
		String name = "Arthur";
		Player newPlayer;
		String difficulty = "easy";
		
		System.out.println("What's your name?");
		name = keyB.nextLine();
		
		System.out.println("Do you want to play on Easy/Medium/Hard? (Changes Starting Health)");
		difficulty = keyB.nextLine();
		
		
		
		return newPlayer;
	}
}
