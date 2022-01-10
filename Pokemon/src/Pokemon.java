import java.util.Scanner;

public class Pokemon {
	
	static boolean running = true;
	static boolean caught;
	static Scanner sc = new Scanner(System.in);
	static int pokemonHealthMin = 25;
	static int pokemonHealthMax = 50;
	static int pokemonHealth = (int)(Math.random()*(pokemonHealthMax - pokemonHealthMin + 1) + pokemonHealthMin);
	static int playerHealth = 50;
	static int damage = 0;
	static int menuChoice;
	static int attackChoice;

	
	public static void main(String[] args) {
		
		System.out.println("Wild Pokemon appeared!");
		System.out.println("Pokemon's health is " + pokemonHealth + "hp.\n");
		
		while (running) {	
			displayMenu();
			menuChoice = getChoice();
			performAction(menuChoice);
			checkForPokemonAttack(running, menuChoice, attackChoice);		
		}
		
	}


	private static void displayMenu() {
		
		System.out.println("+--------------------+");
		System.out.println("| 1) Fight           |");
		System.out.println("| 2) Throw Pokeball  |");
		System.out.println("| 3) Run Away        |");
		System.out.println("+--------------------+");
		System.out.print("Enter choice: ");
	}
	
	
	private static int getChoice() {
		
		while (!sc.hasNextInt()) {
			String input = sc.next();
			System.out.printf("\n\"%s\" is not a valid selection.%n", input);
			System.out.print("Please enter a number 1-3: ");
		}
		
		return sc.nextInt();
		
	}
	
	
	private static void performAction(int menuChoice) {
		
		switch (menuChoice) {
		
		case (1) : 
			displayAttacks();
			attackChoice = getChoice();
			performAttack(attackChoice);
			break;
		
		case (2) :
			caught = throwPokeball(pokemonHealth);
			checkIfCaught(caught);
			break;
		
		case (3) :
			System.out.println("\nGot away safely...");
			running = false;
			break;
		
		default :
			System.out.println("\nPlease enter a valid number 1-3.\n");
			break;
		
		}
		
	}

	
	private static void displayAttacks() {
		
		System.out.println("\n+-----------------------------------+");
		System.out.println("| 1) Thunderbolt (Super Effective)  |");
		System.out.println("| 2) Quick Attack (Effective)       |");
		System.out.println("| 3) Tackle (Not Very Effective)    |");
		System.out.println("+-----------------------------------+");
		System.out.print("Choose your attack: ");
	}

	
	private static void performAttack(int selection) {
		
		switch (selection) {
		
		case (1) :
			damage = thunderboltDamage();
			pokemonHealth = doAttack("Thunderbolt", damage, pokemonHealth);
			checkPokemonHealth(pokemonHealth);
			break;
			
		case (2) :
			damage = quickAttackDamage();
			pokemonHealth = doAttack("Quick Attack", damage, pokemonHealth);
			checkPokemonHealth(pokemonHealth);
			break;
			
		case (3) :	
			damage = tackleDamage();
			pokemonHealth = doAttack("Tackle", damage, pokemonHealth);
			checkPokemonHealth(pokemonHealth);
			break;
		
		default : 
			System.out.println("\nPlease enter a valid number 1-3.\n");
			break;
			
		}
		
	}
	
	
	// Thunderbolt does random damage between 10-20
	
	private static int thunderboltDamage() {
		
		return (int)(Math.random()*(20 - 11) + 10);	
	}
	
	
	// Quick Attack does random damage between 5-10
	
	private static int quickAttackDamage() {
		
		return (int)(Math.random()*(10 - 6) + 5);
	}


	// Tackle does random damage between 1-5
	
	private static int tackleDamage() {
		
		return (int)(Math.random()*(5 - 2) + 1);
	}
	
	
	private static int doAttack(String attack, int damage, int pokemonHealth) {
		
		System.out.println("\nUsed " + attack + "...");
		System.out.println("Attack inflicted " + damage + " damage!");
		pokemonHealth -= damage;
		return pokemonHealth;
	}
	
	
	private static void checkPokemonHealth(int pokemonHealth) {
		
		if (pokemonHealth <= 0) {
			System.out.println("Pokemon's health is now 0hp.");
			System.out.println("\nPokemon fainted...");
			running = false;	
		} 
		
		else {
			System.out.println("Pokemon's health is now " + pokemonHealth + "hp.\n");
		}
		
	}
	
	
	private static void checkForPokemonAttack(boolean running, int menuChoice, int attackChoice) {
		
		if (running && menuChoice <= 3 && menuChoice >= 1 && attackChoice <= 3 && attackChoice >= 1) {
			playerHealth = attackPlayer(playerHealth);
			checkPlayerHealth(playerHealth);
		}
		
	}

	
	// Pokemon inflicts a random damage 4-10 on player each turn
	
	private static int attackPlayer(int playerHealth) {
		
		int attack = (int)(Math.random()*(10 - 5) + 4);
		System.out.println("Wild Pokemon attacked...");
		System.out.println("Its attack inflicted " + attack + " damage on you!");
		playerHealth -= attack;
		return playerHealth;
	}
	
	
	private static void checkPlayerHealth(int playerHealth) {
		
		if (playerHealth <= 0) {
			System.out.println("\nYou fainted... \nWild Pokemon got away.");
			running = false;
		} 
		
		else {
			System.out.println("Your health is now " + playerHealth + "/50hp.\n");
		}
		
	}


	// A random number is generated between 1 to the health of the Pokemon,
	// if that number is <= 3, the Pokemon is caught
	
	private static boolean throwPokeball(int pokemonHealth) {
		
		System.out.println("\nThrew a Pokeball...");
		int range = (int)(Math.random()*(pokemonHealth - 2) + 1);
		return range <= 3;
	}

	
	private static void checkIfCaught(boolean caught) {
		
		if (caught) {
			System.out.println("The wild Pokemon has been captured!!!");
			running = false;	
		} 
		
		else {
			System.out.println("The wild Pokemon broke free!\n");
		}
		
	}

}
