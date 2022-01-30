package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.Pokemon.ChoiceHandler;


public class UI {
	
	JFrame window;
	JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, exitButtonPanel;
	JLabel titleLabel, hpLabel, hpLabelNumber, playerHpLabel, playerHpLabelNumber;
	JButton startButton, choice1, choice2, choice3, exitButton, playAgainButton;
	JTextArea mainTextArea;
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 60);
	Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 12);
	
	public void createUI(ChoiceHandler cHandler) {
		
		// WINDOW
		window = new JFrame();
		window.setSize(350,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.blue);
		window.setLayout(null);
		
		// TITLE SCREEN
		titlePanel = new JPanel();
		titlePanel.setBounds(25,75,300,100);
		titlePanel.setBackground(Color.blue);
		titleLabel = new JLabel("Pokémon!");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);
		titlePanel.add(titleLabel);
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(125,225,100,50);
		startButtonPanel.setBackground(Color.blue);
		startButton = new JButton("Start");
		startButton.setBackground(Color.blue);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		window.add(titlePanel);
		window.add(startButtonPanel);
		
		// GAME SCREEN
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(50,75,250,150);
		mainTextPanel.setBackground(Color.white);
		window.add(mainTextPanel);
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(50,75,250,150);
		mainTextArea.setBackground(Color.white);
		mainTextArea.setForeground(Color.black);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(100, 275, 150, 150);
		choiceButtonPanel.setBackground(Color.blue);
		choiceButtonPanel.setLayout(new GridLayout(3,1));
		window.add(choiceButtonPanel);
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		playerPanel = new JPanel();
		playerPanel.setBounds(15, 15, 370, 25);
		playerPanel.setBackground(Color.blue);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
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
		
		// PLAY AGAIN & EXIT BUTTONS
		exitButtonPanel = new JPanel();
		exitButtonPanel.setBounds(125, 275, 100, 75);
		exitButtonPanel.setBackground(Color.blue);
		exitButtonPanel.setLayout(new GridLayout(2,1));
		window.add(exitButtonPanel);
		playAgainButton = new JButton("Play Again");
		playAgainButton.setBackground(Color.black);
		playAgainButton.setForeground(Color.black);
		playAgainButton.setFont(normalFont);
		playAgainButton.addActionListener(cHandler);
		playAgainButton.setActionCommand("playAgain");
		exitButtonPanel.add(playAgainButton);
		exitButton = new JButton("Exit");
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.black);
		exitButton.setFont(normalFont);
		exitButton.addActionListener(cHandler);
		exitButton.setActionCommand("exit");
		exitButtonPanel.add(exitButton);
		
		
		window.setVisible(true);
		
	}

}
