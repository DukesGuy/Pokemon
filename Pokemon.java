import java.util.Scanner;

public class Pokemon {
	
	static boolean running = true;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int pokemonHealthMin = 25;
		int pokemonHealthMax = 50;
		int pokemonHealth = (int)(Math.random()*(pokemonHealthMax - pokemonHealthMin + 1) + pokemonHealthMin);
		int playerHealth = 50;
		int damage = 0;
		int menuChoice = 1;
		int attackChoice = 1;
		boolean caught;
		
		
		System.out.println("Wild Pokemon appeared!");
		System.out.println("Pokemon's health is " + pokemonHealth + "hp.\n");
		
		
		while (running) {
			
			displayMenu();
			menuChoice = getChoice();
			
			if (menuChoice == 1) {
				
				displayAttacks();
				attackChoice = getChoice();
				
				if (attackChoice == 1) {
					
					damage = thunderboltDamage();
					pokemonHealth = doAttack("Thunderbolt", damage, pokemonHealth);
					healthCheck(pokemonHealth);
				}
					
				else if (attackChoice == 2) {
				
					damage = quickAttackDamage();
					pokemonHealth = doAttack("Quick Attack", damage, pokemonHealth);
					healthCheck(pokemonHealth);
				}
					
				else if (attackChoice == 3) {	
				
					damage = tackleDamage();
					pokemonHealth = doAttack("Tackle", damage, pokemonHealth);
					healthCheck(pokemonHealth);
				}
				
				else {
					
					System.out.println("Please enter a valid number 1-3.\n");
				}
					
			}
			
			
			else if (menuChoice == 2) {
			
				caught = throwPokeball(pokemonHealth);
				checkIfCaught(caught);
			}
			

			else if (menuChoice == 3) {
			
				System.out.println("\nGot away safely...");
				running = false;
				
			}
		
			else {
				
				System.out.println("Please enter a valid number 1-3.\n");
			}
			
			
			// Pokemon attacks player after each attack or capture attempt
			
			if (running && menuChoice <= 3 && menuChoice >= 1 && attackChoice <= 3 && attackChoice >= 1) {
				playerHealth = attackPlayer(playerHealth);
				checkPlayerHealth(playerHealth);
			}	
			
		}
	}

	
	private static void displayMenu() {
		
		System.out.println("-------------------+");
		System.out.println("1) Fight           |");
		System.out.println("2) Throw Pokeball  |");
		System.out.println("3) Run Away        |");
		System.out.println("-------------------+");
		System.out.print("\nEnter choice: ");
	}

	
	private static void displayAttacks() {
		
		System.out.println("\n----------------------------------+");
		System.out.println("1) Thunderbolt (Super Effective)  |");
		System.out.println("2) Quick Attack (Effective)       |");
		System.out.println("3) Tackle (Not Very Effective)    |");
		System.out.println("----------------------------------+");
		System.out.print("Choose your attack: ");
	}
	
	
	private static int getChoice() {
		
		while (!sc.hasNextInt()) {
			String input = sc.next();
			System.out.printf("\"%s\" is not a valid selection.%n", input);
			System.out.print("Please enter a number 1-3: ");
		}
		return sc.nextInt();
	}

	
	private static void healthCheck(int pokemonHealth) {
		
		if (pokemonHealth <= 0) {
			System.out.println("Pokemon's health is now 0hp.");
			System.out.println("\nPokemon fainted...");
			running = false;
		} else {
			System.out.println("Pokemon's health is now " + pokemonHealth + "hp.\n");
		}
		
	}

	
	private static void checkPlayerHealth(int playerHealth) {
		
		if (playerHealth <= 0) {
			System.out.println("\nYou fainted... \nWild Pokemon got away.");
			running = false;
		} else {
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
		} else {
			System.out.println("The wild Pokemon broke free!\n");
		}
	}


	private static int doAttack(String attack, int damage, int pokemonHealth) {
		
		System.out.println("\nUsed " + attack + "...");
		System.out.println("Attack inflicted " + damage + " damage!");
		pokemonHealth -= damage;
		return pokemonHealth;
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
	
	
	// Pokemon inflicts a random damage 3-10 on player each turn
	
	private static int attackPlayer(int playerHealth) {
		
		int attack = (int)(Math.random()*(10 - 4) + 3);
		System.out.println("Wild Pokemon attacked...");
		System.out.println("Its attack inflicted " + attack + " damage on you!");
		playerHealth -= attack;
		return playerHealth;
	}

}
