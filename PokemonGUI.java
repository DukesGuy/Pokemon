import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;


public class PokemonGUI {
	
	static JFrame window;
	static Container con;
	static JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, exitButtonPanel;
	static JLabel titleLabel, hpLabel, hpLabelNumber, playerHpLabel, playerHpLabelNumber;
	static Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 60);
	static Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 12);
	static JButton startButton, choice1, choice2, choice3, exitButton, playAgainButton;
	static JTextArea mainTextArea;
	static Scanner sc = new Scanner(System.in);
	static TitleScreenHandler tsHandler = new TitleScreenHandler();
	static ChoiceHandler choiceHandler = new ChoiceHandler();
	static ExitHandler exitHandler = new ExitHandler();
	static int pokemonHealthMin = 25;
	static int pokemonHealthMax = 50;
	static int pokemonHealth = (int)(Math.random()*(pokemonHealthMax - pokemonHealthMin + 1) + pokemonHealthMin);
	static int playerHealth = 50;
	static int damage = 0;
	static String position, attack;

	
	public static void main(String[] args) {
		
		new PokemonGUI();
	}
	
	
	public PokemonGUI() {
		
		window = new JFrame();
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.blue);
		window.setLayout(null);
		window.setVisible(true);
		window.setSize(350,500);
		con = window.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(25,75,300,100);
		titlePanel.setBackground(Color.blue);
		titleLabel = new JLabel("Pokémon!");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(125,225,100,50);
		startButtonPanel.setBackground(Color.blue);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.blue);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		con.add(titlePanel);
		con.add(startButtonPanel);
	}

	
	public static class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	
	
	public static void createGameScreen() {
		
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50,75,250,150);
		mainTextPanel.setBackground(Color.white);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(50,75,250,150);
		mainTextArea.setBackground(Color.white);
		mainTextArea.setForeground(Color.black);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(100, 275, 150, 150);
		choiceButtonPanel.setBackground(Color.blue);
		choiceButtonPanel.setLayout(new GridLayout(3,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(15, 15, 370, 25);
		playerPanel.setBackground(Color.blue);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("Pokémon HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		playerHpLabel = new JLabel(" Player HP:");
		playerHpLabel.setFont(normalFont);
		playerHpLabel.setForeground(Color.white);
		playerPanel.add(playerHpLabel);
		playerHpLabelNumber = new JLabel();
		playerHpLabelNumber.setFont(normalFont);
		playerHpLabelNumber.setForeground(Color.white);
		playerPanel.add(playerHpLabelNumber);
		
		position = "appeared";
		playerSetup();
	}
	
	
	public static void playerSetup() {
		
		playerHpLabelNumber.setText("" + playerHealth);
		hpLabelNumber.setText("" + pokemonHealth);
		appeared();
	}
	
	
	public static void appeared() {
		
		if (position.equals("appeared")) {
			mainTextArea.setText(" Wild Pokémon appeared!\n Pokémon's health is " + pokemonHealth + "hp.");
			mainTextArea.append("\n\n\n Choose an option...");
		}
		if (!position.equals("appeared")) {
			position = "menu";
		}
		choice1.setText("Fight");
		choice2.setText("Throw Pokéball");
		choice3.setText("Run Away");
	}
	
	
	public static class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "appeared" :
				switch(yourChoice) {
				case "c1" : fight(); break;
				case "c2" : throwPokeball(); break;	
				case "c3" : runAway(); break;
				}
				break;
			case "fight" :
				switch(yourChoice) {
				case "c1" : thunderbolt(); break;
				case "c2" : quickAttack(); break;	
				case "c3" : tackle(); break;
				}
				break;
			case "menu" :
				switch(yourChoice) {
				case "c1" : fight(); break;
				case "c2" : throwPokeball(); break;	
				case "c3" : runAway(); break;
				}
				break;
			}
		}
	}
	
	
	public static void fight() {
		
		position = "fight";
		mainTextArea.setText(" Choose an attack...");
		choice1.setText("Thunderbolt");
		choice2.setText("Quick Attack");
		choice3.setText("Tackle");
	}
	
	
	// A random number is generated between 1 to the health of the Pokemon,
	// if that number is <= 3, the Pokemon is caught
	
	public static void throwPokeball() {
		
		position = "Pokeball";
		mainTextArea.setText(" Threw a Pokéball...");
		
		int range = (int)(Math.random()*(pokemonHealth - 2) + 1);
		if (range <= 3) {
			mainTextArea.append("\n\n The wild Pokémon has been captured !!!");
			exit();
		} else {
			mainTextArea.append("\n The wild Pokémon broke free!");
			attackPlayer();
		}
	}
	
	
	public static void runAway() {
		
		mainTextArea.setText(" Got Away Safely...");
		exit();
	}

	
	public static void thunderbolt() {
		
		attack = "Thunderbolt";
		damage = (int)(Math.random()*(20 - 11) + 10);
		mainTextArea.setText(" Used " + attack + "...\n Attack inflicted " + damage + " damage!");
		pokemonHealth -= damage;
		checkPokemonFainted();
	}
	
	
	public static void quickAttack() {
		
		attack = "Quick Attack";
		damage = (int)(Math.random()*(10 - 6) + 5);
		mainTextArea.setText(" Used " + attack + "...\n Attack inflicted " + damage + " damage!");
		pokemonHealth -= damage;
		checkPokemonFainted();
	}


	public static void tackle() {
	
		attack = "Tackle";
		damage = (int)(Math.random()*(5 - 2) + 1);
		mainTextArea.setText(" Used " + attack + "...\n Attack inflicted " + damage + " damage!");
		pokemonHealth -= damage;
		checkPokemonFainted();
	}
	
	
	public static void checkPokemonFainted() {
		
		if (pokemonHealth <= 0) {
			mainTextArea.append("\n\n Wild Pokémon fainted...");
			hpLabelNumber.setText("0");
			position = "exit";
			exit();
		} 
	
		if (!position.equals("exit")) {
			attackPlayer();
		}
	}
	
	
	// Pokemon inflicts a random damage 4-10 on player each turn
	
	public static void attackPlayer() {
		
		int pokemonAttack = (int)(Math.random()*(10 - 5) + 4);
		mainTextArea.append("\n\n Wild Pokémon attacked...");
		mainTextArea.append("\n Its attack inflicted " + pokemonAttack + " damage on you!");
		playerHealth -= pokemonAttack;
		checkPlayerFainted();
	}
	
	
	public static void checkPlayerFainted() {
		
		if (playerHealth <= 0) {
			mainTextArea.append("\n\n You fainted... \n Wild Pokémon got away.");
			playerHpLabelNumber.setText("0");
			position = "exit";
			exit();
		} 
		
		if (!position.equals("exit")) {
			mainTextArea.append("\n\n Choose an option...");
			playerSetup();
		}
	}
	
	
	public static void exit() {
		
		choiceButtonPanel.setVisible(false);
		
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(125, 275, 100, 75);
		exitButtonPanel.setBackground(Color.blue);
		exitButtonPanel.setLayout(new GridLayout(2,1));
		con.add(exitButtonPanel);
		
		playAgainButton = new JButton("Play Again");
		playAgainButton.setBackground(Color.black);
		playAgainButton.setForeground(Color.black);
		playAgainButton.setFont(normalFont);
		playAgainButton.addActionListener(exitHandler);
		playAgainButton.setActionCommand("play");
		exitButtonPanel.add(playAgainButton);
		exitButton = new JButton("Exit");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.black);
		exitButton.setFont(normalFont);
		exitButton.addActionListener(exitHandler);
		exitButton.setActionCommand("exit");
		exitButtonPanel.add(exitButton);
	}
	
	
	public static class ExitHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String playOrExit = event.getActionCommand();
			
			switch(playOrExit) {
			case "play" : 
				exitButtonPanel.setVisible(false);
				mainTextPanel.setVisible(false);
				playerPanel.setVisible(false);
				pokemonHealth = (int)(Math.random()*(pokemonHealthMax - pokemonHealthMin + 1) + pokemonHealthMin);
				playerHealth = 50;
				createGameScreen();
				break;
			case "exit" : 
				System.exit(0);
			}
		}
	}

}
