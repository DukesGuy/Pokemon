package game;

import actions.Attack;
import actions.QuickAttack;
import actions.Tackle;
import actions.Thunderbolt;

public class GameDialog {
	
	Pokemon game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	
	public GameDialog(Pokemon g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.playerHealth = 50;
		player.pokemonHealth = (int)(Math.random()*(50 - 25 + 1) + 25);
		ui.playerHpLabelNumber.setText("" + player.playerHealth);
		ui.hpLabelNumber.setText("" + player.pokemonHealth);
		selectPosition("pokemonAppears");
		
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "pokemonAppears" : pokemonAppears(); break;
		case "fight" : fight(); break;
		case "pokeball" : throwPokeball(); break;
		case "run" : runAway(); break;
		case "thunderbolt" : attack(new Thunderbolt()); break;
		case "quickAttack" : attack(new QuickAttack()); break;
		case "tackle" : attack(new Tackle()); break;
		}
		
	}

	public void pokemonAppears() {
		
		ui.mainTextArea.setText(" Wild Pokémon appeared!\n Pokémon's health is " + player.pokemonHealth + "hp.");
		ui.mainTextArea.append("\n\n\n Choose an option...");
		ui.choice1.setText("Fight");
		ui.choice2.setText("Throw Pokéball");
		ui.choice3.setText("Run Away");	
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "pokeball";
		game.nextPosition3 = "run";
		
	}
	
	public void fight() {
		
		ui.mainTextArea.setText(" Choose an attack...");
		ui.choice1.setText("Thunderbolt");
		ui.choice2.setText("Quick Attack");
		ui.choice3.setText("Tackle");
		
		game.nextPosition1 = "thunderbolt";
		game.nextPosition2 = "quickAttack";
		game.nextPosition3 = "tackle";
		
	}
	
	public void throwPokeball() {
		
		ui.mainTextArea.setText(" Threw a Pokéball...");
		
		int range = (int)(Math.random()*(player.pokemonHealth - 2) + 1);
		if (range <= 3) {
			ui.mainTextArea.append("\n\n The wild Pokémon has been captured !!!");
			vm.exit();
		} else {
			ui.mainTextArea.append("\n The wild Pokémon broke free!");
			attackPlayer();
		}
		
	}
	
	public void runAway() {
		
		ui.mainTextArea.setText(" Got Away Safely...");
		vm.exit();
		
	}
	
	private void attack(Attack attack) {
		
		ui.mainTextArea.setText(" Used " + attack.name + "...\n Attack inflicted " + attack.damage + " damage!");
		player.pokemonHealth -= attack.damage;
		checkPokemonFainted();
		
		ui.choice1.setText("Fight");
		ui.choice2.setText("Throw Pokéball");
		ui.choice3.setText("Run Away");	
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "pokeball";
		game.nextPosition3 = "run";
		
	}
	
	public void checkPokemonFainted() {
		
		if (player.pokemonHealth <= 0) {
			ui.mainTextArea.append("\n\n Wild Pokémon fainted...");
			ui.hpLabelNumber.setText("0");
			vm.exit();
		} else {
			attackPlayer();
		}
		
	}
	

	public void attackPlayer() {
		
		int pokemonAttack = (int)(Math.random()*(10 - 5) + 4);
		ui.mainTextArea.append("\n\n Wild Pokémon attacked...");
		ui.mainTextArea.append("\n Its attack inflicted " + pokemonAttack + " damage on you!");
		player.playerHealth -= pokemonAttack;
		checkPlayerFainted();
		
	}

	public void checkPlayerFainted() {
		
		if (player.playerHealth <= 0) {
			ui.mainTextArea.append("\n\n You fainted... \n Wild Pokémon got away.");
			ui.playerHpLabelNumber.setText("0");
			vm.exit();
		} else {
			ui.playerHpLabelNumber.setText("" + player.playerHealth);
			ui.hpLabelNumber.setText("" + player.pokemonHealth);
			ui.mainTextArea.append("\n\n Choose an option...");
		}
		
	}


}
